/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainPayment;
import domain.Payment;
import domain.TableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cheng
 */
public class PaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaymentPanel
     */
    MaintainPayment paymentControl;
    
    public PaymentPanel() {
        initComponents();
        paymentControl = new MaintainPayment();
//        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        parentFrame.setTitle("Payment - Veterinary Clinic System");
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
        jtfSearch.setBorder(null);
        setDynamicPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        dynamicPanel = new javax.swing.JPanel();
        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfPayId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbMethodPay = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfCcNum = new javax.swing.JTextField();
        jdpPayDate = new com.toedter.calendar.JDateChooser();
        jbtAddPay = new javax.swing.JButton();
        jcbTransId = new javax.swing.JComboBox<>();
        jcbStaffName = new javax.swing.JComboBox<>();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPayment = new javax.swing.JTable();
        jbtModifyPay = new javax.swing.JButton();
        jbtDeletePay = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 260, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 103));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAdd.setBackground(new java.awt.Color(204, 204, 255));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Payment ID :");
        jpAdd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jtfPayId.setToolTipText("Enter payment ID");
        jtfPayId.setEnabled(false);
        jpAdd.add(jtfPayId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 120, -1));

        jLabel3.setText("Amount Paid (RM) :");
        jpAdd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jtfAmount.setToolTipText("Enter amount paid");
        jpAdd.add(jtfAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 120, -1));

        jLabel4.setText("Method Of Payment :");
        jpAdd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jcbMethodPay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit Card" }));
        jpAdd.add(jcbMethodPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 110, -1));

        jLabel5.setText("Payment Date :");
        jpAdd.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jLabel6.setText("Transaction ID :");
        jpAdd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel7.setText("Staff Name:");
        jpAdd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jLabel8.setText("Credit Card No. :");
        jpAdd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jtfCcNum.setToolTipText("Enter credit card no.");
        jpAdd.add(jtfCcNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, -1));
        jpAdd.add(jdpPayDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 110, -1));

        jbtAddPay.setText("Add Payment");
        jpAdd.add(jbtAddPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jcbTransId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T00000000000000" }));
        jpAdd.add(jcbTransId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jcbStaffName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xiao Liow" }));
        jpAdd.add(jcbStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 110, -1));

        dynamicPanel.add(jpAdd, "card3");

        jpSearch.setBackground(new java.awt.Color(204, 204, 255));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Amount Paid", "Method of Payment", "Date", "Transaction ID", "Staff IC", "Credit Card No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPayment);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 690, 140));

        jbtModifyPay.setText("Modify Payment");
        jbtModifyPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtModifyPayMouseClicked(evt);
            }
        });
        jbtModifyPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyPayActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jbtDeletePay.setText("Delete Payment");
        jbtDeletePay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeletePayMouseClicked(evt);
            }
        });
        jbtDeletePay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeletePayActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeletePay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 970, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 

        jtPayment.setModel(new DefaultTableModel());
        jtPayment.repaint();
        String queryStr =jtfSearch.getText();
        int option =0;
        

            if(Pattern.matches("\\d{12}", queryStr)){
                option=1;
            }
           
            else{
                option=2;
            }
            ArrayList<Payment> paymentList = paymentControl.searchRecord(queryStr,option);

    //        MainMenu.action="search";
    //        setDynamicPanel();
            if(paymentList.size()!=0&&paymentList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<paymentList.size();i++){
                data[i] = paymentList.get(i).getObjects();
                } 
                String[] columnNames = {"Payment ID","Amount Paid","Method of Payment","Date","Transaction IC","Staff IC","Credit Card No."};
                TableModel tModel = new TableModel(data, columnNames);
                jtPayment.setModel(tModel);  
                jtPayment.createDefaultColumnsFromModel();
                jtPayment.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jbtModifyPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtModifyPayActionPerformed

    private void jbtDeletePayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeletePayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDeletePayActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jbtModifyPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtModifyPayMouseClicked
        // TODO add your handling code here:
       MainMenu.action="modify";
       Payment selectedPayment=null;
       if(jtPayment.getSelectedRow()>=0 ) {
           String ic  = (String) jtPayment.getValueAt(jtPayment.getSelectedRow(),0);
           selectedPayment = paymentControl.searchRecord(ic);
            
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtModifyPayMouseClicked

    private void jbtDeletePayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeletePayMouseClicked
        // TODO add your handling code here:
       MainMenu.action="delete";
       Payment selectedPayment=null;
       if(jtPayment.getSelectedRow()>=0 ) {
           String ic  = (String) jtPayment.getValueAt(jtPayment.getSelectedRow(),0);
           selectedPayment = paymentControl.searchRecord(ic);
            
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to delete","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeletePayMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAddPay;
    private javax.swing.JButton jbtDeletePay;
    private javax.swing.JButton jbtModifyPay;
    private javax.swing.JComboBox<String> jcbMethodPay;
    private javax.swing.JComboBox<String> jcbStaffName;
    private javax.swing.JComboBox<String> jcbTransId;
    private com.toedter.calendar.JDateChooser jdpPayDate;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtPayment;
    private javax.swing.JTextField jtfAmount;
    private javax.swing.JTextField jtfCcNum;
    private javax.swing.JTextField jtfPayId;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
