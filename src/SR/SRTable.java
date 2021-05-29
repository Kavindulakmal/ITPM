/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import location.AddLocation;
import location.ManageLocation;
import main.DAC;

/**
 *
 * @author Kale
 */
public class SRTable extends javax.swing.JFrame {

    private static String id;
    /**
     * Creates new form SRTable
     */
    public SRTable() {
        initComponents();
        displayJTable();
        setsessions();
        setRoom();
    }
    
    
    private void clear(){
        txtSubject.setText("");
        txtTag.setText("");
        txtLctr.setText("");
        txtGrp.setText("");
        txtSession.setText("");
        jLabel8.setText("");
        comboSession.setSelectedIndex(0);
        comboRoom.setSelectedIndex(0);
    }
    
    private void setsessions() {
        
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = new DAC().getConnection();

            preparedStatement = connection.prepareStatement("select * from consecutive");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            comboSession.addItem("~ Select sid ~");

            while(rs1.next())
            {
                comboSession.addItem(rs1.getString(1));
            }
        }catch ( SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private void setRoom(){
        
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = new DAC().getConnection();

            preparedStatement = connection.prepareStatement("select * from room");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            comboRoom.addItem("~ Select Room Code ~");

            while(rs1.next())
            {
                comboRoom.addItem(rs1.getString(1));
            }
        }catch ( SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private int resultSetCount(ResultSet resultSet) throws SQLException{
        try{
            int i = 0;
            while (resultSet.next()) {
                i++;
            }
            return i;
        } catch (Exception e){
           System.out.println("Error getting row count");
           e.printStackTrace();
        }
        return 0;
    }
    
    public void displayJTable(){
         
        String[] colNames = {"ID","Lecture 1","Lecture 2","Subject Code","Subject Nname","Group ID","Tag","Room Code","Room Name","Building","Room Type","Room Capactiy"};
        Object[][]rows= new Object[0][12];
        
        Connection connection;
        PreparedStatement preparedStatement;
        try{
            connection = new DAC().getConnection();

            preparedStatement = connection.prepareStatement("select sr.id,s.firstLecturer,s.secondLecturer,s.tag,s.subjectCode,s.subjectName,s.studentGroup,r.* from consecutive s,session_room sr,room r where sr.consecutive=s.sid and r.code=sr.room");
            
            ResultSet rs1 = preparedStatement.executeQuery();
            int x =resultSetCount(rs1);
            int i=0;
            System.out.println(x);
            rows= new Object[x][12];
            rs1 = preparedStatement.executeQuery();
            
            while(rs1.next())
            {
                System.out.println(i);
                System.out.println(rs1.getString(1));
                rows[i][0] = rs1.getString(1);
                rows[i][1] = rs1.getString(2);
                rows[i][2] = rs1.getString(3);
                rows[i][3] = rs1.getString(5);
                rows[i][4] = rs1.getString(6);
                rows[i][5] = rs1.getString(7);
                rows[i][6] = rs1.getString(4);
                rows[i][7] = rs1.getString(8);
                rows[i][8] = rs1.getString(9);
                rows[i][9] = rs1.getString(10);
                rows[i][10] = rs1.getString(11);
                rows[i][11] = rs1.getString(12);
                i++;
            }
            

        }catch ( SQLException  e) {
            System.out.println(e.getMessage());
        }
        
        DefaultTableModel tbm= new DefaultTableModel(rows,colNames);
        msrTable.setModel(tbm);
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
        msrTable = new javax.swing.JTable();
        comboSession = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboRoom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtLctr = new javax.swing.JLabel();
        txtTag = new javax.swing.JLabel();
        txtSubject = new javax.swing.JLabel();
        txtGrp = new javax.swing.JLabel();
        txtSession = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setForeground(new java.awt.Color(0, 255, 102));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        msrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        msrTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msrTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(msrTable);

        comboSession.setForeground(new java.awt.Color(102, 255, 204));
        comboSession.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboSession.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSessionItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Select Session");

        comboRoom.setForeground(new java.awt.Color(153, 255, 204));
        comboRoom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Select Room");

        txtLctr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtTag.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtSubject.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtGrp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtSession.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Session Details...........");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Edit");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("ReFresh");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Add New Session for room");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Add Rooms ");
        jButton5.setBorder(new javax.swing.border.MatteBorder(null));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Manage Rooms");
        jButton6.setBorder(new javax.swing.border.MatteBorder(null));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setActionCommand("Home");
        jButton7.setLabel("Home");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Add Location");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSession, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLctr, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(txtTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSession, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 268, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTag, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtSession, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLctr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txtGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );

        jButton4.getAccessibleContext().setAccessibleName("Add New room for session");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSessionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSessionItemStateChanged
        if(comboSession.getSelectedIndex()!=0){

            System.out.println(comboSession.getSelectedItem().toString());

            Connection connection;
            PreparedStatement preparedStatement;
            try{
                connection = new DAC().getConnection();

                preparedStatement = connection.prepareStatement("select s.*,s.firstLecturer,s.secondLecturer,s.tag,s.subjectCode,s.subjectName,s.studentGroup from consecutive s where s.sid=?");
                preparedStatement.setString(1, comboSession.getSelectedItem().toString());
                ResultSet rs1 = preparedStatement.executeQuery();

                while(rs1.next())
                 {   txtSubject.setText("Subject Name : "+rs1.getString(6)+"  "+"  "+" Subject Code : "+rs1.getString(5));
                    txtTag.setText("Tag : "+rs1.getString(4));
                    txtLctr.setText("Lecturer 1 : "+rs1.getString(2)+"  "+"  "+"Lecturer 2 : "+rs1.getString(3));
                    txtGrp.setText("Group : "+rs1.getString(7));
                    txtSession.setText("  Session ID : "+rs1.getString(1));
                    jLabel8.setText("  NumberOfStudent : "+rs1.getString(8));
                }
            }catch ( SQLException  e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_comboSessionItemStateChanged

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        clear();
        id=null;
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void msrTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msrTableMouseClicked
        int rowIndex = msrTable.getSelectedRow();
        id = msrTable.getValueAt(rowIndex, 0).toString();
        
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = new DAC().getConnection();

            preparedStatement = connection.prepareStatement("select * from session_room where id=?");
            preparedStatement.setString(1, id);
            ResultSet rs1 = preparedStatement.executeQuery();

            while(rs1.next())
            {
                comboSession.setSelectedItem(rs1.getString(2));
                comboRoom.setSelectedItem(rs1.getString(3));
            }
        }catch ( SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_msrTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!(comboSession.getSelectedIndex()==0||comboRoom.getSelectedIndex()==0)){
            Connection connection;
            PreparedStatement preparedStatement;
            try{
                connection = new DAC().getConnection();

                preparedStatement = connection.prepareStatement("update session_room set consecutive=? , room=? where id=?");
                preparedStatement.setString(1, comboSession.getSelectedItem().toString());
                preparedStatement.setString(2, comboRoom.getSelectedItem().toString());
                preparedStatement.setString(3, id);

                if(!preparedStatement.execute()){
                    JFrame f=new JFrame();  
                    JOptionPane.showMessageDialog(f,"Update Successful!");
                    clear();
                    displayJTable();
                }else{
                    JFrame f=new JFrame();  
                    JOptionPane.showMessageDialog(f,"Update Unsuccessful!");
                    clear();
                }

            }catch ( SQLException  e) {
                    System.out.println(e.getMessage());
            }
        }else{
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"Please Select!");
            clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = new DAC().getConnection();

            preparedStatement = connection.prepareStatement("delete from session_room where id=?");
            preparedStatement.setString(1, id);
            
            if(!preparedStatement.execute()){
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Update Successful!");
                clear();
                displayJTable();
            }else{
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Update Unsuccessful!");
                clear();
            }
            
        }catch ( SQLException  e) {
                System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFrame frame = new ManageSR();
        setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFrame frame = new AddLocation();
        setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFrame frame = new ManageLocation();
        setVisible(false);
        frame.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(SRTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SRTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SRTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SRTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SRTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboRoom;
    private javax.swing.JComboBox<String> comboSession;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable msrTable;
    private javax.swing.JLabel txtGrp;
    private javax.swing.JLabel txtLctr;
    private javax.swing.JLabel txtSession;
    private javax.swing.JLabel txtSubject;
    private javax.swing.JLabel txtTag;
    // End of variables declaration//GEN-END:variables

  
}
