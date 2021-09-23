
package com.mycompany.reto5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Cuenta {
    private int numero;
    private String nombre;
    private int numDoc;
    private double saldo;
    
    PreparedStatement ps;
    Conexion conn;
    Connection reg;
    ResultSet rs;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta() {
        conn = new Conexion();
        reg = conn.getConexion();
    }

    public Cuenta(int numero, String nombre, int numDoc, double saldo) {
        conn = new Conexion();
        reg = conn.getConexion();
        this.numero = numero;
        this.nombre = nombre;
        this.numDoc = numDoc;
        this.saldo = saldo;
    }
    
    public void Crear(){
          String sql= "insert into cuenta values('"+this.numero+"','"+this.nombre+"','"+this.numDoc+"','"+this.saldo+"')";
          try{
          ps= reg.prepareStatement(sql);
          ps.executeUpdate();
          if(ps!=null){
              System.out.println("Cuenta creada con éxito");
          }
          }catch(SQLException e){
              System.out.println("Error insertando datos"+e);  
          }
    }
    public void Eliminar(){
        String sql= "Delete from cuenta where numero= '"+this.numero+"' ";
          try{
          ps= reg.prepareStatement(sql);
          int v= ps.executeUpdate();
          if(v>0){
              System.out.println("Cuenta eliminada con éxito");
          }
          }catch(SQLException e){
              System.out.println("Error eliminando datos"+e);  
          }   
    }
    public void Actualizar(){
        String sql = "Update cuenta Set nombre='"+this.nombre+"',numDoc='"+this.numDoc+"',saldo='"+this.saldo+"' where numero= '"+this.numero+"' ";
         try{
            ps= reg.prepareStatement(sql);
            int v= ps.executeUpdate();
            if(v>0){
              System.out.println("Cuenta actualizada con éxito");
            }
          }catch(SQLException e){
              System.out.println("Error actualizando datos"+e);  
          }
    }
    public ResultSet Consultar(){
        String sql = "Select * from cuenta where numero= '"+this.numero+"' ";
        try{
          ps= reg.prepareStatement(sql);
          rs=ps.executeQuery();
        }catch(SQLException e){
              System.out.println("Error insertando datos"+e);  
          }
        return rs;
    } 
    
}
