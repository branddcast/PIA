/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author AETERNAM113
 */
public class Query extends Conexion{
    
    
    public ArrayList<Hashtable> select(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData md;
        Connection con = getConexion();
        ArrayList<Hashtable> data = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            md = rs.getMetaData();
            int columnas = md.getColumnCount();
            
            
            while (rs.next()) {
                Hashtable<String, String> dato = new Hashtable<String, String>();
                
                for (int i = 1; i <= columnas; i++) {    
                     //dato. = rs.getObject(i);
                     dato.put(md.getColumnName(i), rs.getString(i));
                     //System.out.println(rs.getString(i));
                }
                data.add(dato);
              
            }
            
            return data;

        }
        catch (SQLException e


            ) {
                System.err.println(e);
            return null;
        }


            finally{
                try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
