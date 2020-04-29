package com.iason.trading.partner.web.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping(value="/initiative/{initiativeId}/trading-partners")
    public ResponseEntity<String> getTradingPartners(
            @PathVariable("initiativeId") String initiativeId);
}
