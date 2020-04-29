package com.iason.trading.partner.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: HomeController
 * Inside the package - com.iason.trading.partner.config
 * Created Date: 4/29/2020
 * Created Time: 4:07 PM
 **/
@Controller
@Slf4j
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        log.info("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
