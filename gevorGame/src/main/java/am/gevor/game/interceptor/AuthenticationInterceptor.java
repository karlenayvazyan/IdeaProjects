package am.gevor.game.interceptor;

import am.gevor.game.data.model.User;
import am.gevor.game.util.ScopeKeys;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by karlen on 5/28/16.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(ScopeKeys.SESSION_USER);
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
