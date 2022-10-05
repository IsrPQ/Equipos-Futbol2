/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package equipos.futbol2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EquiposFutbol2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Connection con = null;
        //String user = "root";
        //String user = "jesux28";
        //String password = "2812ale";
        //String password = "";
        //String url="jdbc:mysql://localhost:3306/liga";
        //String url="jdbc:postgresql://192.168.100.11:5432/EQUIPO";
        
        try {
            con = DriverManager.getConnection("jdbc:postgresql://192.168.100.11:5432/EQUIPO","jesux28","2812ale");
            //con = DriverManager.getConnection(url,user,password);
            
            //2. CREAR OBJETO STATEMENT
            Statement miStatement = (Statement) con.createStatement();
            //3. EJECUTAR SQL// Nos devuelve el resultado de la Consulta
            String consulta = "SELECT ID_EQUIPO,NOMBRE_EQUIPO FROM equipofutbol;";
            ResultSet miResultSet = miStatement.executeQuery(consulta);
            //4. RECORRER EL RESULT SET, el RS es una tabla en memoria Virtual

            while(miResultSet.next()){ //Con el metodo next podemos avanzar registro
                System.out.println(miResultSet.getInt("ID_EQUIPO")+miResultSet.getString("NOMBRE_EQUIPO"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /*
    private  Connection miCon;
    Imagen_Fondo ima = new Imagen_Fondo();
    public CONEXIONBS() {
        this.setContentPane(ima);
        initComponents();
        try{
           //1. CREAR OBJETO CONNECTION 
            miCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/REPV2","jesux28","2812ale");
         }catch(Exception e){
           System.out.println(e.toString());
         }
    }
    */
   
    
}
