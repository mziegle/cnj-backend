package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by michaelZiegler on 11/7/17.
 */
@Component
@ConfigurationProperties(prefix = "cnj.info")
public class InfoProperties {

    String message;

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
