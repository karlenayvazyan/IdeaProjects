package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.ISoundDao;
import am.ak.mybatis.data.manager.ISoundManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class SoundManagerImpl implements ISoundManager {

    @Autowired
    private ISoundDao soundDao;
}
