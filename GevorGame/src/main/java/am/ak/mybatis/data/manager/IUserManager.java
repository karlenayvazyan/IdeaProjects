package am.ak.mybatis.data.manager;

import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.model.User;

/**
 * Created by karlen on 4/21/15.
 */
public interface IUserManager {

    User get(String email, String password) throws InternalErrorException;
}
