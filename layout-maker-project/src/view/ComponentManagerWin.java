package view;

import control.ComponentControl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ComponentManagerWin extends javax.swing.JDialog {

    ComponentControl ctr;
    ArrayList comps;
    int row_selected;
    int opt_select = 0;
    List list = null;

    /**
     * Creates new form ComponentManager
     */
    public ComponentManagerWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {

            this.ctr = new ComponentControl();

            // Loading files in the table
            ctr.loadTable(table);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO não esperado. " + e.getMessage());
        }
    }
    
    public ComponentManagerWin(java.awt.Frame parent, boolean modal, boolean select) {
        super(parent, modal);
        initComponents();

        try {

            this.ctr = new ComponentControl();

            // Loading files in the table
            ctr.loadTable(table);
            
            if( select ) {
                this.opt_select = 1;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO não esperado. " + e.getMessage());
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

        search_type = new javax.swing.JComboBox();
        input_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add_component = new javax.swing.JToggleButton();
        btn_delete = new javax.swing.JToggleButton();
        btn_select = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        btn_refresh = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Componentes");
        setResizable(false);

        search_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome" }));

        input_search.setToolTipText("");

        btn_search.setText("Pesquisar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
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

        add_component.setText("Adicionar");
        add_component.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_componentActionPerformed(evt);
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
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        jToggleButton7.setText("Categorias");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        btn_refresh.setText("Atualizar");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_type, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jToggleButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_component)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_search)
                    .addComponent(search_type, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_component, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_componentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_componentActionPerformed

        ComponentWin win_component = new ComponentWin(null, true);
        win_component.setLocationRelativeTo(null);
        win_component.setVisible(true);

        try {
            this.refreshTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO!");
        }

    }//GEN-LAST:event_add_componentActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        try {
            // Delete file
            int id = Integer.parseInt(table.getValueAt(this.row_selected, 0).toString());
            ctr.delete(id);

            this.refreshTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO ao excluir. " + e.getMessage());
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        
        this.list = new ArrayList();

        // Pega a quantiade de linhas selecionadas
        int list_size = table.getSelectedRows().length;

        // Pega as linhas selecionadas
        int[] list_file = table.getSelectedRows();

        // Salva os IDs na list
        for (int i = 0; i < list_size; i++) {
            this.list.add(Integer.parseInt(table.getValueAt(list_file[i], 0).toString()));
            this.list.add(table.getValueAt(list_file[i], 1));
        }

        this.setVisible(false);
        
    }//GEN-LAST:event_btn_selectActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed

        CategoryWin catWin = new CategoryWin(null, true);
        catWin.setLocationRelativeTo(null);
        catWin.setVisible(true);

    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        this.row_selected = table.getSelectedRow();

        if (this.row_selected >= 0) {

            // Enable buttons
            btn_delete.setEnabled(true);
            //btn_alter.setEnabled(true);
            
            if( this.opt_select == 1 ) {
                btn_select.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        try {

            if ("".equals(input_search.getText())) {
                JOptionPane.showMessageDialog(this, "Você precisa informar o que quer pesquisar!");
            } else {
                ctr.search(table, search_type.getSelectedIndex(), input_search.getText());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR. " + ex.getMessage());
        }

    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed

        try {
            this.refreshTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO!");
        }

    }//GEN-LAST:event_btn_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(ComponentManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComponentManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComponentManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComponentManagerWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComponentManagerWin dialog = new ComponentManagerWin(new javax.swing.JFrame(), true);
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
            btn_delete.setEnabled(false);
            btn_select.setEnabled(false);
        }

        // Clean search input
        input_search.setText("");
    }

    public List getList() {
        return list;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton add_component;
    private javax.swing.JToggleButton btn_delete;
    private javax.swing.JToggleButton btn_refresh;
    private javax.swing.JToggleButton btn_search;
    private javax.swing.JToggleButton btn_select;
    private javax.swing.JTextField input_search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JComboBox search_type;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
