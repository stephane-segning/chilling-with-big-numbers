package com.ssegning.math.number.impl;

import com.google.inject.Inject;
import com.ssegning.math.number.operation.CalculateDividers;
import com.ssegning.math.number.operation.CheckPerfect;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CheckPerfectImpl implements CheckPerfect {
    private final CalculateDividers calculateDividers;

    @Override
    public Boolean apply(BigInteger bigInteger) {
        var dividers = calculateDividers.apply(bigInteger);
        var sum = dividers.stream().reduce(BigInteger.ZERO, BigInteger::add);
        var res = sum.equals(bigInteger);
        log.debug("{} is perfect: {}", bigInteger, res);
        return res;
    }
}
