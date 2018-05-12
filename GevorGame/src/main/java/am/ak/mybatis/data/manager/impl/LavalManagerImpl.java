package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.ILavalDao;
import am.ak.mybatis.data.manager.IlavalManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class LavalManagerImpl implements IlavalManager {

    @Autowired
    private ILavalDao lavalDao;
}
