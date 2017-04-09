/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvis_ams_entities;

import ams_utilities.dbConnection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nandun
 */
public class UserAccounts {

    private int id;
    private String userAccount_name;
    private String description;
    private Connection conn;
    private Statement stm;
    private String query;

    public UserAccounts(dbConnection db) {
        this.conn = db.getConnection();
    }

    public void AddUserAccount(String name, String description) throws SQLException {
        this.userAccount_name = name;
        this.description = description;
        this.query = "insert into user_roles(role_name,description) values('" + this.userAccount_name + "','" + this.description + "')";
        this.stm = this.conn.createStatement();
        try {
            this.stm.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null, "Record inserted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void DeleteUserAccount(int id) throws SQLException {
        this.id = id;
        this.query = "delete from user_roles where role_id='" + this.id + "'";
        this.stm = this.conn.createStatement();
        try {
            this.stm.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null, "Record deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateUserAccount(int id, String name, String description) throws SQLException {
        this.id = id;
        this.userAccount_name = name;
        this.description = description;
        this.query = "update user_roles set role_name='" + this.userAccount_name + "', description = '" + this.description + "'";
        this.stm = this.conn.createStatement();
        try {
            this.stm.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null, "Record updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
