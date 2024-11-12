/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adyapana.model;

import com.adyapana.gui.student;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author 1zt
 */
public class Load {
    
    
    public void loadCities(JComboBox c){
        try {
            
            String query = "SELECT * FROM adyapana.city";
            
            ResultSet rs = MySQL.search(query);
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadClasses(JComboBox c){
        try {
            
            String query = "SELECT * FROM adyapana.class";
            
            ResultSet rs = MySQL.search(query);
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadDistrict(JComboBox c){
        try {
            
            String query = "SELECT * FROM adyapana.district";
            
            ResultSet rs = MySQL.search(query);
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadCost(JComboBox c) {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM amount");
            
            Vector v = new Vector();
            v.add("Select");
            
            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public String status (String col) {
        String ret = null;
        try {
            ResultSet statusRs = MySQL.search("SELECT * FROM status WHERE status.id = '"+col+"'");
                statusRs.next();
                ret = statusRs.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
        
    }
    
    public String address (String id, String colName) {
        String ret = null;
        
        try {
            ResultSet adRs = MySQL.search("SELECT * FROM address WHERE address.id = '"+id+"'");
                adRs.next();
                ret = adRs.getString(colName);
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ret;
        
    }
    
     public void loadTeacher(JComboBox c) {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM teacher WHERE status_id = '1'");
            
            Vector v = new Vector();
            v.add("Select");
            
            while (rs.next()) {
                v.add( rs.getString("nic") + "_" + rs.getString("fname") +" "+ rs.getString("lname"));
            }
            
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      public void loadSubject(JComboBox c) {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM subject WHERE status_id = '1'");
            
            Vector v = new Vector();
            v.add("Select");
            
            while (rs.next()) {
                v.add(rs.getString("id")+"_"+rs.getString("name"));
            }
            
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
      public void loadMouth(JComboBox c) {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM month");
            
            Vector v = new Vector();
            v.add("Select");
            
            while (rs.next()) {
                v.add(rs.getString("id")+"_"+rs.getString("name"));
            }
            
            c.setModel(new DefaultComboBoxModel(v));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
