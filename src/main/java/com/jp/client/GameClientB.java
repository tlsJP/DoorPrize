package com.jp.client;

/**
 * This is a game client that has the contestant switch to the other door
 * <p/>
 * Created by jalbert on 5/28/2014.
 */
public class GameClientB extends PlayTheGameImpl {

    @Override
    public boolean playTheGame() {
        g.setSelectedDoorNumber(g.getRandomInt(g.getNumberOfDoors()));
        g.exposeAllButPrizeContainer();
        g.switchToLastChanceDoor();
        return g.isWinner();
    }
}
