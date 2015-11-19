/**
 * Roberto Cervantes
 * Daniela Miles
 * Brian Ortiz
 * Brian Radomski
 */
package cievents;

import java.util.*;

/**
 * @author brian.ortiz540
 */
public class CIEvents {
    
    public static void main(String[] args) {
        Database db = new Database();
        db.deleteAllTableData();
        //creating members
        Member me = new Member("Brian Ortiz", "botw89lozla");
        Member him = new Member("Brian Radomski", "sot89lozoot");
        Member her = new Member("Daniela Miles", "nos89lozoot");
        
        //adding members 
        db.addMember(me);
        db.addMember(him);
        db.addMember(her);
        
        //testing getMemberList
        ArrayList<Member> memberList = db.getMemberList();
        for (Member member : memberList)
            System.out.println(member.toString());
        
        //creating invite lists
        ArrayList<String> myInvitees = new ArrayList<String>();
        myInvitees.add("brianortiz@gmail.com");
        myInvitees.add("brianradomski@gmail.com");
        
        ArrayList<String> hisInvitees = new ArrayList<String>(myInvitees);
        hisInvitees.add("javiermercado@gmail.com");
        
        ArrayList<String> herInvitees = new ArrayList<String>(myInvitees);
        herInvitees.add("robertocervantes@gmail.com");
        
        //creating events
        Event event1 = new Event(0, "Super Smash Bros. Melee Tournament 1", "Competitive SSBM tournament.", "11/18/15", "Thousand Oaks Mall", me, myInvitees);
        Event event2 = new Event(0, "Super Smash Bros. Melee Tournament 2", "Competitive SSBM tournament.", "11/18/15", "Thousand Oaks Mall", him, hisInvitees);
        Event event3 = new Event(0, "Super Smash Bros. Melee Tournament 3", "Competitive SSBM tournament.", "11/18/15", "Thousand Oaks Mall", her, herInvitees);
        
        db.addEvent(event1);
        db.addEvent(event2);
        db.addEvent(event3);
        
        //edit event1
        Event editedEvent = db.getEvent(event1);
        editedEvent.setEventDate("11/19/15");
        db.editEvent(editedEvent);
        
        ArrayList<Event> eventList = db.getEventList();
        
        for(Event tmp : eventList)
            System.out.println(tmp.toString());
        
     
    }
    
}
