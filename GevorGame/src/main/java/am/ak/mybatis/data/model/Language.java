package am.ak.mybatis.data.model;

import am.ak.mybatis.data.model.lcp.LanguageLCP;

/**
 * Created by karlen on 03.04.16.
 */
public class Language {

    private Long id;

    private String text;

    private LanguageLCP language;

    public Language() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LanguageLCP getLanguage() {
        return language;
    }

    public void setLanguage(LanguageLCP language) {
        this.language = language;
    }
}
