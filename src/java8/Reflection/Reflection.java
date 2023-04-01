package java8.Reflection;

import java8.IO.InputOutput;
import java8.Meta.BankAccount;

public class Reflection {
    public Reflection() throws ClassNotFoundException {
    }

    public static void main(String[] args) {
//        showName(BankAccount);
    }
    // Example 1
    static void showName(Class<?> theClass) { // pass in the instance name of a class
        System.out.println(theClass.getSimpleName());
    }

    // Example 2
    void showName2(Class<?> theClass) throws ClassNotFoundException {
        Class<?> d = Class.forName("java8.collections.Main");
        showName(d);
    }

    // Example 3
    void showName3(Class<?> theClass) throws ClassNotFoundException {
        Class<?> e = InputOutput.class;
        showName(e);
    }

    void doWork(Object obj) {
        Class<?> c = obj.getClass();
        showName(c);
    }
}
