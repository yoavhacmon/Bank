package OOP.constructor.Bank;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner iput = new Scanner(System.in);
        Private yoav = new Private(12345, 20_000, "Yoav");
        System.out.println(yoav.toString());
    }
}
