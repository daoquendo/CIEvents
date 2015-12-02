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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of addEvent method, of class Database.
     */
    @Test
    public void testAddEvent() {
        System.out.println("addEvent");
        Event newEvent = null;
        Database instance = new Database();
        boolean expResult = false;
        boolean result = instance.addEvent(newEvent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvent method, of class Database.
     */
    @Test
    public void testGetEvent_Event() {
        System.out.println("getEvent");
        Event event = null;
        Database instance = new Database();
        Event expResult = null;
        Event result = instance.getEvent(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvent method, of class Database.
     */
    @Test
    public void testGetEvent_int() {
        System.out.println("getEvent");
        int eventID = 0;
        Database instance = new Database();
        Event expResult = null;
        Event result = instance.getEvent(eventID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvent method, of class Database.
     */
    @Test
    public void testGetEvent_String() {
        System.out.println("getEvent");
        String eventName = "";
        Database instance = new Database();
        Event expResult = null;
        Event result = instance.getEvent(eventName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editEvent method, of class Database.
     */
    @Test
    public void testEditEvent() {
        System.out.println("editEvent");
        Event editedEvent = null;
        Database instance = new Database();
        instance.editEvent(editedEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Database.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Event event = null;
        Database instance = new Database();
        boolean expResult = false;
        boolean result = instance.contains(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventID method, of class Database.
     */
    @Test
    public void testGetEventID() {
        System.out.println("getEventID");
        Event event = null;
        Database instance = new Database();
        int expResult = 0;
        int result = instance.getEventID(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberEventList method, of class Database.
     */
    @Test
    public void testGetMemberEventList() {
        System.out.println("getMemberEventList");
        Member member = null;
        Database instance = new Database();
        ArrayList<Event> expResult = null;
        ArrayList<Event> result = instance.getMemberEventList(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventList method, of class Database.
     */
    @Test
    public void testGetEventList() {
        System.out.println("getEventList");
        Database instance = new Database();
        ArrayList<Event> expResult = null;
        ArrayList<Event> result = instance.getEventList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvent method, of class Database.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        Event event = null;
        Database instance = new Database();
        instance.deleteEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInvite method, of class Database.
     */
    @Test
    public void testAddInvite() {
        System.out.println("addInvite");
        int eventID = 0;
        String email = "";
        Database instance = new Database();
        boolean expResult = false;
        boolean result = instance.addInvite(eventID, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInviteList method, of class Database.
     */
    @Test
    public void testGetInviteList() {
        System.out.println("getInviteList");
        int eventID = 0;
        Database instance = new Database();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getInviteList(eventID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteInviteList method, of class Database.
     */
    @Test
    public void testDeleteInviteList() {
        System.out.println("deleteInviteList");
        int eventID = 0;
        Database instance = new Database();
        instance.deleteInviteList(eventID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMember method, of class Database.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        Member newMember = null;
        Database instance = new Database();
        boolean expResult = false;
        boolean result = instance.addMember(newMember);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class Database.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        Member member = null;
        Database instance = new Database();
        Member expResult = null;
        Member result = instance.getMember(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberList method, of class Database.
     */
    @Test
    public void testGetMemberList() {
        System.out.println("getMemberList");
        Database instance = new Database();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllTableData method, of class Database.
     */
    @Test
    public void testDeleteAllTableData() {
        System.out.println("deleteAllTableData");
        Database instance = new Database();
        instance.deleteAllTableData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
