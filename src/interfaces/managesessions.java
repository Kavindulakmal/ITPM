/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import owncode.DBconnector;

/**
 *
 * @author Gayathree Rajakaruna
 */
public class managesessions extends javax.swing.JInternalFrame {

    /**
     * Creates new form managesessions
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;
    Statement stm ;
    String name;
    public managesessions() {
        //connect to DB
        con = DBconnector.connect();
        initComponents();
        
        tableRowDisplay();


        selectLecturer2();
        selectLecturer1();
        selectSubjectName();
        selectGroup();
        selectSubjectCode();
//        selectTag();

    }
        public void selectLecturer1(){

         try {
            stm = con.createStatement();
            
             rs = stm.executeQuery("select name from lecturers");
           
            while(rs.next()){
                
                String name = rs.getString("name");
                 sl1.addItem(name);
                 
              
            }
            } catch (Exception e) {
        }
      
    }
    public void selectLecturer2(){
        
         try {
            stm = con.createStatement();
            
             rs = stm.executeQuery("select name from lecturers");
           
            while(rs.next()){
                
                String name = rs.getString("name");
                 sl2.addItem(name);
                 
              
            }
            } catch (Exception e) {
        }
    }
    public void selectSubjectName(){
        
        try {
             stm = con.createStatement();
            
            rs = stm.executeQuery("select subname from subjects");
            
            while(rs.next()){
                String subname = rs.getString("subname");
                ssn1.addItem(subname);
                
            }
            
            
            
        } catch (Exception e) {
        }
        
    }
     public void selectSubjectCode(){
         
         try {
             stm = con.createStatement();
            
            rs = stm.executeQuery("select subcode from subjects");
            
            while(rs.next()){
                String subcode = rs.getString("subcode");
                ssc1.addItem(subcode);
                
            }
            
            
            
        } catch (Exception e) {
        }
        
    }
      public void selectGroup(){
        try {
             stm = con.createStatement();
            
            rs = stm.executeQuery("select StudentSubGroupID from studentgroups");
            
            while(rs.next()){
                String StudentSubGroupID = rs.getString("StudentSubGroupID");
                ssg1.addItem(StudentSubGroupID);
                
            }
            
            
            
        } catch (Exception e) {
        }
    }
//      public void selectTag(){
//           try {
//             stm = con.createStatement();
//            
//            rs = stm.executeQuery("select tagname from tags");
//            
//            while(rs.next()){
//                String tagname = rs.getString("tagname");
//                st3.addItem(tagname);
//                
//            }
//            
//            
//            
//        } catch (Exception e) {
//        }
//      }
    
    public void tableRowDisplay(){


            try {
                //getting data from database
             stm = con.createStatement();
            
            rs =stm.executeQuery("select * from `sessions` ");
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
            // inserting row while result set is not empty
            while(rs.next()){
                //using vector to insert row
                 java.util.Vector v=new java.util.Vector();
               
                 v.add(rs.getString("sid"));
                 v.add(rs.getString("firstLecturer"));
                 v.add(rs.getString("secondLecturer"));
                 v.add(rs.getString("tag"));
                 v.add(rs.getString("subjectCode"));
                 v.add(rs.getString("subjectName"));
                 v.add(rs.getString("studentGroup"));
                 v.add(rs.getString("numberOfStudents"));
                 v.add(rs.getString("duration"));
                
            }
            
            
            
        } catch (Exception e) {
        }

    }
    public void tableData(){
        
        int r= jTable.getSelectedRow();
        
        String sid=jTable.getValueAt(r, 0).toString();
        String firstLecturer=jTable.getValueAt(r, 1).toString();
        String secondLecturer=jTable.getValueAt(r, 2).toString();
        String tag=jTable.getValueAt(r, 3).toString();
        String subjectCode=jTable.getValueAt(r, 4).toString();
        String subjectName=jTable.getValueAt(r, 5).toString();
        String studentGroup=jTable.getValueAt(r, 6).toString();
        String numberOfStudents=jTable.getValueAt(r, 7).toString();
        String duration=jTable.getValueAt(r, 8).toString();
        
        
        
        sID.setText(sid);
        sl1.setSelectedItem(firstLecturer);
        sl2.setSelectedItem(secondLecturer);
        st3.setSelectedItem(tag);
        ssc1.setSelectedItem(subjectCode);
        ssn1.setSelectedItem(subjectName);
        ssg1.setSelectedItem(studentGroup);
        nstudent1.setText(numberOfStudents);
        time.setText(duration);
    }
    public void update(){
        
        String sid=sID.getText();
        
        String firstLecturer=sl1.getSelectedItem().toString();
        String secondLecturer=sl2.getSelectedItem().toString();
        String tag=st3.getSelectedItem().toString();
        String subjectCode=ssc1.getSelectedItem().toString();
        String subjectName=ssn1.getSelectedItem().toString();
        String studentGroup=ssg1.getSelectedItem().toString();
        
        String numberOfStudents=nstudent1.getText();
        String duration=time.getText();
        
        String sql ="UPDATE  `sessions` SET `firstLecturer`=' "+ firstLecturer+"',`secondLecturer`=' "+ secondLecturer+"',`tag`=' "+ tag+"',`subjectCode`=' "+ subjectCode+"',`subjectName`=' "+ subjectName+"',`studentGroup`=' "+ studentGroup+"',`numberOfStudents`=' "+ numberOfStudents+"',`duration`=' "+ duration + "' WHERE `sid`='" + sid + "'";
        
        try {
            
           pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update 'successfull");
        } catch (SQLException ex) {
            Logger.getLogger(managesessions.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, ex, "Update", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void clear(){
        sID.setText("");
        
        sl1.setSelectedIndex(0);
        sl2.setSelectedIndex(0);
        
        st3.setSelectedIndex(0);
        ssc1.setSelectedIndex(0);
        ssn1.setSelectedIndex(0);
        ssg1.setSelectedIndex(0);
        nstudent1.setText("");
        time.setText("");
    }
    public void delete() {
        int cheack = JOptionPane.showConfirmDialog(null, "Do you want to Delete!");

        if (cheack == 0) {

            String id = sID.getText();

            String sql = "DELETE FROM `sessions` WHERE sid='" + id + "' ";

            try {
                pst = con.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, " Deleted !");

            } catch (SQLException ex) {
                Logger.getLogger(managesessions.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(null, ex, "Delete", JOptionPane.ERROR_MESSAGE);
            }

        }

        tableRowDisplay();
        clear();
    }
    
    public void search() {
        String srch = jSearch.getText();

        String sql = "SELECT * FROM `sessions` WHERE  subjectCode LIKE'%" + srch + "%' OR sid LIKE'%" + srch + "%'";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs)); //set the data to tabale

        } catch (SQLException ex) {
            Logger.getLogger(managesessions.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex, "Search", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sID = new javax.swing.JTextField();
        sl1 = new javax.swing.JComboBox<>();
        sl2 = new javax.swing.JComboBox<>();
        st3 = new javax.swing.JComboBox<>();
        ssc1 = new javax.swing.JComboBox<>();
        ssn1 = new javax.swing.JComboBox<>();
        ssg1 = new javax.swing.JComboBox<>();
        nstudent1 = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        jSearch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewText = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("MANAGE SESSIONS");

        jTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "sid", "firstLecturer", "secondLecturer", "tag", "subjectCode", "subjectName", "studentGroup", "numberOfStudents", "duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("No.");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Select Lecturer (1):");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Select Lecturer(2):");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Select Subject Code:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Select Tag:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Select Subject Name:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Select Group:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Duration:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Number of  Students:");

        sID.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        sl1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        sl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 1" }));

        sl2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        sl2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 2", "-" }));

        st3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        st3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Tag", "Lecturer", "Tutorial", "Practicle" }));

        ssc1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        ssc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select subject code" }));

        ssn1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        ssn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select subject name" }));

        ssg1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        ssg1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select students Group" }));

        nstudent1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        time.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        viewButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        viewButton.setText("VIEW SESSION");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSearchKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Search Subject Code");

        viewText.setColumns(20);
        viewText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        viewText.setRows(5);
        jScrollPane2.setViewportView(viewText);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("CLEAR");
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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(174, 174, 174)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(243, 243, 243)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(viewButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sl1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sl2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(st3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ssc1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ssn1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ssg1, 0, 184, Short.MAX_VALUE)
                            .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(nstudent1))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(369, 369, 369))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(st3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ssn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ssg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nstudent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(2, 2, 2)))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        tableData();
        
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyPressed
        //tableData();
    }//GEN-LAST:event_jTableKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
        tableRowDisplay();
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       delete();
       clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyPressed
       search();
    }//GEN-LAST:event_jSearchKeyPressed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed

        String firstLecturer=sl1.getSelectedItem().toString();
        String secondLecturer=sl2.getSelectedItem().toString();
        String tag=st3.getSelectedItem().toString();
        String subjectCode=ssc1.getSelectedItem().toString();
        String subjectName=ssn1.getSelectedItem().toString();
        String studentGroup=ssg1.getSelectedItem().toString();
        
        String numberOfStudents=nstudent1.getText();
        String duration=time.getText();
        
//     viewText.append("***************************************************************************************************************************************************************************************************************************************************"
//             + "\n Lecture Name 1\t"+" Lecture Name 2\t"+" Subject Code"+" \t\t" +" Subject Name"+" \t\t" +" Tag\t"+" Student Group"+" \t\t" +" Number Of Student\t"+" Duration"
//             + "\n\n"+ firstLecturer +"\t"+ secondLecturer +"\t"+subjectCode+" \t\t"+subjectName+" \t\t"+tag+"\t"+studentGroup+"\t\t"+numberOfStudents+"\t\t"+duration
//             + "\n****************************************************************************************************************************************************************************************************************************************************");
     viewText.append(""+ firstLecturer+ "  -  " +secondLecturer+ "  -  "+subjectCode+"  -  "+subjectName+"  -  "+tag+"  -  "+studentGroup+"  -  "+numberOfStudents+"  -  "+duration+"");
       
    }//GEN-LAST:event_viewButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewText.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSearch;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField nstudent1;
    private javax.swing.JTextField sID;
    private javax.swing.JComboBox<String> sl1;
    private javax.swing.JComboBox<String> sl2;
    private javax.swing.JComboBox<String> ssc1;
    private javax.swing.JComboBox<String> ssg1;
    private javax.swing.JComboBox<String> ssn1;
    private javax.swing.JComboBox<String> st3;
    private javax.swing.JTextField time;
    private javax.swing.JButton viewButton;
    private javax.swing.JTextArea viewText;
    // End of variables declaration//GEN-END:variables

 
}
