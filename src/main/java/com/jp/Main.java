package com.jp;

import com.jp.client.GameClientA;
import com.jp.client.GameClientB;
import com.jp.client.PlayTheGame;
import com.jp.client.PlayTheGameImpl;
import com.jp.entity.Game;

/**
 * Created by jalbert on 5/28/2014.
 */
public class Main {

    public static final int NUMBER_OF_DOORS = 3;
    public static final int NUMBER_OF_GAMES_TO_PLAY = 10000;
    public static int numberOfWins = 0;

    public static void main(String[] args) {

        PlayTheGame gameA = new GameClientA();
        doTheGame(gameA);

        numberOfWins = 0;
        PlayTheGame gameB = new GameClientB();
        doTheGame(gameB);

    }

    public static void doTheGame(PlayTheGame ga) {
        for (int i = 0; i < NUMBER_OF_GAMES_TO_PLAY; i++) {
            ((PlayTheGameImpl) ga).setG(new Game(NUMBER_OF_DOORS));
            boolean win = ga.playTheGame();
            if (win) {
                numberOfWins++;
            }

        }
        System.out.println("number of wins : " + numberOfWins + "/" + NUMBER_OF_GAMES_TO_PLAY);
        System.out.println("Win rate : " + (double) numberOfWins / NUMBER_OF_GAMES_TO_PLAY * 100);
    }

}
