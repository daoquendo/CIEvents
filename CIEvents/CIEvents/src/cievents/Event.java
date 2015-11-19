/**
 * Roberto Cervantes
 * Daniela Miles
 * Brian Ortiz
 * Brian Radomski
 */
package cievents;

import java.lang.*;
import java.util.*;

/**
 * 
 * @author brian.ortiz540
 */
public class Event {
    private int id; //primary key for event table, determined upon being added to the table
    private String eventName;
    private String eventDescr;
    private String eventDate;
    private String eventLoc;
    private Member eventCreator;
    private ArrayList<String> inviteList;
    
    public Event(int id, String name, String descr, String date, String loc, Member eventCreator, ArrayList<String> inviteList) {
        this.id = id;
        this.eventName = name;
        this.eventDescr = descr;
        this.eventDate = date;
        this.eventLoc = loc;
        this.eventCreator = eventCreator;
        this.inviteList = inviteList;
    }
    
    //accessors
    
    public int getID() {
        return this.id;
    }
    
    public Member getEventCreator() {
        return this.eventCreator;
    }
    
    public String getEventName() {
        return this.eventName;
    }
    
    public String getEventDate() {
        return this.eventDate;
    }
    
    public String getEventLoc() {
        return this.eventLoc;
    }
    
    public String getEventDescr() {
        return this.eventDescr;
    }
    
    public ArrayList<String> getInviteList() {
        ArrayList<String> copy = new ArrayList<String>(this.inviteList); 
        return copy;
    }
    
    //mutators
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setEventCreator(Member newCreator) {
        this.eventCreator = newCreator;
    }
    
    public void setEventName(String newName) {
        this.eventName = newName;
    }
    
    public void setEventDate(String newDate) {
        this.eventDate = newDate;
    }
    
    public void setEventLoc(String newLoc) {
        this.eventLoc = newLoc;
    }
    
    public void setEventDescr(String newDescr) {
        this.eventDescr = newDescr;
    }
    
    public void setInviteList(ArrayList<String> newInviteList) {
        this.inviteList = newInviteList;
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String invitee : this.inviteList)
            str.append(invitee + "\n");
        
        return "Event Name: " + this.eventName + "\nEvent Organizer: " + this.eventCreator.getEmail() + "\nDescription: " + this.eventDescr + "\nDate: " + this.eventDate + "\nLocation: " + this.eventLoc + "\nInvitees:\n" + str.toString();
    }
    
    //business methods
    
    public void addInvitee(String invitee) {
        this.inviteList.add(invitee);
    }
    
}
