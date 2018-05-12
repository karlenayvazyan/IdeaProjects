package am.ak.mybatis.action.general;

import am.ak.mybatis.action.BaseAction;
import am.ak.mybatis.data.manager.IUserManager;
import am.ak.mybatis.data.model.User;
import am.ak.mybatis.util.Validator;
import org.apache.log4j.Logger;
import am.ak.mybatis.util.ScopeKeys;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 5/16/15.
 */
public class LoginAction extends BaseAction {

    @Autowired
    private IUserManager manager;

    private String email;

    private String password;

    private Logger logger = Logger.getLogger(LoginAction.class);

    private Logger tracker = Logger.getLogger("Tracker");

    @Override
    public String execute() {
        try {
            User user = manager.get(email, password);
            if (user == null) {
                addActionError("Incorrect email/password");
                return INPUT;
            }
            session.put(ScopeKeys.USER, user);
            tracker.info("User is login");
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Failed to login " + email);
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (Validator.isEmpty(email)) {
            addFieldError("email", "Email is required");
        } else if (Validator.isEmpty(email)) {
            addFieldError("email", "Email is incorrect");
        }

        if (Validator.isEmpty(password)) {
            addFieldError("password", "Password is required");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
