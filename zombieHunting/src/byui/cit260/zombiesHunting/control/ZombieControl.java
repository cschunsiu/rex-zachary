/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import java.util.Random;

/**
 *
 * @author ChunShing
 */
public class ZombieControl {
    
    public double calcDamage (double attackPt, double health){
        if (attackPt < 0){
            return -1;
        }
        if (health < 0){
            return -1;
        }
        
        double damage;
        
        //This is to determine if the zombie misses.
        Random hitChance = new Random();
        int hitRoll = hitChance.nextInt(10);
        
        if (hitRoll <= 3){
            damage = 0;
        }
        else{
            damage = attackPt * (health/100);
        }
        
        return damage;
    }
    
    public double calcMovementSpeed(double movementSpeed, double health){
        if (movementSpeed<0){
            return -1;
        }
        if (health <0){
            return -1;
        }
        double modifiedSpeed = movementSpeed*(health/100);
        return modifiedSpeed;
    }
    
}
