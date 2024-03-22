package com.ssegning.math.number.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.ssegning.math.number.operation.CheckPerfect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class CheckPerfectImplTest {

    @Inject
    CheckPerfect checkPerfect;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new AppModule()).injectMembers(this);
    }

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