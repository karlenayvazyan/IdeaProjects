package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.client.ISoundClient;
import am.ak.mybatis.data.dao.ISoundDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class SoundDaoImpl implements ISoundDao {

    @Autowired
    private ISoundClient soundClient;
}
