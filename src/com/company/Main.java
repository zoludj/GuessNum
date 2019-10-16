package com.company;

import java.util.*;


public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static LeaderBoard LeaderBoard = new LeaderBoard();

    public static void main(String[] args) {
            LeaderBoard.loadResults ();

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
                    LeaderBoard.addResult(userName,i+1, finish-start);
                    System.out.println("Yeah! You won!");
                    userWon = true;
                    break;
                }
            }
            if (!userWon) {
                System.out.println("Looser!");
            }

        } while (askYesNo("Do you want to play again? (y/n)"));

        LeaderBoard.showResults();
        LeaderBoard.showResults ();


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
