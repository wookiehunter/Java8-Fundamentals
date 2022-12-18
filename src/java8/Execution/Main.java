package java8.Execution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.print(args[0] + " " + args[1] + " " + args[2]);
        if(args.length < 1)
            System.out.print("No args provided");
        else {
            for (String word:args)
                System.out.println(word);
        }

        properties();
        getProps();
        propsXML();
        getPropsXML();
        sysProps();
        envVariables();
    }

    private static void properties() {
        Properties props = new Properties();

        props.setProperty("name", "Steven Godson");
        props.setProperty("role", "Developer");

        try(Writer writer = Files.newBufferedWriter(Paths.get("steven.properties"))) {
            props.store(writer, "What a gent");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getProps() {
        Properties props = new Properties();

        try(Reader reader = Files.newBufferedReader(Paths.get("steven.properties"))) {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String name = props.getProperty("name");
        String role = props.getProperty("role");

        System.out.println(name + " is an awesome " + role);
    }

    private static void propsXML() throws IOException {
        Properties props = new Properties();

        props.setProperty("name", "Steven Godson");
        props.setProperty("role", "Developer");

        try(OutputStream out = Files.newOutputStream(Paths.get("steven.xml"))) {
            props.storeToXML(out, "Geezer");
        }
    }

    private static void getPropsXML() throws IOException {
        Properties props = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("steven.xml"))) {
            props.loadFromXML(in);
        }

        String name = props.getProperty("name");
        String role = props.getProperty("role");

        System.out.println(name + " is an awesome " + role);
    }

    private static void sysProps() {
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String osArch = System.getProperty("os.arch");
        String javaVendor = System.getProperty("java.vendor");

        System.out.println(userName + " " + userHome + " " + osArch + " " + javaVendor);
    }

    private static void envVariables() {
        String compName = System.getenv("COMPUTERNAME");
        String sysRoot = System.getenv("SystemRoot");

        System.out.println(compName + " " + sysRoot);
    }
}
