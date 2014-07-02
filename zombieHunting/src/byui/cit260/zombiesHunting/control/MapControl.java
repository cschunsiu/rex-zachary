/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.Scene;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class MapControl {
            
    public static void moveActorsToLocation(int row, int column, int room) {
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        
        Map[] map = game.getGameMaps();
        
        Location[][] locations = map[room].getLocations();

        //place the user at location
        Scene user = new Scene(false, "P");
        locations[row][column].setScene(user);
        
        //save the players position
        player.setColumnPosition(column);
        player.setRowPosition(row);
        player.setRoom(room);
        
        //save player info
        
    }
    
}
