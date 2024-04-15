package org.ming.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("")
    String home() {
        return "Hello World!";
    }

     @GetMapping("{message}")
    String home(@PathVariable String message) {
        return "Hello " + message;
    }

    @PostMapping("post")
    String post(@RequestBody String message) {
        return "Hello " + message;
    }
}
