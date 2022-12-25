
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Prabuddi Sathyanka
 */
public class RegisterStudents extends javax.swing.JFrame {

    /**
     * Creates new form RegisterStudents
     */
    public RegisterStudents() {
        initComponents();
        DisplayStudent();
    }

    public void DisplayStudent(){
    try{
       
       
        String sql = "SELECT * FROM `student`";
        PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)tblRegisterdStudents.getModel();
          
          tm.setRowCount(0);
while(rs.next())
{
   Object o[]={rs.getInt("studentID"),rs.getString("name"),rs.getString("department"),rs.getString("studentYear")};
       tm.addRow(o);
      
}
          
    
    
    }catch(Exception e){
    
    System.out.println(e.getMessage());
    
    }

}
    int studentID;
private void StudentCount(){
 try{       
        String sql = "SELECT MAX(studentID) FROM `student`";
          PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
          ResultSet rs1 = p.executeQuery();
          rs1.next();
          studentID = rs1.getInt(1)+1;
     
 }catch (Exception e){
 
 }

}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBooks = new javax.swing.JLabel();
        lblStudents = new javax.swing.JLabel();
        lblLibrarian = new javax.swing.JLabel();
        lblReturnBooks = new javax.swing.JLabel();
        lblIssueBooks = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRegisterdStudents = new javax.swing.JTable();
        lblRegisterStudents = new javax.swing.JLabel();
        lblBookTitle2 = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        lblDepartment = new javax.swing.JLabel();
        combxDepartment = new javax.swing.JComboBox<>();
        cmbYear = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        lblBooks.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblBooks.setForeground(new java.awt.Color(204, 204, 204));
        lblBooks.setText("Books");

        lblStudents.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblStudents.setForeground(new java.awt.Color(204, 204, 204));
        lblStudents.setText("Students");

        lblLibrarian.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblLibrarian.setForeground(new java.awt.Color(204, 204, 204));
        lblLibrarian.setText("Librarian");

        lblReturnBooks.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblReturnBooks.setForeground(new java.awt.Color(204, 204, 204));
        lblReturnBooks.setText("Return Books");

        lblIssueBooks.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblIssueBooks.setForeground(new java.awt.Color(204, 204, 204));
        lblIssueBooks.setText("Issue Books");

        lblUserName.setBackground(new java.awt.Color(204, 204, 255));
        lblUserName.setForeground(new java.awt.Color(204, 204, 204));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIssueBooks)
                            .addComponent(lblReturnBooks)
                            .addComponent(lblLibrarian)
                            .addComponent(lblStudents)
                            .addComponent(lblBooks))
                        .addGap(54, 54, 54))
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(481, 481, 481))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(lblBooks)
                .addGap(27, 27, 27)
                .addComponent(lblLibrarian)
                .addGap(33, 33, 33)
                .addComponent(lblStudents)
                .addGap(33, 33, 33)
                .addComponent(lblIssueBooks)
                .addGap(34, 34, 34)
                .addComponent(lblReturnBooks)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(211, 211, 211));

        tblRegisterdStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Department", "Year"
            }
        ));
        tblRegisterdStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegisterdStudentsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRegisterdStudents);

        lblRegisterStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisterStudents.setText("Register Students");

        lblBookTitle2.setText("Student Name");

        lblYear.setText("Year");

        lblDepartment.setText("Department");

        combxDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICT", "Physic", "BIO" }));

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year" }));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(combxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(lblRegisterStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(lblBookTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(lblDepartment))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(combxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnClear)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(lblRegisterStudents)
                    .addGap(24, 24, 24)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBookTitle2)
                        .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDepartment))
                    .addGap(150, 150, 150)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
          String department= combxDepartment.getSelectedItem().toString();
    String year= cmbYear.getSelectedItem().toString();        
         DefaultTableModel tableModel=(DefaultTableModel)tblRegisterdStudents.getModel();
                  int myIndex  = tblRegisterdStudents.getSelectedRow();
                  key = Integer.valueOf(tableModel.getValueAt(myIndex, 0).toString());
        try{
           
            PreparedStatement ps;        
            String sql = "UPDATE `student` SET `studentID`=?,`name`=?,`department`=?,`studentYear`=? WHERE `studentID`=? ";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,key);
            ps.setString(2,txtStudentName.getText());
            ps.setString(3,department);
            ps.setString(4,year);
             ps.setInt(5,key);
             if(ps.executeUpdate() > 0){
                
                  
            DisplayStudent();
             JOptionPane.showMessageDialog(this,"Details updated Successfuly!!");
            }
            else{
            
            JOptionPane.showMessageDialog(this,"Missing Information!");
           // System.out.println(e.getMessage());
            }
            
            
        }
        catch( Exception e){
        JOptionPane.showMessageDialog(this,"Mising information");
         System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         
   
                  
    
    String Name= txtStudentName.getText(); 
    String department= combxDepartment.getSelectedItem().toString();
    String year= cmbYear.getSelectedItem().toString();      
                
    try {
        PreparedStatement ps;      
        String sql = ("INSERT INTO `student`(`studentID`, `name`, `department`, `studentYear`) VALUES (?,?,?,?)");
            ps = MyConnection.getConnection().prepareStatement(sql);           
            StudentCount();
            ps.setInt(1,studentID);
            ps.setString(2,Name);
            ps.setString(3,department);
            ps.setString(4,year);
           
           
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Student details added Successfully!");
            DisplayStudent();
            ps.close();
         
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    
    }//GEN-LAST:event_btnSaveActionPerformed
int key = 0;
    private void tblRegisterdStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegisterdStudentsMouseClicked
       DefaultTableModel tableModel=(DefaultTableModel)tblRegisterdStudents.getModel();
                  int myIndex  = tblRegisterdStudents.getSelectedRow();
                  key = Integer.valueOf(tableModel.getValueAt(myIndex, 0).toString());
                  txtStudentName.setText(tableModel.getValueAt(myIndex, 1).toString());
                 combxDepartment.setSelectedItem(String.valueOf(tableModel.getValueAt(myIndex, 2).toString()));
                  cmbYear.setSelectedItem(String.valueOf(tableModel.getValueAt(myIndex, 3).toString()));
    }//GEN-LAST:event_tblRegisterdStudentsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (key == 0){
            JOptionPane.showMessageDialog(this,"Select A Student!!!");
        
        }else{
            try{
             PreparedStatement ps;        
            String sql = "DELETE FROM `student` WHERE `studentID`="+key;
            ps = MyConnection.getConnection().prepareStatement(sql);           
            ps.execute(sql);
            JOptionPane.showMessageDialog(this," Deleted Successfuly!!");
           DisplayStudent();
            
            }catch(Exception e){
              System.out.println(e.getMessage());
            
            }
        
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JComboBox<String> combxDepartment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBookTitle2;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblIssueBooks;
    private javax.swing.JLabel lblLibrarian;
    private javax.swing.JLabel lblRegisterStudents;
    private javax.swing.JLabel lblReturnBooks;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTable tblRegisterdStudents;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
