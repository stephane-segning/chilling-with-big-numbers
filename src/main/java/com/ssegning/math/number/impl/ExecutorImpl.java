package com.ssegning.math.number.impl;

import com.ssegning.math.number.operation.OperationSupply;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.function.Function;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ExecutorImpl implements OperationSupply {
    public static final ExecutorImpl INSTANCE;

    static {
        var rpe = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        rpe.setRejectedExecutionHandler((r, executor) -> {
            log.error("Task {} rejected", r);
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        INSTANCE = new ExecutorImpl(rpe);
    }

    private final ExecutorService executor;

    public <T, R> Function<T, CompletableFuture<R>> submit(Function<T, R> fn) {
        return t -> CompletableFuture.supplyAsync(() -> fn.apply(t), executor);
    }
}
