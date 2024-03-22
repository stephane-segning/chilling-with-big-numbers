package com.ssegning.math.number.impl;

import com.ssegning.math.number.model.Range;
import com.ssegning.math.number.operation.CheckPerfect;
import com.ssegning.math.number.operation.FindPerfectNumberInRange;
import com.ssegning.math.number.operation.OperationSupply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class FindPerfectNumberInRangeImpl implements FindPerfectNumberInRange {
    private final CheckPerfect checkPerfect;
    private final OperationSupply operationSupply;

    @Override
    public Collection<BigInteger> apply(Range range) {
        var res = Stream
                .iterate(range.start(), i -> i.compareTo(range.end()) <= 0, i -> i.add(BigInteger.ONE))
                .map(operationSupply.submit(i -> new DataHolder(checkPerfect.apply(i), i)))
                .map(CompletableFuture::join)
                .filter(DataHolder::isPerfect)
                .map(DataHolder::number)
                .collect(Collectors.toUnmodifiableSet());
        log.debug("Perfect numbers in range {}: {}", range, res);
        return res;
    }

    private record DataHolder(Boolean isPerfect, BigInteger number) {
    }
}
