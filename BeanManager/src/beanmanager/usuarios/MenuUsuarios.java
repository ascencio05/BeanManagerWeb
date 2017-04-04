/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.usuarios;

import beanmanager.controles.Bdd;

import beanmanager.menuInicio;

import java.awt.Color;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Monica Escrich
 */
public class MenuUsuarios extends javax.swing.JFrame {

    Bdd db = new Bdd("unconnected");

    private TableRowSorter trsFiltro;

    /**
     * Creates new form MenuUsuarios
     */
    public MenuUsuarios() {
        
        initComponents();
        setLocationRelativeTo(null);//Centra pantalla
        setResizable(false); //Quitar Resize
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        

        DefaultTableModel modeloTabla = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };

       

           //agrega columnas de la tabla
           modeloTabla.setColumnIdentifiers(new Object [] {

              "Id Usuario", "Nombres", "Apellidos", "Correo Electronico","Rol", "Fecha Nac"

           });
           
           loadUsuarios(); 
    }
    
    public void loadUsuarios(){
    
        String cmd="SELECT Usuarios.idUsuario, Usuarios.nombre, Usuarios.apellido, Usuarios.correo,"
                +" Usuarios.fechaNacimiento, rolesProyecto.rol " 
                +" FROM Usuarios JOIN rolesProyecto ON rolesProyecto.idRol = Usuarios.idTipo";
        
         try {
            db.setPreparedQuery(cmd);
            ResultSet rs = db.executeReader(null);
            while(rs.next())
            {
                String idProyecto = rs.getString("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fechaNac = rs.getString("fechaNacimiento");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                
                DefaultTableModel model = (DefaultTableModel) jTableUsuarios.getModel();
                model.addRow(new String[] {idProyecto,nombre,apellido,correo,rol,fechaNac});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loadSol()");
        }
        

    }
    
    public void filtro() {
        
        int columnaABuscar = 0;
        if (jComboBoxFiltro.getSelectedItem() == "Id Usuario") {
            columnaABuscar = 0;
        }
        if (jComboBoxFiltro.getSelectedItem().toString() == "Apellidos") {
            columnaABuscar = 2;
        }
        if (jComboBoxFiltro.getSelectedItem() == "Correo Electronico") {
            columnaABuscar = 3;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(), columnaABuscar));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnNuevoUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jbtnModificarUsuario = new javax.swing.JButton();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jTextFieldBuscar = new javax.swing.JTextField();

        jButton1 = new javax.swing.JButton();


        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/newuser.png"))); // NOI18N
        jbtnNuevoUsuario.setToolTipText("Agregar Nuevo Usuario");
        jbtnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoUsuarioActionPerformed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        jbtnModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/modifyuser.png"))); // NOI18N

        jbtnModificarUsuario.setToolTipText("Modificar/Ver Usuario");
        jbtnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarUsuarioActionPerformed(evt);
            }
        });

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Usuario", "Apellidos", "Correo Electronico"}));

        jTextFieldBuscar.setToolTipText("Buscar Usuario");
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/home.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jbtnModificarUsuario.setToolTipText("Modificar/Ver Usuario");

       


        jbtnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarUsuarioActionPerformed(evt);
            }
        });


        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Usuario", "Apellidos", "Correo Electronico"}));

        jTextFieldBuscar.setToolTipText("Buscar Usuario");
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnNuevoUsuario)
                    .addComponent(jbtnModificarUsuario))

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)

                .addComponent(jbtnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jbtnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jbtnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))

        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        NuevoUsuario frmnew_usr = new NuevoUsuario(); 
        frmnew_usr.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jbtnNuevoUsuarioActionPerformed

    private void jbtnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarUsuarioActionPerformed
        // TODO add your handling code here:
        int column=0; 
        int row= jTableUsuarios.getSelectedRow(); 
        int idUsr= Integer.valueOf(jTableUsuarios.getModel().getValueAt(row, column).toString());
        NuevoUsuario newusr = new NuevoUsuario(idUsr); 
        newusr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtnModificarUsuarioActionPerformed


    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // TODO add your handling code here:
        jTextFieldBuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTextFieldBuscar.getText());
                jTextFieldBuscar.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(jTableUsuarios.getModel());
        jTableUsuarios.setRowSorter(trsFiltro);

    }//GEN-LAST:event_jTextFieldBuscarKeyTyped


    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        menuInicio Ini = new menuInicio();
        Ini.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed



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
            java.util.logging.Logger.getLogger(MenuUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton jButton1;

    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JButton jbtnModificarUsuario;
    private javax.swing.JButton jbtnNuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
