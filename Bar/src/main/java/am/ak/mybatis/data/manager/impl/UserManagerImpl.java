package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.IUserDao;
import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.manager.IUserManager;
import am.ak.mybatis.data.model.User;
import am.ak.mybatis.util.HashAlgorithm;
import am.ak.mybatis.util.HashingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by karlen on 4/21/15.
 */
@Transactional(readOnly = true)
public class UserManagerImpl implements IUserManager {

    @Autowired
    private IUserDao userDao;

    @Transactional(readOnly = false,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public void add(User user) throws InternalErrorException {
        try {
            String password = user.getPassword();
            user.setPassword(HashingUtils.hashMessage(HashAlgorithm.SHA1, password));
            user.setCreationDate(new Date());
            userDao.add(user);
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    public boolean isExists(String email) throws InternalErrorException {
        try {
            return userDao.isExists(email);
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }

    public User get(String email, String password) throws InternalErrorException {
        try {
            return userDao.get(email, HashingUtils.hashMessage(HashAlgorithm.SHA1, password));
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }
}
