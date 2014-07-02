/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.Exceptions.MapControlException;
import byui.cit260.zombiesHunting.control.MapControl;
import byui.cit260.zombiesHunting.control.PlayerControl;
import byui.cit260.zombiesHunting.model.Constants;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import java.util.Scanner;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class LocationMenuView extends View{
    
    private static final Game game = ZombieHunting.getCurrentGame();
    private static final Map[] MAP = game.getGameMaps();
    
    public LocationMenuView(){
        super("\n"
        + "\n-------------------------------------------"
        + "\n Location Menu                             |"
        + "\n-------------------------------------------"
        + "\nN - Next Location"
        + "\nC - Construction Site"
        + "\nA - Airport"
        + "\nU - SuperMarket"
        + "\nS - School"
        + "\nM - Mall"
        + "\nL - Laboratory"
        + "\nE - Stay Here"
        + "\n-------------------------------------------");
    }
    
    @Override
    public void doAction(String choice){
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        Map[]map = game.getGameMaps();

        switch (choice) {
            case "N": //Next Location
                int nextRoom = player.getRoom() + 1;
                if (nextRoom <= Constants.LABORATORY){
                    try{
                       MapControl.moveActorsToLocation(0, 0, nextRoom);
                    }
                    catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
                }
                else{
                    System.out.println("You are at the final destination!");
                }
                break;
            case "C": //Construction Site
                try {
                MapControl.moveActorsToLocation(0, 0, Constants.CONSTRUCTION_SITE1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
                ConstructionView construction = new ConstructionView();
                map[Constants.CONSTRUCTION_SITE1].displayMap();
                construction.display();
                break;
            case "A": //Airport
                try{
                   MapControl.moveActorsToLocation(0, 0, Constants.AIRPORT1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                AirportView airport = new AirportView();
                map[Constants.AIRPORT1].displayMap();
                airport.display();
                break;
            case "U": //SuperMarket
                try{
                MapControl.moveActorsToLocation(0, 0, Constants.SUPER_MARKET1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                SupermarketView supermarket = new SupermarketView();
                map[Constants.SUPER_MARKET1].displayMap();
                supermarket.display();
                break;
            case "S": //School
                try {
                   MapControl.moveActorsToLocation(0, 0, Constants.SCHOOL1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                SchoolView school = new SchoolView();
                map[Constants.SCHOOL1].displayMap();
                school.display();
                break;
            case "M": //Mall
                try {
                   MapControl.moveActorsToLocation(0, 0, Constants.MALL1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                MallView mall = new MallView();
                map[Constants.MALL1].displayMap();
                mall.display();
                break;
            case "L": //Laboratory
                try {
                   MapControl.moveActorsToLocation(0, 0, Constants.LABORATORY);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                LaboratoryView lab = new LaboratoryView();
                map[Constants.LABORATORY].displayMap();
                lab.display();
                break;
            case "E": //Stay Here
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

    public void startNewGame(){
        System.out.println("\n*** called startNewGame function ***");
        
        //GameControl.createNewGame(ZombieHunting.getPlayer())
    }
}
