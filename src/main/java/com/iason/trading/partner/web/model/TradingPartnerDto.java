package com.iason.trading.partner.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerDto
 * Inside the package - com.iason.trading.partner.web
 * Created Date: 5/4/2020
 * Created Time: 4:23 PM
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradingPartnerDto implements Serializable {

    static final long serialVersionUID = 8132975155364968911L;

    @Null
    private Long tradingPartnerId;

    @NotNull
    @NotBlank
    private String tradingPartnerDesc;

    @NotNull
    @NotBlank
    @Size(min=3, max=100)
    private String tradingPartner;

    @NotBlank
    @Size(max=2)
    private String stateCode;

    @NotBlank
    @Size(min=3, max=10)
    private String hios;

    @NotEmpty
    private List<TransactionSourceDto> transactionSourceDtos;

    @Null
    //@JsonFormat(pattern = "yyyy-mm-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    //@JsonFormat(pattern = "yyyy-mm-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;
}
