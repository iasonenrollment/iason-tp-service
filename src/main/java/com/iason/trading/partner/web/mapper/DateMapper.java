package com.iason.trading.partner.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: DateMapper
 * Inside the package - com.iason.trading.partner.web.mapper
 * Created Date: 5/21/2020
 * Created Time: 5:50 PM
 **/
@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateTime(Timestamp timestamp){
        if(timestamp!=null){
            return OffsetDateTime.of(timestamp.toLocalDateTime().getYear(),
                    timestamp.toLocalDateTime().getMonthValue(),
                    timestamp.toLocalDateTime().getDayOfMonth(),
                    timestamp.toLocalDateTime().getHour(),
                    timestamp.toLocalDateTime().getMinute(),
                    timestamp.toLocalDateTime().getSecond(),
                    timestamp.toLocalDateTime().getNano(),
                    ZoneOffset.UTC);
        }else{
            return null;
        }
    }

    public Timestamp asTimeStamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime!=null){
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }
        else{
            return null;
        }
    }
}
