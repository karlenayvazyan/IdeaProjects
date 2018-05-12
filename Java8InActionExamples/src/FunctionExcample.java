import java.util.function.Function;

public class FunctionExcample {

    public static void main(String[] args) {
        Function<String, Integer> function = s -> s.length();

        System.out.println(function.apply("str"));
    }
}
