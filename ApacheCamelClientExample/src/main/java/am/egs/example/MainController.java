package am.egs.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by karlen on 6/1/16.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getRemoteMessage(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        String message = producerTemplate.requestBody("direct:start", name, String.class);
        redirectAttributes.addFlashAttribute("msg", message);
        return "redirect:/" ;
    }
}
