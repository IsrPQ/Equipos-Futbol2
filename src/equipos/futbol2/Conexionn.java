/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipos.futbol2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
/**
 *
 * @author Israel
 */
public class Conexionn {
    
    //private final String base = "sis2";
    private final String user = "myik06uzx9r09u45fd1g";
    private final String password = "pscale_pw_PqBgeSjM5uh0q1ucCXYPtOZZigTi2VoK4sNRDK3SRPG";
    private final String url = "jdbc:mysql://aws-sa-east-1.connect.psdb.cloud/equipo";
    private Connection con = null;
    
    public Connection getConexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
        }catch(SQLException e){
            System.err.println(e);
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return con;
        }
    }

/*
private  Connection miCon;
    public Conexion() {
        this.setContentPane(ima);
         try{
           //1. CREAR OBJETO CONNECTION 
            miCon = DriverManager.getConnection(
                     "jdbc:mysql://aws-sa-east-1.connect.psdb.cloud/equipo",
                     "myik06uzx9r09u45fd1g",
                     "pscale_pw_PqBgeSjM5uh0q1ucCXYPtOZZigTi2VoK4sNRDK3SRPG");

         }catch(Exception e){
           System.out.println(e.toString());
         }
        initComponents();
    }



        */