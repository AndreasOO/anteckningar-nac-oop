package OOP.Sprint2.Uppgift13a_b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put in an equation with one operator");

        String input = scanner.nextLine();

        Calculator calc = new Calculator(input);
        calc.execute();



    }
}
