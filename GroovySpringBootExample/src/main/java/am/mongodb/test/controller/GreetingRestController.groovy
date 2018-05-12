package am.mongodb.test.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by karlen on 5/27/16.
 */
@RestController
class GreetingRestController {

    @RequestMapping("/hi/{name}")
    def hi(@PathVariable String name) {
        [greeting: "Hello, " + name + "!"]
    }
}
