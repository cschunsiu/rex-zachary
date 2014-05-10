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
 * @author ChunShing
 */
public class Game implements Serializable{
    
    private String bestTime;
    private double bestZombieKill;

    public Game() {
    }

    public String getBestTime() {
        return bestTime;
    }

    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }

    public double getBestZombieKill() {
        return bestZombieKill;
    }

    public void setBestZombieKill(double bestZombieKill) {
        this.bestZombieKill = bestZombieKill;
    }

    @Override
    public String toString() {
        return "Game{" + "bestTime=" + bestTime + ", bestZombieKill=" + bestZombieKill + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.bestTime);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.bestZombieKill) ^ (Double.doubleToLongBits(this.bestZombieKill) >>> 32));
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.bestTime, other.bestTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bestZombieKill) != Double.doubleToLongBits(other.bestZombieKill)) {
            return false;
        }
        return true;
    }  
}
   