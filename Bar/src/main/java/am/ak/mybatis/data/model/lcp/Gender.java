package am.ak.mybatis.data.model.lcp;

/**
 * Created by karlen on 4/22/15.
 */
public enum Gender {

    MALE    (1, "male"),
    FEMALE  (2, "female");

    Gender(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static Gender valueOf(final int value) {
        for (Gender gender : Gender.values()) {
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
