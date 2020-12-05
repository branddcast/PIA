/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author AETERNAM113
 */
public class FormattingInputs {
    public String completeInput(double input, int length){
        return this.fill(String.valueOf(input), length);
    }
    
    public String completeInput(String input, int length){
        return this.fill(input, length);
    }
    
    private String fill(String text, int length) {
        int currentLength = text.length();
        return currentLength < length ? String.format("%1$-" + length + "s",text) : text;
    }
}
