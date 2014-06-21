package view;

import control.FrameworkControl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ErrorView;

/**
 *
 * @author Luiz
 */
public class FrameworkManagerWin extends javax.swing.JDialog {

    FrameworkControl ctr;
    int row_selected;
    int opt_select = 0;
    List list = null;

    public FrameworkManagerWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            // Control
            ctr = new FrameworkControl();

            // Loading files in the table
            ctr.loadTable(table);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO não esperado. " + e.getMessage());
        }
    }

    public FrameworkManagerWin(java.awt.Frame parent, boolean modal, boolean select) {
        super(parent, modal);
        initComponents();

        try {
            // Control
            ctr = new FrameworkControl();

            // Loading files in the table
            ctr.loadTable(table);

            if (select) {
                this.opt_select = 1;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO não esperado. " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search_type = new javax.swing.JComboBox();
        input_search = new javax.swing.JTextField();
        btn_pesq = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Framework");
        setResizable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        search_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome" }));

        btn_pesq.setText("Pesquisar");
        btn_pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesqActionPerformed(evt);
            }
        });

        btn_add.setText("Adicionar");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setText("Alterar");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Excluir");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_select.setText("Selecionar");
        btn_select.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(search_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(input_search)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_pesq))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesq))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_select))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        FrameworkWin win = new FrameworkWin(null, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);

        try {
            this.refreshTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO!");
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesqActionPerformed

        try {

            if ("".equals(input_search.getText())) {
                JOptionPane.showMessageDialog(this, "Você precisa informar o que quer pesquisar!");
            } else {
                ctr.search(table, search_type.getSelectedIndex(), input_search.getText());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR. " + ex.getMessage());
        }

    }//GEN-LAST:event_btn_pesqActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        this.row_selected = table.getSelectedRow();

        if (this.row_selected >= 0) {

            // Enable buttons
            btn_delete.setEnabled(true);
            btn_update.setEnabled(true);

            if (this.opt_select == 1) {
                btn_select.setEnabled(true);
            }
        }

    }//GEN-LAST:event_tableMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        
        FrameworkWin win = null;

        try {
            // Get ID
            int id = Integer.parseInt(table.getValueAt(this.row_selected, 0).toString());

            // Build windows
            win = new FrameworkWin(id, null, true);

            win.setLocationRelativeTo(null);
            win.setVisible(true);

            this.refreshTable();

        } catch (Exception ex) {
            ErrorView.errorDefault(ex);
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
        try {
            
            int file_id = Integer.parseInt(table.getValueAt(this.row_selected, 0).toString());
            
            ctr.delete(file_id);

            this.refreshTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO ao excluir. " + e.getMessage());
        }
        
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(FrameworkManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameworkManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameworkManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameworkManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameworkManagerWin dialog = new FrameworkManagerWin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void refreshTable() throws Exception {

        // Clean selection
        table.clearSelection();

        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }

        // Load table
        ctr.loadTable(table);

        // Check list is empty 
        if (table.getRowCount() == 0) {
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_select.setEnabled(false);
        }

        // Clean search input
        input_search.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_pesq;
    private javax.swing.JButton btn_select;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField input_search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox search_type;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
