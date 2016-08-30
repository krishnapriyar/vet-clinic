/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cheng
 */
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportPanel
     */
    int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    public ReportPanel() {
        initComponents();
        setAccess();
        jlblPeriod.setVisible(true);
        jmcMonth.setVisible(true);
        jycYear.setVisible(true);
        jlblStart.setVisible(false);
        jlblEnd.setVisible(false);
        jdpStartDate.setVisible(false);
        jdpEndDate.setVisible(false);
    }

    private void setAccess (){
        Staff staff = LoginFrame.getCurrentstaff();
        if(!staff.getStaffPosition().equals("Manager")){
            jbtGenerateReport.setEnabled(false);
            jcbReportType.setEnabled(false);
            jdpEndDate.setEnabled(false);
            jdpStartDate.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Report module is only accessible by managers", "Access Denied!", JOptionPane.ERROR_MESSAGE);
        
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

        jlblReportType = new javax.swing.JLabel();
        jcbReportType = new javax.swing.JComboBox<>();
        jlblStart = new javax.swing.JLabel();
        jlblEnd = new javax.swing.JLabel();
        jdpStartDate = new com.toedter.calendar.JDateChooser();
        jdpEndDate = new com.toedter.calendar.JDateChooser();
        jbtGenerateReport = new javax.swing.JButton();
        jycYear = new com.toedter.calendar.JYearChooser();
        jmcMonth = new com.toedter.calendar.JMonthChooser();
        jlblPeriod = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 234, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblReportType.setText("Report Type :");
        add(jlblReportType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jcbReportType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transaction Detail", "Staff Performance Exception", "Customer Summary", "Services Summary" }));
        jcbReportType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbReportTypeItemStateChanged(evt);
            }
        });
        add(jcbReportType, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, -1));

        jlblStart.setText("Start Date :");
        add(jlblStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jlblEnd.setText("  End Date :");
        add(jlblEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 60, -1));
        add(jdpStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 140, -1));
        add(jdpEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 140, -1));

        jbtGenerateReport.setText("Generate Report");
        jbtGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGenerateReportActionPerformed(evt);
            }
        });
        add(jbtGenerateReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));
        add(jycYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));
        add(jmcMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jlblPeriod.setText("Period :");
        add(jlblPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGenerateReportActionPerformed
        // TODO add your handling code here:
       String host = "jdbc:derby://localhost:1527/vetdb";
       String user = "nbuser";
       String password = "nbuser";
       Connection conn = null;
       String reportSource = "src/reportTemplates/TransactionDetail.jrxml"; 
       
       String reportType = (String) jcbReportType.getSelectedItem();

       Map<String, Object> params = new HashMap<String, Object>(); 
       
       if(reportType.equals("Transaction Detail")){
           reportSource = "src/reportTemplates/TransactionDetail.jrxml";
           params.put("rStartDate", getPeriod(0));
           params.put("rEndDate", getPeriod(1));
       }else if (reportType.equals("Staff Performance Exception")){
           reportSource = "src/reportTemplates/StaffPerformanceException.jrxml";
           params.put("rStartDate", getPeriod(0));
           params.put("rEndDate", getPeriod(1));
       }else if (reportType.equals("Customer Summary")){
           reportSource = "src/reportTemplates/CustomerSummary.jrxml";
           params.put("rStartDate", getPeriod(0));
           params.put("rEndDate", getPeriod(1));
           params.put("rYear", getPeriod(0));
           
       }else if (reportType.equals("Services Summary")){
           Date endDate = jdpEndDate.getDate();
           Date startDate = jdpStartDate.getDate();
           reportSource = "src/reportTemplates/ServiceSummary.jrxml";
           params.put("rStartDate", startDate);
           params.put("rEndDate", endDate);
       }

       

        try{	 
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(host, user, password);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false); 


        } 
        catch (JRException jrex) {
                JOptionPane.showMessageDialog(this, "Error in generating report");
                  jrex.printStackTrace();
        }
        catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Unble to generate report~!");
                  ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtGenerateReportActionPerformed

    private void jcbReportTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbReportTypeItemStateChanged
        // TODO add your handling code here:
        
        JComboBox cb = (JComboBox) evt.getSource();
        String item = (String) evt.getItem();
                
                if(item.equals("Transaction Detail")){
                    jlblPeriod.setVisible(true);
                    jmcMonth.setVisible(true);
                    jycYear.setVisible(true);
                    jlblStart.setVisible(false);
                    jlblEnd.setVisible(false);
                    jdpStartDate.setVisible(false);
                    jdpEndDate.setVisible(false);
                }else if(item.equals("Staff Performance Exception")){
                    jlblPeriod.setVisible(true);
                    jmcMonth.setVisible(true);
                    jycYear.setVisible(true);
                    jlblStart.setVisible(false);
                    jlblEnd.setVisible(false);
                    jdpStartDate.setVisible(false);
                    jdpEndDate.setVisible(false);
                }else if(item.equals("Customer Summary")){
                    jlblPeriod.setVisible(true);
                    jmcMonth.setVisible(false);
                    jycYear.setVisible(true);
                    jlblStart.setVisible(false);
                    jlblEnd.setVisible(false);
                    jdpStartDate.setVisible(false);
                    jdpEndDate.setVisible(false);
                }else if(item.equals("Services Summary")){
                    jlblPeriod.setVisible(false);
                    jmcMonth.setVisible(false);
                    jycYear.setVisible(false);
                    jlblStart.setVisible(true);
                    jlblEnd.setVisible(true);
                    jdpStartDate.setVisible(true);
                    jdpEndDate.setVisible(true);
                }
    }//GEN-LAST:event_jcbReportTypeItemStateChanged

    private Date getPeriod(int index){
        
        Date[] dates = {new Date(), new Date()};
        int month = 0;
        int year = 0;
        
        if(jmcMonth.isVisible()==true){
            month = jmcMonth.getMonth();
            year = jycYear.getYear(); 
            Calendar calStart = Calendar.getInstance();
            Calendar calEnd = Calendar.getInstance();
            calStart.set(year, month, 1);
            calEnd.set(year, month, daysOfMonth[month-1]);
            dates[0] = calStart.getTime();
            dates[1] = calEnd.getTime();
        }else{
            year = jycYear.getYear(); 
            Calendar calStart = Calendar.getInstance();
            Calendar calEnd = Calendar.getInstance();
            calStart.set(year, 1, 1);
            calEnd.set(year, 12, 31);
            
            dates[0] = calStart.getTime();
            dates[1] = calEnd.getTime();
        }
        
        return dates[index]; 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtGenerateReport;
    private javax.swing.JComboBox<String> jcbReportType;
    private com.toedter.calendar.JDateChooser jdpEndDate;
    private com.toedter.calendar.JDateChooser jdpStartDate;
    private javax.swing.JLabel jlblEnd;
    private javax.swing.JLabel jlblPeriod;
    private javax.swing.JLabel jlblReportType;
    private javax.swing.JLabel jlblStart;
    private com.toedter.calendar.JMonthChooser jmcMonth;
    private com.toedter.calendar.JYearChooser jycYear;
    // End of variables declaration//GEN-END:variables
}
