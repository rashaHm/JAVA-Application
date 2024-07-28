/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rasha
 */
public class Employees extends javax.swing.JFrame {
Connection conn;
PreparedStatement pst;
ResultSet rs;
    /**
     * Creates new form Employees
     */
    public Employees() {
         super("Employees");
        initComponents();
        conn =DBconnection.connect();
        fillTableEmployees();
    }
    
    // Fill pump table
    public void fillTableEmployees(){        
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Employee Name", "Username","Phone"}, 0);
        try{
            String sql="SELECT * FROM employee;";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                String d = rs.getString("id");
                String e = rs.getString("name");
                String f = rs.getString("username");
                String g = rs.getString("phone");
                model.addRow(new Object[]{d, e, f,g});
                
            }
            jTable1.setModel(model);
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please try Later!");
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Username", "Phone"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 3, 36)); // NOI18N
        jLabel1.setText("Employees");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rasha\\Documents\\NetBeansProjects\\FuelStation\\images\\worker.png")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField4)
                            .addComponent(jPasswordField1))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap())
        );

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("All Employees");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home was=new Home();
        was.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         try{
             if(jTextField1.getText().length()<2||jTextField2.getText().length()<2||jPasswordField1.getText().length()<2|| jTextField4.getText().length()<2){
                JOptionPane.showMessageDialog(null, "Input Error");
                jTextField1.setText("");
                jTextField2.setText("");
                jPasswordField1.setText("");
                jTextField4.setText("");
                 return;
             }
            String sql="insert into employee(name,username,password,phone) values(?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jPasswordField1.getText());
            pst.setString(4, jTextField4.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "New Account Insered");
            fillTableEmployees();
            jTextField1.setText("");
            jTextField2.setText("");
            jPasswordField1.setText("");
            jTextField4.setText("");
            pst.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please Try Later!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jButton9.setVisible(true);
       jButton10.setVisible(true);
       fillTableEmployees();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int rowId=jTable1.getSelectedRow();
        if(rowId==-1){
            JOptionPane.showMessageDialog(null, "Please Selected Row!");
            return;
        }
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        if(model.getValueAt(rowId,0).toString()==""){
            JOptionPane.showMessageDialog(null, "Error Row!");
            return;
        }
        int empployeeId=Integer.parseInt(model.getValueAt(rowId,0).toString());
        try{
            String sql="select w_num from washer where employee_id =?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, model.getValueAt(rowId,0).toString());
            rs= pst.executeQuery();
            if(rs.first()){
                JOptionPane.showMessageDialog(null, "Sorry you can't delete this Washer!");
                pst.close();  
                rs.close();
                return;                  
            }else{
                pst.close();  
                rs.close();
                String sql2="select p_num from pump where employee_id =?";
                pst=conn.prepareStatement(sql2);
                pst.setString(1, model.getValueAt(rowId,0).toString());
                rs= pst.executeQuery();
                if(rs.first()){
                JOptionPane.showMessageDialog(null, "Sorry you can't delete this Washer!");
                pst.close();  
                rs.close();
                return;                  
            }
         }
            pst.close();  
            rs.close(); 
            
            String sql2="Delete from employee where id=?";
            pst=conn.prepareStatement(sql2);
            pst.setInt(1, empployeeId);
            pst.execute();
            fillTableEmployees();
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sorry!! Something wrong !!");
        }   
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         try{
            if(Integer.parseInt(jTextField5.getText()) ==0 || Integer.parseInt(jTextField5.getText())<0 || jTextField5.getText()==""){
                JOptionPane.showMessageDialog(null, "Wrong Input!");
                jTextField5.setText("");
                return;
            }
            String sql="select * from employee where id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField5.getText());
            rs= pst.executeQuery();
            int pumpId=0;
            int washerId=0;
            boolean found=true;
            if(rs.first()){
                pst.close();  
                rs.close();
                String sql2="select p_num from pump where employee_id=?";
                pst=conn.prepareStatement(sql2);
                pst.setString(1,jTextField5.getText());
                rs= pst.executeQuery();
                if(rs.first()){
                    pumpId=rs.getInt("p_num");
                    pst.close();  
                    rs.close();
                }else{
                    pst.close();  
                    rs.close();
                    String sql3="select w_num from washer where employee_id=?";
                    pst=conn.prepareStatement(sql3);
                    pst.setString(1,jTextField5.getText());
                    rs= pst.executeQuery();
                    if(rs.first()){
                    washerId=rs.getInt("w_num");
                    System.out.println(washerId);
                    pst.close();  
                    rs.close();
                 }else{
                        found=false;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Input!");
                pst.close();  
                rs.close();
                jTextField5.setText("");
                return;
            }
            
            if(pumpId!=0){
            DefaultTableModel model = new DefaultTableModel(new String[]{ "ID", "Employee Name", "Pump No"}, 0);
            String sql4="SELECT id,name,p_num FROM employee INNER JOIN pump ON employee.id=pump.employee_id  where employee.id=?";
            pst=conn.prepareStatement(sql4);
            pst.setString(1,jTextField5.getText());
            rs= pst.executeQuery();
            while(rs.next()){
                    String a = rs.getString("id");
                    String d = rs.getString("name");
                    String f = rs.getString("p_num");
                    model.addRow(new Object[]{a,d, f});
                }
            jButton9.setVisible(false);
            jButton10.setVisible(false);
            jTable1.setModel(model);
            pst.close();  
            rs.close();
            jTextField5.setText("");
            }else if(washerId!=0){
                 DefaultTableModel model = new DefaultTableModel(new String[]{ "ID", "Employee Name", "Washer No"}, 0);
                String sql5="SELECT id,name,w_num FROM employee INNER JOIN washer ON washer.employee_id=employee.id  where employee.id=?;";
                pst=conn.prepareStatement(sql5);
                pst.setString(1,jTextField5.getText());
                rs= pst.executeQuery();
                while(rs.next()){
                        String a = rs.getString("id");
                        String d = rs.getString("name");
                        String f = rs.getString("w_num");
                        model.addRow(new Object[]{a,d, f});
                    }
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                jTextField5.setText("");
                jTable1.setModel(model);
                pst.close();
            }else if(found==false){
                JOptionPane.showMessageDialog(null, "This user is not responsible for anything yet");
                fillTableEmployees();
                jTextField5.setText("");
                return;
            }else{
                JOptionPane.showMessageDialog(null, "Error Input!");
                jTextField5.setText("");
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please Try Later!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int rowId=jTable1.getSelectedRow();
        if(rowId==-1){
            JOptionPane.showMessageDialog(null, "Please Selected Row!");
            return;
        }
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        if(model.getValueAt(rowId,0).toString()==""){
            JOptionPane.showMessageDialog(null, "Error Row!");
            return;
        }
        String name=model.getValueAt(rowId,1).toString();
        String username=model.getValueAt(rowId,2).toString();
        int phone=Integer.parseInt(model.getValueAt(rowId,3).toString());
        if(name.length()<2||name==""||username.length()<3||username==""||model.getValueAt(rowId,3).toString().length()<3){
               JOptionPane.showMessageDialog(null, "Error Input");
                fillTableEmployees();
                return;
        }
        
        fillTableEmployees();
        DefaultTableModel model2=(DefaultTableModel)jTable1.getModel();
        int userId=Integer.parseInt(model2.getValueAt(rowId,0).toString());
        try{
            String sql2="UPDATE employee SET name=?,username=?,phone=? WHERE id=?";
            pst=conn.prepareStatement(sql2);
            pst.setString(1,  name);
            pst.setString(2, username);
            pst.setInt(3, phone);
            pst.setInt(4, userId);
            pst.execute();
            fillTableEmployees();
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sorry!! Something wrong !!");
        }   
    }//GEN-LAST:event_jButton10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
