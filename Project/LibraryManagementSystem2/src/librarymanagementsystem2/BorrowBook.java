/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem2;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sagar
 */
public class BorrowBook extends javax.swing.JFrame {
    //Please Check Comments In Books Class For The Same Code That is Used In Every Class
Connection con=null;
PreparedStatement pst=null;
ResultSet rs=null;
String Date=null;
String username=null;
String id=null;
String role=null;
String time=null;
String available=null;
String returnId=null;
    /**
     * Creates new form BorrowBook
     */
    public BorrowBook() {
        initComponents();
        con=dbConnectivity.Connect();
        initPanelsNLabels();
        std_name.setEditable(false);
        std_email.setEditable(false);
        std_fname.setEditable(false);
        Borrow_details();
        
    }

    BorrowBook(String id, String role) {
        initComponents();
        con=dbConnectivity.Connect();
        this.id=id;
        this.role=role;
        if(role.equals("student") ){
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jLabel27.setVisible(true);
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel24.setVisible(false);
        stdBorrowList();
        }else if(role.equals("librarian")){
            initPanelsNLabels();
            Borrow_details();
            std_name.setEditable(false);
            std_email.setEditable(false);
            std_fname.setEditable(false);
        }
    }
    public void getTime(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
        time=sdf.format(date);
    }
    public void initPanelsNLabels(){
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jLabel27.setVisible(false);
        jLabel25.setBackground(new Color(0,153,153));
        jLabel26.setBackground(new Color(0,153,153,150));
        jLabel24.setBackground(new Color(0,153,153,150));
    }

    public void Borrow_details(){
        try {
            String sql="SELECT        dbo.borrow_detail.id, dbo.student_details.Name AS StudentName, dbo.Books.Title AS Book, dbo.borrow_detail.Date_from, dbo.borrow_detail.Date_to, dbo.borrow_detail.Issue_time, dbo.borrow_detail.Return_time, \n" +
"                         dbo.borrow_detail.Actual_Return_Date, dbo.librarian_details.UserName AS IssuedBy, dbo.borrow_detail.Status\n" +
"FROM            dbo.Books INNER JOIN\n" +
"                         dbo.borrow_detail ON dbo.Books.ISBN = dbo.borrow_detail.Book_ISBN INNER JOIN\n" +
"                         dbo.librarian_details ON dbo.borrow_detail.Issued_by = dbo.librarian_details.id INNER JOIN\n" +
"                         dbo.student_details ON dbo.borrow_detail.Student_id = dbo.student_details.Student_id";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    public void stdBorrowList(){
        try {
            String sql="SELECT        dbo.borrow_detail.id, dbo.student_details.Name AS StudentName, dbo.Books.Title AS Book, dbo.borrow_detail.Date_from, dbo.borrow_detail.Date_to, dbo.borrow_detail.Actual_Return_Date, \n" +
"                         dbo.librarian_details.UserName AS IssuedBy, dbo.borrow_detail.Status\n" +
"FROM            dbo.Books INNER JOIN\n" +
"                         dbo.borrow_detail ON dbo.Books.ISBN = dbo.borrow_detail.Book_ISBN INNER JOIN\n" +
"                         dbo.librarian_details ON dbo.borrow_detail.Issued_by = dbo.librarian_details.id INNER JOIN\n" +
"                         dbo.student_details ON dbo.borrow_detail.Student_id = dbo.student_details.Student_id\n" +
"WHERE        dbo.borrow_detail.Student_id ="+id+" and dbo.borrow_detail.Status='Issued'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    public void getIssuedList(){
        try {
            String sql="SELECT        dbo.borrow_detail.id, dbo.Books.Title AS Book, dbo.student_details.Name AS StudentName\n" +
"FROM            dbo.Books INNER JOIN\n" +
"                         dbo.borrow_detail ON dbo.Books.ISBN = dbo.borrow_detail.Book_ISBN INNER JOIN\n" +
"                         dbo.student_details ON dbo.borrow_detail.Student_id = dbo.student_details.Student_id where dbo.borrow_detail.Student_id="+re_std_id.getText()+" and dbo.borrow_detail.Status='Issued'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            if(!rs.next()){
                re_std_name.setText(null);
                re_bk_title.setText(null);
                re_date.setText(null);
            }
        
        } catch (Exception e) {
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

        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        std_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bk_isbn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bk_tl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        std_name = new javax.swing.JTextField();
        std_fname = new javax.swing.JTextField();
        std_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        re_std_id = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        re_bk_title = new javax.swing.JLabel();
        re_std_name = new javax.swing.JLabel();
        re_date = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(254, 245, 244));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 7));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 245, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(254, 245, 244));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Student ID:");

        std_id.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        std_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                std_idKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(std_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 70, 240, 70));

        jPanel6.setBackground(new java.awt.Color(254, 245, 244));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("ISBN");

        bk_isbn.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        bk_isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bk_isbnKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Book Title");

        bk_tl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button.png"))); // NOI18N
        jButton1.setText("Issue");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bk_tl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bk_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel13))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bk_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bk_tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 200, 210));

        jPanel7.setBackground(new java.awt.Color(254, 245, 244));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Name:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Father Name:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Email:");

        std_name.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        std_fname.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        std_email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(std_email, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(std_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(std_name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel9))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel11)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addComponent(std_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(std_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(std_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 210));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/id-card (1).png"))); // NOI18N
        jLabel5.setText("Book ID");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 120, 30));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calendar.png"))); // NOI18N
        jLabel6.setText("Issue Date");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 120, 30));

        jPanel11.setBackground(new java.awt.Color(254, 245, 244));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setText("From:");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel30.setText("To:");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 52, -1, 20));

        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        jPanel11.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 14, 140, -1));

        jDateChooser2.setDateFormatString("yyyy/MM/dd");
        jPanel11.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 52, 140, -1));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 240, 100));

        jLabel28.setBackground(new java.awt.Color(0, 153, 153));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/id-card (1).png"))); // NOI18N
        jLabel28.setText("Student ID");
        jLabel28.setOpaque(true);
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 119, 30));

        jLabel31.setBackground(new java.awt.Color(0, 153, 153));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clipboard.png"))); // NOI18N
        jLabel31.setText("Auto Fill ");
        jLabel31.setOpaque(true);
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 121, 30));

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 770, 310));

        jPanel3.setBackground(new java.awt.Color(254, 245, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        jTable1.setBackground(new java.awt.Color(254, 245, 244));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 770, 310));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(254, 245, 244));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setText("Book Title:");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel19.setText("Student ID:");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button.png"))); // NOI18N
        jButton2.setText("Return");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, 40));

        re_std_id.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        re_std_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                re_std_idKeyReleased(evt);
            }
        });
        jPanel9.add(re_std_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 130, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setText("Student Name:");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setText("Return Date:");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        re_bk_title.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        re_bk_title.setText("          ");
        jPanel9.add(re_bk_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, 20));

        re_std_name.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        re_std_name.setText("       ");
        jPanel9.add(re_std_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 120, 20));

        re_date.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        re_date.setText(" ");
        jPanel9.add(re_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 120, 20));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 240));

        jPanel10.setBackground(new java.awt.Color(254, 245, 244));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 440, 240));

        jLabel15.setBackground(new java.awt.Color(0, 153, 153));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow (2).png"))); // NOI18N
        jLabel15.setText("Return a Book");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel15.setOpaque(true);
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 180, 30));

        jLabel18.setBackground(new java.awt.Color(0, 153, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/list.png"))); // NOI18N
        jLabel18.setText("Returned Books List");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel18.setOpaque(true);
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 180, 30));

        jPanel8.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 770, 310));

        jLabel24.setBackground(new java.awt.Color(0, 153, 153));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow (2).png"))); // NOI18N
        jLabel24.setText("Return Book");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 250, 30));

        jLabel25.setBackground(new java.awt.Color(0, 153, 153));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/issue-book.png"))); // NOI18N
        jLabel25.setText("Issue Book");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 30));

        jLabel26.setBackground(new java.awt.Color(0, 153, 153));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/list.png"))); // NOI18N
        jLabel26.setText("Borrow List");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 250, 30));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout (1).png"))); // NOI18N
        jLabel7.setText("Logout");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 130, 40));

        jLabel32.setBackground(new java.awt.Color(0, 153, 153));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home (2).png"))); // NOI18N
        jLabel32.setText("HOME");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel32.setOpaque(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 130, 40));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/about-24.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 830, 80));

        jLabel27.setBackground(new java.awt.Color(0, 153, 153));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/list.png"))); // NOI18N
        jLabel27.setText("Borrow List");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.setOpaque(true);
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 770, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jLabel25.setBackground(new Color(0,153,153));
        jLabel26.setBackground(new Color(0,153,153,150));
        jLabel24.setBackground(new Color(0,153,153,150));
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        
        jPanel3.setVisible(true);
        jPanel1.setVisible(false);
        jPanel4.setVisible(false);
        jLabel26.setBackground(new Color(0,153,153));
        jLabel25.setBackground(new Color(0,153,153,150));
        jLabel24.setBackground(new Color(0,153,153,150));
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        jPanel4.setVisible(true);
        jPanel3.setVisible(false);
        jPanel1.setVisible(false);
        jLabel24.setBackground(new Color(0,153,153));
        jLabel25.setBackground(new Color(0,153,153,150));
        jLabel26.setBackground(new Color(0,153,153,150));
    }//GEN-LAST:event_jLabel24MouseClicked

    private void std_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_std_idKeyReleased
        try {
            String sql="select Name,Father_Name,Email from Student_details where Student_id="+std_id.getText()+" and status='active'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                std_name.setText(rs.getString("Name"));
                std_fname.setText(rs.getString("Father_Name"));
                std_email.setText(rs.getString("Email"));
            }else{
                std_name.setText(null);
                std_email.setText(null);
                std_fname.setText(null);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_std_idKeyReleased

    private void bk_isbnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bk_isbnKeyReleased
        try {
                String sql="select Title,availability from Books where ISBN="+bk_isbn.getText()+"";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    bk_tl.setText(rs.getString("Title"));
                    available=rs.getString("availability");
                }else{
                    bk_tl.setText(null);
                }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bk_isbnKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dateFrom=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String dateTo=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
        getTime();
        try {
            String sql="insert into Borrow_Detail(Student_ID,Book_ISBN,Date_From,Date_To,Issue_time,Issued_by,Status) values("+std_id.getText()+","+bk_isbn.getText()+",'"+dateFrom+"','"+dateTo+"','"+time+"',"+id+",'Issued')";
            if(available.equals("yes")){
            pst=con.prepareStatement(sql);
            pst.execute();
            Borrow_details();
            jDateChooser1.setDate(null);
            jDateChooser2.setDate(null);
            std_id.setText(null);
            bk_isbn.setText(null);
            std_fname.setText(null);
            std_name.setText(null);
            std_email.setText(null);
            bk_tl.setText(null);
            JOptionPane.showMessageDialog(null, "Book Issued!");
            }else{
                
            JOptionPane.showMessageDialog(null, "This Book is not Available!");    
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        if(role.equals("student")){
            StudentHome sh=new StudentHome(id, role);
            sh.setVisible(true);
            this.dispose();
        }else if(role.equals("librarian")){
        librarianHome lh=new librarianHome(id, role);
        lh.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Login log=new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        aboutUs au=new aboutUs();
        au.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       getTime();
       int stdid=0;
        try {
            String sql1="select Student_id from borrow_detail where Student_id="+re_std_id.getText()+" and status='Issued'";
            System.out.println(sql1);
            pst=con.prepareStatement(sql1);
            rs=pst.executeQuery();
            if(rs.next()){
                stdid=rs.getInt("Student_id");
            }
            if(stdid==0){
                JOptionPane.showMessageDialog(null, "Please Select a Book to return!");
                
            }else{
                String sql="update borrow_detail set Status='Returned',Actual_Return_Date='"+Date+"',Return_time='"+time+"'where id="+returnId+"";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Book Successfully Returned");
                getIssuedList();
                re_std_id.setText(null);
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select a Book to return!");
            
            }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void re_std_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_re_std_idKeyReleased
            getIssuedList();
    }//GEN-LAST:event_re_std_idKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        returnId=jTable2.getModel().getValueAt(row, 0).toString();
        re_bk_title.setText(jTable2.getModel().getValueAt(row, 1).toString());
        re_std_name.setText(jTable2.getModel().getValueAt(row, 2).toString());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Date=sdf.format(date);
        re_date.setText(Date);
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bk_isbn;
    private javax.swing.JTextField bk_tl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel re_bk_title;
    private javax.swing.JLabel re_date;
    private javax.swing.JTextField re_std_id;
    private javax.swing.JLabel re_std_name;
    private javax.swing.JTextField std_email;
    private javax.swing.JTextField std_fname;
    private javax.swing.JTextField std_id;
    private javax.swing.JTextField std_name;
    // End of variables declaration//GEN-END:variables
}
