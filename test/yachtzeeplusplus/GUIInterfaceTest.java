/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sister
 */
public class GUIInterfaceTest {
    
    public GUIInterfaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Player.NUM_OF_PLAYERS=5;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
    /**
     * Test of addActionListenersToDices method, of class GUIInterface.
     */
    @Test
    public void testAddActionListenersToDices() {
        System.out.println("addActionListenersToDices");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.addActionListenersToDices();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sortResult method, of class GUIInterface.
     */
    @Test
    public void testSortResult() {
        System.out.println("sortResult");
        GUIInterface instance = new GUIInterfaceImpl();
        int[] expResult = null;
        int[] result = instance.sortResult();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of checkForGrandTotal method, of class GUIInterface.
     */
    @Test
    public void testCheckForGrandTotal() {
        System.out.println("checkForGrandTotal");
        GUIInterface instance = new GUIInterfaceImpl();
        Integer expResult = null;
        Integer result = instance.checkForGrandTotal();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of scoreAnalyzier method, of class GUIInterface.
     */
    @Test
    public void testScoreAnalyzier() {
        System.out.println("scoreAnalyzier");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.scoreAnalyzier();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of scoreAnalyzierUnderResoringMode method, of class GUIInterface.
     */
    @Test
    public void testScoreAnalyzierUnderResoringMode() {
        System.out.println("scoreAnalyzierUnderResoringMode");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.scoreAnalyzierUnderResoringMode();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeDicePanel method, of class GUIInterface.
     */
    @Test
    public void testRemoveDicePanel() {
        System.out.println("removeDicePanel");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.removeDicePanel();
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of addUserToLeftPanel method, of class GUIInterface.
     */
    @Test
    public void testAddUserToLeftPanel() {
        System.out.println("addUserToLeftPanel");
        GridBagConstraints g = null;
        GUIInterface instance = new GUIInterfaceImpl();
        int expResult = 0;
        int result = instance.addUserToLeftPanel(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addUserToRightPanel method, of class GUIInterface.
     */
    @Test
    public void testAddUserToRightPanel() {
        System.out.println("addUserToRightPanel");
        int boundary = 0;
        GridBagConstraints g = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.addUserToRightPanel(boundary, g);
        // TODO review the generated test code and remove the default call to fail.
      }

    /**
     * Test of verifyIfAllPlayerTossed method, of class GUIInterface.
     */
    @Test
    public void testVerifyIfAllPlayerTossed() {
        System.out.println("verifyIfAllPlayerTossed");
        GUIInterface instance = new GUIInterfaceImpl();
        boolean expResult = false;
        boolean result = instance.verifyIfAllPlayerTossed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of fixTurnForPlayers method, of class GUIInterface.
     */
    @Test
    public void testFixTurnForPlayers() {
        System.out.println("fixTurnForPlayers");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.fixTurnForPlayers();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeTurnFixer method, of class GUIInterface.
     */
    @Test
    public void testRemoveTurnFixer() {
        System.out.println("removeTurnFixer");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.removeTurnFixer();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addDicePanelToCentralPanel method, of class GUIInterface.
     */
    @Test
    public void testAddDicePanelToCentralPanel() {
        System.out.println("addDicePanelToCentralPanel");
        JPanel panel = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.addDicePanelToCentralPanel(panel);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addUserToTheList method, of class GUIInterface.
     */
    @Test
    public void testAddUserToTheList() {
        System.out.println("addUserToTheList");
        String name = "";
        GUIInterface instance = new GUIInterfaceImpl();
        instance.addUserToTheList(name);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deletePlayerPaneMultiuserMode method, of class GUIInterface.
     */
    @Test
    public void testDeletePlayerPaneMultiuserMode() {
        System.out.println("deletePlayerPaneMultiuserMode");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.deletePlayerPaneMultiuserMode();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addDicePanelToPlayBoard method, of class GUIInterface.
     */
    @Test
    public void testAddDicePanelToPlayBoard() {
        System.out.println("addDicePanelToPlayBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.addDicePanelToPlayBoard();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of createPlayerPanel method, of class GUIInterface.
     */
    @Test
    public void testCreatePlayerPanel_int() {
        System.out.println("createPlayerPanel");
        int x = 0;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.createPlayerPanel(x);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of createPlayerPanel method, of class GUIInterface.
     */
    @Test
    public void testCreatePlayerPanel_0args() {
        System.out.println("createPlayerPanel");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.createPlayerPanel();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deletePlayerPanel method, of class GUIInterface.
     */
    @Test
    public void testDeletePlayerPanel() {
        System.out.println("deletePlayerPanel");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.deletePlayerPanel();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hideSelectGameMode method, of class GUIInterface.
     */
    @Test
    public void testHideSelectGameMode() {
        System.out.println("hideSelectGameMode");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.hideSelectGameMode();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of selectGameMode method, of class GUIInterface.
     */
    @Test
    public void testSelectGameMode() {
        System.out.println("selectGameMode");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.selectGameMode();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of hideMenus method, of class GUIInterface.
     */
    @Test
    public void testHideMenus() {
        System.out.println("hideMenus");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.hideMenus();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of confirmLayout method, of class GUIInterface.
     */
    @Test
    public void testConfirmLayout() {
        System.out.println("confirmLayout");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.confirmLayout();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of refreshPanel method, of class GUIInterface.
     */
    @Test
    public void testRefreshPanel() {
        System.out.println("refreshPanel");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.refreshPanel();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createDiceObject method, of class GUIInterface.
     */
    @Test
    public void testCreateDiceObject() {
        System.out.println("createDiceObject");
        GUIInterface instance = new GUIInterfaceImpl();
        Dice result = instance.createDiceObject();
        assertTrue(result!=null);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getScreenDimension method, of class GUIInterface.
     */
    @Test
    public void testGetScreenDimension() {
        System.out.println("getScreenDimension");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.getScreenDimension();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setIconPath method, of class GUIInterface.
     */
    @Test
    public void testSetIconPath() {
        System.out.println("setIconPath");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.setIconPath();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of makeBasicGui method, of class GUIInterface.
     */
    @Test
    public void testMakeBasicGui() {
        System.out.println("makeBasicGui");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.makeBasicGui();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of showMenus method, of class GUIInterface.
     */
    @Test
    public void testShowMenus() {
        System.out.println("showMenus");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.showMenus();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPlusAndMinusButtonDisabled method, of class GUIInterface.
     */
    @Test
    public void testSetPlusAndMinusButtonDisabled() {
        System.out.println("setPlusAndMinusButtonDisabled");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.setPlusAndMinusButtonDisabled();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createPlayBoard method, of class GUIInterface.
     */
    @Test
    public void testCreatePlayBoard() {
        System.out.println("createPlayBoard");
        Player p = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.createPlayBoard(p);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removePlayBoard method, of class GUIInterface.
     */
    @Test
    public void testRemovePlayBoard() {
        System.out.println("removePlayBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.removePlayBoard();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPlusAndMinusButtonEnabled method, of class GUIInterface.
     */
    @Test
    public void testSetPlusAndMinusButtonEnabled() {
        System.out.println("setPlusAndMinusButtonEnabled");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.setPlusAndMinusButtonEnabled();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeDicePanelFromPlayBoard method, of class GUIInterface.
     */
    @Test
    public void testRemoveDicePanelFromPlayBoard() {
        System.out.println("removeDicePanelFromPlayBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.removeDicePanelFromPlayBoard();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of deleteDefaultActionListenerFromDices method, of class GUIInterface.
     */
    @Test
    public void testDeleteDefaultActionListenerFromDices() {
        System.out.println("deleteDefaultActionListenerFromDices");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.deleteDefaultActionListenerFromDices();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actionPerformed method, of class GUIInterface.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of checkIsGameOver method, of class GUIInterface.
     */
    @Test
    public void testCheckIsGameOver() {
        System.out.println("checkIsGameOver");
        GUIInterface instance = new GUIInterfaceImpl();
        boolean expResult = false;
        boolean result = instance.checkIsGameOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of mouseClicked method, of class GUIInterface.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.mouseClicked(e);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of mousePressed method, of class GUIInterface.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of mouseReleased method, of class GUIInterface.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.mouseReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of mouseEntered method, of class GUIInterface.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.mouseEntered(e);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of mouseExited method, of class GUIInterface.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        GUIInterface instance = new GUIInterfaceImpl();
        instance.mouseExited(e);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of loadScoreBoard method, of class GUIInterface.
     */
    @Test
    public void testLoadScoreBoard() {
        System.out.println("loadScoreBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.loadScoreBoard();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of writePlayerScoresToScoreBoard method, of class GUIInterface.
     */
    @Test
    public void testWritePlayerScoresToScoreBoard() {
        System.out.println("writePlayerScoresToScoreBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.writePlayerScoresToScoreBoard();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of disableButtons method, of class GUIInterface.
     */
    @Test
    public void testDisableButtons() {
        System.out.println("disableButtons");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.disableButtons();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeScoreBoard method, of class GUIInterface.
     */
    @Test
    public void testRemoveScoreBoard() {
        System.out.println("removeScoreBoard");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.removeScoreBoard();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of showDevevloperInfo method, of class GUIInterface.
     */
    @Test
    public void testShowDevevloperInfo() {
        System.out.println("showDevevloperInfo");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.showDevevloperInfo();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of hideDeveloperInfo method, of class GUIInterface.
     */
    @Test
    public void testHideDeveloperInfo() {
        System.out.println("hideDeveloperInfo");
        GUIInterface instance = new GUIInterfaceImpl();
        instance.hideDeveloperInfo();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    public class GUIInterfaceImpl extends GUIInterface {
    }
    
}
