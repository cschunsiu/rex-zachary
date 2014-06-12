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
    private int attackPt;
    private int speed;

    public Zombie() {
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

    @Override
    public String toString() {
        return "Zombie{" + "zombieType=" + zombieType + ", attackPt=" + attackPt + ", speed=" + speed + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.zombieType);
        hash = 97 * hash + this.attackPt;
        hash = 97 * hash + this.speed;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zombie other = (Zombie) obj;
        if (!Objects.equals(this.zombieType, other.zombieType)) {
            return false;
        }
        if (this.attackPt != other.attackPt) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        return true;
    }


    
}
