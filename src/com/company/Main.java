package com.company;

import javax.xml.namespace.QName;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<GameResult> users = new ArrayList<>();

    public static void main(String[] args) {

        do {
            String userName = askString("Enter your name");

            int myNum = rand.nextInt(100) + 1;
            System.out.println((myNum));
            boolean userWon = false;

            long start = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {
                int userNum = askInt("Please, enter your guess:", 1, 100);


                if (myNum > userNum) {
                    System.out.println("My number is greater than yours");
                } else if (myNum < userNum) {
                    System.out.println("My number is less than yours");
                } else {

                    long finish = System.currentTimeMillis();
                    GameResult r = new GameResult();
                    r.name = userName;
                    r.triesCount = i + 1;
                    r.gameplay =finish-start;
                    users.add(r);
                    System.out.println("Yeah! You won!");
                    userWon = true;
                    break;
                }
            }
            if (!userWon) {
                System.out.println("Looser!");
            }

        } while (askYesNo("Do you want to play again? (y/n)"));

        users.sort(Comparator.comparing(r->r.triesCount));


        for (GameResult result : users) {

            System.out.printf("%s \t\t\t %d %d\n", result.name, result.triesCount, result.gameplay/1000);

        }
        System.out.println("Goodbye!");
    }


    private static String askString(String msg) {
        System.out.println(msg);
        return scan.next();
    }

    static int askInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int answer = scan.nextInt();
                if (answer >= min && answer <= max) {
                    return answer;
                }
            } catch (InputMismatchException ex) {
                System.out.println("It isn't a number!");
                scan.next();
            }
            System.out.printf("Please enter number from %d to %d\n", min, max);

        }
    }


    static boolean askYesNo(String msg) {
        while (true) {
            System.out.println(msg);
            String answer = scan.next();
            boolean isY = answer.equalsIgnoreCase("y");
            boolean isN = answer.equalsIgnoreCase("n");
            if (isY || isN) {
                return isY;
            }
            System.out.println("Enter 'y' or 'no' ");
        }
    }
}
