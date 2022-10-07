/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package equipos.futbol2;

import Vistas.vistaRegistroEquipos;
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
        
        new vistaRegistroEquipos().setVisible(true);
    }
   
    
}
