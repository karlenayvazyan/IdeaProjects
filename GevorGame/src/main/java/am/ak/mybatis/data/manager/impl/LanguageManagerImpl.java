package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.ILanguageDao;
import am.ak.mybatis.data.manager.ILanguageManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 03.04.16.
 */
public class LanguageManagerImpl implements ILanguageManager {

    @Autowired
    private ILanguageDao languageDao;
}
