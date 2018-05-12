package am.levon.jdbc.data.manager.impl;

import am.levon.jdbc.data.dao.IUserDao;
import am.levon.jdbc.data.dao.impl.UserDaoImpl;
import am.levon.jdbc.data.manager.IUserManager;
import am.levon.jdbc.data.model.User;

/**
 * Created by karlen on 8/1/15.
 */
public class UserManagerImpl implements IUserManager {

    private IUserDao userDao;

    public UserManagerImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
