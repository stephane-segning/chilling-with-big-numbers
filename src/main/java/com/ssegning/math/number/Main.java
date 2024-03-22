package com.ssegning.math.number;

import com.google.inject.Guice;
import com.google.inject.Stage;
import com.ssegning.math.number.impl.AppModule;
import com.ssegning.math.number.model.Range;
import com.ssegning.math.number.operation.FindPerfectNumberInRange;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var app = Guice.createInjector(Stage.PRODUCTION, new AppModule());

        var operation = app.getInstance(FindPerfectNumberInRange.class);

        while (true) {
            var scanner = new Scanner(System.in);
            var start = scanner.nextInt();
            var end = scanner.nextInt();
            log.info("Perfect numbers between [{} - {}]: {}", start, end, operation.apply(Range.of(start, end)));
        }
    }
}
