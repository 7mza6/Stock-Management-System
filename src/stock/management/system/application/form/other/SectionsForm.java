package stock.management.system.application.form.other;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import stock.management.system.application.Application;
import static stock.management.system.application.form.other.FormDashboard.getConnection;
import stock.management.system.classes.ComboBoxItem;
import stock.management.system.classes.Sections;
import static stock.management.system.classes.Sections.getSectionById;
/**
 *
 * @author sakalolo
 */
public class SectionsForm extends javax.swing.JPanel {
    int id =0;
    public SectionsForm() {
        try {
            initComponents();
            fillWarehouseComboBox();
            jLabel1.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(SectionsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public SectionsForm(int id){
        try {
            this.id =id;
            initComponents();
            fillWarehouseComboBox();
            jLabel1.setVisible(false);
            fillDetails(id);
        } catch (SQLException ex) {
            Logger.getLogger(SectionsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("description");

        jLabel3.setText("name");

        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        jButton1.setText("save");
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

        jLabel4.setText("warehouse");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButton2)
                        .addGap(102, 102, 102)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(id == 0){
            try (Connection connection = getConnection()){   

            ComboBoxItem selectedWarehouse = (ComboBoxItem) jComboBox1.getSelectedItem();

               int warehouseId = selectedWarehouse != null ? selectedWarehouse.getId() : -1;
               if (warehouseId == -1)
                    JOptionPane.showMessageDialog(this, "No Warehouse selected");

                Sections Section = new Sections();
                Section.addSection(name.getText(), description.getText(),warehouseId);
                Application.showForm(new Section());    
            } catch (SQLException ex) {
                    Logger.getLogger(Section.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else {
            try (Connection connection = getConnection()) {
                ComboBoxItem selectedWarehouse = (ComboBoxItem) jComboBox1.getSelectedItem();
                int warehouseId = selectedWarehouse != null ? selectedWarehouse.getId() : -1;
                if (warehouseId == -1)
                    JOptionPane.showMessageDialog(this, "No Warehouse selected");
                else{
                    Sections section = new Sections();

                    section.updateSection(id, name.getText(), description.getText(), warehouseId);

                    Application.showForm(new Section());
                }
            } catch (SQLException ex) {
            Logger.getLogger(Section.class.getName()).log(Level.SEVERE, null, ex);
            }

    }


      
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Application.showForm(new Section());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
private void fillWarehouseComboBox() throws SQLException {

  

    Connection conn = getConnection();
    String sql = "SELECT ID, Name FROM Warehouses";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                jComboBox1.addItem(new ComboBoxItem(id, name));
            }
        }
    }
}
public void fillDetails(int id) {
    try {
        Vector<Object> SectionDetails = getSectionById(id); 
        if (!SectionDetails.isEmpty()) {
            name.setText((String) SectionDetails.get(1)); 
            description.setText((String) SectionDetails.get(2));
            setComboBoxSelectedItemById(jComboBox1,(int) SectionDetails.get(3));      
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<ComboBoxItem> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
