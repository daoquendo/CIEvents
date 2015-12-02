/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cievents;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author brian
 */
public class DBUpdate
{
        String url = "jdbc:derby://localhost:1527/cievents";
        String userName = "student";
        String password = "student";
        
        public boolean add(String event, String desc, String month, String day, String year, String loc, String name)
        {
            String Query = "INSERT INTO APP.event (EVENT_NAME, EVENT_DESCR, EVENT_DATE, EVENT_LOC, EVENT_CREATOR) "
                    + "VALUES ('"+event+"' , '"+desc+"' , "
                    + "'"+month + day + year+"' , "
                    + "'"+loc+"', '"+name+"')";
             try{
           Connection con = DriverManager.getConnection(url, userName, password);
           Statement stm = con.createStatement();
           stm.execute(Query);
           return true;      
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
             return false;
        }
        
        public boolean addInvite(String email)
        {
            String Query = "INSERT INTO APP.invite (EMAIL) "
                    + "VALUES ('"+email+"')";
             try{
           Connection con = DriverManager.getConnection(url, userName, password);
           Statement stm = con.createStatement();
           stm.execute(Query);
           return true;      
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
             return false;
        }
        
        
        
        
        public DefaultTableModel getData()
        {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("EVENT_ID");
        model.addColumn("EVENT_NAME");
        model.addColumn("EVENT_DESCR");
        model.addColumn("EVENT_DATE");
        model.addColumn("EVENT_LOC");
        model.addColumn("EVENT_CREATOR");
        String Que = "Select * from APP.event";
        try{
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(Que);
          
            while (rs.next())
            {
                String ID = rs.getString(1);
                String event = rs.getString(2);
                String descr = rs.getString(3);
                String date = rs.getString(4);
                String loc = rs.getString(5);
                String creator = rs.getString(6);
                model.addRow(new String [] {ID, event, descr, date, loc, creator});
     
            }
            return model;
          
        }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
        }
     
        public boolean update(String id, String event, String desc, String month, String day, String year, String loc, String name)
        {
            String Query = "UPDATE APP.event SET EVENT_NAME = '"+event+"' ,EVENT_DESCR = '"+desc+"' , EVENT_DATE = '"+month + day + year+"' "
                    + ", EVENT_LOC ='"+loc+"', EVENT_CREATOR ='"+name+"' WHERE EVENT_ID = "+id+"";
             try{
           Connection con = DriverManager.getConnection(url, userName, password);
           Statement stm = con.createStatement();
           stm.execute(Query);
           return true;      
        }
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
             return false;
        }
        
           
         public boolean delete(String id)
        {
           String Query = "DELETE FROM app.event WHERE event_id =" + id +"";
                  // + "EVENT_NAME = '"+event+"' ,EVENT_DESCR = '"+desc+"' , EVENT_DATE = '"+month + day + year+"' "
                  //  + ", EVENT_LOC ='"+loc+"', EVENT_CREATOR ='"+name+"' WHERE EVENT_ID = '"+id+"'";
           try{
           Connection con = DriverManager.getConnection(url, userName, password);
           Statement stm = con.createStatement();
           stm.executeUpdate(Query);
           return true;      
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
             return false;
        }
         
         public boolean logincheck(String user, String pass) 
         {                                            
        // TODO add your handling code here:
 
        try{
            Connection conn = DriverManager.getConnection(url, userName, password);
            String Sql = "Select * from APP.MEMBER where email=? and password=?";
            PreparedStatement pst = conn.prepareStatement(Sql);
            pst.setString(1,user);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(null,"Welcome user");
                createEventsUI w = new createEventsUI();
                w.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid username or password", "Access Denied",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
        
    }   
    
}
