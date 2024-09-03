package tests;

import lambda.Lambda;
import streams.*;

import java.util.ArrayList;
import java.util.List;



public class Tests {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Hugo", "HTL", "HTL3R", "", "Haus-Boot", "SEW", "Softwareentwicklung"));
        list.add(null);
        System.out.println(Lambda.hauptworte(list));
        System.out.println(Lambda.mult(List.of(1.0, 2.0, 3.0, 4.0, 5.0), 2.0));
        System.out.println(Lambda.func(List.of(1.0, 2.0, 3.0, 4.0, 5.0), Math::sqrt));
        System.out.println(Lambda.numerisch("12", "Wappler", "8", "-5", "8", "Hugo", "-6", "-10", "Hugo", "-10", "7"));
        System.out.println("------------------------");
        StreamsBasic.zahlenreihen();
        StreamsBasic.printFolgeOhne3(10);
        StreamsBasic.wuerfelStatistik(3);
        StreamsBasic.alleTeiler(12);
        System.out.println(StreamsBasic.istPrimzahl(13));
        System.out.println(StreamsBasic.gaussSumme(100));
        StreamsBasic.verticalString("Hallo Welt");
        StreamsBasic.mitStern("Hallo Welt");
        StreamsBasic.deleteBlanks("Hallo Welt");
        System.out.println(StreamsBasic.enthaeltZiffern("Hallo Welt"));
        System.out.println(StreamsBasic.enthaeltZiffern("Hallo Welt 123"));
        System.out.println("------------------------");
        System.out.println(StreamsAdv.berechnePI(-5));
        System.out.println(StreamsAdv.berechnePI(1));
        System.out.println(StreamsAdv.berechnePI(2));
        System.out.println(StreamsAdv.berechnePI(3));
        System.out.println(StreamsAdv.berechnePI(1001));
        System.out.println(StreamsAdv.zaehleZeichenAusVorrat("Hallo 1AI" , "aeiou"));
        System.out.println(StreamsAdv.zaehleZeichenAusVorrat ("*code*123#" , "?%*!#$"));
        System.out.println(StreamsAdv.createRandomString("1234",5));
        System.out.println("------------------------");
        StudentStatistic studentStatistics = new StudentStatistic("ressources/students.csv");
        studentStatistics.printStatistik();


    }
}
