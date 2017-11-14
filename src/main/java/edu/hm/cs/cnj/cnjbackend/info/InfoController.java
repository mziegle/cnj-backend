package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelZiegler on 10/17/17.
 */
@RestController
public class InfoController {

    @Autowired
    InfoProperties infoProperties;

    @RequestMapping("/info")
    public Info greeting() {
        Info result = new Info();
        result.setMessage(infoProperties.getMessage());
        return result;
    }

}
