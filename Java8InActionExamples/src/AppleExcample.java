import java.util.ArrayList;
import java.util.List;

public class AppleExcample {

    public static void main(String[] args) {

    }

    private static List<Apple> filter(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> appleList = new ArrayList<>(apples.size());
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }

    private static class Apple {
        public String color;
        public Integer weight;

        public Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }
    }

    private static List<Apple> createListOfApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red", 12));
        apples.add(new Apple("red", 17));
        apples.add(new Apple("red", 20));
        apples.add(new Apple("green", 60));
        apples.add(new Apple("green", 50));
        apples.add(new Apple("green", 12));
        apples.add(new Apple("blue", 12));
        apples.add(new Apple("black", 12));
        apples.add(new Apple("black", 14));
        apples.add(new Apple("black", 17));
        return apples;
    }
}
