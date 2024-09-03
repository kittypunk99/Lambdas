package streams;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class StreamsAdv {
    public static Set<Integer> lottoziehung() {
        Random random = new Random();
        Set<Integer> lottoNumbers = new TreeSet<>();
        IntStream.generate(() -> random.nextInt(45) + 1).distinct().limit(6).forEach(lottoNumbers::add);
        return lottoNumbers;
    }

    public static double berechnePI(int anzGlieder) {
        if (anzGlieder <= 0) {
            return -1.0;
        }
        double pi = IntStream.range(0, anzGlieder).mapToDouble(i -> Math.pow(-1, i) / (2 * i + 1)).sum();
        return pi * 4;
    }

    public static int zaehleZeichenAusVorrat(String text, String vorrat) {
        return (int) text.chars().filter(c -> vorrat.indexOf(c) != -1).count();
    }

    public static String createRandomString(String vorrat, int len) {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(vorrat.length())).limit(len).mapToObj(vorrat::charAt).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public static int[] deleteEquals(int[] ia) {
        return IntStream.of(ia).distinct().toArray();
    }


}
