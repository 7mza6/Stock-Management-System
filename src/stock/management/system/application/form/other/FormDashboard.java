package stock.management.system.application.form.other;

import static stock.management.system.application.form.other.FormDashboard.getConnection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import stock.management.system.application.Application;
import stock.management.system.classes.Cart;
import stock.management.system.classes.Customers;
import static stock.management.system.classes.Customers.SelectedCustomer;
import stock.management.system.classes.Items;
import stock.management.system.classes.sales;
/**
 *
 * @author Raven
 */
public class FormDashboard extends javax.swing.JPanel {
private int SelectedR;
private int Customerid;
public static Connection getConnection() throws SQLException {

       return java.sql.DriverManager.getConnection("");

   }
    public FormDashboard()  {
        initComponents();
        tblupdate();
        getcustomers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        category = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        barcode = new javax.swing.JTextField();
        sectionId = new javax.swing.JTextField();
        companyId = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        warehouseId = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        Sales = new javax.swing.JTable();
        add = new javax.swing.JButton();
        Send = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        getBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        item = new javax.swing.JTable();
        UpdateC = new javax.swing.JButton();
        quantity1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Sells = new javax.swing.JTable();
        Sell = new javax.swing.JButton();
        ShowDet = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        addCus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        Id.setEnabled(false);
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        Sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SaleDetailID", "SaleID", "ItemID", "Quantity", "UnitPrice", "TotalPrice"
            }
        ));
        Sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Sales);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add.setText("add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        Send.setText("send to ");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        getBack.setText("Get back");
        getBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getBackActionPerformed(evt);
            }
        });

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Praice", "Quantity", "Total price", "CustomerId"
            }
        ));
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cart);

        item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "quantity", "weight", "category", "price", "barcode", "code", "status", "description", "section", "warehouse", "company"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        item.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                itemAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(item);

        UpdateC.setText("Update");
        UpdateC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCActionPerformed(evt);
            }
        });

        quantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Set Quantity");

        Sells.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sale ID", "Customer ID", "Sale Date", "Total Paid"
            }
        ));
        Sells.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Sells);

        Sell.setText("Sell");
        Sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellActionPerformed(evt);
            }
        });

        ShowDet.setText("Show details");
        ShowDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDetActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        addCus.setText("add");
        addCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCusActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Customer  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addCus)
                                .addComponent(Sell)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowDet))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(getBack)))
                        .addGap(51, 51, 51)
                        .addComponent(UpdateC)))
                .addContainerGap(410, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(add))
                .addGap(389, 389, 389))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(472, 472, 472)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(add)
                .addGap(30, 30, 30)
                .addComponent(delete)
                .addGap(29, 29, 29)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Send)
                    .addComponent(getBack)
                    .addComponent(UpdateC))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(addCus)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(Sell)
                            .addGap(108, 108, 108))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ShowDet)
                        .addGap(124, 124, 124))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(423, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        DefaultTableModel Mcart = (DefaultTableModel)cart.getModel();
        SelectedR = cart.getSelectedRow();
    }//GEN-LAST:event_cartMouseClicked

    private void itemAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_itemAncestorAdded

    }//GEN-LAST:event_itemAncestorAdded

    private void itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMouseClicked
        DefaultTableModel items = (DefaultTableModel)item.getModel();
        int Row = item.getSelectedRow();
        Id.setText(items.getValueAt(Row, 0).toString());
        name.setText(items.getValueAt(Row, 1).toString());
        quantity.setText(items.getValueAt(Row, 2).toString());
        price.setText(items.getValueAt(Row, 5).toString());

    }//GEN-LAST:event_itemMouseClicked

    private void quantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1ActionPerformed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
          try (Connection connection = getConnection()) {
            if( Items.getQuantity(Integer.parseInt(Id.getText())) < Integer.parseInt(quantity1.getText())){
                JOptionPane.showMessageDialog(this, "No enough quantity availble");
            }
            else{
                try {
                    Cart cart = new Cart();
                    if(cart.inCart(Integer.parseInt(Id.getText())) > 0){
                        cart.addQuantity(Integer.parseInt(Id.getText()),Integer.parseInt(quantity1.getText()));
                    }
                    else{
                        double total = Integer.parseInt(quantity1.getText())* Double.parseDouble(price.getText());
                        cart.addToCart(Integer.parseInt(Id.getText()),name.getText(),Double.parseDouble(price.getText()),Integer.parseInt(quantity1.getText()) ,total,Customerid);
                    }
                    Items item = new Items();
                    item.takenItem(Integer.parseInt(Id.getText()), Integer.parseInt(quantity1.getText()));
                    tblupdate();
                } catch (SQLException ex) {
                    Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SendActionPerformed

    private void getBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBackActionPerformed
        try {
            Items item = new Items();
            Cart cart = new Cart();
            int id = Cart.getRowId(SelectedR);
            int id1 = Cart.getItemsId(SelectedR);
            int q = -1 * Cart.getQuantity(id);
            item.takenItem(id1,q);
            cart.deleteFromCart(id);
            tblupdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_getBackActionPerformed

    private void UpdateCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCActionPerformed
        try (Connection connection = getConnection()) {
            Cart cart = new Cart();
            Items item = new Items();
            int Itemid = Cart.getItemsId(SelectedR);
            int id = Cart.getRowId(SelectedR);
            int q =Cart.getQuantity(id);

            if( Items.getQuantity(Itemid ) < Integer.parseInt(quantity1.getText())){
                JOptionPane.showMessageDialog(this, "No enough quantity availble");
            }
            else{

                cart.updateQuantity(Itemid,Integer.parseInt(quantity1.getText()));

                if(q > Integer.parseInt(quantity1.getText())){
                    q =Integer.parseInt(quantity1.getText()) - q;
                    item.takenItem(Itemid,q);

                }
                else if(q == Integer.parseInt(quantity1.getText())){

                }
                else{
                    q =Integer.parseInt(quantity1.getText()) - q;
                    item.takenItem(Itemid, q);

                }
                tblupdate();
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateCActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    Application.showForm(new ItemsForm());
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try (Connection connection = getConnection()){
            Items item = new Items();
            item.deleteItem(Integer.parseInt(Id.getText()));
            tblupdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     int id= Integer.parseInt(Id.getText());
     System.out.println(id);
        Application.showForm(new ItemsForm(id));
         tblupdate();
     
    }//GEN-LAST:event_updateActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void SellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellActionPerformed
    processSale();  
    try {
        Cart cart =new Cart();
        cart.deleteAll();
    } catch (SQLException ex) {
        Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    tblupdate();

    }//GEN-LAST:event_SellActionPerformed

    private void ShowDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDetActionPerformed
    try {
        jDialog1.setVisible(true);
        jDialog1.setTitle("Sells Ditels");
        jDialog1.setBounds(600, 400, 700, 500);
        
        int id = sales.getRowId(Sells.getSelectedRow());
        tblupdate(id);
    } catch (SQLException ex) {
        Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_ShowDetActionPerformed

    private void SellsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellsMouseClicked
       DefaultTableModel Sales = (DefaultTableModel)Sells.getModel();
       int SellId = Sells.getSelectedRow();
    }//GEN-LAST:event_SellsMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    try {
        Customerid = Customers.getRowId(jComboBox1.getSelectedIndex());
         SelectedCustomer(Customerid);
         tblupdate();
    } catch (SQLException ex) {
        Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void addCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCusActionPerformed
     Application.showForm(new CustomersForm());
    
    }//GEN-LAST:event_addCusActionPerformed

    private void SalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesMouseClicked

    }//GEN-LAST:event_SalesMouseClicked

    
        private void tblupdate(int id) {
            try (Connection connection = getConnection()) {
           
            DefaultTableModel sells = (DefaultTableModel)Sales.getModel();
            sells.setRowCount(0);
            for(Vector s : sales.getAllSalesD(id)){
              sells.addRow(s);
            }
        } 
        catch (SQLException e) {
           System.out.println(e);
        }
            
            
}
        private void tblupdate() {
            
            try (Connection connection = getConnection()) {
                
            DefaultTableModel items = (DefaultTableModel)item.getModel();
            items.setRowCount(0);
            for(Vector s : Items.getAllItems()){
              items.addRow(s);
              
            }  
            
             DefaultTableModel Mcart = (DefaultTableModel)cart.getModel();
            Mcart.setRowCount(0);
            for(Vector s : Cart.getAll()){
              Mcart.addRow(s);
            }
            DefaultTableModel sells1 = (DefaultTableModel)Sells.getModel();
            sells1.setRowCount(0);
            for(Vector s : sales.getAllSales()){
              sells1.addRow(s);
            }
        } 
        catch (SQLException e) {
           System.out.println(e);
        }
            
            
            
    }
       private void processSale() {
            try (Connection connection = getConnection()) {
             connection.setAutoCommit(false); // Start transaction

            int customerId = getCustomerIdFromTable();
            double totalAmount = calculateTotalAmount();

            // Insert the master sale record
            String salesInsertSql = "INSERT INTO Sales (CustomerID, SaleDate, TotalAmount) VALUES (?, CURRENT_TIMESTAMP, ?)";
            PreparedStatement salesStmt = connection.prepareStatement(salesInsertSql, Statement.RETURN_GENERATED_KEYS);
            salesStmt.setInt(1, customerId);
            salesStmt.setDouble(2, totalAmount);

            int affectedRows = salesStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating sale failed, no rows affected.");
            }

            int saleId;

              try (ResultSet generatedKeys = salesStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    saleId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating sale failed, no ID obtained.");
                }
            }

            // Insert each sale detail record
            String salesDetailsInsertSql = "INSERT INTO SalesDetails (SaleID, ItemID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement salesDetailsStmt = connection.prepareStatement(salesDetailsInsertSql);
            DefaultTableModel model = (DefaultTableModel) cart.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                salesDetailsStmt.setInt(1, saleId);
                salesDetailsStmt.setInt(2, Cart.getItemsId(i)); // ItemID
                salesDetailsStmt.setInt(3, Integer.parseInt(model.getValueAt(i, 2).toString())); // Quantity
                salesDetailsStmt.setDouble(4, Double.parseDouble(model.getValueAt(i, 1).toString())); // UnitPrice
                salesDetailsStmt.addBatch();
            }
            salesDetailsStmt.executeBatch();

            connection.commit(); // Commit transaction
            JOptionPane.showMessageDialog(this, "Sale processed successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error processing sale: " + ex.getMessage());
            ex.printStackTrace();
        }
}


      private void getcustomers(){
        jComboBox1.removeAllItems();
            try {
                for(String s : Customers.getAllCustomersName()){
                    jComboBox1.addItem(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

    private int getCustomerIdFromTable() {
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        int lastColumnIndex = model.getColumnCount() - 1;
        return Integer.parseInt(model.getValueAt(0, lastColumnIndex).toString());
    }

    private double calculateTotalAmount() {
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        double totalAmount = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalAmount += Double.parseDouble(model.getValueAt(i, 3).toString());
        }
        return totalAmount;
    }  
        
        
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JTable Sales;
    private javax.swing.JButton Sell;
    private javax.swing.JTable Sells;
    private javax.swing.JButton Send;
    private javax.swing.JButton ShowDet;
    private javax.swing.JButton UpdateC;
    private javax.swing.JButton add;
    private javax.swing.JButton addCus;
    private javax.swing.JTextField barcode;
    private javax.swing.JTable cart;
    private javax.swing.JTextField category;
    private javax.swing.JTextField code;
    private javax.swing.JTextField companyId;
    private javax.swing.JButton delete;
    private javax.swing.JTextField description;
    private javax.swing.JButton getBack;
    private javax.swing.JTable item;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField quantity1;
    private javax.swing.JTextField sectionId;
    private javax.swing.JTextField status;
    private javax.swing.JButton update;
    private javax.swing.JTextField warehouseId;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
