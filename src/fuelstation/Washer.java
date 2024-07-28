/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelstation;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rasha
 */
public class Washer extends javax.swing.JFrame {
Connection conn;
PreparedStatement pst;
ResultSet rs;
    /**
     * Creates new form Washer
     */
    public Washer() {
        super("Washer");
        initComponents();
        conn =DBconnection.connect();
        fillJComboBox1();
        fillTableWasher();
    }
    
     // Fill pump table
    public void fillTableWasher(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Washer No", "Employee Name", "Phone"}, 0);
        try{
            String sql="SELECT w_num,name,w_phone FROM washer INNER JOIN employee ON washer.employee_id=employee.id;";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                String d = rs.getString("w_num");
                String e = rs.getString("name");
                String f = rs.getString("w_phone");
                model.addRow(new Object[]{d, e, f});
                
            }
            jTable1.setModel(model);
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please try Later!");
        }
    }
    //Fill Employee number
    public void fillJComboBox1() {
       try{
            String sql1="SELECT id,name FROM employee;";
            pst=conn.prepareStatement(sql1);
            rs= pst.executeQuery();
            int employeeId=0;
            String employeeName="";
            jComboBox1.addItem("Select Employee Name");
            while(rs.next()){
                boolean found=false;
                employeeId=rs.getInt("id");
                employeeName=rs.getString("name");
                                
                String sql3="select employee_id from pump where employee_id=?";
                pst=conn.prepareStatement(sql3);
                pst.setInt(1, employeeId );
                if(pst.executeQuery().first())found=true;
                
                String sql4="select employee_id from washer where employee_id=?";
                pst=conn.prepareStatement(sql4);
                pst.setInt(1, employeeId );
                if(pst.executeQuery().first())found=true;
                if(found==false)
                jComboBox1.addItem(employeeName);   
            }
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Wrong !!");
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
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Show cars are washed in washer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Employee Name", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 2, 36)); // NOI18N
        jLabel1.setText("Car Wash");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("All Washer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Phone");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Employee Name");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 107, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rasha\\Documents\\NetBeansProjects\\FuelStation\\images\\car-wash.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(451, 451, 451)
                .addComponent(jButton1))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton5)
                                .addGap(41, 41, 41)
                                .addComponent(jButton6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jButton3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ho=new Home();
        ho.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try{
             if(jTextField1.getText().length()<2||jComboBox1.getSelectedIndex()==0){
               JOptionPane.showMessageDialog(null, "Error Input");
                jTextField1.setText("");
                jComboBox1.setSelectedIndex(0);
                return; 
            }
            String sql="select id from employee where name=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, (String)jComboBox1.getSelectedItem() );
            rs= pst.executeQuery();
            String Id="";
            if(rs.next()){
                Id=rs.getString("id"); 
            }
            pst.close();
            rs.close();
            String sql2="insert into washer(employee_id,w_phone)values(?,?)";
            pst=conn.prepareStatement(sql2);
            pst.setString(1,Id );
            pst.setString(2, jTextField1.getText());
            pst.execute();
            pst.close();
            jComboBox1.removeAllItems();
            fillJComboBox1();
            jTextField1.setText("");
            fillTableWasher();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please Try Later!");
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jButton6.setVisible(true);
        jButton5.setVisible(true);
        fillTableWasher();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            if(Integer.parseInt(jTextField2.getText()) ==0 || Integer.parseInt(jTextField2.getText())<0 || jTextField2.getText()==""){
                JOptionPane.showMessageDialog(null, "Wrong Input!");
                jTextField2.setText("");
                return;
            }
            String sql="select w_num from washer";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            boolean found=false;
            while(rs.next()){
                 if(Integer.parseInt(rs.getString("w_num"))==Integer.parseInt(jTextField2.getText()))
                     found=true; 
            }
            pst.close();  
            rs.close();
            if(found==true){
            DefaultTableModel model = new DefaultTableModel(new String[]{ "Car No","Washer No","Date","Cost"}, 0);
            String sql2="SELECT c_num,w_num,date,cost FROM car_washer Where c_num =?;";
            pst=conn.prepareStatement(sql2);
            pst.setString(1,jTextField2.getText());
            rs= pst.executeQuery();
         //  model.addRow(new Object[]{"No Data"});
            while(rs.next()){
                    String a = rs.getString("c_num");
                    String d = rs.getString("w_num");
                    String e = rs.getString("date");
                    String f = rs.getString("cost");
                    model.addRow(new Object[]{a,d, e, f});
                }
            jButton6.setVisible(false);
            jButton5.setVisible(false);
            jTable1.setModel(model);
            pst.close();  
            rs.close();
            found=false;
            jTextField2.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Error Input!");
                jTextField2.setText("");
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Error, Please Try Later!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         int rowId=jTable1.getSelectedRow();
        if(rowId==-1){
            JOptionPane.showMessageDialog(null, "Please Selected Row!");
            return;
        }
        fillTableWasher();
        DefaultTableModel model2=(DefaultTableModel)jTable1.getModel();
        int washerId=Integer.parseInt(model2.getValueAt(rowId,0).toString());
        try{
            String sql="select * from car_washer where w_num =?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,washerId);
            rs= pst.executeQuery();
            if(rs.first()){
                JOptionPane.showMessageDialog(null, "Sorry, You cant delete!");
                pst.close();  
                rs.close();
                return;                  
            }
            pst.close();  
            rs.close();
            
            String sql2="Delete from washer where w_num =?";
            pst=conn.prepareStatement(sql2);
            pst.setInt(1, washerId);
            pst.execute();
            fillTableWasher();
            pst.close();  
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sorry!! Something wrong !!");
        }   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int rowId=jTable1.getSelectedRow();
        if(rowId==-1){
            JOptionPane.showMessageDialog(null, "Please Selected Row!");
            return;
        }
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        String employeeName=model.getValueAt(rowId,1).toString();
        String phone=model.getValueAt(rowId,2).toString();
        if(employeeName.length()<2||phone.length()<1){
            JOptionPane.showMessageDialog(null, "Error Input");
            fillTableWasher();
            return;
        }
        fillTableWasher();
        DefaultTableModel model2=(DefaultTableModel)jTable1.getModel();
        int pumpId=Integer.parseInt(model2.getValueAt(rowId,0).toString());
        String oldname=model2.getValueAt(rowId,1).toString();
        
        try{
           String sql="select id,name from employee where name =?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, employeeName);
            rs= pst.executeQuery();
            if(!rs.first()){                
                JOptionPane.showMessageDialog(null, "Sorry, No employee!");
                
                pst.close();  
                rs.close();
                return;                  
            }  
            int employeeId=rs.getInt("id");
            pst.close();  
            rs.close();
            if(!oldname.equals(employeeName)){
             String sql3="select employee_id from pump where employee_id=? ";
            pst=conn.prepareStatement(sql3);
            pst.setInt(1, employeeId );
                
            if(pst.executeQuery().first()){
                JOptionPane.showMessageDialog(null, "Sorry, You Can't Editing!");
                pst.close();  
                rs.close();
                return; 
            }
            pst.close();  
            rs.close(); 
                
            String sql4="select employee_id from washer where employee_id=?";
            pst=conn.prepareStatement(sql4);
            pst.setInt(1, employeeId );
            
            if(pst.executeQuery().first()){
                JOptionPane.showMessageDialog(null, "Sorry, You Can't Editing");
                pst.close();  
                rs.close();
                return; 
            }
            pst.close();  
            rs.close();
            String sql2="UPDATE washer SET employee_id=?,w_phone=? WHERE w_num=?";
            pst=conn.prepareStatement(sql2);
            pst.setInt(1,  employeeId);
            pst.setString(2, phone);
            pst.setInt(3, pumpId);
            pst.execute();
            fillTableWasher();
            pst.close();  
            rs.close();
            }else{                
                String sql6="UPDATE washer SET w_phone=? WHERE w_num=?";
                pst=conn.prepareStatement(sql6);
                pst.setString(1, phone);
                pst.setInt(2, pumpId);
                pst.execute();
                fillTableWasher();
                pst.close();  
                rs.close();
            }          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sorry!! Something wrong !!");
        }  
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
