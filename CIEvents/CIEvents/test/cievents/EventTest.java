/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cievents;

import java.util.ArrayList;
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
public class EventTest {
    
    public EventTest() {
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
     * Test of getID method, of class Event.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Event instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getEventCreator method, of class Event.
     */
    @Test
    public void testGetEventCreator() {
        System.out.println("getEventCreator");
        Event instance = null;
        Member expResult = null;
        Member result = instance.getEventCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getEventName method, of class Event.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        Event instance = null;
        String expResult = "";
        String result = instance.getEventName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getEventDate method, of class Event.
     */
    @Test
    public void testGetEventDate() {
        System.out.println("getEventDate");
        Event instance = null;
        String expResult = "";
        String result = instance.getEventDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getEventLoc method, of class Event.
     */
    @Test
    public void testGetEventLoc() {
        System.out.println("getEventLoc");
        Event instance = null;
        String expResult = "";
        String result = instance.getEventLoc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getEventDescr method, of class Event.
     */
    @Test
    public void testGetEventDescr() {
        System.out.println("getEventDescr");
        Event instance = null;
        String expResult = "";
        String result = instance.getEventDescr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of getInviteList method, of class Event.
     */
    @Test
    public void testGetInviteList() {
        System.out.println("getInviteList");
        Event instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getInviteList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setID method, of class Event.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 0;
        Event instance = null;
        instance.setID(id);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setEventCreator method, of class Event.
     */
    @Test
    public void testSetEventCreator() {
        System.out.println("setEventCreator");
        Member newCreator = null;
        Event instance = null;
        instance.setEventCreator(newCreator);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setEventName method, of class Event.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String newName = "";
        Event instance = null;
        instance.setEventName(newName);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setEventDate method, of class Event.
     */
    @Test
    public void testSetEventDate() {
        System.out.println("setEventDate");
        String newDate = "";
        Event instance = null;
        instance.setEventDate(newDate);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setEventLoc method, of class Event.
     */
    @Test
    public void testSetEventLoc() {
        System.out.println("setEventLoc");
        String newLoc = "";
        Event instance = null;
        instance.setEventLoc(newLoc);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setEventDescr method, of class Event.
     */
    @Test
    public void testSetEventDescr() {
        System.out.println("setEventDescr");
        String newDescr = "";
        Event instance = null;
        instance.setEventDescr(newDescr);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setInviteList method, of class Event.
     */
    @Test
    public void testSetInviteList() {
        System.out.println("setInviteList");
        ArrayList<String> newInviteList = null;
        Event instance = null;
        instance.setInviteList(newInviteList);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of toString method, of class Event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Event instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addInvitee method, of class Event.
     */
    @Test
    public void testAddInvitee() {
        System.out.println("addInvitee");
        String invitee = "";
        Event instance = null;
        instance.addInvitee(invitee);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
