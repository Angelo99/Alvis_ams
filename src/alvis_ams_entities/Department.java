/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvis_ams_entities;

import java.sql.*;
import ams_utilities.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nandun
 */
public class Department {

    private String deptName;
    private String deptDescription;
    private Connection con;
    private Statement stm;
    private String query;

    public Department(dbConnection db){
        this.con = db.getConnection();
    }
    public boolean addDept(String dept, String deptDescription) throws SQLException {
        this.deptName = dept;
        this.deptDescription = deptDescription;
        this.stm = con.createStatement();
        this.query = "insert into department(dept_name,description) values('" + this.deptName + "','" + this.deptDescription + "')";
        this.stm.executeUpdate(this.query);
        JOptionPane.showMessageDialog(null,"New Record Added\nDepartment: "+this.deptName);
        return true;
    }
    
    public boolean deleteDept(String name) throws SQLException{
        this.query = "delete from department where dept_name ='"+name+"'";
        System.out.println(this.query);
        this.stm = this.con.createStatement();
        try{
            this.stm.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null, "Record deleted");
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Record not deleted");
            return false;
        }
    }
    
    public void Update(int did, String name, String desc) throws SQLException{
        this.query = "update department set dept_name ='"+name+"', description = '"+desc+"' where dept_id = '"+did+"'";
        this.stm  = this.con.createStatement();
        try{
            this.stm.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null,"Record updated");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Record not updated");
        }
    }
}
