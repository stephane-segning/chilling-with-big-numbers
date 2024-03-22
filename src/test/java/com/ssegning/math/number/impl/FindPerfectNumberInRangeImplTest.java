package com.ssegning.math.number.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.ssegning.math.number.model.Range;
import com.ssegning.math.number.operation.FindPerfectNumberInRange;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class FindPerfectNumberInRangeImplTest {
    @Inject
    FindPerfectNumberInRange findPerfectNumberInRange;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new AppModule()).injectMembers(this);
    }

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

}