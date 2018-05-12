package am.ak.mybatis.data.model.lcp;

/**
 * Created by karlen on 4/22/15.
 */
public enum LanguageLCP {

    AM      (1, "am"),
    EN      (2, "en"),
    RU      (3, "ru");

    LanguageLCP(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static LanguageLCP valueOf(final int value) {
        for (LanguageLCP gender : LanguageLCP.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        return null;
    }

    private final int value;

    private final String title;

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }
}
