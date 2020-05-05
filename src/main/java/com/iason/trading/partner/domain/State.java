package com.iason.trading.partner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: State
 * Inside the package - com.iason.trading.partner.domain
 * Created Date: 4/29/2020
 * Created Time: 4:52 PM
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {

    @Id
    private Long stateId;

    private String stateCode;

    private String stateName;

    @JsonIgnore
    @OneToMany(mappedBy = "state")
    private List<TradingPartner> tradingPartners;
}
