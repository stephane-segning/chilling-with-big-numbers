package com.ssegning.math.number.model;

import java.math.BigInteger;

public record Range(BigInteger start, BigInteger end) {
    public static Range of(BigInteger start, BigInteger end) {
        return new Range(start, end);
    }

    public static Range of(int start, int end) {
        return new Range(BigInteger.valueOf(start), BigInteger.valueOf(end));
    }
}
