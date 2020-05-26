package com.iason.trading.partner.web.mapper;

import com.iason.trading.partner.domain.TradingPartner;
import com.iason.trading.partner.web.model.TradingPartnerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerMapper
 * Inside the package - com.iason.trading.partner.web.mapper
 * Created Date: 5/21/2020
 * Created Time: 5:51 PM
 **/
@Mapper(uses = {DateMapper.class})
@DecoratedWith(TradingPartnerMapperDecorator.class)
public interface TradingPartnerMapper {

    TradingPartnerDto tradingPartnerToTradingPartnerDto(TradingPartner tradingPartner);

    TradingPartner tradingPartnerDtoToTradingPartner(TradingPartnerDto tradingPartnerDto);
}
