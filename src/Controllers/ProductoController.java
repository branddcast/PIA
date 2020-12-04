/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Producto;
import java.util.ArrayList;

/**
 *
 * @author AETERNAM113
 */
public class ProductoController {
    private Producto producto;

    public ProductoController() {
        this.producto = new Producto();
    }
    
    public void index () {
        ArrayList<Producto> notesList = this.producto.select();
        
        for(int i = 0; i < notesList.size(); i++){
            System.out.println(notesList.get(i).getProducto());
        }
    }
    
    public void findProductoById(int id){
        this.producto = producto.find(id);
        System.out.println(this.producto.getProducto()); 
    }
    
}
