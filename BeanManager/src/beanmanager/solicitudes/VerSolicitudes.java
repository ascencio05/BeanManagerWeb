/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.solicitudes;

import beanmanager.controles.Bdd;
import beanmanager.proyectos.IndexProyecto;
import beanmanager.solicitudes.Detalles;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import beanmanager.clases.Proyecto;
import beanmanager.clases.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rodrigo
 */
public final class VerSolicitudes extends javax.swing.JInternalFrame {
    Detalles detalle;
    IndexSolicitud padre;
    JTable table;
    public Bdd db;
    List<Proyecto> proyectos = new ArrayList<>();
    boolean busqueda;
    public Usuario session;
    /**
     * Creates new form VerSolicitudes
     */
    public VerSolicitudes() {
        initComponents();
        detalle = new Detalles();
    }

    public  VerSolicitudes(IndexSolicitud p)
    {
        initComponents();
        detalle = new Detalles(p);
        padre = p;
        table = initTable();
        jScrollPane1.add(table);
        jScrollPane1.setViewportView(table);
        db = padre.db;
        txtBusqueda.setSize(10, 28);
        getContentPane().setBackground(Color.white);
        jPanel1.setBackground(Color.white);
        jPanel2.setBackground(Color.white);
        loadSol(false,false,null);
        eventBusqueda();
    }
    
    public void eventBusqueda()
    {
        txtBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busqueda  =true;
                String opcion = cmbBusqueda.getSelectedItem().toString();
                if(opcion.equals("Titulo"))
                {
                    String cmd = "select Usuarios.correo, Proyecto.idProyecto, Proyecto.titulo, "
                                + "Proyecto.descripcion, Proyecto.fechaInicio, Proyecto.fechaFinal, "
                                + "Proyecto.fechaCreacion from Proyecto inner join Usuarios on "
                                + "Usuarios.idUsuario = Proyecto.idUsuario where Proyecto.aceptado = 0 "
                            + "and Proyecto.titulo like ?";
                    loadSol(true, true, cmd);
                }
                else
                {
                    String cmd = "select Usuarios.correo, Proyecto.idProyecto, Proyecto.titulo, "
                                + "Proyecto.descripcion, Proyecto.fechaInicio, Proyecto.fechaFinal, "
                                + "Proyecto.fechaCreacion from Proyecto inner join Usuarios on "
                                + "Usuarios.idUsuario = Proyecto.idUsuario where Proyecto.aceptado = 0 "
                            + "and Proyecto.idProyecto = ?";
                    loadSol(true, false, cmd);
                }
            }
        });
        
        txtBusqueda.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(busqueda)
                {
                    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    {
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.setRowCount(0);
                        loadSol(false,false,null);
                    }
                    busqueda = false;
                    txtBusqueda.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    
    public JTable initTable()
    {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id","Titulo","Fecha Creación","Selección"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable table = new JTable();
        table.setModel(model);
        
        TableColumn id = table.getColumnModel().getColumn(3);
        table.removeColumn(id);
        return table;
    }
    
    private void loadSol(boolean busqueda, boolean mode, String cmd)
    {
        if(!busqueda)
        {
            cmd = "select Usuarios.correo, Proyecto.idProyecto, Proyecto.titulo, "
                + "Proyecto.descripcion, Proyecto.fechaInicio, Proyecto.fechaFinal, "
                + "Proyecto.fechaCreacion from Proyecto inner join Usuarios on "
                + "Usuarios.idUsuario = Proyecto.idUsuario where Proyecto.aceptado = 0";
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setRowCount(0);
        }
        try {
            List<Object> parametros = new ArrayList<>();
            db.setPreparedQuery(cmd);
            if(busqueda)
            {
                if(mode)
                {
                    parametros.add(txtBusqueda.getText() + "%");
                }
                else
                {
                    parametros.add(txtBusqueda.getText());
                }
            }
            ResultSet rs = db.executeReader(parametros);
            while(rs.next())
            {
                String usuario = rs.getString("correo");
                String idProyecto = rs.getString("idProyecto");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String fechaI = rs.getString("fechaInicio");
                String fechaF = rs.getString("fechaFinal");
                String fechaC = rs.getString("fechaCreacion");
                
                Proyecto aux = new Proyecto(idProyecto, usuario, titulo, descripcion, fechaI, fechaF, fechaC, "0", "0");
                
                proyectos.add(new Proyecto(idProyecto, usuario, titulo, descripcion, fechaI, fechaF, fechaC, "0", "0"));
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[] {idProyecto,titulo,fechaC,aux});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loadSol()");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnDetalles = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        cmbBusqueda = new javax.swing.JComboBox<>();

        setClosable(true);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetalles);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Buscar:");
        jPanel2.add(jLabel1);
        jPanel2.add(txtBusqueda);

        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titulo", "Id" }));
        jPanel2.add(cmbBusqueda);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int selected = table.getSelectedRow();
        if(selected != -1)
        {
            Proyecto aux = (Proyecto) model.getValueAt(selected, 3);

            detalle.actual = aux;
            detalle.setActual();
            detalle.session = session;
            this.hide();
            padre.detalles = detalle;
            padre.add(detalle);
            detalle.setVisible(true);
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int selected = table.getSelectedRow();
        if(selected != -1)
        {
            Proyecto aux = (Proyecto) model.getValueAt(selected, 3);
            try {
                aux.aceptarSolicitud(db,session);
                model.setRowCount(0);
                loadSol(false,false,null);
                JOptionPane.showMessageDialog(null, "Solicitud aceptada.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al aceptar solicitud");
            }
            
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JComboBox<String> cmbBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
