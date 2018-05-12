package am.gevor.game.controller;

import am.gevor.game.data.converter.Converter;
import am.gevor.game.data.model.*;
import am.gevor.game.data.mongo.CategoryRepository;
import am.gevor.game.data.mvc.model.SubCategoryFrom;
import am.gevor.game.util.ControllerPath;
import am.gevor.game.util.FileUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 5/29/16.
 */
@Controller
@RequestMapping(ControllerPath.SUB_CATEGORY + ControllerPath.ID)
public class SubCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Autowired
    private FileUtils fileUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String viewSubCategory(SubCategoryFrom subCategoryFrom, @PathVariable String id, Model model) {
        try {
            List<Category> categories = categoryRepository.findByCategoryId(id);
            model.addAttribute("categories", categories);
            model.addAttribute("categoryId", id);
            return "subCategory-view";
        } catch (Exception e) {
            logger.error("Sub category view error", e);
            return "error/error";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCategory(@Valid SubCategoryFrom subCategoryFrom, BindingResult bindingResult, Model model) {
        boolean isValid = validate(subCategoryFrom, bindingResult);
        if (isValid) {
            Converter<Category, SubCategoryFrom> converter = new Converter<Category, SubCategoryFrom>() {
                @Override
                public Category convert(SubCategoryFrom from) {
                    Category category = new Category();
                    List<Language> languages = convert(from.getLanguages());
                    category.setLanguages(languages);
                    category.setCategoryId(from.getCategoryId());
                    return category;
                }
            };
            DB newDB = mongoDbFactory.getDb(dbName);
            String id = IdProvider.getNextId(newDB, "category");
            try {
                Category category = converter.convert(subCategoryFrom);
                category.setId(id);
                category.setCreationDate(new Date());
                List<File> files = fileUtils.getAndStoreFiles(subCategoryFrom, id);
                category.setFiles(files);
                categoryRepository.save(category);
                return "redirect:" + ControllerPath.SUB_CATEGORY + "/" + category.getCategoryId();
            } catch (Exception e) {
                fileUtils.removeUploadedFiles(subCategoryFrom, id);
                logger.error("Add sub category error", e);
                return "error/error";
            }
        } else {
            try {
                List<Category> categories = categoryRepository.findByCategoryId(subCategoryFrom.getCategoryId());
                model.addAttribute("categories", categories);
                model.addAttribute("categoryId", subCategoryFrom.getCategoryId());
                return "subCategory-view";
            } catch (Exception e) {
                logger.error("Sub category view error", e);
                return "error/error";
            }
        }
    }

    @RequestMapping(value = ControllerPath.DELETE_BY_ID, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable String id, @PathVariable String subCategoryId, Model model) {
        try {
            categoryRepository.deleteById(subCategoryId);
            return "redirect:" + ControllerPath.SUB_CATEGORY + "/" + id;
        } catch (Exception e) {
            logger.error("Delete sub category error", e);
            return "error/error";
        }
    }

    private boolean validate(SubCategoryFrom subCategoryFrom, BindingResult bindingResult) {
        boolean isValid = true;
        if (bindingResult.hasErrors()) {
            isValid = false;
        }
        if (subCategoryFrom.getFileSize1().isEmpty()) {
            isValid = false;
        }
        if (subCategoryFrom.getFileSize2().isEmpty()) {
            isValid = false;
        }
        if (subCategoryFrom.getFileSize3().isEmpty()) {
            isValid = false;
        }
        if (subCategoryFrom.getFileSize4().isEmpty()) {
            isValid = false;
        }
        if (subCategoryFrom.getFileSize5().isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}
