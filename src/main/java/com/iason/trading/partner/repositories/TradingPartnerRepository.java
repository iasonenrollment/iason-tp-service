package com.iason.trading.partner.repositories;

import com.iason.trading.partner.domain.TradingPartner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerRepository
 * Inside the package - com.iason.trading.partner
 * Created Date: 5/2/2020
 * Created Time: 5:26 PM
 **/
public interface TradingPartnerRepository extends JpaRepository<TradingPartner, Long> {
}
