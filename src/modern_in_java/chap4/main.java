package modern_in_java.chap4;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class main {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        //Quiz 5-1 Filtering
        List<Dish> twoMeat = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        //Quiz 5-2 Mapping

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(toList());

        squares.stream().forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());

        System.out.println("=======================5-3");
        //Quiz 5-3 reduce

        Optional<Integer> count = menu.stream().map(d -> 1).reduce((a, b) -> (a + b));
        count.ifPresent(System.out::println);

        long count2 = menu.stream().count();
        System.out.println(count2);

    }

}
