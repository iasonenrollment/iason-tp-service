package com.iason.trading.partner.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.repositories.TradingPartnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerProducer
 * Inside the package - com.iason.trading.partner.scheduler
 * Created Date: 5/4/2020
 * Created Time: 1:23 PM
 **/
@Service
@Slf4j
public class TradingPartnerProducer {

    private static KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper mapper;

    private TradingPartnerRepository repository;

    public TradingPartnerProducer(KafkaTemplate kafkaTemplate,
                                  ObjectMapper mapper,
                                  TradingPartnerRepository repository){
        this.mapper = mapper;
        this.kafkaTemplate = kafkaTemplate;
        this.repository = repository;
    }

    public void sendTradingPartners(List<TradingPartner> tradingPartnerList) throws JsonProcessingException {
        for (TradingPartner tradingPartner: tradingPartnerList) {
            String tp = mapper.writeValueAsString(tradingPartner);
            kafkaTemplate.send("trading_partners",tp);
            log.debug("Trading Partner Produced: " + tradingPartner.getTradingPartnerDesc());
        }

    }

}
