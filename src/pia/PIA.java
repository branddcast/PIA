/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pia;

import Config.Query;
import java.sql.*;
import Controllers.NoteController;
import Controllers.ProductoController;
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
        File reporte = new File("reporte.txt");
        
        //Se crea un objeto de la clase ReportFormat para mandarle los datos que
        //llenarán el reporte. 
        
        ReportFormat nuevoReporte = new ReportFormat(reporte);
        
        nuevoReporte.setNoPrograma("000123");
        nuevoReporte.setPlanta("P01");
        nuevoReporte.setNombrePlanta("MITRAS NORTE. MONTERREY, NUEVO LEON");
        nuevoReporte.setHoja("1234");
        nuevoReporte.setDepto("D00023");
        nuevoReporte.setNombreDepto("JUGUETERIA");
        nuevoReporte.header();
        
        // PRODUCTO 1
        nuevoReporte.setCodigo("P00001");
        nuevoReporte.setDescripcion("Producto 1");
        nuevoReporte.setAlmacenConsumo(34);
        nuevoReporte.setProdConsumo(54);
        nuevoReporte.setPrecioUnitario(15);
        
        nuevoReporte.body();
        
        limpiar(nuevoReporte);
        
        // PRODUCTO 2
        nuevoReporte.setCodigo("P00002");
        nuevoReporte.setDescripcion("Producto 2");
        nuevoReporte.setAlmacenConsumo(45);
        nuevoReporte.setProdConsumo(22);
        nuevoReporte.setPrecioUnitario(25);
        
        nuevoReporte.body();
        
        limpiar(nuevoReporte);
        
        // PRODUCTO 2
        nuevoReporte.setCodigo("P00003");
        nuevoReporte.setDescripcion("Producto 3");
        nuevoReporte.setAlmacenConsumo(100);
        nuevoReporte.setProdConsumo(42);
        nuevoReporte.setPrecioUnitario(50);
        
        nuevoReporte.body();
        
        nuevoReporte.footer();
        
            //Notas
            /*NoteController note = new NoteController();
            note.edit(1);
            note.index();*/
            //ProductoController producto = new ProductoController();
            //producto.index();
            //producto.findProductoById(1);

        Query query = new Query();
        ArrayList<Hashtable> queryList = query.select("SELECT " + 
                " productos.id, productos.producto, consumos.claveReporte, consumos.planta "+ 
                " FROM consumos INNER JOIN " +
                " productos ON consumos.producto = productos.producto");

        //ArrayList<Hashtable> queryList = query.select("SELECT * FROM consumos");
        
        for(int i = 0; i < queryList.size(); i++){
            Hashtable data = queryList.get(i);
            System.out.println(data);
            /*System.out.print(data.get("id") + " ");
            System.out.print(data.get("producto") + " ");
            System.out.print(data.get("descripcion") + " ");
            System.out.print(data.get("precioUnitario") + " \n");*/
        }
    }
    
}
