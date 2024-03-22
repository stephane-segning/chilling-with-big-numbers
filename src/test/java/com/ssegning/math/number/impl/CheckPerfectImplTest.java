package com.ssegning.math.number.impl;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CheckPerfectImplTest {
    private final CheckPerfectImpl checkPerfect = new CheckPerfectImpl(new CalculateDividersImpl(ExecutorImpl.INSTANCE));

    @Test
    void apply_6() {
        assertTrue(checkPerfect.apply(BigInteger.valueOf(6)));
    }

    @Test
    void apply_28() {
        assertTrue(checkPerfect.apply(BigInteger.valueOf(28)));
    }

    @Test
    void apply_7() {
        assertFalse(checkPerfect.apply(BigInteger.valueOf(7)));
    }

    @Test
    void apply_100() {
        assertFalse(checkPerfect.apply(BigInteger.valueOf(100)));
    }
}