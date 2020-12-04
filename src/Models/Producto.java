/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AETERNAM113
 */
public class Producto extends Conexion{
    private int id;
    private String producto;
    private String descripcion;
    private int precioUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public boolean save(Producto producto) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO "
                + " productos (producto, descripcion, precioUnitario) "
                + " VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecioUnitario());

            return (boolean) ps.execute();

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean update(Producto producto) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE productos SET "
                + " producto = ?, descripcion = ?, precioUnitario = ? "
                + " WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecioUnitario());
            ps.setInt(5, producto.getId());
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean delete(Producto producto) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM productos WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getId());

            return (boolean) ps.execute();

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public Producto find(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM productos WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(rs.getString("id")));
                producto.setProducto(rs.getString("producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(Integer.parseInt(rs.getString("precioUnitario")));

                return producto;
            }

            return null;

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<Producto> select() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Producto> productos = new ArrayList();

        String sql = "SELECT * FROM productos ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(rs.getString("id")));
                producto.setProducto(rs.getString("producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(Integer.parseInt(rs.getString("precioUnitario")));
                
                productos.add(producto);
            }
            
            return productos;

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