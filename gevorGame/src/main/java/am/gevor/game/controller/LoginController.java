package am.gevor.game.controller;

import am.gevor.game.data.mongo.UserRepository;
import am.gevor.game.data.model.User;
import am.gevor.game.data.mvc.model.LoginForm;
import am.gevor.game.util.ControllerPath;
import am.gevor.game.util.HashAlgorithm;
import am.gevor.game.util.HashingUtils;
import am.gevor.game.util.ScopeKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by karlen on 5/27/16.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = ControllerPath.LOGIN, method = RequestMethod.GET)
    public String loginView(LoginForm loginForm) {
        return "login-view";
    }

    @RequestMapping(value = ControllerPath.LOGIN, method = RequestMethod.POST)
    public String doLogin(@Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session) {
        try {
            if (bindingResult.hasErrors()) {
                return "login-view";
            }
            User user = userRepository.findByLoginAndPassword(loginForm.getLogin(),
                    HashingUtils.hashMessage(HashAlgorithm.SHA1, loginForm.getPassword()));
            session.setAttribute(ScopeKeys.SESSION_USER, user);
            return "redirect:" + ControllerPath.CATEGORY;
        } catch (Exception e) {
            logger.error("Login error", e);
            return "error/error";
        }
    }

    @RequestMapping(value = ControllerPath.LOGOUT, method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(ScopeKeys.SESSION_USER);
        return "redirect:" + ControllerPath.LOGIN;
    }
}
