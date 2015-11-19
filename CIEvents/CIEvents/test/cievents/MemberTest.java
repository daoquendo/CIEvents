/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cievents;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brian
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmail method, of class Member.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Member instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getPassword method, of class Member.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Member instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setEmail method, of class Member.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Member instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setPassword method, of class Member.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Member instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of equals method, of class Member.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Member other = null;
        Member instance = null;
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of toString method, of class Member.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Member instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
