/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombiehunting;

import byui.cit260.zombiesHunting.JFrame.StartProgramViewFrame;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.RoomType;
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;
import byui.cit260.zombiesHunting.view.StartProgramView;

/**
 *
 * @author ChunShing
 */
public class ZombieHunting {

    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        ZombieHunting.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        ZombieHunting.player = player;
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 

        //Testing for the view layer
        try {
           //StartProgramView startProgramView = new StartProgramView();
           //startProgramView.startProgram();
            
           StartProgramViewFrame startProgramView = new StartProgramViewFrame();
           startProgramView.setVisible(true);
            
        }
        catch (Throwable e){
            System.out.println("An abnormal error occured."
                             + "Try restarting the program."
                             + "Call for help if error persists");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
