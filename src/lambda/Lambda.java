package lambda;

import java.util.*;
import java.util.function.UnaryOperator;

public class Lambda {
    public static void print(Collection<?> collection) {
        collection.forEach(System.out::println);
    }

    public static Collection<String> hauptworte(Collection<String> collection) {
        return collection.stream().filter(Objects::nonNull).filter(s -> s.matches("[A-ZÄÖÜ][a-zA-ZÄÖÜäöüß]*")).toList();

    }

    public static List<Double> mult(List<Double> zahlen, double faktor) {
        return zahlen.stream().mapToDouble(zahl -> zahl * faktor).boxed().toList();
    }

    public static List<Double> func(List<Double> zahlen, UnaryOperator<Double> op) {
        return zahlen.stream().mapToDouble(op::apply).boxed().toList();
    }

    public static List<String> numerisch(String... elements) {
        List<Integer> numericList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for (String element : elements) {
            if (element.matches("-?\\d+")) {
                numericList.add(Integer.parseInt(element));
            } else {
                stringList.add(element);
            }
        }

        Collections.sort(numericList);
        Collections.sort(stringList);

        List<String> result = new ArrayList<>();
        for (Integer num : numericList) {
            result.add(num.toString());
        }
        result.addAll(stringList);

        return result;
    }

}