package com.market.place.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
public class UtilityTest {

    @Test
    @DisplayName("날짜 형식 변환 테스트")
    public void createDate() {
        LocalDateTime timeStamp = LocalDateTime.now();
        String parseTimeStamp = timeStamp.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        log.info("TME STAMP >>>>>>> {}",parseTimeStamp);
    }
}
