/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Note;
import java.util.ArrayList;

/**
 *
 * @author AETERNAM113
 */
public class NoteController{
    private Note note;

    public NoteController(Note note) {
        this.note = note;
    }
    
    public void index () {
        ArrayList<Note> notesList = this.note.select();
        
        for(int i = 0; i < notesList.size(); i++){
            System.out.println(notesList.get(i).getTitle());
        }
    }
    
    public void findNoteById(int id){
        this.note = note.find(id);
        System.out.println(this.note.getTitle()); 
    }
    
    public void edit(int id){
        this.note = note.find(id);
        this.note.setTitle("Nuevo Titulo 2");
        boolean saved = note.update(this.note);
        
        System.out.println(saved);
    }
    
}
