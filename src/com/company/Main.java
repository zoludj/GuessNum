package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);

        boolean userWon = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Please, enter your guess:");
            int userNum = scan.nextInt();

            if (myNum > userNum) {
                System.out.println("My number is greater than yours");
            } else if (myNum < userNum) {
                System.out.println("My number is less than yours");
            } else {
                System.out.println("Yeah! You won!");
                userWon = true;
                break;
            }
        }

        if (!userWon) {
            System.out.println("Looser!");
        }
    }
}
