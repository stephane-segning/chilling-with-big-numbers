package com.ssegning.math.number;


import com.ssegning.math.number.impl.*;
import com.ssegning.math.number.operation.*;

public class Main {
    public static void main(String[] args) {
        OperationSupply operationSupply = ExecutorImpl.INSTANCE;
        CalculateDividers calculateDividers = new CalculateDividersImpl(operationSupply);
        CheckPrime checkPrime = new CheckPrimeImpl(calculateDividers);
        CheckPerfect checkPerfect = new CheckPerfectImpl(calculateDividers);
        FindPerfectNumberInRange findPerfectNumberInRange = new FindPerfectNumberInRangeImpl(checkPerfect, operationSupply);

        // TODO Do the inputs in a cool way
    }
}
