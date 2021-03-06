/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvis_ams_admin;

import ams_utilities.dbConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Nandun
 */
public class TimeLogs extends javax.swing.JFrame {

    private Connection conn;
    private Statement stm;
    private ResultSet rset;
    private String query;
    private String date;

    /**
     * Creates new form TimeLogs
     *
     * @throws java.sql.SQLException
     */
    public TimeLogs() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        dbConnection db = new dbConnection("ams", "root", null);
        this.conn = db.getConnection();
        this.stm = conn.createStatement();
        this.query = "select u.name as 'Name', d.dept_name as 'Department', t.date as 'Date', t.time as 'Time' from user_details u inner join department d on u.dept_id = d.dept_id inner join time_log t on t.user_id = u.user_id order by t.date";
        this.rset = stm.executeQuery(query);
        jTable1.setModel(DbUtils.resultSetToTableModel(rset));
        stm.close();
        this.conn.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnShowAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Time Logs");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Department", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel1.setText("Filter by Date");

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnShowAll)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowAll, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        dbConnection db = new dbConnection("ams", "root", null);
        this.conn = db.getConnection();
        try {
            if (jDateChooser1.getDate() == null) {
                this.query = "select u.name as 'Name', d.dept_name as 'Department', t.date as 'Date', t.time as 'Time' from user_details u inner join department d on u.dept_id = d.dept_id inner join time_log t on t.user_id = u.user_id order by t.date";
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                this.date = sdf.format(jDateChooser1.getDate());
                this.query = "select u.name as 'Name', d.dept_name as 'Department', t.date as 'Date', t.time as 'Time' from user_details u inner join department d on u.dept_id = d.dept_id inner join time_log t on t.user_id = u.user_id where t.date='" + this.date + "' order by t.date";
            }
            this.stm = conn.createStatement();
            this.rset = stm.executeQuery(query);
            jTable1.setModel(DbUtils.resultSetToTableModel(rset));
            stm.close();
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TimeLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // TODO add your handling code here:
        dbConnection db = new dbConnection("ams", "root", null);
        this.conn = db.getConnection();
        try {
            this.stm = conn.createStatement();
            this.query = "select u.name as 'Name', d.dept_name as 'Department', t.date as 'Date', t.time as 'Time' from user_details u inner join department d on u.dept_id = d.dept_id inner join time_log t on t.user_id = u.user_id order by t.date";
            this.rset = stm.executeQuery(query);
            jTable1.setModel(DbUtils.resultSetToTableModel(rset));
            stm.close();
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TimeLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimeLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TimeLogs().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TimeLogs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowAll;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
