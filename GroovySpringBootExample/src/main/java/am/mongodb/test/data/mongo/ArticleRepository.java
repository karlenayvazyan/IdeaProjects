package am.mongodb.test.data.mongo;

import am.mongodb.test.data.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by karlena on 5/20/2016.
 */
public interface ArticleRepository extends MongoRepository<Article, String> {

    Article findById(String id);

    void deleteById(String id);
}
