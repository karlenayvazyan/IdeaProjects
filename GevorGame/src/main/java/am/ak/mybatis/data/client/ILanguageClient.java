package am.ak.mybatis.data.client;

import am.ak.mybatis.data.model.Language;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public interface ILanguageClient {

    void add(Language language);

    void delete(List<Language> languages);

    void edit(Language language);
}
