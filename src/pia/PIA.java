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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author AETERNAM113
 */
public class PIA {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        /*NoteController note = new NoteController();
        note.edit(1);
        note.index();*/
        //ProductoController producto = new ProductoController();
        //producto.index();
        //producto.findProductoById(1);
        
        Query query = new Query();
        ArrayList<Hashtable> queryList = query.select("SELECT * FROM consumos");
        
        for(int i = 0; i < queryList.size(); i++){
            Hashtable data = queryList.get(i);
            System.out.print(data.get("id") + " ");
            System.out.print(data.get("producto") + " ");
            System.out.print(data.get("descripcion") + " ");
            System.out.print(data.get("precioUnitario") + " \n");
        }
    }
    
}
