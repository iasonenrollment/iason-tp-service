package com.iason.trading.partner.web.mapper;

import com.iason.trading.partner.domain.TransactionSource;
import com.iason.trading.partner.web.model.TransactionSourceDto;
import org.mapstruct.Mapper;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TransactionSourceMapper
 * Inside the package - com.iason.trading.partner.web.mapper
 * Created Date: 5/21/2020
 * Created Time: 6:18 PM
 **/
@Mapper(uses = {DateMapper.class})
public interface TransactionSourceMapper {

    TransactionSource transactionSourceDtoToTransactionSource(TransactionSourceDto transactionSourceDto);
    TransactionSourceDto transactionSourceToTransactionSourceDto(TransactionSource transactionSource);
}
