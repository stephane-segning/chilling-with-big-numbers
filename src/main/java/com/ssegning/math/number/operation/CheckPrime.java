package com.ssegning.math.number.operation;

import java.math.BigInteger;
import java.util.function.Function;

@FunctionalInterface
public interface CheckPrime extends Function<BigInteger, Boolean> {
}
