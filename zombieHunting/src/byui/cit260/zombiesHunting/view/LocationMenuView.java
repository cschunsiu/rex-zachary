/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

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
                    MapControl.moveActorsToLocation(0, 0, nextRoom);
                }
                else{
                    System.out.println("You are at the final destination!");
                }
                break;
            case "C": //Construction Site
                MapControl.moveActorsToLocation(0, 0, Constants.CONSTRUCTION_SITE1);
                ConstructionView construction = new ConstructionView();
                map[Constants.CONSTRUCTION_SITE1].displayMap();
                construction.display();
                break;
            case "A": //Airport
                MapControl.moveActorsToLocation(0, 0, Constants.AIRPORT1);
                AirportView airport = new AirportView();
                map[Constants.AIRPORT1].displayMap();
                airport.display();
                break;
            case "U": //SuperMarket
                MapControl.moveActorsToLocation(0, 0, Constants.SUPER_MARKET1);
                SupermarketView supermarket = new SupermarketView();
                map[Constants.SUPER_MARKET1].displayMap();
                supermarket.display();
                break;
            case "S": //School
                MapControl.moveActorsToLocation(0, 0, Constants.SCHOOL1);
                SchoolView school = new SchoolView();
                map[Constants.SCHOOL1].displayMap();
                school.display();
                break;
            case "M": //Mall
                MapControl.moveActorsToLocation(0, 0, Constants.MALL1);
                MallView mall = new MallView();
                map[Constants.MALL1].displayMap();
                mall.display();
                break;
            case "L": //Laboratory
                MapControl.moveActorsToLocation(0, 0, Constants.LABORATORY);
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
