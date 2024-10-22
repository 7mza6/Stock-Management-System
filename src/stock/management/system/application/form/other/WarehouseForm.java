package stock.management.system.application.form.other;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import stock.management.system.application.Application;
import static stock.management.system.application.form.other.FormDashboard.getConnection;
import stock.management.system.classes.ComboBoxItem;
import stock.management.system.classes.Warehouses;
import static stock.management.system.classes.Warehouses.getWarehouseById;
/**
 *
 * @author sakalolo
 */
public class WarehouseForm extends javax.swing.JPanel {
 int id = 0;
    public WarehouseForm() {
        try {
            initComponents();
            fillCompanyComboBox();
            jLabel1.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public WarehouseForm(int id) {
        try {
            this.id =id;
            initComponents();
            fillCompanyComboBox();
            jLabel1.setVisible(false);
            fillItemDetails(id);
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("location");

        jLabel3.setText("name");

        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("you cant add with empty location or name");

        jLabel4.setText("company");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 334, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton2)
                            .addGap(48, 48, 48)
                            .addComponent(jButton1)))
                    .addGap(0, 334, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 379, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addGap(0, 146, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if (id == 0) {
        if(name.getText().equals("")|| location.getText().equals("")){
            jLabel1.setVisible(true);
        }
        else{
ComboBoxItem selectedCompany = (ComboBoxItem) jComboBox1.getSelectedItem();
            int companyId = selectedCompany != null ? selectedCompany.getId() : -1;

            Warehouses warehouses = new Warehouses();

            warehouses.addWarehouse(companyId,name.getText(), location.getText());

            System.out.println(name.getText());

            

            Application.showForm(new warehouse());

        }
}
else{
    if(name.getText().equals("")|| location.getText().equals("")){
            jLabel1.setVisible(true);
        }
        else{
    try(Connection connection = getConnection())
     {
        
            Warehouses Warehouse = new Warehouses();
            ComboBoxItem selectedCompany = (ComboBoxItem) jComboBox1.getSelectedItem();
            Warehouse.updateWarehouse(id,name.getText(),location.getText(),selectedCompany.getId());
                      }
             catch (SQLException ex) {
                  Logger.getLogger(FormDashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
    Application.showForm(new warehouse());
    }
   
}
      
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Application.showForm(new warehouse());

    }//GEN-LAST:event_jButton2ActionPerformed
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
public void fillItemDetails(int id) {
    try {
        Vector<Object> WarehouseDetails = getWarehouseById(id); 
        if (!WarehouseDetails.isEmpty()) {
            name.setText((String) WarehouseDetails.get(1)); 
            location.setText((String) WarehouseDetails.get(2));
            setComboBoxSelectedItemById(jComboBox1,(int) WarehouseDetails.get(3));      
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
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<ComboBoxItem> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField location;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
