package am.gevor.game.data.mongo;

import am.gevor.game.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by karlen on 5/28/16.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByLoginAndPassword(String login, String password);
}
