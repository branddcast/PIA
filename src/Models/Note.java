/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AETERNAM113
 */
public class Note extends Conexion {

    private int id;
    private String title;
    private String description;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public boolean save(Note note) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO "
                + " notes (title, description, created_at, updated_at) "
                + " VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getDescription());
            ps.setDate(3, note.getCreated_at());
            ps.setDate(4, note.getUpdated_at());

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

    public boolean update(Note note) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE notes SET "
                + " title = ?, description = ?, created_at = ?, updated_at = ? "
                + " WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getDescription());
            ps.setDate(3, note.getCreated_at());
            ps.setDate(4, note.getUpdated_at());
            ps.setInt(5, note.getId());
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

    public boolean delete(Note note) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM notes WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, note.getId());

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

    public Note find(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM notes WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Note note = new Note();
                note.setId(Integer.parseInt(rs.getString("id")));
                note.setTitle(rs.getString("title"));
                note.setDescription(rs.getString("description"));
                note.setCreated_at(rs.getDate("created_at"));
                note.setUpdated_at(rs.getDate("updated_at"));

                return note;
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

    public ArrayList<Note> select() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Note> notes = new ArrayList();

        String sql = "SELECT * FROM notes ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Note note = new Note();
                note.setId(Integer.parseInt(rs.getString("id")));
                note.setTitle(rs.getString("title"));
                note.setDescription(rs.getString("description"));
                note.setCreated_at(rs.getDate("created_at"));
                note.setUpdated_at(rs.getDate("updated_at"));
                notes.add(note);
            }

            return notes;

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
