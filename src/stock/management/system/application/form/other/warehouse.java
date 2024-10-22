package stock.management.system.application.form.other;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import stock.management.system.application.Application;
import stock.management.system.classes.Warehouses;
import static stock.management.system.application.form.other.FormDashboard.getConnection;

/**
 *
 * @author Raven
 */
public class warehouse extends javax.swing.JPanel {

    public warehouse() {
        initComponents();
        tblupdate();
    }
    int id;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Twarehouses = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        Twarehouses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Location", "Company"
            }
        ));
        Twarehouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TwarehousesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Twarehouses);

        jButton1.setText("add WH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton2.setText("cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jButton4)
                .addGap(29, 29, 29)
                .addComponent(update)
                .addGap(46, 46, 46)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TwarehousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwarehousesMouseClicked
        Twarehouses.getSelectedRow();
        DefaultTableModel warehouse = (DefaultTableModel)Twarehouses.getModel();
        int row = Twarehouses.getSelectedRow();
        String Sid = warehouse.getValueAt(row, 0).toString();
        id = Integer.parseInt(Sid);
        // TODO add your handling code here:
    }//GEN-LAST:event_TwarehousesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Application.showForm(new WarehouseForm());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

          Warehouses warehouse = new Warehouses();
            warehouse.deleteWarehouse(id);
            tblupdate();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       
        System.out.println(id);
        Application.showForm(new WarehouseForm(id));
        tblupdate();

    }//GEN-LAST:event_updateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Application.showForm(new FormDashboard());
    }//GEN-LAST:event_jButton2ActionPerformed
public  void tblupdate() {
            try (Connection connection = getConnection()) {
             
            
            
         DefaultTableModel warehouses = (DefaultTableModel)Twarehouses.getModel();
         warehouses.setRowCount(0);
           
            for(Vector s : Warehouses.getAllWarehouses()){
       
              warehouses.addRow(s);
                
            }          
        } 
        catch (SQLException e) {
           System.out.println(e);
        }
 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Twarehouses;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
