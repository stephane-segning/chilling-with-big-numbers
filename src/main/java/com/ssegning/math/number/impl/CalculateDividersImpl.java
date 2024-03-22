package com.ssegning.math.number.impl;

import com.google.inject.Inject;
import com.ssegning.math.number.operation.CalculateDividers;
import com.ssegning.math.number.operation.OperationSupply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculateDividersImpl implements CalculateDividers {
    private final OperationSupply operationSupply;

    @Override
    public Collection<BigInteger> apply(BigInteger s) {
        var results = Stream
                .iterate(BigInteger.ONE, i -> i.compareTo(s.divide(BigInteger.TWO)) <= 0, i -> i.add(BigInteger.ONE))
                .map(operationSupply.submit(new DividerProvider(s)))
                .map(CompletableFuture::join)
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableSet());
        log.debug("Dividers of {}: {}", s, results);
        return results;
    }

    @Slf4j
    private record DividerProvider(BigInteger number) implements Function<BigInteger, BigInteger> {
        @Override
        public BigInteger apply(BigInteger possibleDivider) {
            log.trace("Checking if {} is a divider of {}", possibleDivider, number);
            if (number.mod(possibleDivider).equals(BigInteger.ZERO)) {
                return possibleDivider;
            }
            return null;
        }
    }
}
