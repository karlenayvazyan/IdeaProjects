package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.client.ILavalClient;
import am.ak.mybatis.data.dao.ILavalDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class LavalDaoImpl implements ILavalDao {

    @Autowired
    private ILavalClient lavalClient;
}
