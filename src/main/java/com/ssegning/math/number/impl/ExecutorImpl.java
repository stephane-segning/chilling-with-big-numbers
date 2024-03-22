package com.ssegning.math.number.impl;

import com.google.inject.Singleton;
import com.ssegning.math.number.operation.OperationSupply;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.function.Function;

@Slf4j
@Getter
@Singleton
public class ExecutorImpl implements OperationSupply {
    private final ExecutorService executor;

    {
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

        this.executor = rpe;
    }

    public <T, R> Function<T, CompletableFuture<R>> submit(Function<T, R> fn) {
        return t -> CompletableFuture.supplyAsync(() -> fn.apply(t), executor);
    }
}
