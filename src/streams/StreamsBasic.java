package streams;

import java.util.stream.IntStream;

public class StreamsBasic {
    public static void zahlenreihen() {
        IntStream.rangeClosed(1, 25).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.iterate(1, i -> i + 2).limit(13).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.iterate(20, i -> i >= -20, i -> i - 5).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.iterate(1, i -> i <= 64, i -> i * 2).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.iterate(2, i -> i <= 128, i -> i * 2).map(i -> i + 1).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void printFolgeOhne3(int anz) {
        IntStream.iterate(3, i -> i + 1).filter(i -> i % 3 != 0).limit(anz).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void wuerfelStatistik(int augenzahl) {
        System.out.println((int) IntStream.rangeClosed(1, 1000).map(i -> (int) (Math.random() * 6) + 1).filter(i -> i == augenzahl).count());
    }

    public static void alleTeiler(int zahl) {
        IntStream.rangeClosed(1, zahl).filter(i -> zahl % i == 0).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static boolean istPrimzahl(int zahl) {
        return IntStream.rangeClosed(2, zahl / 2).noneMatch(i -> zahl % i == 0);
    }

    public static int gaussSumme(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

    public static void verticalString(String str) {
        str.chars().forEach(c -> System.out.println((char) c));
    }

    public static void mitStern(String str) {
        str.chars().forEach(c -> System.out.print((char) c + "*"));
        System.out.println();
    }

    public static void deleteBlanks(String str) {
        str.chars().filter(c -> c != ' ').forEach(c -> System.out.print((char) c));
        System.out.println();
    }

    public static boolean enthaeltZiffern(String str) {
        return str.chars().anyMatch(Character::isDigit);
    }
}
