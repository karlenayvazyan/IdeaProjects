package am.ak.mybatis.data.dao;

import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.model.Language;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public interface ILanguageDao {

    void add(Language language) throws DatabaseException;

    void delete(List<Language> languages) throws DatabaseException;

    void edit(Language language) throws DatabaseException;
}
