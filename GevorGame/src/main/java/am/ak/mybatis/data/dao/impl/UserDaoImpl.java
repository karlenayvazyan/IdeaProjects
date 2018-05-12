package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.dao.IUserDao;
import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.client.IUserClient;
import am.ak.mybatis.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karlen on 4/21/15.
 */
public class UserDaoImpl implements IUserDao {

    @Autowired
    private IUserClient userClient;

    public User get(String email, String password) throws DatabaseException {
        try {
            Map<String, String> params = new HashMap<String, String>(2);
            params.put("username", email);
            params.put("password", password);
            return userClient.get(params);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
