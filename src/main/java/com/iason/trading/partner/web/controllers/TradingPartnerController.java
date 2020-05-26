package com.iason.trading.partner.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iason.trading.partner.repositories.TradingPartnerRepository;
import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.producer.TradingPartnerProducer;
import com.iason.trading.partner.services.ITradingPartnerService;
import com.iason.trading.partner.web.model.TradingPartnerDto;
import com.iason.trading.partner.web.apis.TradingPartnerAPIs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerController
 * Inside the package - com.iason.trading.partner.web.controllers
 * Created Date: 4/29/2020
 * Created Time: 4:10 PM
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class TradingPartnerController implements TradingPartnerAPIs {

    private final ITradingPartnerService iTradingPartnerService;

//    private TradingPartnerProducer tradingPartnerProducer;
//
//    @Autowired
//    public void setTradingPartnerRepository(TradingPartnerRepository tradingPartnerRepository) {
//        this.tradingPartnerRepository = tradingPartnerRepository;
//    }
//
//    @Autowired
//    public void setTradingPartnerProducer(TradingPartnerProducer tradingPartnerProducer){
//        this.tradingPartnerProducer = tradingPartnerProducer;
//    }

    @Override
    public ResponseEntity getTradingPartners() {
        List<TradingPartnerDto> tradingPartners = iTradingPartnerService.getTradingPartners();
        //tradingPartnerProducer.sendTradingPartners(tradingPartners);
        log.info("Trading Parnters: {}", tradingPartners);
        for (TradingPartnerDto tp: tradingPartners) {
            log.info("HIOS Name: {} ", tp.getHios());
            log.info("State Name: {} ", tp.getStateCode());
        }
        return new ResponseEntity(tradingPartners,HttpStatus.OK);
    }

    @Override
    public ResponseEntity createTradingPartner(@RequestBody TradingPartnerDto tradingPartnerDto) {
        TradingPartnerDto tp = iTradingPartnerService.createTradingPartner(tradingPartnerDto);
        return new ResponseEntity(tp, HttpStatus.CREATED);
    }

    @Override
    public String helloTradingPartner() {
        return "Hello, you have successfully connected to Trading Partner Service ";
    }
}
