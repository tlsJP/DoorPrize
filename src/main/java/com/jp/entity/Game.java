package com.jp.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Basic structure for a Game That has x number of doors.  a contestant can pick
 * a door that may have a prize behind it.  All but one other remaining door is
 * exposed, leaving the contestant with an option to switch to the other door.
 *
 * Created with IntelliJ IDEA.
 * User: jalbert
 * Date: 5/27/14
 * Time: 1:13 PM
 */
public class Game {

    private Logger logger = LoggerFactory.getLogger(Game.class);

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    private int numberOfDoors;
    private int winningDoorNumber;
    private int lastChanceDoorNumber;
    private int selectedDoorNumber;

    public Game(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        winningDoorNumber = getRandomInt(numberOfDoors);

        if (logger.isDebugEnabled()) {
            logger.info("Winning door number : " + winningDoorNumber);
        }

    }

    public int getWinningDoorNumber() {
        return winningDoorNumber;
    }

    public void setSelectedDoorNumber(int selectedDoorNumber) {
        if (logger.isDebugEnabled()) {
            logger.info("Contestant picked door number " + selectedDoorNumber);
        }
        this.selectedDoorNumber = selectedDoorNumber;
    }

    /* This method simulates exposing all remaining doors to the contestant except for one.
     * This door is the contestant's last chance to switch to in an attempt to win the prize.
     */
    public void exposeAllButPrizeContainer() {

        /* If the selected door number is the winning door number, then any other door number will suffice
         * as the lat chance door number
         */
        if (selectedDoorNumber == winningDoorNumber) {
            do {
                lastChanceDoorNumber = getRandomInt(numberOfDoors);
            } while (lastChanceDoorNumber == selectedDoorNumber);
            // If the selected door is not the winner, then the last chance door must be set to the winning door
        } else {
            lastChanceDoorNumber = winningDoorNumber;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("The last chance door number is " + lastChanceDoorNumber);
        }
    }

    public int getRandomInt(int maximum) {
        Random r = new Random();
        return r.nextInt(maximum);
    }

    public boolean isWinner() {
        boolean winner = selectedDoorNumber == winningDoorNumber;

        if (logger.isDebugEnabled()) {
            logger.debug("The contestant wins? " + winner);
        }
        return winner;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public void switchToLastChanceDoor() {
        if (logger.isDebugEnabled()) {
            logger.info("Contestant switched to the last-chance door!");
        }
        selectedDoorNumber = lastChanceDoorNumber;
    }


}
