import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class returnPage extends javax.swing.JFrame {

  
    public returnPage() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jBookID = new javax.swing.JTextField();
        jUserID = new javax.swing.JTextField();
        jIssuesDate = new javax.swing.JTextField();
        jDueDate = new javax.swing.JTextField();
        jReturn = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jSearch = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 44, 37, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4.png"))); // NOI18N
        jLabel7.setText("jLabel5");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 61, -1));

        jLabel8.setText("Book ID:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 70, -1));

        jLabel9.setText("User ID:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 70, -1));

        jLabel10.setText("Issues Date:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 70, -1));

        jLabel11.setText("Due Date:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 70, -1));
        getContentPane().add(jBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 145, -1));
        getContentPane().add(jUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 145, -1));

        jIssuesDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIssuesDateActionPerformed(evt);
            }
        });
        getContentPane().add(jIssuesDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 145, -1));

        jDueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDueDateActionPerformed(evt);
            }
        });
        getContentPane().add(jDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 145, -1));

        jReturn.setText("Return");
        jReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReturnActionPerformed(evt);
            }
        });
        getContentPane().add(jReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\icons\\icons (2)\\1.png")); // NOI18N
        jSearch.setText("SEARCH");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 160, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\icons\\returnbook.png")); // NOI18N
        jLabel12.setText("       ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDueDateActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        setVisible(false);
        new home().setVisible(true);
    }//GEN-LAST:event_jCancelActionPerformed

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        
        String bookID = jBookID.getText();
        String userID = jUserID.getText();
        
        try{
        Connection con = Project.ConnectionProvider.getCon();
        String executeQuery = "select * from issues where bookID = ? and userID = ?";
        PreparedStatement pstmt = con.prepareStatement(executeQuery);
        pstmt.setString(1, bookID);
        pstmt.setString(2, userID);

        ResultSet rs = pstmt.executeQuery();


        if (rs.next()) {
            
           // String issueDate = rs.getString("issueDate");
            //String returnDate = rs.getString("returnDate");
            
           jIssuesDate.setText(rs.getString(3));
            jDueDate.setText(rs.getString(4));
            jBookID.setEditable(false);
            jUserID.setEditable(false);

      
        } else {
            JOptionPane.showMessageDialog(null, "No record found for the given Book ID and User ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error occurred while searching for the record.");
    }
        
        
    }//GEN-LAST:event_jSearchActionPerformed

    private void jReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReturnActionPerformed
       String bookID = jBookID.getText();
    String userID = jUserID.getText();
    try {
        Connection con = Project.ConnectionProvider.getCon();
        String executeQuery = "UPDATE issues SET returned='Yes' WHERE bookID = ? AND userID = ?";
        PreparedStatement pstmt = con.prepareStatement(executeQuery);
        pstmt.setString(1, bookID);
        pstmt.setString(2, userID);

        int updatedRows = pstmt.executeUpdate();
        if (updatedRows > 0) {
            JOptionPane.showMessageDialog(null, "Updated successfully");
        } else {
            JOptionPane.showMessageDialog(null, "No records updated. Verify Book ID and User ID.");
        }

        pstmt.close(); // Close the PreparedStatement
        con.close(); // Close the Connection (recommended to do in a finally block in production code)
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error occurred while updating the record.");
    }

    }//GEN-LAST:event_jReturnActionPerformed

    private void jIssuesDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIssuesDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIssuesDateActionPerformed

    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                returnPage rp = new returnPage();
                rp.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jBookID;
    private javax.swing.JButton jCancel;
    private javax.swing.JTextField jDueDate;
    private javax.swing.JTextField jIssuesDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jReturn;
    private javax.swing.JButton jSearch;
    private javax.swing.JTextField jUserID;
    // End of variables declaration//GEN-END:variables
}
