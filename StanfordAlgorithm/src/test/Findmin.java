package test;

import java.util.Scanner;

public class Findmin {
    public static void main(String args[]) {
        System.out.println("hello plesae give me 5 numbers: \n");
        int numbers[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int minNum = Integer.MAX_VALUE;
        String end = "";
        while (count < 5) {
            numbers[count] = Integer.parseInt(scanner.next());
            if (minNum > numbers[count]) {
                minNum = numbers[count];
            }
            count++;
        }
        System.out.println("The smallest number is  " + minNum);

    }
}