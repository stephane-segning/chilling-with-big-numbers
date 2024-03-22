package com.ssegning.math.number.impl;

import com.ssegning.math.number.model.Range;
import com.ssegning.math.number.operation.FindPerfectNumberInRange;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPerfectNumberInRangeImplTest {

    private final FindPerfectNumberInRange findPerfectNumberInRange = new FindPerfectNumberInRangeImpl(new CheckPerfectImpl(new CalculateDividersImpl(ExecutorImpl.INSTANCE)), ExecutorImpl.INSTANCE);

    @Test
    void apply_0_1000() {
        var res = findPerfectNumberInRange.apply(Range.of(BigInteger.ONE, BigInteger.valueOf(1000)));
        assertEquals(3, res.size());
    }

    @Test
    void apply_100_1000() {
        var res = findPerfectNumberInRange.apply(Range.of(BigInteger.valueOf(100), BigInteger.valueOf(1_000)));
        assertEquals(1, res.size());
    }

    @Test
    void apply_1000_20000() {
        var res = findPerfectNumberInRange.apply(Range.of(BigInteger.valueOf(1_000), BigInteger.valueOf(20_000)));
        assertEquals(1, res.size());
    }
}