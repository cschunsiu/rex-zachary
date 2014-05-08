/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombiehunting;

import byui.cit260.zombiesHunting.model.Player;

/**
 *
 * @author ChunShing
 */
public class ZombieHunting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Bill");
        playerOne.setHealth(10.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
