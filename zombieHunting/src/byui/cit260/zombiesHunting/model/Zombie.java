/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Zach
 */
public class Zombie implements Serializable {
    private String zombieType;
    private String description;
    
    private int columnPosition;
    private int rowPosition;
    private int roomPosition;
    /*****************************
     * Cycle parameters:
     * 0 - forward movement
     * 1 - backward movement
     *****************************/
    private int cycle;
    private String script;
    
    
    private int attackPt;
    private int speed;
    private int number;
    
    public Zombie() {
        cycle = 0;
    }
    
    public Zombie(int row, int column, int room, String nScript){
        rowPosition = row;
        columnPosition = column;
        roomPosition = room;
        script = nScript;
        cycle = 0;
    }
    
    public Zombie(int attack){
        attackPt = attack;
    }

    public int getRoomPosition() {
        return roomPosition;
    }

    public void setRoomPosition(int roomPosition) {
        this.roomPosition = roomPosition;
    }
    
    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
    
    public int getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZombieType() {
        return zombieType;
    }

    public void setZombieType(String zombieType) {
        this.zombieType = zombieType;
    }

    public int getAttackPt() {
        return attackPt;
    }

    public void setAttackPt(int attackPt) {
        this.attackPt = attackPt;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
 
}
