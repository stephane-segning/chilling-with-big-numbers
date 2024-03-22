package com.ssegning.math.number.operation;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface OperationSupply {
    <T, R> Function<T, CompletableFuture<R>> submit(Function<T, R> supplier);
}
