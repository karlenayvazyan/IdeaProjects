package am.ak.mybatis.data.dao;

import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.model.User;

/**
 * Created by karlen on 4/21/15.
 */
public interface IUserDao {

    User get(String email, String password) throws DatabaseException;
}
