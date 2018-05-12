package org.sample;

/**
 * Created by karlen on 5/29/16.
 */
public class Test1 {

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::parseInt;
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }
}

interface Converter<F, T> {
    T convert(F from);
}
