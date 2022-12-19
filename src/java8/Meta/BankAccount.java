package java8.Meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class BankAccount {
    // customer annotation
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DoSomething {
        boolean useThreadPool() default true;
    }
    // usage = @DoSomething(useThreadPool = true/false)
    private final String id;
    private int balance = 0;
    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    };
    public String getId() {
        return null;
    };
    public synchronized int getBalance() {
        return 0;
    };
    public synchronized void deposit() {

    };
    public synchronized void withdrawel() {

    };

    @Override
    public String toString() {
        return String.format(getId() + ": " + getBalance());
    }

    private void custom() {

    }

}
