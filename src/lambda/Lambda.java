package lambda;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lambda {
    public static void print(Collection<?> collection) {
        collection.forEach(System.out::println);
    }

    public static Collection<String> hauptworte(Collection<String> collection) {
        return collection.stream().filter(Objects::nonNull).filter(s -> s.matches("\\p{javaUpperCase}\\p{javaLetter}*")).toList();
    }

    public static List<Double> mult(List<Double> zahlen, double faktor) {
        return zahlen.stream().mapToDouble(zahl -> zahl * faktor).boxed().toList();
    }

    public static List<Double> func(List<Double> zahlen, UnaryOperator<Double> op) {
        return zahlen.stream().mapToDouble(op::apply).boxed().toList();
    }

    public static List<String> numerisch(String... elements) {
        List<String> numericList = Arrays.stream(elements)
                .filter(e -> e.matches("-?\\d+"))
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .toList();

        List<String> stringList = Arrays.stream(elements)
                .filter(e -> !e.matches("-?\\d+"))
                .sorted()
                .toList();

        List<String> result = new ArrayList<>(numericList);
        result.addAll(stringList);

        return result;
    }

}