/**
 * Roberto Cervantes
 * Daniela Miles
 * Brian Ortiz
 * Brian Radomski
 */

package cievents;

import java.sql.*;
import java.util.*;

/**
 *
 * @author brianortiz
 */
public class Database {
    Connection con;
    
    public Database() {
        String url = "jdbc:derby://localhost:1527/cievents";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String userName = "student";
        String password = "student";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe);
        }
        
        Statement stmt = null;
        try {
            this.con = DriverManager.getConnection(url, userName, password);
            stmt = this.con.createStatement();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        
        //create event table (ignored if already exists)
        try {
            stmt.execute("CREATE TABLE APP.event(event_id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "event_name varchar(64),"
                    + "event_descr varchar(512)," 
                    + "event_date varchar(32)," 
                    + "event_loc varchar(32),"
                    + "event_creator varchar(64))");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        
        //create member table (ignored if already exists)
        try {
            stmt.execute("CREATE TABLE APP.member(email varchar(64)," 
                    + "password varchar(64))");
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }

        //create invite table (ignored if already exists)
        try {
            stmt.execute("CREATE TABLE APP.invite(event_id int NOT NULL,"
                    + "email varchar(64))");
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        
    }
    
    //event table methods
    public boolean addEvent(Event newEvent) {
        boolean result = true;
        String sql = "INSERT INTO APP.event(event_name,event_descr,event_date,event_loc,event_creator) VALUES(\'" + newEvent.getEventName() + "\',\'" + newEvent.getEventDescr() + "\',\'" + newEvent.getEventDate() + "\',\'" + newEvent.getEventLoc() + "\',\'" + newEvent.getEventCreator().getEmail() + "\')" ;
        try {
            if (contains(newEvent)) throw new SQLException();
            Statement stmt = this.con.createStatement();
            stmt.execute(sql);
            int eventID = getEventID(newEvent);
            //add invitees to the invite table
            ArrayList<String> inviteList = newEvent.getInviteList();
            for (String email: inviteList)
                addInvite(eventID, email);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            result = false;
        }
        return result;
    }
    
    public Event getEvent(Event event) {
        Event requested = null;
        String sql = "SELECT * FROM APP.event WHERE event_name = \'" + event.getEventName() + "\' AND event_descr = \'" + event.getEventDescr() + "\'" + " AND event_date = \'" + event.getEventDate() + "\' AND event_loc = \'" + event.getEventLoc() + "\' AND event_creator = \'" + event.getEventCreator().getEmail() + "\'";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
            {
                Member eventCreator = new Member(rs.getString("event_creator"), "" ); //the member's password is passed as an empty String
                ArrayList<String> inviteList = getInviteList(rs.getInt("event_id"));
                requested = new Event(rs.getInt("event_id"), rs.getString("event_name"), rs.getString("event_descr"), rs.getString("event_date"), rs.getString("event_loc"), eventCreator, inviteList);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }       
        return requested;
    }
    
    public Event getEvent(int eventID) {
        Event requested = null;
        String sql = "SELECT * FROM APP.event WHERE event_id = " + eventID;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
            {
                Member eventCreator = new Member(rs.getString("event_creator"), "" ); //the member's password is passed as an empty String
                ArrayList<String> inviteList = getInviteList(eventID);
                requested = new Event(eventID, rs.getString("event_name"), rs.getString("event_descr"), rs.getString("event_date"), rs.getString("event_loc"), eventCreator, inviteList);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }       
        return requested;
    }  
    
    public Event getEvent(String eventName) {
        Event requested = null;
        String sql = "SELECT * FROM APP.event WHERE event_name =\'" + eventName + "\'";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
            {
                Member eventCreator = new Member(rs.getString("event_creator"), "" ); //the member's password is passed as an empty String
                ArrayList<String> inviteList = getInviteList(rs.getInt("event_id"));
                requested = new Event(rs.getInt("event_id"), rs.getString("event_name"), rs.getString("event_descr"), rs.getString("event_date"), rs.getString("event_loc"), eventCreator, inviteList);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }       
        return requested;
    }
    
    public void editEvent(Event editedEvent)
    {
        String sql = "UPDATE APP.event SET event_name = \'" + editedEvent.getEventName() + "\'," 
                + "event_descr = \'" + editedEvent.getEventDescr() + "\'," 
                + "event_date = \'" + editedEvent.getEventDate() + "\'," 
                + "event_loc = \'" + editedEvent.getEventLoc() + "\' "
                + "WHERE event_id = " + editedEvent.getID();
        try {
            Statement stmt = this.con.createStatement();
            stmt.execute(sql);
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }
    
    public boolean contains(Event event)
    {
        return getEvent(event) != null;
    }
    
    public int getEventID(Event event) {
        int id = -1;
        String sql = "SELECT * FROM APP.event WHERE event_name = \'" + event.getEventName() + "\' AND event_descr = \'" + event.getEventDescr() + "\'" + " AND event_date = \'" + event.getEventDate() + "\' AND event_loc = \'" + event.getEventLoc() + "\' AND event_creator = \'" + event.getEventCreator().getEmail() + "\'";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                id = rs.getInt("event_id");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return id;
    }
    
    public ArrayList<Event> getMemberEventList(Member member)
    {
        ArrayList<Event> memberEventList = new ArrayList<Event>();
        String sql = "SELECT * FROM APP.event  WHERE event_creator = \'" + member.getEmail() + "\'";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                memberEventList.add(getEvent(rs.getInt("event_id")));
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return memberEventList;
    }
    
    public ArrayList<Event> getEventList() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        String sql = "SELECT * FROM APP.event";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                eventList.add(getEvent(rs.getInt("event_id")));
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return eventList;
    }
    
    public void deleteEvent(Event event)
    {
        String sql = "DELETE * FROM APP.event WHERE event_name = \'" + event.getEventName() + "\' AND event_descr = \'" + event.getEventDescr() + "\'" + " AND event_date = \'" + event.getEventDate() + "\' AND event_loc = \'" + event.getEventLoc() + "\' AND event_creator = \'" + event.getEventCreator().getEmail() + "\'";
        try {
            Statement stmt = this.con.createStatement();
            stmt.execute(sql);
            
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        deleteInviteList(event.getID());
    }
    
    //invite table methods
    public boolean addInvite(int eventID, String email) {
        boolean result = true;
        String sql = "INSERT INTO APP.invite(event_id,email) VALUES(" + eventID + ",\'" + email + "\')";
        try {
            Statement stmt = this.con.createStatement();
            stmt.execute(sql);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            result = false;
        }
        return result;
    }
    
    public ArrayList<String> getInviteList(int eventID) {
        ArrayList<String> inviteList = new ArrayList<String>();
        String sql = "SELECT * FROM APP.invite WHERE event_id = " + eventID;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                inviteList.add(rs.getString("email"));
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return inviteList;
    }
    
    public void deleteInviteList(int eventID)
    {
        String sql = "DELETE * FROM APP.invite WHERE event_id = " + eventID;
        try {
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(sql);       
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
    
    //member table methods
    public boolean addMember(Member newMember) {
        boolean result = true;
        String sql = "INSERT INTO APP.member(email,password) VALUES(\'" + newMember.getEmail() + "\'," + "\'"+ newMember.getPassword() +"\')";
        try {
            Statement stmt = this.con.createStatement();
            stmt.execute(sql);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            result = false;
        }
        return result;
    }
    
    public Member getMember(Member member) {
        Member requested = null;
        String sql = "SELECT * FROM APP.member WHERE email = \'" + member.getEmail() + "\' AND password = \'" + member.getPassword() + "\'";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                requested = new Member(rs.getString("email"),rs.getString("password"));
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return requested;
    }
    
    public ArrayList<Member> getMemberList() {
        ArrayList<Member> memberList = new ArrayList<Member>();
        String sql = "SELECT * FROM APP.member";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                memberList.add(new Member(rs.getString("email"),rs.getString("password")));
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        
        return memberList;
    }
    
    public void deleteAllTableData()
    {
        try {
            Statement stmt = this.con.createStatement();
            stmt.execute("DELETE FROM APP.event");
            stmt.execute("DELETE FROM APP.invite");
            stmt.execute("DELETE FROM APP.member");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    } 
}
