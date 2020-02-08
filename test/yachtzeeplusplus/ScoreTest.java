/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;

import javax.swing.table.DefaultTableModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sister
 */
public class ScoreTest {
    
    public ScoreTest() {
   
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getScoreObject method, of class Score.
     */
    @Test
    public void testGetScoreObject() {
        System.out.println("getScoreObject");
        Score instance = new Score();
        Score expResult = null;
        Score result = instance.getScoreObject();
        assertNotEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTossScore method, of class Score.
     */
    @Test
    public void testSetTossScore() {
        System.out.println("setTossScore");
        int TS = 0;
        Score instance = new Score();
        instance.setTossScore(TS);
        assertTrue(instance.tossScore==TS);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTossScore method, of class Score.
     */
    @Test
    public void testGetTossScore() {
        System.out.println("getTossScore");
        Score instance = new Score();
        int expResult = 0;
        int result = instance.getTossScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isTossScoreWritten method, of class Score.
     */
    @Test
    public void testIsTossScoreWritten() {
        System.out.println("isTossScoreWritten");
        DefaultTableModel tblModel = null;
        int sum = 0;
        Player current_player = null;
        Score instance = new Score();
        boolean expResult = false;
        boolean result = instance.isTossScoreWritten(tblModel, sum, current_player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of initializeScoreObject method, of class Score.
     */
    @Test
    public void testInitializeScoreObject() {
        System.out.println("initializeScoreObject");
        Score instance = new Score();
        Score expResult = null;
        Score result = instance.initializeScoreObject();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of countOnes method, of class Score.
     */
    @Test
    public void testCountOnes() {
        System.out.println("countOnes");
        Score instance = new Score();
       
        Dice.outcomes[0]=0;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=1;
        
        System.out.println(instance.countOnes()); // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of countTwos method, of class Score.
     */
    @Test
    public void testCountTwos() {
        System.out.println("countTwos");
        Score instance = new Score();
        
        Dice.outcomes[0]=0;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=1;
        System.out.println(instance.countTwos());
        
    }

    /**
     * Test of countThrees method, of class Score.
     */
    @Test
    public void testCountThrees() {
        System.out.println("countThrees");
        Score instance = new Score();
         Dice.outcomes[0]=0;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=1;
        
        System.out.println(instance.countThrees());
    }

    /**
     * Test of countFours method, of class Score.
     */
    @Test
    public void testCountFours() {
        System.out.println("countFours");
        Score instance = new Score();
        Dice.outcomes[0]=0;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=1;
        
        System.out.println(instance.countFours());
        int expResult = 0;
        int result = instance.countFours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of countFives method, of class Score.
     */
    @Test
    public void testCountFives() {
        System.out.println("countFives");
        Score instance = new Score();
        
        Dice.outcomes[0]=5;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=5;
        
        int expResult = 10;
        int result = instance.countFives();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of countSixes method, of class Score.
     */
    @Test
    public void testCountSixes() {
        System.out.println("countSixes");
        Score instance = new Score();
        
        Dice.outcomes[0]=5;Dice.outcomes[1]=1;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=6;
        
        int expResult = 6;
        int result = instance.countSixes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getKindOf3 method, of class Score.
     */
    @Test
    public void testGetKindOf3() {
        System.out.println("getKindOf3");
        Score instance = new Score();
        
        Dice.outcomes[0]=5;Dice.outcomes[1]=5;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=5;
        
        int expResult = 18;
        int result = instance.getKindOf3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getKindOf4 method, of class Score.
     */
    @Test
    public void testGetKindOf4() {
        System.out.println("getKindOf4");
        Score instance = new Score();
        
        Dice.outcomes[0]=0;Dice.outcomes[1]=5;Dice.outcomes[2]=2;Dice.outcomes[3]=1;
        Dice.outcomes[4]=5;
        
        int expResult = 0;
        int result = instance.getKindOf4();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkYachtzee method, of class Score.
     */
    @Test
    public void testCheckYachtzee() {
        System.out.println("checkYachtzee");
        Score instance = new Score();
        
        Dice.outcomes[0]=1;Dice.outcomes[1]=1;Dice.outcomes[2]=1;Dice.outcomes[3]=1;
        Dice.outcomes[4]=0;
        
        boolean expResult = false;
        boolean result = instance.checkYachtzee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkSmallStraight method, of class Score.
     */
    @Test
    public void testCheckSmallStraight() {
        System.out.println("checkSmallStraight");
        Score instance = new Score();
       
        Dice.outcomes[0]=1;Dice.outcomes[1]=1;Dice.outcomes[2]=1;Dice.outcomes[3]=1;
        Dice.outcomes[4]=0;
        
        boolean expResult = false;
        boolean result = instance.checkSmallStraight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkFullHouse method, of class Score.
     */
    @Test
    public void testCheckFullHouse() {
        System.out.println("checkFullHouse");
        Score instance = new Score();
        
        Dice.outcomes[0]=1;Dice.outcomes[1]=1;Dice.outcomes[2]=1;Dice.outcomes[3]=1;
        Dice.outcomes[4]=0;
        
        
        boolean expResult = false;
        boolean result = instance.checkFullHouse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkLargeStraight method, of class Score.
     */
    @Test
    public void testCheckLargeStraight() {
        System.out.println("checkLargeStraight");
        Score instance = new Score();
        
        Dice.outcomes[0]=1;Dice.outcomes[1]=3;Dice.outcomes[2]=2;Dice.outcomes[3]=4;
        Dice.outcomes[4]=5;
        
        boolean expResult = true;
        boolean result = instance.checkLargeStraight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getChance method, of class Score.
     */
    @Test
    public void testGetChance() {
        System.out.println("getChance");
        Score instance = new Score();
        
        Dice.outcomes[0]=1;Dice.outcomes[1]=3;Dice.outcomes[2]=2;Dice.outcomes[3]=4;
        Dice.outcomes[4]=5;
        
        int expResult = 0;
        int result = instance.getChance();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getScoreData method, of class Score.
     */
    @Test
    public void testGetScoreData() {
        System.out.println("getScoreData");
        Player player = null;
        Score instance = new Score();
        Score expResult = null;
        Score result = instance.getScoreData(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
