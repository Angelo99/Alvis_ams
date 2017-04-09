/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams_utilities;

import java.sql.*;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Angelo
 */
public class dbConnection {

    //constroctor uname:pw
    //select datbase
    //select table
    //grab values
    private String Database;
    private String userName;
    private String pw;
    private Connection con; //
    private Statement stm;
    private ResultSet rset;
    private Calendar cal;
    private SimpleDateFormat sdf_time;
    private SimpleDateFormat sdf_date;
    private String time;
    private String date;
    private String query;

    public dbConnection(String db, String username, String Password) {
        try {
            this.Database = db;
            this.userName = username;
            this.pw = Password;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, username, Password);
            if (!con.isClosed()) {
                System.out.println("Database is Open");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    /**
     * CHECK IF DATABASE OPEN OR NOT
     *
     * @return TRUE IF DATABASE IS OPEN RETURN FALSE IF DATABASE IS NOT OPEN
     */
    public Boolean isOpen() {

        boolean value = false;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.Database, this.userName, this.pw);
            if (!con.isClosed()) {
                value = true;
            } else {
                value = false;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return value;

    }

    /**
     * THIS METHOD IS USEING FOR CHECK IF AUTH OK OR NOT.
     *
     * @param username PROVIDE USERNAME
     * @param password PROVIDE PASSWORD
     * @return RETURN STRING VAILD IF USER NAME AND PASSWORD IS OK/RETURN FALSE
     * INVAILD IF USER NAME AND PASSWORD IS NOT OK
     */
    public String checkLogin(String username, String password) {

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.Database, this.userName, this.pw);
            PreparedStatement pst = con.prepareStatement("Select * from user_login where uname=? and pwd=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return "Vaild";
            } else {
                return "Invaild";
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return "Something Wrong Error NO:#100";
    }

    public Connection getConnection() {
        return this.con;
    }

    public boolean addTimeLog(int uid) throws SQLException {
        /////statements
        this.stm = con.createStatement();
        this.cal = Calendar.getInstance();
        this.sdf_time = new SimpleDateFormat("HH:mm:ss");
        this.sdf_date = new SimpleDateFormat("yyyy/MM/dd");
        this.time = sdf_time.format(cal.getTime());
        this.date = sdf_date.format(cal.getTime());

        this.query = "insert into time_log(user_id,date,time) values('" + uid + "','" + date + "','" + time + "')";
        try {
            this.stm.executeUpdate(query);
            this.query = "select * from user_details where user_id='"+uid+"'";
            String name=null;
            this.rset = stm.executeQuery(query);
            while(rset.next()){
                name = rset.getString("name");
            }
            JOptionPane.showMessageDialog(null, "Time logged in\n\nName: "+name);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public void close() throws SQLException {
        con.close();
    }

}
