package com.iason.trading.partner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: HIOS
 * Inside the package - com.iason.trading.partner.domain
 * Created Date: 4/29/2020
 * Created Time: 4:45 PM
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HIOS {

    @Id
    private Long hiosId;

    private String hios;

    private String hiosName;

    @JsonIgnore
    @OneToMany(mappedBy = "hios")
    private List<TradingPartner> tradingPartners;
}
