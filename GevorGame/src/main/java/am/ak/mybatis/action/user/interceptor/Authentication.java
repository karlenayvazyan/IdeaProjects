package am.ak.mybatis.action.user.interceptor;

import am.ak.mybatis.data.model.User;
import am.ak.mybatis.util.ScopeKeys;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by karlen on 5/16/15.
 */
public class Authentication extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
         Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        User user = (User) session.get(ScopeKeys.USER);
        if (user == null) {
            session.put(ScopeKeys.MESSAGE, "You must login");
            return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
