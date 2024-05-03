package org.ming.demo.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    private final Path root = Paths.get("d:\\uploads");

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
}
