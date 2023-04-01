package java8.Strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static void main(String[] args) throws IOException {
        String text = "This is the way...";

        joiner();
        edge();
        format(text);
        int Charles = 9;
        int Mel = 45;
        int Steven = 46;
        doWrite(Charles, Mel, Steven);
        regex();
    }

    private static void regex() {
        String s1 = "apple, apple and orange please";
        String s2 = s1.replace("ple,", "ricot,");
        System.out.println("Apricot: " + s2);

        String[] parts = s1.split("\\b");
        for (String thePart:parts)
            if(thePart.matches("\\w+"))
                System.out.println(thePart);

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s1);
        while (matcher.find())
            System.out.println(matcher.group());
    }

    private static void joiner() {
        StringJoiner sj = new StringJoiner("], [", "[", "]");
//        sj.add("Bob");
//        sj.add("Charles");
//        sj.add("Mel");

        sj.add("Bob").add("Charles").add("Mel");
        String res = sj.toString();
        System.out.println(res);
    }

    private static void edge() {
//        StringJoiner sj = new StringJoiner("");
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.setEmptyValue("Nothing");

//        sj.add("Bob");
//        sj.add("Charles");
//        sj.add("Mel");

//        sj.add("Bob").add("Charles").add("Mel");
        String res = sj.toString();
        System.out.println("Edge: " + res);
    }

    private static void format(String data) {
        int dave = 13, fred = 10, charles = 9;
        String nephews = String.format("My nephews are %d, %d and %d years old", charles, fred, dave);
        double avgDiff = ((dave - fred) + (fred - charles) + (dave - charles)) / 3.0d;
        String ageDiff = String.format("The average age between them is %.2f years.", avgDiff);
        System.out.println(nephews);
        System.out.println(ageDiff);

        String s1a = String.format("W:%4d X:%4d", 11, 2);
        String s1b = String.format("W:%4d X:%4d", 101, 202);
        System.out.println(s1a);
        System.out.println(s1b);

        String s1c = String.format("W:%04d X:%04d", 11, 2);
        String s1d = String.format("W:%04d X:%04d", 101, 202);
        System.out.println(s1c);
        System.out.println(s1d);

        String s1e = String.format("W:%-4d X:%-4d", 11, 2);
        String s1f = String.format("W:%-4d X:%-4d", 101, 202);
        System.out.println(s1e);
        System.out.println(s1f);

        String s3 = String.format("%,d", 123456789);
        System.out.println(s3);

        String s4 = String.format("%+d", 110);
        String s5 = String.format("%+d", -110);
        String s6 = String.format("% (d", 110);
        String s7 = String.format("% (d", -110);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }

    private static void doWrite(int Charles, int Mel, int Steven) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("family.txt"));
        try (Formatter f = new Formatter(writer)) {
            f.format("Our ages are %d, %d and %d", Charles,Mel, Steven);
        }
    }
}
