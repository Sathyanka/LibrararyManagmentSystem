
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
public class IssueBooks extends javax.swing.JFrame {

    /**
     * Creates new form IssueBooks
     */
    public IssueBooks() {
        initComponents();
        DisplayIssuedBooks();
        DisplayBooks();
        FillComboBoxStudent();
    }
public void DisplayBooks(){
    try{
       
       
        String sql = "SELECT * FROM `booktbl`";
        PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)tblBooks.getModel();
          
          tm.setRowCount(0);
while(rs.next())
{
   Object o[]={rs.getInt("bookID"),rs.getString("title"),rs.getString("author"),rs.getInt("price"),rs.getInt("quantity")};
       tm.addRow(o);
      
}
          
    
    
    }catch(Exception e){
    
    System.out.println(e.getMessage());
    
    }

}
   public void DisplayIssuedBooks(){
    try{
       
       
        String sql = "SELECT * FROM `issuebooks`";
        PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)tblIssueBooks.getModel();
          
          tm.setRowCount(0);
while(rs.next())
{
   Object o[]={rs.getInt("issuedId"),rs.getInt("studentID"),rs.getInt("issuedBookID"),rs.getString("issuedDate")};
       tm.addRow(o);
      
}
          
    
    
    }catch(Exception e){
    
    System.out.println(e.getMessage());
    
    }

}
 int rentalID;
private void BookCount(){
 try{       
        String sql = "SELECT MAX(issuedId) FROM `issuebooks`";
          PreparedStatement p = MyConnection.getConnection().prepareStatement(sql);
          ResultSet rs1 = p.executeQuery();
          rs1.next();
          rentalID = rs1.getInt(1)+1;
     
 }catch (Exception e){
 
 }

} 
  public void FillComboBoxStudent()
    {
    
    try{
    PreparedStatement ps;
        String query ="SELECT * FROM `student`"; 
        ps = MyConnection.getConnection().prepareStatement(query);        
        ResultSet rs =(ResultSet) ps.executeQuery();
        
        while(rs.next()){
            String teacherClass = rs.getString("studentID");
            cmbStudent.addItem(teacherClass);
        
        }
    
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        
    
    }
    
    } 
   
   public ImageIcon ResizeCover(String ImagePath,byte[] pic){
        ImageIcon MyImage = null;
        if(ImagePath != null){
         MyImage = new ImageIcon(ImagePath);
        }
        else{
        MyImage = new ImageIcon(pic);
        }
        
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblBookCoverImage.getWidth(),lblBookCoverImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    @SuppressWarnings("unchecked")
    private void GetBookCover(){
    try{
       PreparedStatement ps;      
        String sql = "SELECT cover FROM `booktbl` WHERE `bookID`="+key;
        
        ps = MyConnection.getConnection().prepareStatement(sql);           
            ps.execute(sql);
        
        ResultSet rs1 = ps.executeQuery();
         if(rs1.next()){
          lblBookCoverImage.setIcon(ResizeCover(null,rs1.getBytes("cover")));
         }
          
    }
    catch(Exception e){
    }

}
    
    public void UpdateBooks(){
    try{
        int     numberOfBokks =  Integer.valueOf(availableBooks)-1;
        int bookID = Integer.valueOf(txtBookID.getText());
            PreparedStatement ps;        
            String sql = "UPDATE `booktbl` SET `quantity`=? WHERE `bookID`=?";
            ps = MyConnection.getConnection().prepareStatement(sql);
                    
           ps.setInt(1,numberOfBokks ); 
           ps.setInt(2,bookID);
            
             if(ps.executeUpdate() > 0){
                
                  
            DisplayBooks();
            JOptionPane.showMessageDialog(this,"Book updated Successfuly!!");
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
        
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBooks = new javax.swing.JLabel();
        lblStudents = new javax.swing.JLabel();
        lblLibrarian = new javax.swing.JLabel();
        lblReturnBooks = new javax.swing.JLabel();
        lblIssueBooks = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBorrow = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssueBooks = new javax.swing.JTable();
        lblIssueBooksBaner = new javax.swing.JLabel();
        lblBookCoverImage = new javax.swing.JLabel();
        lblBookTitle = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblBookCover = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        cmbStudent = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        txtAuthor = new javax.swing.JTextField();
        lblAuthor = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblBookTitle1 = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(211, 211, 211));

        btnBorrow.setText("Borrow");
        btnBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowActionPerformed(evt);
            }
        });

        tblIssueBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Student", "Book", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblIssueBooks);

        lblIssueBooksBaner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIssueBooksBaner.setText("Issue Books");

        lblBookCoverImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblBookCoverImage.setEnabled(false);

        lblBookTitle.setText("Book ID");

        lblStudent.setText("Student");

        txtBookID.setEnabled(false);

        lblDate.setText("Date");

        lblBookCover.setText("Book Cover");

        btnReset.setText("Reset");

        cmbStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudentActionPerformed(evt);
            }
        });

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book_ID", "Title", "Author", "Price", "Quantity"
            }
        ));
        tblBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblBooks.setRowHeight(23);
        tblBooks.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tblBooks.setShowGrid(false);
        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBooksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBooks);

        txtAuthor.setEnabled(false);
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        lblAuthor.setText("Author");

        lblPrice.setText("Price");

        txtPrice.setEnabled(false);

        lblQuantity.setText("Quantity");

        txtQuantity.setEnabled(false);

        lblBookTitle1.setText("Book Title");

        txtBookTitle.setEnabled(false);

        btnClear.setText("Clear");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(398, 398, 398)
                                .addComponent(btnReset))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblQuantity)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblBookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblBookCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblBookTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDate))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(btnBorrow)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClear)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(lblIssueBooksBaner, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(477, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblQuantity))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBookCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblBookCover)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBookTitle)
                            .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBookTitle1)
                                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStudent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAuthor)
                                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBorrow)
                                    .addComponent(btnClear))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnReset)
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(lblIssueBooksBaner)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 int key = 0;
 int availableBooks;
    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableModel=(DefaultTableModel)tblBooks.getModel();
        int myIndex  = tblBooks.getSelectedRow();
        key = Integer.valueOf(tableModel.getValueAt(myIndex, 0).toString());
        txtBookID.setText(tableModel.getValueAt(myIndex, 0).toString());
        txtBookTitle.setText(tableModel.getValueAt(myIndex, 1).toString());
        txtAuthor.setText(tableModel.getValueAt(myIndex, 2).toString());
        txtPrice.setText(tableModel.getValueAt(myIndex, 3).toString());
        txtQuantity.setText(tableModel.getValueAt(myIndex, 4).toString());
        availableBooks = Integer.valueOf(tableModel.getValueAt(myIndex, 4).toString());
        GetBookCover();

    }//GEN-LAST:event_tblBooksMouseClicked

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void cmbStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStudentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtBookID.setText("");
        txtBookTitle.setText("");
        txtAuthor.setText("");
        txtPrice.setText("");
         txtQuantity.setText("");
         lblBookCover.setText("");
          txtDate.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed
        availableBooks =  Integer.valueOf(txtQuantity.getText());
        int bookID = Integer.valueOf(txtBookID.getText());
        
          String date= txtDate.getText(); 
         
        if(txtBookTitle.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Select a Book!!");
        
        }
        else if(availableBooks == 0 ){
    
    JOptionPane.showMessageDialog(this,"Books arer not available!!");
    }
        else{
                  
                  String bookTitle= txtBookTitle.getText();
                 
                  
                  
        
        
        try {
            PreparedStatement ps;      
            BookCount();
            String sql = ("INSERT INTO `issuebooks`(`issuedId`,`studentID`, `issuedBookID`, `issuedDate`) VALUES (?,?,?,?)");
            ps = MyConnection.getConnection().prepareStatement(sql);           
//            ps.bookID(sql);
            
            ps.setInt(1,rentalID);
            ps.setInt(2,Integer.valueOf(cmbStudent.getSelectedItem().toString()));
            ps.setInt(3,bookID);
            ps.setString(4,date);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Book details added Successfully!");
            ps.close();
            UpdateBooks();
            DisplayIssuedBooks();
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        }
    }//GEN-LAST:event_btnBorrowActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrow;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbStudent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookCover;
    private javax.swing.JLabel lblBookCoverImage;
    private javax.swing.JLabel lblBookTitle;
    private javax.swing.JLabel lblBookTitle1;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblIssueBooks;
    private javax.swing.JLabel lblIssueBooksBaner;
    private javax.swing.JLabel lblLibrarian;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblReturnBooks;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblIssueBooks;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

    private Icon ResizeCover(Object object, byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
