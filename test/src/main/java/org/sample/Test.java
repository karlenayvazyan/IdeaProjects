package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Test {

    private List<String> names;

    @Setup
    public void setUp() {
        names = Arrays.asList("peter", "anna", "mike", "xenia");
    }

    @Benchmark
    public void lambda() {
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }

    @Benchmark
    public void noLambda() {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}