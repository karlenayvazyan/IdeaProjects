package org.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by karlen on 5/29/16.
 */
public class Test2 {

    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;

        System.out.println(isEmpty.test(""));
    }
}
