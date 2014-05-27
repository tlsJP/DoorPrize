package com.jp.client;


import com.jp.entity.Game;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jalbert
 * Date: 5/27/14
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static Random r = new Random();

    public static void main(String[] args) {

        int numberOfDoors = 4;
        int numberOfWins = 0;
        int numberOfGames = 1000;

        for (int i = 0; i < numberOfGames; i++) {
            Game g = new Game(numberOfDoors);
            g.executePathB(r.nextInt(numberOfDoors));
            if (g.isWinner()) {
                numberOfWins++;
            }
        }

        System.out.println("Number of wins : " + numberOfWins + "/" + numberOfGames);
        System.out.println("Win rate : " + (double) numberOfWins / numberOfGames * 100);

    }

    public int doPathA(int numberOfDoors, int numberOfGames) {
        int wins = 0;
        for (int i = 0; i < numberOfGames; i++) {
            Game g = new Game(numberOfDoors);
            g.executePathA(numberOfDoors);
            if (g.isWinner()) {
                wins++;
            }

        }
        return wins;
    }

    public int doPathB(int numberOfDoors, int numberOfGames) {
        int wins = 0;
        for (int i = 0; i < numberOfGames; i++) {
            Game g = new Game(numberOfDoors);
            g.executePathB(numberOfDoors);
            if (g.isWinner()) {
                wins++;
            }

        }
        return wins;
    }

}
