/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AETERNAM113
 */
public class FormattingInputs {
    public String completeInput(int input, int length){
        return this.fillLeft(input, length);
    }
    
    public String completeInput(String input, int length){
        return this.fillRight(input, length);
    }
    
    public String formatDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        return formatter.format(date).toUpperCase();
    }
    
    private String fillRight(String text, int length) {
        int currentLength = text.length();
        return currentLength < length ? String.format("%1$-" + length + "s",text) : text;
    }
    
    private String fillLeft(int text, int length) {
        //NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
        DecimalFormat formatoImporte = new DecimalFormat("##,###,###");
        int currentLength = String.valueOf(text).length();
        String cadena = String.valueOf(formatoImporte.format(text));
        return currentLength < length ? String.format("%1$" + length + "s",cadena) : cadena;
    }
}
