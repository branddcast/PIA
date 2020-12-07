/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pia;

import Config.Query;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.ReportFormat;
import java.io.IOException;

/**
 *
 * @author AETERNAM113
 */
public class PIA {

    /**
     * @param nuevoReporte
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void limpiar(ReportFormat nuevoReporte) {
        nuevoReporte.setDescripcion("");
        nuevoReporte.setAlmacenConsumo(0);
        nuevoReporte.setAlmacenImporte(0);
        nuevoReporte.setProdConsumo(0);
        nuevoReporte.setProdImporte(0);
        nuevoReporte.setDifConsumo(0);
        nuevoReporte.setDifImporte(0);
        nuevoReporte.setaFavorDe("");
        nuevoReporte.setPrecioUnitario(0);
    }

    public static void main(String[] args) throws SQLException, IOException {
        String planta = "P01"; // Recibe este valor como parámetro
        String tabla = "T04"; // Recibe este valor como parámetro
        String depto = "D00001"; // Recibe este valor como parámetro
        
        String nombrePlanta = "";
        
        File reporte = new File("reporte.txt");
        ReportFormat nuevoReporte = new ReportFormat(reporte);
        Query query = new Query();
        
        ArrayList<Hashtable> dataHeader = query.select("SELECT informacion FROM tablas WHERE claveTabla = \"T05\" AND llaveTabla = \""+(planta+depto)+"\"");
        
        ArrayList<Hashtable> queryList = query.select("SELECT \n"
                + "p.producto,\n"
                + "p.descripcion,\n"
                + "p.precioUnitario,\n"
                + "c.planta,\n"
                + "c.claveReporte,\n"
                + "c.departamento,\n"
                + "c.cantConsumo,\n"
                + "d.cantDevolucion,\n"
                + "t.informacion,\n"
                + "t.claveTabla\n"
                + "FROM productos AS p\n"
                + "INNER JOIN consumos AS c ON c.producto = p.producto\n"
                + "INNER JOIN devoluciones AS d ON d.producto = p.producto\n"
                + "INNER JOIN tablas AS t ON t.llaveTabla = c.planta\n"
                + "WHERE c.planta = \""+planta+"\" and c.departamento = \""+depto+"\""
                + "AND d.planta = \""+planta+"\" and d.departamento = \""+depto+"\"");

        for (int i = 0; i < queryList.size(); i++) {
            Hashtable data = queryList.get(i);

            nuevoReporte.setCodigo(data.get("producto").toString());
            nuevoReporte.setDescripcion(data.get("descripcion").toString());
            nuevoReporte.setAlmacenConsumo(34); //Falta definir estos valores
            nuevoReporte.setProdConsumo(54); //Falta definir estos valores
            nuevoReporte.setPrecioUnitario(Integer.parseInt(data.get("precioUnitario").toString()));
            
            nombrePlanta = data.get("informacion").toString();
            nuevoReporte.body();
            limpiar(nuevoReporte);
        }
        
        nuevoReporte.setNoPrograma(String.valueOf((int)(1000000*Math.random())));
        nuevoReporte.setPlanta(planta);
        nuevoReporte.setNombrePlanta(nombrePlanta);
        nuevoReporte.setHoja(String.valueOf((int)(10000 * Math.random())));
        nuevoReporte.setDepto(depto);
        nuevoReporte.setNombreDepto(dataHeader.get(0).get("informacion").toString());
        nuevoReporte.header();

        nuevoReporte.footer();
        
        nuevoReporte.makeReport();
    }

}
