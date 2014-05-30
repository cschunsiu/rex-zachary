/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Player;

/**
 *
 * @author Computer
 */
public class ProgramControl {

    public static Player createPlayer(String playersName) {
        System.out.println("\n**** CreatePlayer function called ****");
        Player player = new Player();
        player.setName(playersName);
        return player;
    }

    public static void saveGame() {
        System.out.println("*** SaveGame stub function called ***");
    }
    
}
