package am.ak.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class Example {

    @RequestMapping("/")
    String home(@RequestBody String name) {
        return "Hello: " + name + "!";
    }
}