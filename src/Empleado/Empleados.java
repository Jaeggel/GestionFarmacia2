/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Farmacia.*;
import Principal.Login;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author FRANCISCO
 */
public class Empleados extends javax.swing.JFrame {

    Statement estSQL1=Login.estSQL;
    DefaultTableModel modelo=null;
   
    public Empleados() 
    {
        
        initComponents();
        insertImage();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/icono.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        
        cerrar();
        txtActual.setVisible(false);
        labell.setVisible(false);
        String cabecera[]={};
        String datos[][]={};
        
        modelo=new DefaultTableModel(datos,cabecera);
        //modelo=new DefaultTableModel(datos,null);
        Table.setModel(modelo); 
       
        cargarCombo();
       
        limpiarTabla(Table);
        
	         
        
        genClave();
     
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEmpl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId_empleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre_Empleado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido_empleado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSueldo_empleado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnMoficiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbId_farmacia = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        labell = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtActual = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 28)); // NOI18N
        jLabel1.setText("REGISTRO DE EMPLEADOS");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("ID Empleado:");

        txtId_empleado.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtId_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_empleadoActionPerformed(evt);
            }
        });
        txtId_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtId_empleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtId_empleadoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Nombres: ");

        txtNombre_Empleado.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtNombre_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_EmpleadoActionPerformed(evt);
            }
        });
        txtNombre_Empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre_EmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_EmpleadoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        txtApellido_empleado.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtApellido_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellido_empleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido_empleadoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Sueldo:");

        txtSueldo_empleado.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("ID Farmacia:");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar Registro");
        btnGuardar.setPreferredSize(new java.awt.Dimension(193, 55));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Consultar Empleados");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnMoficiar.setBackground(new java.awt.Color(255, 255, 255));
        btnMoficiar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnMoficiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnMoficiar.setText("   Modificar");
        btnMoficiar.setPreferredSize(new java.awt.Dimension(193, 55));
        btnMoficiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoficiarActionPerformed(evt);
            }
        });

        cmbId_farmacia.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        cmbId_farmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbId_farmaciaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Escriba el Id. y luego \"B\" para Buscar.");
        jLabel8.setEnabled(false);

        labell.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labell.setText("Farmacia actual:");
        labell.setEnabled(false);

        txtActual.setEditable(false);
        txtActual.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N

        Table.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Nombre", "Apellido", "Sueldo", "ID Farmacia"
            }
        ));
        jScrollPane2.setViewportView(Table);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono-personas.png"))); // NOI18N

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(183, 55));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmplLayout = new javax.swing.GroupLayout(panelEmpl);
        panelEmpl.setLayout(panelEmplLayout);
        panelEmplLayout.setHorizontalGroup(
            panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmplLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmplLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmplLayout.createSequentialGroup()
                        .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(panelEmplLayout.createSequentialGroup()
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEmplLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelEmplLayout.createSequentialGroup()
                            .addGap(247, 247, 247)
                            .addComponent(jLabel10))
                        .addGroup(panelEmplLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMoficiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelEmplLayout.createSequentialGroup()
                            .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelEmplLayout.createSequentialGroup()
                                    .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelEmplLayout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)))
                                                .addGroup(panelEmplLayout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel6)))
                                            .addGap(22, 22, 22))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmplLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(labell)))
                                    .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelEmplLayout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtId_empleado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNombre_Empleado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtApellido_empleado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtSueldo_empleado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbId_farmacia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelEmplLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelEmplLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEmplLayout.setVerticalGroup(
            panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmplLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmplLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmplLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSueldo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbId_farmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labell))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmplLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(307, 307, 307))
                    .addGroup(panelEmplLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panelEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnMoficiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel10)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Metodos obj=new Metodos();
        String transIn="BEGIN TRANSACTION";
        obj.transacciones(estSQL1, transIn);
        
        String sentenciaSQL="DELETE from empleado where id_empleado='"+txtId_empleado.getText().trim()+"'";

        if(obj.ingresarDatos(estSQL1, sentenciaSQL))
        {
                JOptionPane.showMessageDialog(null, "Datos Eliminados Exitosamente.");
                String transOutOk="COMMIT TRANSACTION";
                obj.transacciones(estSQL1, transOutOk);
        }else
        {
            String transOutBad="ROLLBACK TRANSACTION";
            obj.transacciones(estSQL1, transOutBad);
        }
        limpiar(); 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbId_farmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbId_farmaciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbId_farmaciaActionPerformed

    private void btnMoficiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoficiarActionPerformed
        txtActual.setVisible(false);
        labell.setVisible(false);
        Metodos obj=new Metodos();
        String transIn="BEGIN TRANSACTION";
        obj.transacciones(estSQL1, transIn);
        
        String sentenciaSQL="UPDATE empleado SET nombres_empleado='"+txtNombre_Empleado.getText().trim()+"',apellidos_empleado='"+txtApellido_empleado.getText().trim()+"',sueldo="+Double.parseDouble(txtSueldo_empleado.getText().trim())+",id_farmacia='"+cmbId_farmacia.getSelectedItem().toString()+"' WHERE id_empleado='"+txtId_empleado.getText().trim()+"'";
        
        if(obj.ingresarDatos(estSQL1, sentenciaSQL))
        {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Exitosamente.");
                String transOutOk="COMMIT TRANSACTION";
                obj.transacciones(estSQL1, transOutOk);
        }else
        {
            String transOutBad="ROLLBACK TRANSACTION";
            obj.transacciones(estSQL1, transOutBad);
        }
        limpiar();
    }//GEN-LAST:event_btnMoficiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpiarTabla(Table);
        Procesos_Farmacia sql=new Procesos_Farmacia();

        ResultSet rs=sql.consultarDatos(estSQL1, "select * from vista_empleado");
        sql.procesarRB(rs, modelo);
        editarCabecera();
        limpiar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        txtActual.setVisible(false);
        labell.setVisible(false);
        Metodos obj=new Metodos();

        String transIn="BEGIN TRANSACTION";
        obj.transacciones(estSQL1, transIn);

        String sentenciaSQL="Insert into empleado values('"+txtId_empleado.getText().trim()+"','"+txtNombre_Empleado.getText().trim()+"','"+txtApellido_empleado.getText().trim()+"',"+Double.parseDouble(txtSueldo_empleado.getText().trim())+",'"+cmbId_farmacia.getSelectedItem().toString()+"')";
        if(obj.ingresarDatos(estSQL1, sentenciaSQL))
        {

            JOptionPane.showMessageDialog(null, "Datos Agregados Exitosamente.");
            String transOutOk="COMMIT TRANSACTION";
            obj.transacciones(estSQL1, transOutOk);
        }else
        {
            String transOutBad="ROLLBACK TRANSACTION";
            obj.transacciones(estSQL1, transOutBad);
        }
        cmbId_farmacia.removeAllItems();
        limpiar();
        txtNombre_Empleado.requestFocus();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtApellido_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido_empleadoKeyTyped

        if(Character.isDigit(evt.getKeyChar()))
        evt.consume();

    }//GEN-LAST:event_txtApellido_empleadoKeyTyped

    private void txtApellido_empleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido_empleadoKeyReleased
        if(Character.isDigit(evt.getKeyChar())|| txtId_empleado.getText().length()==10)
        evt.consume();
    }//GEN-LAST:event_txtApellido_empleadoKeyReleased

    private void txtNombre_EmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_EmpleadoKeyTyped

        if(Character.isDigit(evt.getKeyChar()))
        evt.consume();

    }//GEN-LAST:event_txtNombre_EmpleadoKeyTyped

    private void txtNombre_EmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_EmpleadoKeyReleased

    }//GEN-LAST:event_txtNombre_EmpleadoKeyReleased

    private void txtNombre_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_EmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_EmpleadoActionPerformed

    private void txtId_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_empleadoKeyTyped
        if(!Character.isDigit(evt.getKeyChar())|| txtId_empleado.getText().length()==10)
        evt.consume();
    }//GEN-LAST:event_txtId_empleadoKeyTyped

    private void txtId_empleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_empleadoKeyReleased
        if(evt.getKeyChar()==KeyEvent.VK_B)
        {
            txtActual.setVisible(true);
            labell.setVisible(true);
            txtId_empleado.setBackground(Color.red);
            //////////////////////////////////////
            String sentenciaSQL="select *from empleado where id_empleado='"+txtId_empleado.getText()+"'";
            Metodos obj=new Metodos();
            ResultSet rs=obj.consultaDatos(estSQL1, sentenciaSQL);

            try{
                rs.next();
                txtNombre_Empleado.setText(String.valueOf(rs.getObject(2)));
                txtApellido_empleado.setText(String.valueOf(rs.getObject(3)));
                txtSueldo_empleado.setText(String.valueOf(rs.getObject(4)));
                txtActual.setText(String.valueOf(rs.getObject(5)));
                cmbId_farmacia.removeAllItems();
                cargarCombo();

            }
            catch(Exception E1)
            {
                JOptionPane.showMessageDialog(null,"El id seleccionado no existe");
                E1.printStackTrace();
            }

        }
    }//GEN-LAST:event_txtId_empleadoKeyReleased

    private void txtId_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_empleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMoficiar;
    private javax.swing.JComboBox cmbId_farmacia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labell;
    private javax.swing.JPanel panelEmpl;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtApellido_empleado;
    private javax.swing.JTextField txtId_empleado;
    private javax.swing.JTextField txtNombre_Empleado;
    private javax.swing.JTextField txtSueldo_empleado;
    // End of variables declaration//GEN-END:variables

    public void cargarCombo ()
{
    ResultSet rs;
 Metodos obj=new Metodos();
 rs=obj.consultaDatos(estSQL1,"SELECT distinct id_farmacia FROM farmacia");
 obj.procesarRSCombo(rs, cmbId_farmacia);
 
}
 public void limpiarTabla(JTable tabla)
    {
        while(tabla.getRowCount()>0)
        {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    }
 public void genClave()
    {
        Metodos sql=new Metodos();
        String cadeql="select max(id_empleado) from empleado";
        ResultSet rs=sql.consultarUltimoId(estSQL1,cadeql);
        Object valorO;
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                txtId_empleado.setText(Integer.parseInt(valorO.toString().trim())+1+"");
            }else
            {
                txtId_empleado.setText(444000+"");
            }
        }catch(Exception e)
        {    
        }   
    }
     public void limpiar()
    {
        txtId_empleado.setBackground(Color.white);
        txtNombre_Empleado.setText("");
        txtApellido_empleado.setText("");
        txtSueldo_empleado.setText("");
        txtActual.setText("");
        cmbId_farmacia.removeAllItems();
        cargarCombo();
        genClave();
    }
  public class ImagePanel extends JPanel 
    {
        public ImagePanel()
        {
            //Se crea un método cuyo parámetro debe ser un objeto Graphics
            this.setSize(810,669);
        }
    @Override
    public void paint(Graphics grafico)
    {
        Dimension height = getSize();
        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource("/Img/fondo1.jpg")); 
        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
    }
  public void editarCabecera()
    {
        JTableHeader th; 
        th = Table.getTableHeader(); 
        Font fuente = new Font("Consolas", Font.BOLD, 12); 
        th.setFont(fuente); 
    }
  public void insertImage()
    {
        ImagePanel Imagen = new ImagePanel();
        panelEmpl.add(Imagen);
        panelEmpl.repaint();
    }
  public void cerrar()
    {
        try
        {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter ()
            {
                public void windowClosing(WindowEvent e)
                {
                    dispose();
                }
            });        
        this.setVisible(true);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
