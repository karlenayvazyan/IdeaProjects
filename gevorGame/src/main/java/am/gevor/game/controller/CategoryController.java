package am.gevor.game.controller;

import am.gevor.game.data.converter.Converter;
import am.gevor.game.data.model.Language;
import am.gevor.game.data.mongo.CategoryRepository;
import am.gevor.game.data.model.Category;
import am.gevor.game.data.mvc.model.CategoryForm;
import am.gevor.game.util.ControllerPath;
import am.gevor.game.util.IdProvider;
import com.mongodb.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 5/27/16.
 */
@Controller
@RequestMapping(ControllerPath.CATEGORY)
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @RequestMapping(method = RequestMethod.GET)
    public String categoryView(CategoryForm categoryForm, Model model) {
        try {
            List<Category> categories = categoryRepository.findByCategoryId("-1");
            model.addAttribute("categories", categories);
            return "category-view";
        } catch (Exception e) {
            logger.error("View category error", e);
            return "error/error";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCategory(@Valid CategoryForm categoryForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryRepository.findByCategoryId("-1");
            model.addAttribute("categories", categories);
            return "category-view";
        }
        Converter<Category, CategoryForm> converter = new Converter<Category, CategoryForm>() {
            @Override
            public Category convert(CategoryForm from) {
                Category category = new Category();
                List<Language> languages = convert(from.getLanguages());
                category.setLanguages(languages);
                return category;
            }
        };
        try {
            DB newDB = mongoDbFactory.getDb(dbName);
            Category category = converter.convert(categoryForm);
            category.setId(IdProvider.getNextId(newDB, "category"));
            category.setCategoryId("-1");
            category.setCreationDate(new Date());
            categoryRepository.save(category);
            return "redirect:" + ControllerPath.CATEGORY;
        } catch (Exception e) {
            logger.error("Add category error", e);
            return "error/error";
        }
    }

    @RequestMapping(value = ControllerPath.DELETE_BY_ID, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable String id) {
        try {
            categoryRepository.deleteById(id);
            return "redirect:" + ControllerPath.CATEGORY;
        } catch (Exception e) {
            logger.error("Delete category error", e);
            return "error/error";
        }
    }
}
