package am.mongodb.test.controller;

import am.mongodb.test.data.model.Article;
import am.mongodb.test.data.mongo.ArticleRepository;
import am.mongodb.test.util.IdProvider;
import am.mongodb.test.util.MongoDBKeys;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 20.05.16.
 */
@RestController
@RequestMapping("/article")
public class VideoController {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Article add(@RequestBody Article article) {
        DB newDB = mongoDbFactory.getDb(MongoDBKeys.DB_NAME);
        article.setId(IdProvider.getNextId(newDB, "article"));
        article.setCreationDate(new Date());
        repository.insert(article);
        return article;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Article> get() {
        return repository.findAll();
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Article getById(@RequestParam(value = "id") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody String id) {
        repository.deleteById(id);
        return "Article deleted successfully";
    }
}
