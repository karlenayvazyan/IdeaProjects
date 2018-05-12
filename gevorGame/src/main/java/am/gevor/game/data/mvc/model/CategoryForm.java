package am.gevor.game.data.mvc.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by karlen on 5/30/16.
 */
public class CategoryForm {

    @Valid
    @NotNull
    private List<LanguageForm> languages;

    public List<LanguageForm> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageForm> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryForm that = (CategoryForm) o;

        return languages != null ? languages.equals(that.languages) : that.languages == null;

    }

    @Override
    public int hashCode() {
        return languages != null ? languages.hashCode() : 0;
    }
}
