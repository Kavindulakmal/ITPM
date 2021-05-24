/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mycode.DBconnect;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author official
 */
public class Overlaping extends javax.swing.JInternalFrame {
        
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null; 
            Statement stmt = null;
    /**
     * Creates new form Overlaping
     */
    public Overlaping() {
        initComponents();
        
        con = DBconnect.connect();
        sessiontableload();
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
        OverTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        oversearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        OverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        OverTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OverTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OverTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Non Overlapping Sessions");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add Overlapping Sessions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("View Overlapping Sessions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Delete Overlapping Sessions");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        oversearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        oversearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oversearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Search");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton1)
                        .addGap(140, 140, 140)
                        .addComponent(jButton2)
                        .addGap(134, 134, 134)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(598, 598, 598)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oversearch, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(oversearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        int row = OverTable.getSelectedRow();
        
        String sid = OverTable.getValueAt(row, 0).toString();
        String firstLecturer = OverTable.getValueAt(row, 1).toString();
        String secondLecturer = OverTable.getValueAt(row, 2).toString();
        String tag = OverTable.getValueAt(row, 3).toString();
        String subjectCode = OverTable.getValueAt(row, 4).toString();      
        String subjectName = OverTable.getValueAt(row, 5).toString();
        String studentGroup = OverTable.getValueAt(row, 6).toString();
        String numberOfStudents = OverTable.getValueAt(row, 7).toString();
        String duration = OverTable.getValueAt(row, 8).toString();
        String day = OverTable.getValueAt(row, 9).toString();
        
        try {
       String g = "INSERT INTO overlappingsessions(sid,firstLecturer,secondLecturer,tag,subjectCode,subjectName,studentGroup, numberOfStudents, duration, day ) VALUES ('"+ sid +"','"+firstLecturer +"', '"+ secondLecturer +"', '"+ tag +"', '"+ subjectCode +"','"+ subjectName +"',"
                        + "'"+ studentGroup +"','"+ numberOfStudents +"', '"+ duration +"', '"+ day +"')";
                pst = con.prepareStatement(g);
                pst.execute();           
            }

            catch (Exception e) {
                       System.out.println(e);
            }
            
            JOptionPane.showMessageDialog(null, "The Overlapping session was added successfully.");    
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void oversearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oversearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oversearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String getvalue = oversearch.getText();
        
        String oversearch = "SELECT sid,firstLecturer,secondLecturer,tag,subjectCode,subjectName,studentGroup,numberOfStudents,duration,day FROM sessions WHERE getvalue = '"+ getvalue +"'";
        
        try {
        pst = con.prepareStatement(oversearch);
        rs = pst.executeQuery();
        
        OverTable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        
        catch (Exception e) {
                  System.out.println(e);
    }//GEN-LAST:event_jButton4ActionPerformed
        
    }
   
    public void overtableload() {
          
            try {
            String session = "SELECT sid,firstLecturer,secondLecturer,tag,subjectCode,subjectName,studentGroup,numberOfStudents,duration,day FROM overlappingsessions";
            pst = con.prepareStatement(session);
            rs = pst.executeQuery();

            OverTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
          
           catch (Exception e) {
                System.out.println(e);
            } 
            
    }
    
    private void OverTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OverTableMouseClicked
        
        int row = OverTable.getSelectedRow();
        
        String sid = OverTable.getValueAt(row, 0).toString();
        String firstLecturer = OverTable.getValueAt(row, 1).toString();
        String secondLecturer = OverTable.getValueAt(row, 2).toString();
        String tag = OverTable.getValueAt(row, 3).toString();
        String subjectCode = OverTable.getValueAt(row, 4).toString();      
        String subjectName = OverTable.getValueAt(row, 5).toString();
        String studentGroup = OverTable.getValueAt(row, 6).toString();
        String numberOfStudents = OverTable.getValueAt(row, 7).toString();
        String duration = OverTable.getValueAt(row, 8).toString();
        String day = OverTable.getValueAt(row, 9).toString();
    }//GEN-LAST:event_OverTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int Overdelete = JOptionPane.showConfirmDialog(null, "Do you want to delete this Overlapping session?");
        
        int row = OverTable.getSelectedRow();
        
        String sid = OverTable.getValueAt(row, 0).toString();
         
                try {
                    
                  String sql = "DELETE from overlappingsessions where sid = '"+ sid +"'";
                  pst = con.prepareStatement(sql);
                  pst.execute();

                  overtableload();

                  }

                  catch (Exception e) {
                      System.out.println(e);
                  }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             overtableload();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void sessiontableload() {
           
            try {
            String session = "SELECT sid,firstLecturer,secondLecturer,tag,subjectCode,subjectName,studentGroup,numberOfStudents,duration,day FROM sessions";
            pst = con.prepareStatement(session);
            rs = pst.executeQuery();

            OverTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
          
           catch (Exception e) {
                System.out.println(e);
            }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OverTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField oversearch;
    // End of variables declaration//GEN-END:variables
}
