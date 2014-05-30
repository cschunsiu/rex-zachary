/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombiehunting;

import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.RoomLocation;
import byui.cit260.zombiesHunting.model.RoomType;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;
import byui.cit260.zombiesHunting.view.StartProgramView;

/**
 *
 * @author ChunShing
 */
public class ZombieHunting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        //Testing for the view layer
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
    }
}
