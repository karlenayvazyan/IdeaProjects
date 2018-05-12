package am.ak.spring.data.service;

import am.ak.spring.data.dao.JpaAccountDao;
import am.ak.spring.data.dao.JpaItemDao;

/**
 * Created by karlen on 3/8/17.
 */
public class PetStoreServiceImpl {

    private JpaItemDao itemDao;

    private JpaAccountDao accountDao;

    public void setItemDao(JpaItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
