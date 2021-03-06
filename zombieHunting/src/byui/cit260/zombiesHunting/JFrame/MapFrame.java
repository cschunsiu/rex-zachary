/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.JFrame;

import byui.cit260.zombiesHunting.Exceptions.GameControlException;
import byui.cit260.zombiesHunting.Exceptions.MapControlException;
import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.control.MapControl;
import byui.cit260.zombiesHunting.control.PlayerControl;
import byui.cit260.zombiesHunting.control.ZombieControl;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.InventoryItem;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;
import byui.cit260.zombiesHunting.view.LaboratoryView;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class MapFrame extends javax.swing.JFrame {

    
    private static Game game;
    private static Map[] rooms;

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        MapFrame.game = game;
    }

    public static Map[] getRooms() {
        return rooms;
    }

    public static void setRooms(Map[] rooms) {
        MapFrame.rooms = rooms;
    }
    
    
    /**
     * Creates new form MapFrame
     */
    public MapFrame() {
        initComponents();
        MapTableModel mapTableModel = new MapTableModel();
        this.jTable1.setModel(mapTableModel);
        //can add your own code
        
        GameControl gameData = new GameControl();
        try {
           gameData.startNewGame();
        }
        catch (GameControlException err){
            err.getMessage();
            //err.stackTrace();
        }
        
        Game game = ZombieHunting.getCurrentGame();
        Map rooms[] = game.getGameMaps();
        Location locations[][] = rooms[0].getLocations();
        
   
        int rowCount = this.jTable1.getRowCount();
        int columnCount = this.jTable1.getColumnCount();
                
        //Object[][] data = new Object [16][20];
        Object[][] data = getTableData(locations);
        //Object [] columns = new Object [20];
        Object[] columns = getColumnData(20);
        mapTableModel.setDataVector(data, columns);
        this.renderMap();
        //populates the table
              
    }

    private Object[][] getTableData(Location[][] locations) {

        Object[][] data = new Object[locations.length][locations[0].length];

        for (int i = 0; i < locations.length; i++) {
            Location[] row = locations[i];
            for (int j = 0; j < row.length; j++) {
                Location location = locations[i][j];
                Scene scene = location.getScene();
                Object value;
                
                if (scene == null){
                    Scene temp = new Scene();
                    locations[i][j].setScene(temp);
                    scene = temp;
                }
                
                value = getIcon(scene.getDescription());
                /*
                if (scene == null) {
                    value = "??";
                } else if (this.getIcon(scene.getDescription()) != null) {
                    
                    value = getIcon(scene.getDescription());
                }else {
                    value = scene.getMapSymbol();
                }
                */

                data[i][j] = value;

            }
        }
        return data;
    }
        

    private Object[] getColumnData(int columnCount) {
        Object[] columnHeaderData = new Object[columnCount];
        for (int i = 0; i < columnHeaderData.length; i++) {
            Object object = columnHeaderData[i];
        }
        return columnHeaderData;
    }

    private Object getIcon(String description) {
        
        Object value = null;
        Scene temp = new Scene();
        Game game = ZombieHunting.getCurrentGame();
        
        if (description == null || description == " "){ //Floor
                    
            BufferedImage image = null;
                   
            try {
                image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Floor Tile.png");
            }
            catch (IOException err){
                err.getMessage();
                err.printStackTrace();
            }
                   
            if (image != null){
                //int rowHeight = this.jTable1.getRowHeight();
                //int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                //resize(image, columnWidth, rowHeight);       
                value = new ImageIcon(image);
            }
                   
        }       
        else if (description == "P"){ //PLAYER
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/actor_square-hero FLOOR.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){

                       value = new ImageIcon(image);
                   }
                }
        else if (description == "x"){ //wall
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Wall2.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       
                       value = new ImageIcon(image);
                   }
                   
                }
        else if (description == "E"){ //exit
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Stair.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       
                       value = new ImageIcon(image);
                   }
                   
                }
        else if (description == "C"){ //cure
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Potion.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       
                       value = new ImageIcon(image);
                   }                  
                }
        else if (description == "z"){ //zombie
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Actor_square-zombie FLOOR.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       
                       value = new ImageIcon(image);
                   }
                   
                }
        return value;
    }
 private class MapTableModel extends DefaultTableModel {

        public Class getColumnClass(int columnIndex) {
            Vector rows = this.getDataVector();
            int rowCount = this.getRowCount();
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {

                Vector row = (Vector) rows.elementAt(rowIndex);
                if (row.elementAt(columnIndex) != null) {
                    return getValueAt(rowIndex, columnIndex).getClass();
                }
            }
            return ImageIcon.class;
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpUpButton = new javax.swing.JButton();
        jpRightButton = new javax.swing.JButton();
        jpLeftButton = new javax.swing.JButton();
        jpDownButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpCheckWeaponsButton = new javax.swing.JButton();
        jpInventoryView = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jpKeyLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jpTextField = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpUpButton.setText("Up");
        jpUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpUpButtonActionPerformed(evt);
            }
        });

        jpRightButton.setText("Right");
        jpRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpRightButtonActionPerformed(evt);
            }
        });

        jpLeftButton.setText("Left");
        jpLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpLeftButtonActionPerformed(evt);
            }
        });

        jpDownButton.setText("Down");
        jpDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpDownButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movement");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Options");

        jpCheckWeaponsButton.setText("check weapons");
        jpCheckWeaponsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpCheckWeaponsButtonActionPerformed(evt);
            }
        });

        jpInventoryView.setText("View inventory");
        jpInventoryView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpInventoryViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jpUpButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpLeftButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpRightButton)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpInventoryView)
                            .addComponent(jpCheckWeaponsButton))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpDownButton)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpUpButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpLeftButton)
                    .addComponent(jpRightButton))
                .addGap(18, 18, 18)
                .addComponent(jpDownButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCheckWeaponsButton)
                .addGap(18, 18, 18)
                .addComponent(jpInventoryView)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpKeyLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jpKeyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpKeyLabel.setText("Key");

        jLabel3.setText("P: Player");

        jLabel4.setText("x: wall");

        jLabel5.setText("E: exit");

        jLabel6.setText("z: zombie");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpKeyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpKeyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jpTextField.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //int row = this.jTable1.
    }//GEN-LAST:event_jTable1MouseClicked

    private void jpUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpUpButtonActionPerformed
        // TODO add your handling code here:
        Game game = ZombieHunting.getCurrentGame();
        Map rooms[] = game.getGameMaps();
        
        Player player = game.getPlayer();
        Location locations[][] = rooms[player.getRoom()].getLocations();
        //old positioning data
        int oldRow = player.getRowPosition();
        int oldColumn = player.getColumnPosition();
        
        //move the player
        this.movePlayer("W");
        
        //new positioning data
        int newRow = player.getRowPosition();
        int newColumn = player.getColumnPosition();
        
        Scene reset = new Scene();
        locations[oldRow][oldColumn].setScene(reset);
        
        Object value1 = getIcon(reset.getDescription());
        this.jTable1.getModel().setValueAt(value1,oldRow,oldColumn);
        Scene scene = locations[newRow][newColumn].getScene();
        Object value = getIcon(scene.getDescription());
        this.jTable1.getModel().setValueAt(value,newRow,newColumn);
    }//GEN-LAST:event_jpUpButtonActionPerformed

    private void jpInventoryViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpInventoryViewActionPerformed

        Game game = ZombieHunting.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        //Display Title
        String display = "\nList of Inventory Items\n";
        
        //Display description
        display += "Description" + "\t" + "In Stock";
                           
        //for each inventory Item
        for (InventoryItem InventoryItem : inventory){
            display += "\n" + InventoryItem.getDescription() 
                            + "\t   " + InventoryItem.getQuantity();
        }
        
        jTextArea1.setText(display);
        
    }//GEN-LAST:event_jpInventoryViewActionPerformed

    private void jpDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpDownButtonActionPerformed
        // TODO add your handling code here:
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        Map rooms[] = game.getGameMaps();
        Location locations[][] = rooms[player.getRoom()].getLocations();
        //old positioning data
        int oldRow = player.getRowPosition();
        int oldColumn = player.getColumnPosition();
        
        //move the player
        this.movePlayer("S");
        
        //new positioning data
        int newRow = player.getRowPosition();
        int newColumn = player.getColumnPosition();
        
        Scene reset = new Scene();
        locations[oldRow][oldColumn].setScene(reset);
        
        Object value1 = getIcon(reset.getDescription());
        this.jTable1.getModel().setValueAt(value1,oldRow,oldColumn);
        Scene scene = locations[newRow][newColumn].getScene();
        Object value = getIcon(scene.getDescription());
        this.jTable1.getModel().setValueAt(value,newRow,newColumn);
    }//GEN-LAST:event_jpDownButtonActionPerformed

    private void jpLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpLeftButtonActionPerformed
        // TODO add your handling code here:
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        Map rooms[] = game.getGameMaps();
        Location locations[][] = rooms[player.getRoom()].getLocations();
        //old positioning data
        int oldRow = player.getRowPosition();
        int oldColumn = player.getColumnPosition();
        
        //move the player
        this.movePlayer("A");
        
        //new positioning data
        int newRow = player.getRowPosition();
        int newColumn = player.getColumnPosition();
        
        Scene reset = new Scene();
        locations[oldRow][oldColumn].setScene(reset);
        
        Object value1 = getIcon(reset.getDescription());
        this.jTable1.getModel().setValueAt(value1,oldRow,oldColumn);
        Scene scene = locations[newRow][newColumn].getScene();
        Object value = getIcon(scene.getDescription());
        this.jTable1.getModel().setValueAt(value,newRow,newColumn);
    }//GEN-LAST:event_jpLeftButtonActionPerformed

    private void jpRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpRightButtonActionPerformed
        // TODO add your handling code here:
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        
        //old positioning data
        int oldRow = player.getRowPosition();
        int oldColumn = player.getColumnPosition();
        Map rooms[] = game.getGameMaps();
        Location locations[][] = rooms[player.getRoom()].getLocations();
        //move the player
        this.movePlayer("D");
        
        //new positioning data
        int newRow = player.getRowPosition();
        int newColumn = player.getColumnPosition();
        
        Scene reset = new Scene();
        locations[oldRow][oldColumn].setScene(reset);
        
        Object value1 = getIcon(reset.getDescription());
        this.jTable1.getModel().setValueAt(value1,oldRow,oldColumn);
        Scene scene = locations[newRow][newColumn].getScene();
        Object value = getIcon(scene.getDescription());
        this.jTable1.getModel().setValueAt(value,newRow,newColumn);
    }//GEN-LAST:event_jpRightButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       char keyPressed = evt.getKeyChar();
       if (keyPressed == 'a' || keyPressed == 'A') {
           //this.movePlayer("A");
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        
        //old positioning data
        int oldRow = player.getRowPosition();
        int oldColumn = player.getColumnPosition();
        
        //move the player
        this.movePlayer("A");
        
        //new positioning data
        int newRow = player.getRowPosition();
        int newColumn = player.getColumnPosition();
        
        //this.jTable1.getModel().setValueAt(" ", oldRow, oldColumn);
        //this.jTable1.getModel().setValueAt("P", newRow, newColumn);
        this.renderMap();
       }
       else if (keyPressed == 'w' || keyPressed == 'W') {
           movePlayer("W");
       }
       else if (keyPressed == 's' || keyPressed == 'S') {
           movePlayer("S");
       }
       else if (keyPressed == 'd' || keyPressed == 'D') {
           movePlayer("D");
       }
    }//GEN-LAST:event_formKeyPressed

    private void jpCheckWeaponsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpCheckWeaponsButtonActionPerformed
        String notification = checkWeapons();
        jTextArea1.setText(notification);
    }//GEN-LAST:event_jpCheckWeaponsButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jpCheckWeaponsButton;
    private javax.swing.JButton jpDownButton;
    private javax.swing.JButton jpInventoryView;
    private javax.swing.JLabel jpKeyLabel;
    private javax.swing.JButton jpLeftButton;
    private javax.swing.JButton jpRightButton;
    private javax.swing.JScrollPane jpTextField;
    private javax.swing.JButton jpUpButton;
    // End of variables declaration//GEN-END:variables

    private void movePlayer(String direction) {
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        Map[] map = game.getGameMaps();
        
        int row = player.getRowPosition();
        int column = player.getColumnPosition();
        
        this.moveZombie(map[player.getRoom()]);
            
        switch(direction){
            case "W": //up
                row = row - 1;
                break;
            case "S": //down
                row = row + 1;
                break;
            case "A": //left
                column = column - 1;
                break;
            case "D": //right
                column = column + 1;
                break;
        }
        
        Location[][] oldLocations = map[player.getRoom()].getLocations();
        Scene temp;
        String nextScene = null;
        Boolean blocked = true;
        //int maxRow = 18;
        //int maxColumn = 23;
        
        int maxRow = 20;
        int maxColumn = 20;
        
        if (row >= 0 && 
            column >= 0 &&
            row <= maxRow &&
            column <= maxColumn){
            
               temp = oldLocations[row][column].getScene();
               blocked = temp.isBlocked();
               nextScene = temp.getDescription();
        }
        
        //boundary checking
            if (nextScene == "z"){
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
                
                //PlayerControl.attackZombie();
                
                try{
                MapControl.moveActorsToLocation(row, column, player.getRoom());
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if (nextScene == "E"){ //exit
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
            
                try{
                   MapControl.moveActorsToLocation(0, 0, player.getRoom() + 1);
                   this.renderMap();
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                //inBounds = true;
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if(nextScene == "C"){
                VictoryViewFrame victoryViewFrame = new VictoryViewFrame();; 
                victoryViewFrame.setVisible(true);
            }
            else if (column >= 0 && 
                row >= 0 && 
                column <= maxRow && 
                column <= maxColumn &&
                !blocked){
            
               //inBounds = true;
                        
               // get the player's current location
               int currentRow = player.getRowPosition();
               int currentColumn = player.getColumnPosition();
               try{
                  MapControl.moveActorsToLocation(row, column, player.getRoom());
               }
               catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
               Scene reset = new Scene();
               oldLocations[currentRow][currentColumn].setScene(reset);                            
            }
                           
    }

    private void renderMap() {
        Game game = ZombieHunting.getCurrentGame();
        Map rooms[] = game.getGameMaps();
        Player player = game.getPlayer();
        Location locations[][] = rooms[player.getRoom()].getLocations();
        
        int rowCount = this.jTable1.getRowCount();
        int columnCount = this.jTable1.getColumnCount();
        
        int totalRows = rooms[player.getRoom()].getTotalRows();
        int totalColumns = rooms[player.getRoom()].getTotalColumns();

        
        for (int row = 0; row < totalRows; row++ ){
            for (int column = 0; column < totalColumns; column++){
                Scene temp = locations[row][column].getScene();
                Object value = null;
                
                if (temp == null || temp.getDescription() == " "){//set to floor scene
                   Scene square = new Scene();
                   locations[row][column].setScene(square);
                   temp = locations[row][column].getScene();
                   
                   BufferedImage image = null;
                   
                   
                   try {
                   image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Floor Tile.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   if(image != null){
                      //int rowHeight = this.jTable1.
                      int rowHeight = this.jTable1.getRowHeight();
                      //int columnWidth = this.jTable1.getColumn(value).getWidth();
                      int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                      
                      resize(image, columnWidth, rowHeight);
                      //BufferedImage iconImage = GameMeunuFrame.resize(image,columnWidth,rowHeight);
                      value = new ImageIcon(image);
                    }
                   
                   //value.setImageIcon(image);
                   this.jTable1.getModel().setValueAt(value,row,column);
                   //this.jTable1.getModel().setValueAt(square.getDescription(), row, column);
                }
                /*
                else{
                    this.jTable1.getModel().setValueAt(temp.getDescription(), row, column);
                }
                */
                
                else if (temp.getDescription() == "P"){ //PLAYER
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/actor_square-hero FLOOR.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       int rowHeight = this.jTable1.getRowHeight();
                       int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                       
                       image = resize(image, columnWidth, rowHeight);
                       
                       value = new ImageIcon(image);
                   }
                   this.jTable1.getModel().setValueAt(value, row, column);
                }
                else if (temp.getDescription() == "x"){ //WALL
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Wall2.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       int rowHeight = this.jTable1.getRowHeight();
                       int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                       
                       resize(image, columnWidth, rowHeight);
                       
                       value = new ImageIcon(image);
                   }
                    this.jTable1.getModel().setValueAt(value, row, column);
                }
                else if (temp.getDescription() == "z"){ //ZOMBIE
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Actor_square-zombie FLOOR.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       int rowHeight = this.jTable1.getRowHeight();
                       int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                       
                       resize(image, columnWidth, rowHeight);
                       
                       value = new ImageIcon(image);
                   }
                    this.jTable1.getModel().setValueAt(value, row, column);
                }  
                else if (temp.getDescription() == "E"){
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Stair.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       int rowHeight = this.jTable1.getRowHeight();
                       int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                       
                       resize(image, columnWidth, rowHeight);
                       
                       value = new ImageIcon(image);
                   }
                    this.jTable1.getModel().setValueAt(value, row, column);
                }
                else if (temp.getDescription() == "C"){
                    
                   BufferedImage image = null;
                   
                   try {
                      image = getImage(temp, "/byui/cit260/zombiesHunting/Images/Potion.png");
                   }
                   catch (IOException err){
                       err.getMessage();
                       err.printStackTrace();
                   }
                   
                   if (image != null){
                       int rowHeight = this.jTable1.getRowHeight();
                       int columnWidth = this.jTable1.getColumnModel().getColumn(column).getWidth();
                       
                       resize(image, columnWidth, rowHeight);
                       
                       value = new ImageIcon(image);
                   }
                    this.jTable1.getModel().setValueAt(value, row, column);
                }                      
            }        
        }
    }
    private static BufferedImage getImage(Scene scene, String location) throws IOException{
        URL url = scene.getClass().getResource(location);
        BufferedImage image= null;
        
        image = ImageIO.read(url);
        
        return image;
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        if (image == null)
            return null;
        
        double imageWidth = image.getWidth();
        double imageHeight = image.getHeight();
        
        double ratio = imageHeight / imageWidth;
        
        if (imageWidth > imageHeight) {
            height = (int) (width * ratio);
        }
        else {
            width = (int) (height / ratio);
        }

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bufferedImage;
    }
    
    private String checkWeapons() {
        Game game = ZombieHunting.getCurrentGame();
        WeaponItem[] weapon = game.getInventoryWeapons();
        WeaponItem lowestAmmo = weapon[0];
        WeaponItem highestAmmo = weapon[0];
        String ammoStockpile = "";
        String notification = "";
 
        for (WeaponItem weapons : weapon){
            if (weapons.getAmmo() == 0)
            {
                notification += "WARNING: The " + weapons.getDescription() + " Is out of ammo.";
            }
            else if (weapons.getAmmo() < 10)
            {
                notification += "WARNING: The " + weapons.getDescription() +
                                   " Is running low on ammo." +
                                   " Only " + weapons.getAmmo() + " bullets left.";
            }
            else
            {
                notification += "The " + weapons.getDescription() + 
                                " is looking good on ammo and is ready to go";
            }
            
            if (lowestAmmo.getAmmo() > weapons.getAmmo()){
                lowestAmmo = weapons;
            }
            else if (highestAmmo.getAmmo() < weapons.getAmmo()){
                highestAmmo = weapons;
            }
            
            ammoStockpile += "\n\tAmmo Stockpile: " + weapons.getDescription() + "-" + weapons.getAmmo() + "  ";
        }//end of for loop
        
        if (lowestAmmo.getAmmo() != highestAmmo.getAmmo()){
            
         notification +=   "\nThe " + lowestAmmo.getDescription() +
                           " has the lowest ammo with only " + lowestAmmo.getAmmo() +
                           ". ";
        }
        
        notification += ammoStockpile;
        
        return notification;
    }

    private void moveZombie(Map map) {
        Zombie[] zombies = map.getZombies();
        Game game = ZombieHunting.getCurrentGame();
        Map rooms[] = game.getGameMaps();
        Location locations[][] = rooms[zombies[0].getRoomPosition()].getLocations();
        
        if (zombies != null){
            ZombieControl zombieMove = new ZombieControl();
            for (Zombie zombie : zombies){
               int oldRow = zombie.getRowPosition();
               int oldColumn = zombie.getColumnPosition();
               
               zombieMove.moveZombie(zombie);
               
               int newRow = zombie.getRowPosition();
               int newColumn = zombie.getColumnPosition();
               
               Scene reset = new Scene();
               locations[oldRow][oldColumn].setScene(reset);
        
               Object value1 = getIcon(reset.getDescription());
               this.jTable1.getModel().setValueAt(value1,oldRow,oldColumn);
               Scene scene = locations[newRow][newColumn].getScene();
               Object value = getIcon(scene.getDescription());
               this.jTable1.getModel().setValueAt(value,newRow,newColumn);
               //this.jTable1.getModel().setValueAt(" ", oldRow, oldColumn);
               //this.jTable1.getModel().setValueAt("z", newRow, newColumn);
            }
        }
    }

}