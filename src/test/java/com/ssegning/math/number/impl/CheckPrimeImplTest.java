package com.ssegning.math.number.impl;

import com.ssegning.math.number.operation.CheckPrime;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.Executors;

class CheckPrimeImplTest {
    CheckPrime checkPrime = new CheckPrimeImpl(new CalculateDividersImpl(ExecutorImpl.INSTANCE));

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