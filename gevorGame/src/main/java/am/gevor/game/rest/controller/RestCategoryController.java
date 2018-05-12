package am.gevor.game.rest.controller;

import am.gevor.game.controller.CategoryController;
import am.gevor.game.data.mongo.CategoryRepository;
import am.gevor.game.data.model.Category;
import am.gevor.game.data.mongo.LevelRepository;
import am.gevor.game.util.IdProvider;
import am.gevor.game.util.RestControllerPath;
import com.mongodb.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 5/27/16.
 */
@RestController
@RequestMapping(RestControllerPath.CATEGORY)
public class RestCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LevelRepository levelRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> add() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return categories;
        } catch (Exception e) {
            logger.error("Get all category error", e);
            return null;
        }
    }
}
