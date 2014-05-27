package com.jp.entities;


import com.jp.entity.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: jalbert
 * Date: 5/27/14
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {

    static int numberOfDoors = 4;
    Game g;

    @Before
    public void setup() {
        g = new Game(numberOfDoors);
    }

    @Test
    public void constructor() {
        assertNotNull(g);
        System.out.println(g);
        assertTrue(g.getWinningDoorNumber() <= numberOfDoors);
    }

    @Test
    public void selectDoor() {
        System.out.println(g);
        g.setSelectedDoorNumber(1);
        System.out.println(g);
    }

    @Test
    public void pathA(){
        System.out.println(g);
        g.executePathA(1);
        System.out.println(g);
        System.out.println("Winning door selected : " + g.isWinner());
    }

    @Test
    public void pathB() {
        System.out.println(g);
        g.executePathB(1);
        System.out.println(g);
        System.out.println("Winning door selected : " + g.isWinner());
    }
}
