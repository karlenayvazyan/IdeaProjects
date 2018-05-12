package am.gevor.game.data.mongo;

import am.gevor.game.data.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by karlen on 5/27/16.
 */
public interface CategoryRepository extends MongoRepository<Category, String> {

    List<Category> findByCategoryId(String id);

    void deleteById(String id);
}
