package com.ssegning.math.number.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.ssegning.math.number.operation.CalculateDividers;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
class CalculateDividersImplTest {

    @Inject
    CalculateDividers calculateDividers;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new AppModule()).injectMembers(this);
    }

    @Test
    void apply_10() {
        var result = calculateDividers.apply(BigInteger.TEN);
        log.info("Dividers of 10: {}", result);
        assert result.contains(BigInteger.ONE);
        assert !result.contains(BigInteger.valueOf(7));
        assert result.contains(BigInteger.TWO);
        assert result.contains(BigInteger.valueOf(5));
        assert !result.contains(BigInteger.valueOf(10));
    }

    @Test
    void apply_7() {
        var result = calculateDividers.apply(BigInteger.valueOf(7));
        log.info("Dividers of 10: {}", result);
        assert result.contains(BigInteger.ONE);
        assert !result.contains(BigInteger.valueOf(7));
        assert !result.contains(BigInteger.TWO);
        assert !result.contains(BigInteger.valueOf(5));
    }
}