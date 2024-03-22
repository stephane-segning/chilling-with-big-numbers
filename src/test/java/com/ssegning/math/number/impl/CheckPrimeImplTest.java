package com.ssegning.math.number.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.ssegning.math.number.operation.CheckPrime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
class CheckPrimeImplTest {

    @Inject
    CheckPrime checkPrime;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new AppModule()).injectMembers(this);
    }

    @Test
    void apply_10() {
        assert !checkPrime.apply(BigInteger.TEN);
    }

    @Test
    void apply_7() {
        assert checkPrime.apply(BigInteger.valueOf(7));
    }

    @Test
    void apply_31() {
        assert checkPrime.apply(BigInteger.valueOf(31));
    }
}