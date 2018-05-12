package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.client.IFileClient;
import am.ak.mybatis.data.dao.IFileDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class FileDaoImpl implements IFileDao {

    @Autowired
    private IFileClient fileClient;
}
