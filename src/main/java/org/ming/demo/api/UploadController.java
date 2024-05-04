package org.ming.demo.api;


import org.ming.demo.config.UploadConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    private final Path root = Paths.get("d:\\uploads");

    @Autowired
    UploadConfig uploadConfig;

    @PostMapping("upload")
    String upload(@RequestParam("file") MultipartFile file) {
        try {
            Files.copy(file.getInputStream(),
                    this.root.resolve(file.getOriginalFilename()));

            return "success";
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return "fail";
    }

    @GetMapping("upload/config")
    Map<String, String> config() {
        Map<String, String> map = new HashMap<>();
        map.put("path", uploadConfig.getPath());
        map.put("extensions", uploadConfig.getExtensions());

        return map;
    }
}
