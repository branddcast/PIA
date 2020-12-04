/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pia;

import java.sql.*;
import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *
 * @author AETERNAM113
 */
public class Conexion {
    private Connection conexion = null;
    
    Conexion(String database, String username, String password) throws SQLException{
        this.conexion = DriverManager
                .getConnection("jdbc:mysql://localhost/" 
                + database , username, password);
    }
    
    public ResultSet query (String sql) throws SQLException {
        Statement s;
        s = conexion.createStatement();
        ResultSet rs = s.executeQuery (sql);
        return rs;
    }
    
    public void close () throws SQLException {
        conexion.close();
    }
}
