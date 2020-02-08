/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;

import javax.swing.JPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sister
 */
public class DiceTest {
    
    public DiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of updateDiceAfterPowerRollOperation method, of class Dice.
     */
    @Test
    public void testUpdateDiceAfterPowerRollOperation() {
        System.out.println("updateDiceAfterPowerRollOperation");
        String operation = "";
        Dice instance = new Dice();
        instance.updateDiceAfterPowerRollOperation(operation);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTemporaryActionListenerToDices method, of class Dice.
     */
    @Test
    public void testAddTemporaryActionListenerToDices() {
        System.out.println("addTemporaryActionListenerToDices");
        Dice instance = new Dice();
        instance.addTemporaryActionListenerToDices();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of resetMirrorButtons method, of class Dice.
     */
    @Test
    public void testResetMirrorButtons() {
        System.out.println("resetMirrorButtons");
        Dice instance = new Dice();
        instance.resetMirrorButtons();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of findDisabledDice method, of class Dice.
     */
    @Test
    public void testFindDisabledDice() {
        System.out.println("findDisabledDice");
        Dice instance = new Dice();
        instance.findDisabledDice();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getReferenceToDicePanel method, of class Dice.
     */
    @Test
    public void testGetReferenceToDicePanel() {
        System.out.println("getReferenceToDicePanel");
        Dice instance = new Dice();
        JPanel expResult = null;
        JPanel result = instance.getReferenceToDicePanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAcesForAllDices method, of class Dice.
     */
    @Test
    public void testSetAcesForAllDices() {
        System.out.println("setAcesForAllDices");
        Dice instance = new Dice();
        instance.setAcesForAllDices();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setImageURLforButtons method, of class Dice.
     */
    @Test
    public void testSetImageURLforButtons() {
        System.out.println("setImageURLforButtons");
        Dice instance = new Dice();
        instance.setImageURLforButtons();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createDicePanel method, of class Dice.
     */
    @Test
    public void testCreateDicePanel() {
        System.out.println("createDicePanel");
        Dice instance = new Dice();
        instance.createDicePanel();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of beforeRoll method, of class Dice.
     */
    @Test
    public void testBeforeRoll() {
        System.out.println("beforeRoll");
        Dice instance = new Dice();
        instance.beforeRoll();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of duringRoll method, of class Dice.
     */
    @Test
    public void testDuringRoll() {
        System.out.println("duringRoll");
        Dice instance = new Dice();
        instance.duringRoll();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of rollOnlyDeselectedDices method, of class Dice.
     */
    @Test
    public void testRollOnlyDeselectedDices() {
        System.out.println("rollOnlyDeselectedDices");
        Dice instance = new Dice();
        instance.rollOnlyDeselectedDices();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of afterRollForToss method, of class Dice.
     */
    @Test
    public void testAfterRollForToss() {
        System.out.println("afterRollForToss");
        Dice instance = new Dice();
        int result = instance.afterRollForToss();
        assertTrue(result!=0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of afterPlayRoll method, of class Dice.
     */
    @Test
    public void testAfterPlayRoll() {
        System.out.println("afterPlayRoll");
        Dice instance = new Dice();
        instance.afterPlayRoll();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addDices method, of class Dice.
     */
    @Test
    public void testAddDices() {
        System.out.println("addDices");
        Dice instance = new Dice();
        instance.addDices();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
