package com.iason.trading.partner.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iason.trading.partner.repositories.TradingPartnerRepository;
import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.producer.TradingPartnerProducer;
import com.iason.trading.partner.web.TradingPartnerDto;
import com.iason.trading.partner.web.apis.TradingPartnerAPIs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Slf4j
public class TradingPartnerController implements TradingPartnerAPIs {

    private TradingPartnerRepository tradingPartnerRepository;

    private TradingPartnerProducer tradingPartnerProducer;

    @Autowired
    public void setTradingPartnerRepository(TradingPartnerRepository tradingPartnerRepository) {
        this.tradingPartnerRepository = tradingPartnerRepository;
    }

    @Autowired
    public void setTradingPartnerProducer(TradingPartnerProducer tradingPartnerProducer){
        this.tradingPartnerProducer = tradingPartnerProducer;
    }

    @Override
    public ResponseEntity<String> getTradingPartners(String initiativeId) throws JsonProcessingException {
        List<TradingPartner> tradingPartners = tradingPartnerRepository.findAll();
        tradingPartnerProducer.sendTradingPartners(tradingPartners);
        log.info("Trading Parnters: {}", tradingPartners);
        for (TradingPartner tp: tradingPartners) {
            log.info("HIOS Name: {} ", tp.getHios().getHiosName());
            log.info("State Name: {} ", tp.getState().getStateName());
        }
        return new ResponseEntity("Hello World!!!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity createTradingPartner(TradingPartnerDto tradingPartnerDto) {
        return null;
    }
}
