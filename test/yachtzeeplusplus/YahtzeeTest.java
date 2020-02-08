/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sister
 */
public class YahtzeeTest {
    
    public YahtzeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Yahtzee.
     */
    @Test
    public void testMain() {
        System.out.println("Test for main Function");
        String[] args ={"arg2","arg1"};
        Yahtzee.main(args);
        System.out.println(args[0]);
       
    }   
 
}
