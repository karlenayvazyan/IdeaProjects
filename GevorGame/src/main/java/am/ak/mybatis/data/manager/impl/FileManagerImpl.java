package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.IFileDao;
import am.ak.mybatis.data.manager.IFileManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class FileManagerImpl implements IFileManager {

    @Autowired
    private IFileDao fileDao;
}
