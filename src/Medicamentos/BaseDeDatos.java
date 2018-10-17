/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicamentos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class BaseDeDatos {

     public Statement ConectionDB(String strUsuario, String strPassword, String strBaseDatos, String strHost)
    {
     Connection conn=null;
     Statement estSQL1=null;
     
     try
     {
      //Cargar Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://"+strHost+";databaseName="+strBaseDatos;
        conn=DriverManager.getConnection(url,strUsuario,strPassword);
        if(conn!=null)
        {
            System.out.println("Conexion establecida");
            estSQL1=(Statement) conn.createStatement();
        }
        else
        {
            System.out.println("Conexion establecida");
             estSQL1=null;
        }
     }
     catch(ClassNotFoundException e){
         System.out.println("ERROR: Error al cargar la clase del Driver\n");
         e.printStackTrace();
     }
     catch(SQLException e){
          JOptionPane.showMessageDialog(null, "ERROR en la Conexion");
          e.printStackTrace();
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, "ERROR..........");
          e.printStackTrace();
     }
     
     return estSQL1;
    }
     
    public ResultSet Cargar(Statement estSQL, String cadeql){
        
        ResultSet rs=null;
         try
     {
      rs=estSQL.executeQuery(cadeql);
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error en la sentencia", "Mesaje Error", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }
        return rs;
        
    }
     
     public boolean Ingresar_Datos(Statement estSQL, String sentencia){
        try{
            estSQL.execute(sentencia);
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR...", "Mesaje Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    return true;    
    }
     
     public boolean transacciones(Statement estSQL, String sentencia){
        try{
            estSQL.execute(sentencia);
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    return true;    
    }
     
     public ResultSet ConsultaDatos(Statement estSQL, String cadsql)
    {
        ResultSet rs=null;
        try{
            rs=estSQL.executeQuery(cadsql);
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error en la sentencia");
            e.printStackTrace();
        }
       
        return rs;
    }
    
    public DefaultTableModel procesarRS(ResultSet resul, DefaultTableModel modelo){
        try{
            ResultSetMetaData metaDatos=resul.getMetaData();
            int numeroColumnas=metaDatos.getColumnCount();
            Object[] etiquetas=new Object[numeroColumnas];
            
            for(int i=0; i<numeroColumnas;i++){
                etiquetas[i]=metaDatos.getColumnLabel(i+1);
            }
            modelo.setColumnIdentifiers(etiquetas);
            while(resul.next())
            {
                Object[] fila=new Object[numeroColumnas];
                for(int i=0; i<numeroColumnas; i++)
                {
                    fila[i]=resul.getObject(i+1);
                    System.out.println(fila[i]);
                }
                
              modelo.addRow(fila);
            }
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error en la sentencia");
            e.printStackTrace();
        }
     return modelo;   
    }
}
