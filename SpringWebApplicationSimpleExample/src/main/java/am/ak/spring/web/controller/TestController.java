package am.ak.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by karlen on 5/17/17.
 */
@Controller
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String pringHello() {
        return "test";
    }
}
