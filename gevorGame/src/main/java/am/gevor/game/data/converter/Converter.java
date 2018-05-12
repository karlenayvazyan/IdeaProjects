package am.gevor.game.data.converter;

import am.gevor.game.data.model.Language;
import am.gevor.game.data.mvc.model.LanguageForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karlen on 5/30/16.
 */
public interface Converter<T, F> {

    T convert(F from);

    default List<Language> convert(List<LanguageForm> from) {
        List<Language> languages = new ArrayList<>();
        from.forEach((languageForm) -> {
            Language language = new Language();
            language.setText(languageForm.getText());
            language.setLanguage(languageForm.getLanguage());
            languages.add(language);
        });
        return languages;
    }
}
