
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class RegisterLibrarian extends javax.swing.JFrame {

    /**
     * Creates new form RegisterLibrarian
     */
    public RegisterLibrarian() {
        initComponents();
        DisplayLibrarian();
    }
    
    public void DisplayLibrarian(){
    try{
       
       
        String sql = "SELECT * FROM `librariantbl`";
        PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)tblRegisterdLibrarian.getModel();
          
          tm.setRowCount(0);
while(rs.next())
{
   Object o[]={rs.getInt("librarianID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("userName"),rs.getString("password")};
       tm.addRow(o);
      
}
          
    
    
    }catch(Exception e){
    
    System.out.println(e.getMessage());
    
    }

}
int librarinID;
private void LibrarianCount(){
 try{       
        String sql = "SELECT MAX(librarianID) FROM `librariantbl`";
          PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
          ResultSet rs1 = p.executeQuery();
          rs1.next();
          librarinID = rs1.getInt(1)+1;
     
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
        tblRegisterdLibrarian = new javax.swing.JTable();
        lblRegisterLibrarian = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtLibrarianFirstName = new javax.swing.JTextField();
        lblRegisteredLibrarianList = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblLastName = new javax.swing.JLabel();
        txtLibrarianLastName = new javax.swing.JTextField();
        lblUserNames = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        pswd = new javax.swing.JPasswordField();

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
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(211, 211, 211));

        tblRegisterdLibrarian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "User Name", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegisterdLibrarian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRegisterdLibrarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegisterdLibrarianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRegisterdLibrarian);

        lblRegisterLibrarian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisterLibrarian.setText("Register Libraian");

        lblFirstName.setText("First Name");

        lblRegisteredLibrarianList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisteredLibrarianList.setText("Registered Librarins");

        btnEdit.setText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblLastName.setText("Last Name");

        lblUserNames.setText("User Name");

        lblPassword.setText("Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblUserNames, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPassword))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLibrarianLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(pswd))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(lblRegisterLibrarian, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLibrarianFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(9, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(lblRegisteredLibrarianList, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(143, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLibrarianLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPassword)
                        .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUserNames))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnClear))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(lblRegisterLibrarian)
                    .addGap(24, 24, 24)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFirstName)
                        .addComponent(txtLibrarianFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(150, 150, 150)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(180, 180, 180)
                    .addComponent(lblRegisteredLibrarianList)
                    .addContainerGap(180, Short.MAX_VALUE)))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
   
    if(txtLibrarianFirstName.getText().isEmpty()|| txtLibrarianLastName.getText().isEmpty()|| txtUserName.getText().isEmpty() || pswd.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Missing Information");
        
    }
        
    else{
                  
    String firstName= txtLibrarianFirstName.getText();
    String lastName= txtLibrarianLastName.getText(); 
    String userName= txtUserName.getText(); 
    String password=String.valueOf(pswd.getPassword());          
                
    try {
        PreparedStatement ps;      
        String sql = ("INSERT INTO `librariantbl`(`librarianID`, `firstName`, `lastName`, `userName`, `password`) VALUES (?,?,?,?,?)");
            ps = MyConnection.getConnection().prepareStatement(sql);           
//           
            ps.setInt(1,librarinID);
            ps.setString(2,firstName);
            ps.setString(3,lastName);
            ps.setString(4,userName);
            ps.setString(5,password);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Librarian registerd Successfully!");
            DisplayLibrarian();
            ps.close();
         
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        }
    }//GEN-LAST:event_btnSaveActionPerformed
int key = 0;
    private void tblRegisterdLibrarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegisterdLibrarianMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableModel=(DefaultTableModel)tblRegisterdLibrarian.getModel();
                  int myIndex  = tblRegisterdLibrarian.getSelectedRow();
                  key = Integer.valueOf(tableModel.getValueAt(myIndex, 0).toString());
                  txtLibrarianFirstName.setText(tableModel.getValueAt(myIndex, 1).toString());
                  txtLibrarianLastName.setText(tableModel.getValueAt(myIndex, 2).toString());
                  txtUserName.setText(tableModel.getValueAt(myIndex, 3).toString());
                  pswd.setText(tableModel.getValueAt(myIndex, 4).toString());
                 
    }//GEN-LAST:event_tblRegisterdLibrarianMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtLibrarianFirstName.setText("");
        txtLibrarianLastName.setText("");
          txtUserName.setText("");
              pswd.setText("");  
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String password=String.valueOf(pswd.getPassword());  
         DefaultTableModel tableModel=(DefaultTableModel)tblRegisterdLibrarian.getModel();
                  int myIndex  = tblRegisterdLibrarian.getSelectedRow();
                  key = Integer.valueOf(tableModel.getValueAt(myIndex, 0).toString());
        try{
           
            PreparedStatement ps;        
            String sql = "UPDATE `librariantbl` SET `librarianID`=?,`firstName`=?,`lastName`=?,`userName`=?,`password`=? WHERE `librarianID`=? ";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,key);
            ps.setString(2,txtLibrarianFirstName.getText());
            ps.setString(3,txtLibrarianLastName.getText());   
           ps.setString(4,txtUserName.getText()); 
           ps.setString(5,password); 
             ps.setInt(6,key);
             if(ps.executeUpdate() > 0){
                
                  
             DisplayLibrarian();
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
            java.util.logging.Logger.getLogger(RegisterLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterLibrarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblIssueBooks;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLibrarian;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegisterLibrarian;
    private javax.swing.JLabel lblRegisteredLibrarianList;
    private javax.swing.JLabel lblReturnBooks;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNames;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JTable tblRegisterdLibrarian;
    private javax.swing.JTextField txtLibrarianFirstName;
    private javax.swing.JTextField txtLibrarianLastName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
