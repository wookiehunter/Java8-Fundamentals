package java8.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Buffered {
    static String[] data = {
            "Line 1",
            "Line 2 2",
            "Line 3 3 3",
            "Line 4 4 4 4",
            "Line 5 5 5 5 5"
    };
    public static void main(String[] args) throws IOException {
//        writeData(data);
//        readData();
//        newReadData();
        newReadAll();
    }


    static void writeData(String[] data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data3.txt"))) {
            for (String d:data) {
                writer.write(d);
                writer.newLine();
            }
        }
    }

    static void readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data3.txt"))) {
            String inValue;
            while ((inValue = reader.readLine()) != null) {
                System.out.println("Reading...");
                System.out.println(inValue);
            }
        }
    }

    static void newReadData() throws IOException {
        try  (BufferedReader br = Files.newBufferedReader(Paths.get("data3.txt"))) {
            String inValue;
            System.out.println("Reading...");
            while ((inValue = br.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }

    static void newReadAll() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data3.txt"));
        for (String line:lines)
            System.out.println(line);
    }
}
