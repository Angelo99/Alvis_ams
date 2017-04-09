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
public class User {

    private String name;
    private int dept_id;
    private String dept;
    private String act_type;
    private String uname;
    private String pwd;
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rset;
    private String query;
    private String subquery;
    private int uid;

    public User(dbConnection db) {
        this.con = db.getConnection();
    }


    public boolean addUser(String name, String dept, String act_type, String uname, String pwd) throws SQLException {
        this.name = name;
        this.dept = dept;
        this.act_type = (String) act_type;
        this.uname = uname;
        this.pwd = pwd;
        this.subquery = "select * from department where dept_id = " + this.dept_id;
        this.rset = stm.executeQuery(this.subquery);
        while (rset.next()) {
            this.dept_id = Integer.parseInt(rset.getString("dept_id"));
        }
        this.query = "insert into user_details(name,dept_id,account_type) values('" + this.name + "','" + this.dept_id + "','" + this.act_type + "')";
        this.stm = con.prepareStatement(this.query);
        try{
            this.stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Added\nName: "+this.name+"\nAccount Type: "+this.act_type);
            return true;
        }
        catch(Exception e){
            return false;
        }
        
        //add login details if account type = "admin"
    }

   
    public boolean deleteUser(int uid) throws SQLException {
        this.uid = uid;
        this.query = "delete from user_details where uid ='" + this.uid + "'";
        this.stm = con.prepareStatement(this.query);
        try{
            this.stm.executeQuery();
            JOptionPane.showMessageDialog(null,"Record deleted");
            return true;
            
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean updateUser(int userid, String name, String dept, String act_type, String uname, String pwd) throws SQLException{
        this.name = name;
        this.dept = dept;
        this.act_type = act_type;
        this.uname = uname;
        this.pwd = pwd;
        this.stm = con.prepareStatement("update user_details set name=?, set dept=?, set account_type=?");
        this.stm.setString(1,this.name);
        //get dept id and add dept info and user login details
        this.stm.setString(3,this.act_type);
        return true;
    }
    private String temp="";
    public boolean UpdateUserName(String userid,String name)throws SQLException{
    
        this.temp=userid;
        this.name=name;
         
         this.stm = con.prepareStatement("update user_details set name=? where user_id=?");
        this.stm.setString(1,this.name);
       this.stm.setString(2,temp);
       stm.executeUpdate();
        return true;
    }
    
    private String dept_="";
      private String temp_="";
     public boolean UpdateDept(String dept_id,String user_id)throws SQLException{
         this.dept_=dept_id;
         this.temp_=user_id;
         this.stm = con.prepareStatement("update user_details set dept_id=? where user_id=?");
        this.stm.setString(1,this.dept_);
       this.stm.setString(2,temp_);
       stm.executeUpdate();
        return true;
    }
    

}
