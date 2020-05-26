package com.iason.trading.partner.services;

import com.iason.trading.partner.web.model.TradingPartnerDto;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ITradingPartnerService
 * Inside the package - com.iason.trading.partner.services
 * Created Date: 5/21/2020
 * Created Time: 5:39 PM
 **/
public interface ITradingPartnerService {
    List<TradingPartnerDto> getTradingPartners();
    TradingPartnerDto createTradingPartner(TradingPartnerDto tradingPartnerDto);
}
