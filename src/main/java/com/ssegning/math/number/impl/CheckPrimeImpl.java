package com.ssegning.math.number.impl;

import com.ssegning.math.number.operation.CalculateDividers;
import com.ssegning.math.number.operation.CheckPrime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
@RequiredArgsConstructor
public class CheckPrimeImpl implements CheckPrime {
    private final CalculateDividers calculateDividers;

    @Override
    public Boolean apply(BigInteger number) {
        var dividers = calculateDividers.apply(number);
        var res = dividers.size() == 1;
        log.debug("{} is prime: {}", number, res);
        return res;
    }
}
