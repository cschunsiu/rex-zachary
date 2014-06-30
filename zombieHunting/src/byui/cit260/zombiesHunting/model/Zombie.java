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
    private int number;
    private int attackPt;
    private int speed;
    
    public Zombie() {
    }
    
    public Zombie(int attack){
        attackPt = attack;
    }
         
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
 
}
