package com.iason.trading.partner.services;

import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.domain.TransactionSource;
import com.iason.trading.partner.repositories.TradingPartnerRepository;
import com.iason.trading.partner.web.mapper.TradingPartnerMapper;
import com.iason.trading.partner.web.mapper.TransactionSourceMapper;
import com.iason.trading.partner.web.model.TradingPartnerDto;
import com.iason.trading.partner.web.model.TransactionSourceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerServiceImpl
 * Inside the package - com.iason.trading.partner.services
 * Created Date: 5/21/2020
 * Created Time: 5:39 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class TradingPartnerServiceImpl implements ITradingPartnerService{

    private final TradingPartnerRepository tradingPartnerRepository;

    private final TradingPartnerMapper tradingPartnerMapper;

    private final TransactionSourceMapper transactionSourceMapper;


    @Override
    public List<TradingPartnerDto> getTradingPartners() {
        List<TradingPartner> tradingPartners = tradingPartnerRepository.findAll();
        log.info("Trading Partners : " + tradingPartners);
        List<TradingPartnerDto> tradingPartnerDtos =
                tradingPartners
                        .stream()
                        .map(tradingPartnerMapper :: tradingPartnerToTradingPartnerDto)
                        .collect(Collectors.toList());
        log.info("Trading Partners Dtos: " + tradingPartnerDtos);
        for(TradingPartnerDto tradingPartnerDto : tradingPartnerDtos){
            log.info("Transaction Sources: {}", tradingPartnerDto.getTransactionSourceDtos());
        }
        return tradingPartnerDtos;
    }

    @Override
    public TradingPartnerDto createTradingPartner(TradingPartnerDto tradingPartnerDto){
        TradingPartner tradingPartner = tradingPartnerMapper.tradingPartnerDtoToTradingPartner(tradingPartnerDto);
        log.info("Transaction Sources: {}", tradingPartner.getTransactionSources());
        TradingPartner createdTp = tradingPartnerRepository.save(tradingPartner);
        return tradingPartnerMapper.tradingPartnerToTradingPartnerDto(createdTp);
    }
}
