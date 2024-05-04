package org.ming.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "upload")
public class UploadConfig {
    private String path;
    private String extensions;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getExtensions() {
        return extensions;
    }
    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }
}
