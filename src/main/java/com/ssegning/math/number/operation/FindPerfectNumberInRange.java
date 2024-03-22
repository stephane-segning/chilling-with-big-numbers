package com.ssegning.math.number.operation;

import com.ssegning.math.number.model.Range;

import java.math.BigInteger;
import java.util.Collection;
import java.util.function.Function;

@FunctionalInterface
public interface FindPerfectNumberInRange extends Function<Range, Collection<BigInteger>> {
}
