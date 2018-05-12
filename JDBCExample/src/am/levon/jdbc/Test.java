package am.levon.jdbc;

import am.levon.jdbc.data.manager.IUserManager;
import am.levon.jdbc.data.manager.impl.UserManagerImpl;
import am.levon.jdbc.data.model.User;

/**
 * Created by karlen on 8/1/15.
 */
public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Levon");
        user.setSurname("Uzunyan");
        IUserManager userManager = new UserManagerImpl();
        userManager.addUser(user);
    }
}
