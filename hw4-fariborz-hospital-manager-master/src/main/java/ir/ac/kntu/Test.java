package ir.ac.kntu;

import ir.ac.kntu.tool.DateTools;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        A oa = new B();
        System.out.println(oa instanceof B);
    }
}

class A {

}

class B extends A {

}