package com.iason.trading.partner.web.apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iason.trading.partner.web.TradingPartnerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TradingPartnerAPIs
 * Inside the package - com.iason.trading.partner.web.apis
 * Created Date: 4/29/2020
 * Created Time: 3:52 PM
 **/
@Tag(name = "Iason Trading Partner", description = "APIs for Trading Partner")
public interface TradingPartnerAPIs {

    @Operation(
            summary = "Get Trading Partners",
            description = "Find the list of trading partners for the initiative",
//            tags = {
//                    "product"
//            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully Retrieved Trading Partners",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = String.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping(value="/initiative/{initiativeId}/trading-partners",
                produces = {"application/json"})
    ResponseEntity<String> getTradingPartners(
            @PathVariable("initiativeId") String initiativeId) throws JsonProcessingException;

    @Operation(
            summary = "Create Trading Partners",
            description = "Create a new Trading Partner for the state",
//            tags = {
//                    "product"
//            },
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Trading Partner Created"
                    )
            }
    )
    @PostMapping(value="/trading-partners",
                 consumes = {"application/json"})
    ResponseEntity createTradingPartner(@Valid @RequestBody TradingPartnerDto tradingPartnerDto);
}
