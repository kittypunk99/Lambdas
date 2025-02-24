package streams;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentStatistic {
    private final List<Student> students;

    public StudentStatistic(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            this.students = reader.lines().skip(1).map(Student::new).toList();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStudentsFromDepartment(String department) {
        return students.stream().filter(s -> s.dep.equals(department)).toList().size();
    }

    public int getAmountOfClasses() {
        return (int) students.stream().map(s -> s.klasse).distinct().count();
    }

    public int getAverageClassSize() {
        return students.size()/getAmountOfClasses();
    }

    public int[] birthdaysPerMonth() {
        int[] birthdays = new int[12];
        students.stream().map(s -> s.bd).forEach(bd -> birthdays[Integer.parseInt(bd.substring(3, 5)) - 1]++);
        return birthdays;
    }
    public int classesWithStudentsWithSameBirthday() {
        HashMap<String, Integer> birthdays = new HashMap<>();
        students.stream().map(s -> s.bd).forEach(bd -> birthdays.put(bd, birthdays.getOrDefault(bd, 0) + 1));
        return (int) birthdays.values().stream().filter(v -> v > 1).count();
    }

    public void printStatistik(){
        System.out.println("Anzahl der Schüler: " + students.size());
        System.out.println("Anzahl der Klassen: " + getAmountOfClasses());
        System.out.println("Durchschnittliche Klassengröße: " + getAverageClassSize());
        System.out.println("Geburtstage pro Monat: " + Arrays.toString(birthdaysPerMonth()));
        System.out.println("Anzahl der Klassen mit Schülern mit gleichem Geburtstag: " + classesWithStudentsWithSameBirthday());
        System.out.println("Anzahl der Schüler aus der guten Abteilung: " + getStudentsFromDepartment("IT"));
        System.out.println("Anzahl der Schüler aus der Mechatronik: " + getStudentsFromDepartment("ME"));
    }

    private static class Student {
        public final String name;
        public final String klasse;
        public final String bd;
        public final String dep;

        public Student(String csvLine) {
            String[] parts = csvLine.split(";");
            this.name = parts[0].strip() + " " + parts[1].strip();
            this.klasse = parts[2];
            this.bd = parts[3];
            this.dep = parts[4];
        }
    }
}
