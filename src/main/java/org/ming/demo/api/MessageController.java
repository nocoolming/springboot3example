package org.ming.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @PostMapping("message/create")
    Map<String, String> post(@RequestBody Map<String, String> map){
        log.info("message/create");
        return map;
    }
}
