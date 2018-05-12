package am.ak.mybatis.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by karlen on 4/21/15.
 */
public class BaseAction extends ActionSupport implements SessionAware {

    protected Map<String, Object> session;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
