/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pia;

import java.sql.*;
import Controllers.NoteController;
import Models.Note;

/**
 *
 * @author AETERNAM113
 */
public class PIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        NoteController note = new NoteController(new Note());
        note.edit(1);
        note.index();
    }
    
}
