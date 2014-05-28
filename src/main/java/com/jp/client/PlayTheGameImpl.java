package com.jp.client;

import com.jp.entity.Game;

/**
 * Generic implementation of playing the game.  The contestant picks a random door number
 * <p/>
 * Created by jalbert on 5/28/2014.
 */
public class PlayTheGameImpl implements PlayTheGame {

    Game g;

    public void setG(Game g) {
        this.g = g;
    }

    @Override
    public boolean playTheGame() {
        g.setSelectedDoorNumber(g.getRandomInt(g.getNumberOfDoors()));
        g.exposeAllButPrizeContainer();
        return g.isWinner();
    }
}
