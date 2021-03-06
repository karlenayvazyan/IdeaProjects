package am.ak.mybatis.data.client;

import am.ak.mybatis.data.model.User;

import java.util.Map;

/**
 * Created by karlen on 4/21/15.
 */
public interface IUserClient {

    void add(User user);

    int isExists(String email);

    User get(Map<String, String> params);
}
