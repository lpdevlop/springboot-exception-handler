package com.exceptionhandler.springbootexceptionhandler.utill;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtils {

    public static Instant getCurrentUTCTime() {
        return Instant.now();
    }
}

