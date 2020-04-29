package com.iason.trading.partner.web.controllers;

import com.iason.trading.partner.web.apis.TradingPartnerAPIs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerController
 * Inside the package - com.iason.trading.partner.web.controllers
 * Created Date: 4/29/2020
 * Created Time: 4:10 PM
 **/
@RestController
public class TradingPartnerController implements TradingPartnerAPIs {
    @Override
    public ResponseEntity<String> getTradingPartners(String initiativeId) {
        return new ResponseEntity("Hello World!!!", HttpStatus.OK);
    }
}
