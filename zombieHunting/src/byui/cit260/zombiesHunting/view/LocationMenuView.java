/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.model.Constants;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.Map;
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
        Map[] map = game.getGameMaps();
        
        switch (choice) {
            case "N": //Next Location
                System.out.println("\n*** You have chosen to move to new location***");
                break;
            case "C": //Construction Site
                ConstructionView construction = new ConstructionView();
                map[Constants.CONSTRUCTION_SITE1].displayMap();
                construction.display();
                break;
            case "A": //Airport
                AirportView airport = new AirportView();
                airport.display();
                break;
            case "U": //SuperMarket
                SupermarketView supermarket = new SupermarketView();
                supermarket.display();
                break;
            case "S": //School
                SchoolView school = new SchoolView();
                school.display();
                break;
            case "M": //Mall
                MallView mall = new MallView();
                mall.display();
                break;
            case "L": //Laboratory
                LaboratoryView lab = new LaboratoryView();
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
