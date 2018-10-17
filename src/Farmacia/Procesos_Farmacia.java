/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JL
 */
public class Procesos_Farmacia 
{
        
    public Statement conexion (String Usuario,String contraseña,String baseDatos,String Host)
    {
        Connection conn=null;
        Statement estSQL1=null;
        try
        {
            // cargar el driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://"+Host+";databaseName="+baseDatos;
            conn=DriverManager.getConnection(url,Usuario,contraseña);
            if(conn!=null)
            {
                System.out.println("La Conexion ha sido establecida");
                estSQL1=(Statement)conn.createStatement();
            }
            else
            {
                System.out.println("Conexion No Establecida");
                estSQL1= null;
            }
            
        }catch(ClassNotFoundException e)
        {
            System.out.println("ERROR al cargar la clase del driver\n");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error en la conexión","Mensaje Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null,"ERROR ","Mensaje Error",JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        return estSQL1;        
    }
    public ResultSet consultarUltimoId(Statement estSQL,String cadeql)
    {
        ResultSet rs=null;
        try
        {
            rs=estSQL.executeQuery(cadeql);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en la Sentencia ","Mensaje Error",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
        }
    return rs;    
    }
    public boolean ingresarDatos(Statement estSQL, String sent)
    {
        boolean sw=true;
        try
        {
            estSQL.execute(sent);
            sw=true;
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR...","Mensaje Error",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
             sw=false;
        }
    return sw;    
    }
    public ResultSet consultarDatos(Statement estSQL,String cadeql)
    {
        ResultSet rs=null;
        try
        {
            rs=estSQL.executeQuery(cadeql);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en la Sentencia ","Mensaje Error",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
        }
    return rs;    
    }
    public DefaultTableModel procesarRB(ResultSet result,DefaultTableModel model)
    {
        try
        {
            ResultSetMetaData metadatos=result.getMetaData(); //Se preparan los datos de la tabla de SQL
            int numColumnas=metadatos.getColumnCount();
            Object[] etiquetas=new Object[numColumnas];
            for(int i=0;i<numColumnas;i++)
            {
                etiquetas[i]=metadatos.getColumnLabel(i+1);
            }
            model.setColumnIdentifiers(etiquetas);
            while(result.next())
            {
                Object[]fila= new Object[numColumnas];
                for(int i=0;i<numColumnas;i++)
                {
                    fila[i]=result.getObject(i+1);
                    System.out.println(fila[i]);
                }
                model.addRow(fila);
                
            }
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "ERROR","Mensaje Error",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
        }
    return model;
   }
   public boolean actualizar(String id_farmaceutico,String id_farmacia,Statement stm)
   {
       boolean sw=true;
        try
        {
            stm.execute("update farmaceutico set id_farmacia='"+id_farmacia+"' where id_farmaceutico='"+id_farmaceutico+"'");            
            sw=true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "ERROR: No se Pudo Actualizar\nNo Tiene los permisos necesarios para esta acción...","Mensaje Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            sw=false;
        }
   return sw;    
   }
   public void buscarDatosCombo (ResultSet result,JComboBox combo)
   {
       try
       {
           ResultSetMetaData metadatos = result.getMetaData();
           int numColumnas=metadatos.getColumnCount();
           while(result.next())
           {
               for(int i=0;i<numColumnas;i++)
               {
                   combo.addItem(result.getObject(i+1));
               }
           }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "ERROR");
           e.printStackTrace();
       }
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
}
