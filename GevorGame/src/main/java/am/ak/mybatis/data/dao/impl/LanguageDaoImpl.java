package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.client.ILanguageClient;
import am.ak.mybatis.data.dao.ILanguageDao;
import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.model.Language;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public class LanguageDaoImpl implements ILanguageDao {

    @Autowired
    private ILanguageClient languageClient;

    public void add(Language language) throws DatabaseException {
        try {
            languageClient.add(language);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void delete(List<Language> languages) throws DatabaseException {
        try {
            languageClient.delete(languages);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void edit(Language language) throws DatabaseException {
        try {
            languageClient.edit(language);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
