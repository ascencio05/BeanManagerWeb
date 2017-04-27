/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.solicitudes;

import beanmanager.clases.Proyecto;
import beanmanager.clases.Requerimiento;
import beanmanager.clases.Usuario;
import beanmanager.proyectos.IndexProyecto;
import java.awt.Color;

/**
 *
 * @author Rodrigo
 */
public class VerRequerimientos extends javax.swing.JInternalFrame {
    IndexSolicitud padres;
    int page;
    Requerimiento actReq;
    public Proyecto actual;
    public Usuario session;
    /**
     * Creates new form VerRequerimientos
     */
    public VerRequerimientos() {
        initComponents();
    }
    
    public VerRequerimientos(IndexSolicitud p) {
        initComponents();
        padres = p;
        page = 0;
        getContentPane().setBackground(Color.white);
        
        jPanel1.setBackground(Color.white);
        jPanel2.setBackground(Color.white);
        jPanel3.setBackground(Color.white);
        jPanel5.setBackground(Color.white);
        jPanel6.setBackground(Color.white);
        tfProyecto.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProyecto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfProyecto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBorder(null);

        jLabel1.setText("Proyecto:");
        jPanel1.add(jLabel1);

        lblProyecto.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblProyecto.setText("idProyecto");
        jPanel1.add(lblProyecto);

        getContentPane().add(jPanel1);

        jPanel2.setBorder(null);

        jLabel3.setText("Titulo:");
        jPanel2.add(jLabel3);

        lblTitle.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblTitle.setText("titulo");
        jPanel2.add(lblTitle);

        getContentPane().add(jPanel2);

        jPanel3.setBorder(null);

        jLabel5.setText("Fecha:");
        jPanel3.add(jLabel5);

        lblDate.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblDate.setText("00/00/0000");
        jPanel3.add(lblDate);

        getContentPane().add(jPanel3);

        jPanel5.setBorder(null);

        jLabel9.setText("Requerimiento");

        tfProyecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfProyecto)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 356, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5);

        jPanel6.setBorder(null);
        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel6.add(btnAnterior);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel6.add(btnSiguiente);

        getContentPane().add(jPanel6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        padres.detalles.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        next();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    public void next()
    {
        if((actual.requerimientos.size() - 1) > page)
        {
            page++;
            Requerimiento aux = actual.requerimientos.get(page);
            actReq = aux;
            printActual();
        }
    }
    
    public void anterior()
    {
        if(page > 0)
        {
            page--;
            Requerimiento aux = actual.requerimientos.get(page);
            actReq = aux;
            printActual();
        }
    }
    
    public void printActual()
    {
        if(actual.requerimientos.size() > 0)
        {
            lblProyecto.setText(actual.titulo);
            lblTitle.setText(actReq.titulo);
            lblDate.setText(actReq.fecha);
            tfProyecto.setText(actReq.descripcion);
            if(page == 0)
            {
                btnAnterior.setEnabled(false);
                btnSiguiente.setEnabled(true);
            }
            if(page == (actual.requerimientos.size() - 1))
            {
                btnSiguiente.setEnabled(false);
                btnAnterior.setEnabled(true);
            }
            if((actual.requerimientos.size() - 1) == 0)
            {
                btnSiguiente.setEnabled(false);
                btnAnterior.setEnabled(false);
            }
        }
        else
        {
            lblProyecto.setText("");
            lblTitle.setText("");
            lblDate.setText("");
            tfProyecto.setText("NO SE ENCONTRARON REQUERIMIENTOS");
            btnSiguiente.setEnabled(false);
            btnAnterior.setEnabled(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField tfProyecto;
    // End of variables declaration//GEN-END:variables
}
