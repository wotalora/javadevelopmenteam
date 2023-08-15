/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author varkr
 */
public class TestFile {
    
    public TestFile() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of placeBet method, of class Player.
     */
    @Test
    public void testPlaceBet() {
        System.out.println("placeBet");
        double bet = 900.0;
        Player instance = new Player("First", 1000.0);
        boolean expResult = true;
        boolean result = instance.placeBet(bet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of placeBet method, of class Player.
     */
    @Test
    public void testPlaceBetBad() {
        System.out.println("placeBet");
        double bet = 0.0;
        Player instance = new Player("First", 1000.0);
        boolean expResult = false;
        boolean result = instance.placeBet(bet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of placeBet method, of class Player.
     */
    @Test
    public void testPlaceBoundary() {
        System.out.println("placeBet");
        double bet = 0.0;
        Player instance = new Player("First", 1000.0);
        boolean expResult = false;
        boolean result = instance.placeBet(bet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
//    *******************************
    
      /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuit");
        Card instance = new Card(Suit.DIAMOND, 10);
        Suit expResult = Suit.DIAMOND;
        Suit result = instance.getSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaceValue method, of class Card.
     */
    @Test
    public void testGetFaceValue() {
        System.out.println("getFaceValue");
        Card instance = new Card(Suit.CLUB, 10);
        int expResult = 10;
        int result = instance.getFaceValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }  
    
    /**
     * Test of createShoe method, of class Shoe.
     */
    @Test
    public void testCreateShoe() {
        System.out.println("createShoe");
        Shoe instance = new Shoe(1);
        boolean expResult = true;
        boolean result = instance.createShoe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    /**
     * Test of createShoe method, of class Shoe.
     */
    @Test
    public void testCreateShoeBad() {
        System.out.println("createShoe");
        Shoe instance = new Shoe(0);
        boolean expResult = false;
        boolean result = instance.createShoe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
