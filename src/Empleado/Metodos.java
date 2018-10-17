/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado;

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
 * @author FRANCISCO
 */
public class Metodos {
    
     public Statement coneccionDB(String Usuario,String contraseña,String baseDatos,String Host)
    {
        Statement estSQL1=null;
        Connection conn=null;
        estSQL1=null;
       
        try
        {
            // cargar el driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://"+Host+";databaseName="+baseDatos;
            conn=DriverManager.getConnection(url,Usuario,contraseña);
            if(conn!=null)
            {
                System.out.println("Coneccion establecida :D");
                estSQL1=(Statement)conn.createStatement();
            }
            else
            {
                 System.out.println("Coneccion establecida :D");
            }
            
        }catch(ClassNotFoundException e)
        {
            System.out.println("ERROR al cargar la clase del driver\n");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
             System.out.println("Error en la coneccion");
             e.printStackTrace();
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null,"ERROR .i.");
            e1.printStackTrace();
        }
        return estSQL1;
    }
    
   public boolean ingresarDatos(Statement estSQL1, String sent)
    {
        try
        {
            estSQL1.execute(sent); 
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR...", "Mesaje Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
   
 
    public DefaultTableModel ConsultaTabla(ResultSet result, DefaultTableModel modelo) throws SQLException{
        ResultSetMetaData metaDatos=result.getMetaData();
        
       int numeroColumnas=metaDatos.getColumnCount();
      Object[] etiquetas= new Object[numeroColumnas];
      
            for(int i=0;i<numeroColumnas;i++){
         etiquetas[i]=metaDatos.getColumnLabel(i+1);
            }
        modelo.setColumnIdentifiers(etiquetas);
        while(result.next()){
        Object[] fila=new Object[numeroColumnas];
            for(int i=0;i<numeroColumnas;i++){
           fila[i]=result.getObject(i+1);
            
            }
           modelo.addRow(fila);
        }
       return modelo; 
    }
    
   public ResultSet consultaDatos(Statement estSQL,String cadsql)
   {
       ResultSet rs=null;
       try
       {
           rs=estSQL.executeQuery(cadsql);
       }
       catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, "Error");
           e.printStackTrace();
       }
       return rs;
   }
    
    public void procesarRSCombo(ResultSet resul,JComboBox cmbId_farmacia)
    {
        try
        {
            ResultSetMetaData metaDatos=resul.getMetaData();
            int numeroColumnas=metaDatos.getColumnCount();
                
            
               while(resul.next())
               {
                   Object []fila=new Object[numeroColumnas];
                   for(int i=0;i<numeroColumnas;i++)
                   {
                       //para cargar combobox
                      cmbId_farmacia.addItem(resul.getObject(i+1));
                              System.out.println(fila[i]);
                   }
                
               }
                      
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"    Error de sentencia sql");
            e.printStackTrace();
        }
       
    }
    
    //METODO PARA CARGAR

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

