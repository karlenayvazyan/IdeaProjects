package am.gevor.game.data.model;

import org.springframework.data.annotation.Id;

/**
 * Created by karlen on 5/27/16.
 */
public class User {

    @Id
    private String _id;

    private String id;

    private String login;

    private String password;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
