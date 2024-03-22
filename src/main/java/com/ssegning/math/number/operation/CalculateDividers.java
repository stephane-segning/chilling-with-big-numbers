package com.ssegning.math.number.operation;

import java.math.BigInteger;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.function.Function;

@FunctionalInterface
public interface CalculateDividers extends Function<BigInteger, Collection<BigInteger>> {
}
