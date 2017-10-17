package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelZiegler on 10/17/17.
 */
@RestController
public class InfoController {

    @RequestMapping("/info")
    public Info greeting() {
        Info result = new Info();
        result.setMessage("OK");
        return result;
    }

}
