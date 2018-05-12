package am.gevor.game.data.mongo;

import am.gevor.game.data.model.Level;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by karlen on 5/29/16.
 */
public interface LevelRepository extends MongoRepository<Level, String> {

    List<Level> findByCategoryId(String categoryId);
}
