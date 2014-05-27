package com.jp.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jalbert
 * Date: 5/27/14
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private Logger logger = LoggerFactory.getLogger(Game.class);
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

    public void setWinningDoorNumber(int winningDoorNumber) {
        this.winningDoorNumber = winningDoorNumber;
    }

    public int getLastChanceDoorNumber() {
        return lastChanceDoorNumber;
    }

    public void setLastChanceDoorNumber(int lastChanceDoorNumber) {
        this.lastChanceDoorNumber = lastChanceDoorNumber;
    }

    public int getSelectedDoorNumber() {
        return selectedDoorNumber;
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
    private void exposeAllButPrizeContainer() {

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

    private int getRandomInt(int maximum) {
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

    private void switchToLastChanceDoor() {
        if (logger.isDebugEnabled()) {
            logger.info("Contestant switched to the last-chance door!");
        }
        selectedDoorNumber = lastChanceDoorNumber;
    }

    /* Path A is where the contestant picks a door, and stays with their selection
     * even after being presented with one other door.
     */
    public void executePathA(int selectedDoorNumber) {
        this.setSelectedDoorNumber(selectedDoorNumber);
        this.exposeAllButPrizeContainer();
    }

    // Path B is where the contestant picks a door, then switches to the last-chance-door
    public void executePathB(int selectedDoorNumber) {
        this.executePathA(selectedDoorNumber);
        this.switchToLastChanceDoor();
    }
}
