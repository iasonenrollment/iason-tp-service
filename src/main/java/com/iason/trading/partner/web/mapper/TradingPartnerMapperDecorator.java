package com.iason.trading.partner.web.mapper;

import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.domain.TransactionSource;
import com.iason.trading.partner.web.model.TradingPartnerDto;
import com.iason.trading.partner.web.model.TransactionSourceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerMapperDecorator
 * Inside the package - com.iason.trading.partner.web.mapper
 * Created Date: 5/21/2020
 * Created Time: 6:38 PM
 **/
@Slf4j
public abstract class TradingPartnerMapperDecorator implements TradingPartnerMapper{

    private TradingPartnerMapper tradingPartnerMapper;

    private TransactionSourceMapper transactionSourceMapper;

    @Autowired
    public void setTradingPartnerMapper(TradingPartnerMapper tradingPartnerMapper) {
        this.tradingPartnerMapper = tradingPartnerMapper;
    }

    @Autowired
    public void setTransactionSourceMapper(TransactionSourceMapper transactionSourceMapper) {
        this.transactionSourceMapper = transactionSourceMapper;
    }

    public TradingPartnerDto tradingPartnerToTradingPartnerDto(TradingPartner tradingPartner){
        TradingPartnerDto tradingPartnerDto = tradingPartnerMapper.tradingPartnerToTradingPartnerDto(tradingPartner);
        List<TransactionSource> transactionSources = tradingPartner.getTransactionSources();
        List<TransactionSourceDto> transactionSourceDtos =
                transactionSources
                        .stream()
                        .map(transactionSourceMapper :: transactionSourceToTransactionSourceDto)
                        .collect(Collectors.toList());
        tradingPartnerDto.setTransactionSourceDtos(transactionSourceDtos);
        return tradingPartnerDto;
    }

    public TradingPartner tradingPartnerDtoToTradingPartner(TradingPartnerDto tradingPartnerDto){
        TradingPartner tradingPartner = tradingPartnerMapper.tradingPartnerDtoToTradingPartner(tradingPartnerDto);
        List<TransactionSourceDto> transactionSourceDtos = tradingPartnerDto.getTransactionSourceDtos();
        List<TransactionSource> transactionSources =
                transactionSourceDtos
                        .stream()
                        .map(transactionSourceMapper :: transactionSourceDtoToTransactionSource)
                        .collect(Collectors.toList());
        for (TransactionSource ts: transactionSources) {
            ts.setTradingPartner(tradingPartner);
        }
        tradingPartner.setTransactionSources(transactionSources);
        return tradingPartner;
    }
}
