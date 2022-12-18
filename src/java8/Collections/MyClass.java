package java8.Collections;

import org.jetbrains.annotations.NotNull;

public class MyClass implements Comparable<MyClass> {
    String label, value;
    public String toString() {return label + " | " + value;}

    public boolean equals(Object o) {
        MyClass other = (MyClass) o;
        return value.equalsIgnoreCase(other.value);
    }

    public int compareTo(MyClass other) {
        return value.compareToIgnoreCase(other.value);
    }
}
