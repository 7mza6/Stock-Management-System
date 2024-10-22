package stock.management.system.application.form.other;

import stock.management.system.classes.ComboBoxItem;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import stock.management.system.application.Application;
import stock.management.system.classes.Items;
import static stock.management.system.application.form.other.FormDashboard.getConnection;import stock.management.system.classes.Cart;
import static stock.management.system.classes.Items.getItemById;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import static stock.management.system.classes.Sections.getSectionsByWarehouseId;

public class ItemsForm extends javax.swing.JPanel {
    int Id=0;
    public ItemsForm()  {
        try {
            initComponents();
            fillWarehouseComboBox();
            fillCompanyComboBox();
            fillSectionComboBox();

        } catch (SQLException ex) {
            Logger.getLogger(ItemsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public ItemsForm(int id) {
        try {
            initComponents();

            fillSectionComboBox();
            fillWarehouseComboBox();
            fillCompanyComboBox();
            this.Id =id;
            fillItemDetails(id);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ItemsForm(int id, String name, int quantity, double weight, String category, double price, String barcode, String code, String status, String description, int sectionId, int warehouseId, int companyId) throws SQLException {
        Items item = new Items();
        item.updateItem(id, name,  quantity,  weight,  category,  price,  barcode,  code,  status,  description,  sectionId,  warehouseId,  companyId);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        category = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        jLabel4.setText("Price");

        jLabel5.setText("Section");

        jLabel6.setText("Company");

        jLabel7.setText("Warehouse");

        jLabel8.setText("Barcode");

        jLabel9.setText("code");

        jLabel10.setText("Weight");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel11.setText("status");

        jLabel12.setText("Description");

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Item Name");

        jLabel2.setText("Quantity");

        jLabel3.setText("Category");

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel9)
                                .addComponent(code, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(weight, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(category, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(Cancel)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Cancel))
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void fillItemDetails(int itemId) {
    try {
        Vector<Object> itemDetails = getItemById(itemId); // getConnection() should be defined elsewhere
        if (!itemDetails.isEmpty()) {
            name.setText((String) itemDetails.get(1)); // Assuming index 1 is Name
            barcode.setText((String) itemDetails.get(6)); // Assuming index 6 is Barcode
            code.setText((String) itemDetails.get(7)); // Assuming index 7 is Code
            status.setText((String) itemDetails.get(8)); // Assuming index 8 is Status
            description.setText((String) itemDetails.get(9)); // Assuming index 9 is Description
            quantity.setText(String.valueOf(itemDetails.get(2))); // Assuming index 2 is Quantity
            weight.setText(itemDetails.get(3).toString()); // Assuming index 3 is Weight
            category.setText((String) itemDetails.get(4)); // Assuming index 4 is Category
            price.setText(((BigDecimal) itemDetails.get(5)).toPlainString()); // Assuming index 5 is Price
            int id = (int) itemDetails.get(14); 
            setComboBoxSelectedItemById(jComboBox1,(int) itemDetails.get(14));
            setComboBoxSelectedItemById(jComboBox2,(int) itemDetails.get(12));
            setComboBoxSelectedItemById(jComboBox3,(int) itemDetails.get(10));

         
            
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        
    }
}

private void setComboBoxSelectedItemById(JComboBox<ComboBoxItem> comboBox, int id) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        ComboBoxItem item = comboBox.getItemAt(i);
        if (item.getId() == id) {
            comboBox.setSelectedIndex(i);
            break;
        }
    }
}
    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(Id==0){        try (Connection connection = getConnection()) {
            Items item1 = new Items();
        //    item1.addItem(name.getText(),Integer.parseInt(quantity.getText()),Double.parseDouble(weight.getText()),category.getText(),Double.parseDouble(price.getText()),barcode.getText(),code.getText(),status.getText(),description.getText(),Integer.parseInt(sectionId.getText()),Integer.parseInt(warehouseId.getText()),Integer.parseInt(companyId.getText()));
            Application.showForm(new FormDashboard());
        } catch (SQLException ex) {
            Logger.getLogger(ItemsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                       Application.showForm(new FormDashboard());

}
else{
     try(Connection connection = getConnection())
     {
          Cart cart = new Cart();
            if(cart.inCart(Id) > 0){
                cart.updatePrice(Id,Double.parseDouble(price.getText()));
            }
                Application.showForm(new FormDashboard());

ComboBoxItem selectedSection = (ComboBoxItem) jComboBox3.getSelectedItem();
ComboBoxItem selectedWarehouse = (ComboBoxItem) jComboBox2.getSelectedItem();
ComboBoxItem selectedCompany = (ComboBoxItem) jComboBox1.getSelectedItem();

// Make sure to handle potential null values if nothing is selected
            int sectionId = selectedSection != null ? selectedSection.getId() : -1; // Replace -1 with default or error value
            int warehouseId = selectedWarehouse != null ? selectedWarehouse.getId() : -1;
            int companyId = selectedCompany != null ? selectedCompany.getId() : -1;
            Items item = new Items();
            item.updateItem( Id, name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(weight.getText()), 
                category.getText(), Double.parseDouble(price.getText()), barcode.getText(), code.getText(), 
                status.getText(), description.getText(), sectionId, warehouseId, companyId);
                      }
             catch (SQLException ex) {
                  Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
}

    }//GEN-LAST:event_jButton1ActionPerformed
private void fillCompanyComboBox() throws SQLException {
    
    Connection conn = getConnection();
    String sql = "SELECT ID, Name FROM Companys";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            jComboBox1.addItem(new ComboBoxItem(id, name));
        }
    }
    
}

private void fillWarehouseComboBox() throws SQLException {
        jComboBox2.removeAllItems(); // Clear existing items

    ComboBoxItem selectedCompany = (ComboBoxItem) jComboBox1.getSelectedItem();
    
    int companyId = selectedCompany != null ? selectedCompany.getId() : -1;

    Connection conn = getConnection();
    String sql = "SELECT ID, Name FROM Warehouses WHERE companyId = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, companyId);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                jComboBox2.addItem(new ComboBoxItem(id, name));
            }
        }
    }
}


private void fillSectionComboBox() throws SQLException {
    jComboBox3.removeAllItems(); // Clear existing items
ComboBoxItem selectedWarehouse = (ComboBoxItem) jComboBox2.getSelectedItem();

            int warehouseId = selectedWarehouse != null ? selectedWarehouse.getId() : -1;

    try {
        Vector<Vector<Object>> sections = getSectionsByWarehouseId(warehouseId);
        for (Vector<Object> section : sections) {
            jComboBox3.addItem(new ComboBoxItem((int) section.get(0), (String) section.get(1)));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle the exception as appropriate
    }
}

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        Application.showForm(new FormDashboard());
    }//GEN-LAST:event_CancelActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {
            fillSectionComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            fillWarehouseComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField barcode;
    private javax.swing.JTextField category;
    private javax.swing.JTextField code;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<ComboBoxItem> jComboBox1;
    private javax.swing.JComboBox<ComboBoxItem> jComboBox2;
    private javax.swing.JComboBox<ComboBoxItem> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField status;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
