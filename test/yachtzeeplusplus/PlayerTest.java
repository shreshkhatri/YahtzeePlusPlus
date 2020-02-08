/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;

import javax.swing.DefaultListModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sister
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createPlayers method, of class Player.
     */
    @Test
    public void testCreatePlayers() {
        System.out.println("createPlayers");
        DefaultListModel listModel = null;
        Player instance = new Player();
        instance.createPlayers(listModel);
       
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of initializeScoreObject method, of class Player.
     */
    @Test
    public void testInitializeScoreObject() {
        System.out.println("initializeScoreObject");
        Player instance = new Player();
        Score expResult = null;
        Score result = instance.initializeScoreObject();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPlayerInOrder method, of class Player.
     */
    @Test
    public void testGetPlayerInOrder() {
        System.out.println("getPlayerInOrder");
        int input = 0;
        Player instance = new Player();
        Player expResult = null;
        Player result = instance.getPlayerInOrder(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createSinglePlayer method, of class Player.
     */
    @Test
    public void testCreateSinglePlayer() {
        System.out.println("createSinglePlayer");
        String name = "";
        Player instance = new Player();
        Player expResult = null;
        Player result = instance.createSinglePlayer(name);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
