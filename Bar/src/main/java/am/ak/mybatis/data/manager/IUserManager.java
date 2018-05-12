package am.ak.mybatis.data.manager;

import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.model.User;

/**
 * Created by karlen on 4/21/15.
 */
public interface IUserManager {

    void add(User user) throws InternalErrorException;

    boolean isExists(String email) throws InternalErrorException;

    User get(String email, String password) throws InternalErrorException;
}
