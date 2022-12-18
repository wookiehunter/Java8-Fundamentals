package java8.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // basic();
        // hash();
        sorted();
    }

    private static void basic() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Steak");
        list1.add("Chips");
        list1.add("Sausages");

        for(String o:list1)
            System.out.println(o);

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Sauce");
        list2.add("Mac & Cheese");
        list2.add("Fried Eggs");

        list1.addAll(list2);
        for(String o:list1)
            System.out.println(o);

        System.out.println(list1.contains("Fried Eggs"));
        list1.remove("Fried Eggs");
        System.out.println(list1.contains("Fried Eggs"));
    }

    private static void hash() {
        Map<String, String> map = new HashMap<>();

        map.put("222", "ghi");
        map.put("333", "abc");
        map.put("111", "def");

        String s1 = map.get("333");
        String s2 = map.get("999");
        String s3 = map.getOrDefault("999", "Default");
        System.out.println(s1 + " - " + s2 + " - " + s3);

        map.forEach((k, v) -> System.out.println(k + " | " + v));
        map.replaceAll((k,v) -> v.toUpperCase());
        map.forEach((k, v) -> System.out.println(k + " | " + v));
    }

    private static void sorted() {
        SortedMap<String, String> map = new TreeMap<>();

        map.put("222", "ghi");
        map.put("333", "abc");
        map.put("111", "def");
        map.put("444", "jkl");
        map.put("666", "mno");
        map.put("555", "pqr");

        map.forEach((k, v) -> System.out.println(k + " | " + v));

        System.out.println();

        SortedMap<String, String> hMap = map.headMap("333");
        hMap.forEach((k, v) -> System.out.println(k + " | " + v));

        System.out.println();

        SortedMap<String, String> tMap = map.tailMap("333");
        tMap.forEach((k, v) -> System.out.println(k + " | " + v));


    }
}
