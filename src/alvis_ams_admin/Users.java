/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvis_ams_admin;

import alvis_ams_entities.User;
import alvis_ams_entities.passValues;
import ams_utilities.dbConnection;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Nandun
 */

public class Users extends javax.swing.JFrame {

    /**
     * Creates new form Users
     */
    public Users() {
        initComponents();
        this.setLocationRelativeTo(this.rootPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ams?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        userDetailsQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM UserDetails u");
        userDetailsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : userDetailsQuery.getResultList();
        userDetailsQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM UserDetails u");
        userDetailsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : userDetailsQuery1.getResultList();
        userDetailsQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM UserDetails u");
        userDetailsList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : userDetailsQuery2.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newUserBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Users");
        setName("mainFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userDetailsList1, org.jdesktop.beansbinding.ObjectProperty.create(), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        newUserBtn.setText("New ");
        newUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newUserBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserBtn)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private   Connection con_;
    private   Statement stm;
    private   ResultSet rset;
    private String deptName="";
    JComboBox virtual=new JComboBox ();
    private void newUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserBtnActionPerformed
        try {
            // TODO add your handling code here:
            AddUser x = new AddUser();
            x.setVisible(true);
            x.setLocationRelativeTo(this.rootPane);
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newUserBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:.
        int row = jTable1.getSelectedRow();
        dbConnection con=new dbConnection("ams", "root", "");
        User x=new User(con);
        try{
            
         x.UpdateUserName((String) jTable1.getModel().getValueAt( row, 0), (String) jTable1.getModel().getValueAt( row, 1));
            System.out.println((String) jTable1.getModel().getValueAt( row, 2));
        }
        catch (Exception ex){
        System.out.println(ex.getMessage());
        }
        
        //jcombobox changed vale
         try{
          dbConnection db = new dbConnection("ams", "root", "");
        con_ = db.getConnection();
        String query = "SELECT * FROM department WHERE dept_name= '"+virtual.getSelectedItem().toString()+"' ";
         
        stm = con_.createStatement();
        rset = stm.executeQuery(query);
        while(rset.next()){
            deptName = rset.getString("dept_id");
           x.UpdateDept(deptName, (String) jTable1.getModel().getValueAt( row, 0));
             
        }
         }
         catch (Exception ex){
         
         }
        
    }//GEN-LAST:event_jTable1PropertyChange
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
 
        Vector row = new Vector();
   
   
        
     
         
       TableColumn col=null;
  
        Object x=null;
       
        String sql = "SELECT * FROM user_details RIGHT JOIN department ON user_details.dept_id=department.dept_id  ";
          try 
          {   
        Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "ams", "root", "");
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;  
        ps=con.prepareStatement(sql);  

        rs=ps.executeQuery();
        int co=0;
        
        while (rs.next()) {  
              
            String user_id = rs.getString("user_id");
            String id = rs.getString("dept_name");
            String name = rs.getString("name");
             col=jTable1.getColumnModel().getColumn(2);
                virtual.insertItemAt(id, co);
                row.add(user_id);
            row.add(name);
             row.add(id);

           
             model.addRow(new Object[]{user_id,name});
               
           co++;
          
        }

          }
          catch(Exception ex){}
          
               col.setCellEditor(new DefaultCellEditor(virtual));
                         virtual.setSelectedIndex(0);

    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
     int row = jTable1.getSelectedRow();
         System.out.println((String) jTable1.getModel().getValueAt( row, 0));
         System.out.println((String) jTable1.getModel().getValueAt( row, 1));
         //System.out.println((String) jTable1.getModel().getValueAt( row, 2));
    }//GEN-LAST:event_jTable1MouseClicked

   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       while(model.getRowCount()>0){
           
           for(int i=0;i<model.getRowCount();i++){
               model.removeRow(i);
           }
       }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newUserBtn;
    private java.util.List<alvis_ams_admin.UserDetails> userDetailsList;
    private java.util.List<alvis_ams_admin.UserDetails> userDetailsList1;
    private java.util.List<alvis_ams_admin.UserDetails> userDetailsList2;
    private javax.persistence.Query userDetailsQuery;
    private javax.persistence.Query userDetailsQuery1;
    private javax.persistence.Query userDetailsQuery2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
