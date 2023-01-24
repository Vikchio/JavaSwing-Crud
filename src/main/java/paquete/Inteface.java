package paquete;
// @author vikchio

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Inteface extends javax.swing.JFrame
{
    
    String base = "jdbc:mysql://localhost/BDEmpleados";
    String usuario = "Pepe";
    String contraseña = "12345";
    Connection conexion;
    DefaultTableModel modelo = new DefaultTableModel();
    Statement ejecutor = null;
    
    protected void cargarBD()
    {
        modelo.addColumn("emp_no");
        modelo.addColumn("birth_date");
        modelo.addColumn("first_name");
        modelo.addColumn("last_name");
        modelo.addColumn("hire_date");
        modelo.setRowCount(0);
        String datos[] = new String[5];
        String query = "SELECT * FROM employees";
        ResultSet rs;
        try
        {
            ejecutor = conexion.createStatement();
            ejecutor.setQueryTimeout(20);
            rs = ejecutor.executeQuery(query);
            while (rs.next() == true)
            {
                datos[0] = rs.getString("emp_no");
                datos[1] = rs.getString("birth_date");
                datos[2] = rs.getString("first_name");
                datos[3] = rs.getString("last_name");
                datos[4] = rs.getString("hire_date");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void conectar()
    {
        conexion = null;
        try
        {
            conexion = DriverManager.getConnection(base, usuario, contraseña);
            if (conexion != null)
            {
                estadoCon.setText("Conectado");
            }
        }
        catch (SQLException ex)
        {
            estadoCon.setText("No Conectado");
        }
    }
    protected void buscarTabla(String fnacimiento,String prNombre,String apellido, String fcont){
        modelo.setRowCount(0);
        String datos[]=new String[5];
        String where=" where 1=1 ";
        //Si la fecha de nacimiento no esta vacio
        if(fnacimiento.isEmpty()==false){
            where=where+" and birth_date='"+fnacimiento+"' ";
        }
        //Si nombre no esta vacio
        if(prNombre.isEmpty()==false){
            where=where+" and first_name='"+prNombre+"' ";
        }
        //Si apellido no esta vacio
        if(apellido.isEmpty()==false){
            where=where+" and last_name='"+apellido+"' ";
        }
        //Si fecha contratracion no esta vacio
        if(fcont.isEmpty()==false){
            where=where+" and hire_date='"+fcont+"' ";
        }
        String query="select * from employees "+where+" ;";
        ResultSet rs;
        try {
            ejecutor=conexion.createStatement();
            ejecutor.setQueryTimeout(20);
            rs=ejecutor.executeQuery(query);
            while(rs.next()==true){
                datos[0] = rs.getString("emp_no");
                datos[1] = rs.getString("birth_date");
                datos[2] = rs.getString("first_name");
                datos[3] = rs.getString("last_name");
                datos[4] = rs.getString("hire_date");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);

        } catch (Exception e) {
        }
    }
    public Inteface()
    {
        initComponents();
        conectar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        estadoCon = new javax.swing.JLabel();
        llenarTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fnacimiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        fcont = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        llenarTabla.setText("Ver Datos");
        llenarTabla.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                llenarTablaActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "emp_no", "birth_date", "first_name", "last_name", "hire_date"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Fecha de nacimiento");

        jLabel2.setText("Nombre");

        prNombre.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                prNombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido");

        apellido.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                apellidoActionPerformed(evt);
            }
        });

        fcont.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fcontActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha contratacion");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(llenarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(estadoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fnacimiento)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fcont)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(llenarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estadoCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTablaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_llenarTablaActionPerformed
    {//GEN-HEADEREND:event_llenarTablaActionPerformed
        cargarBD();
    }//GEN-LAST:event_llenarTablaActionPerformed

    private void prNombreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_prNombreActionPerformed
    {//GEN-HEADEREND:event_prNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prNombreActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_apellidoActionPerformed
    {//GEN-HEADEREND:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void fcontActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fcontActionPerformed
    {//GEN-HEADEREND:event_fcontActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fcontActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        buscarTabla(fnacimiento.getText(),prNombre.getText(),apellido.getText(),fcont.getText());
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Inteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Inteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Inteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Inteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Inteface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JLabel estadoCon;
    private javax.swing.JTextField fcont;
    private javax.swing.JTextField fnacimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton llenarTabla;
    private javax.swing.JTextField prNombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
