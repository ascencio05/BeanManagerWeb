/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.ajustes;
import beanmanager.controles.*;
import beanmanager.clases.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author jacky
 */
public class AgregarRol extends javax.swing.JFrame {
    Usuario session;
    /**
     * Creates new form AgregarRol
     */
    public AgregarRol(Usuario u) {
        initComponents();
        setResizable(false);
        setTitle("Bean Manager");
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        session = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbTitulo = new javax.swing.JLabel();
        jlbNombre = new javax.swing.JLabel();
        jlbDescripcion = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jbntAtras = new javax.swing.JButton();
        jbntAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTitulo.setText("Agregar Rol");

        jlbNombre.setText("Nombre del Rol: ");

        jlbDescripcion.setText("Desripción: ");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        jbntAtras.setText("Atras");
        jbntAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntAtrasActionPerformed(evt);
            }
        });

        jbntAgregar.setText("Agregar");
        jbntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbntAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbntAtras))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbNombre)
                                .addComponent(jlbDescripcion))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jtfNombre)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbDescripcion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbntAtras)
                    .addComponent(jbntAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbntAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntAtrasActionPerformed
        // TODO add your handling code here:
        Roles jfmRoles = new Roles(session);
        jfmRoles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbntAtrasActionPerformed

    private void jbntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntAgregarActionPerformed
        // TODO add your handling code here:
        try
        {
            if(this.jtfNombre.getText().equals("") || this.jtaDescripcion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Es necesario que llene todos los campos");
            }
            else
            {
                String nombre = this.jtfNombre.getText(),
                        descripcion = this.jtaDescripcion.getText();
                Bdd conexion = new Bdd();
                String consulta="INSERT INTO `rolesProyecto`(`rol`, `descripcion`, `eliminado`) VALUES ('"+nombre+"','"+descripcion+"',0)";
                Statement stmt = conexion.con.createStatement();
                int agregado = stmt.executeUpdate(consulta);
                if(agregado>0)
                {
                    
                    conexion.close();
                    AgregarPermisosRol agregar = new AgregarPermisosRol(nombre,descripcion);
                    agregar.PermisosRol();
                    JOptionPane.showMessageDialog(null, "Se ha agregado el rol con éxito.");
                    this.jbntAtras.doClick();
                }
                else
                {
                    conexion.close();
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el rol.");
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }//GEN-LAST:event_jbntAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarRol(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbntAgregar;
    private javax.swing.JButton jbntAtras;
    private javax.swing.JLabel jlbDescripcion;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
