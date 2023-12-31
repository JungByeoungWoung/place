package com.market.place.utility;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class UtilityService {
    public String createTimeStamp() {
        LocalDateTime timeStamp = LocalDateTime.now();
        String parseTimeStamp = timeStamp.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return parseTimeStamp;
    }
}
