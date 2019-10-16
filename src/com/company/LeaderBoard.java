package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LeaderBoard {
    private ArrayList <GameResult> results = new ArrayList<>();
    public  void addResult (String name, int tries,long time) {
        GameResult r = new GameResult();
        r.setName(name);
        r.setTriesCount(tries);
        r.setGamePlay(time);
        results.add (r);
    }
    public void loadResults () {
        File file = new File("leader_board.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                String name = in.next();
                int tries = in.nextInt();
                long time = in.nextLong();

            }
        }catch (IOException e) {
            System.out.println("Cannot read leader board");
        }
    }

    public void saveResults () {
        File file = new File("leader_board.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (GameResult r : results) {
                out.print(r.getName());
                out.print(" ");
                out.print(r.getTriesCount());
                out.print(" ");
                out.print(r.getGamePlay());
            }
        } catch (IOException e) {
            System.out.println("Cannot save leader board");
        }
    }
    public void showResults (){
        results.stream()
                .sorted(Comparator.comparingInt(GameResult::getTriesCount)
                        .thenComparing(GameResult::getGamePlay))
                .limit (5)
                .forEach(r-> System.out.printf("%s \t\t\t %d \t\t\t %d\n",
                        r.getName(),
                        r.getTriesCount(),
                        r.getGamePlay()/1000));


    }
}
