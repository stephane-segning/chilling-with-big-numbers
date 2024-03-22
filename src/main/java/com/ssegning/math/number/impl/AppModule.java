package com.ssegning.math.number.impl;

import com.google.inject.AbstractModule;
import com.ssegning.math.number.operation.*;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CalculateDividers.class).to(CalculateDividersImpl.class);
        bind(CheckPerfect.class).to(CheckPerfectImpl.class);
        bind(CheckPrime.class).to(CheckPrimeImpl.class);
        bind(FindPerfectNumberInRange.class).to(FindPerfectNumberInRangeImpl.class);
        bind(OperationSupply.class).to(ExecutorImpl.class);
    }
}
