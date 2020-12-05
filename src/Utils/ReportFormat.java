/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AETERNAM113
 */
public class ReportFormat extends FormattingInputs{
    private String noPrograma;
    private String fecha;
    private String planta;
    private String nombrePlanta;
    private String hoja;
    private String depto;
    private String nombreDepto;
    private String codigo;
    private String descripcion;
    private double almacenConsumo;
    private double almacenImporte;
    private double prodConsumo;
    private double prodImporte;
    private double difConsumo;
    private double difImporte;
    private String aFavorDe;
    private double totalalmacen;
    private double totalAFavorAlmacen;
    private double totalProd;
    private double totalAFavorProd;
    
    PrintWriter out;
    FileWriter output;

    public ReportFormat(File file) throws IOException{
        this.openFile(file);
    }

    public ReportFormat(File file, String noPrograma, String fecha, String planta, String nombrePlanta, String hoja, String depto, String nombreDepto, String codigo, String descripcion, double almacenConsumo, double almacenImporte, double prodConsumo, double prodImporte, double difConsumo, double difImporte, String aFavorDe, double totalalmacen, double totalAFavorAlmacen, double totalProd, double totalAFavorProd) throws IOException {
        this.noPrograma = noPrograma;
        this.fecha = fecha;
        this.planta = planta;
        this.nombrePlanta = nombrePlanta;
        this.hoja = hoja;
        this.depto = depto;
        this.nombreDepto = nombreDepto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.almacenConsumo = almacenConsumo;
        this.almacenImporte = almacenImporte;
        this.prodConsumo = prodConsumo;
        this.prodImporte = prodImporte;
        this.difConsumo = difConsumo;
        this.difImporte = difImporte;
        this.aFavorDe = aFavorDe;
        this.totalalmacen = totalalmacen;
        this.totalAFavorAlmacen = totalAFavorAlmacen;
        this.totalProd = totalProd;
        this.totalAFavorProd = totalAFavorProd;
        
        this.openFile(file);
    }
    
    public String getNoPrograma() {
        return noPrograma;
    }

    public void setNoPrograma(String noPrograma) {
        this.noPrograma = noPrograma;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public String getHoja() {
        return hoja;
    }

    public void setHoja(String hoja) {
        this.hoja = hoja;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getAlmacenConsumo() {
        return almacenConsumo;
    }

    public void setAlmacenConsumo(double almacenConsumo) {
        this.almacenConsumo = almacenConsumo;
    }

    public double getAlmacenImporte() {
        return almacenImporte;
    }

    public void setAlmacenImporte(double almacenImporte) {
        this.almacenImporte = almacenImporte;
    }

    public double getProdConsumo() {
        return prodConsumo;
    }

    public void setProdConsumo(double prodConsumo) {
        this.prodConsumo = prodConsumo;
    }

    public double getProdImporte() {
        return prodImporte;
    }

    public void setProdImporte(double prodImporte) {
        this.prodImporte = prodImporte;
    }

    public double getDifConsumo() {
        return difConsumo;
    }

    public void setDifConsumo(double difConsumo) {
        this.difConsumo = difConsumo;
    }

    public double getDifImporte() {
        return difImporte;
    }

    public void setDifImporte(double difImporte) {
        this.difImporte = difImporte;
    }

    public String getaFavorDe() {
        return aFavorDe;
    }

    public void setaFavorDe(String aFavorDe) {
        this.aFavorDe = aFavorDe;
    }

    public double getTotalalmacen() {
        return totalalmacen;
    }

    public void setTotalalmacen(double totalalmacen) {
        this.totalalmacen = totalalmacen;
    }

    public double getTotalAFavorAlmacen() {
        return totalAFavorAlmacen;
    }

    public void setTotalAFavorAlmacen(double totalAFavorAlmacen) {
        this.totalAFavorAlmacen = totalAFavorAlmacen;
    }

    public double getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(double totalProd) {
        this.totalProd = totalProd;
    }

    public double getTotalAFavorProd() {
        return totalAFavorProd;
    }

    public void setTotalAFavorProd(double totalAFavorProd) {
        this.totalAFavorProd = totalAFavorProd;
    }
    
    private void openFile (File file) throws IOException {
        this.output = new FileWriter(file);
    }
    
    public void header() {
        try {
            String headerText = "\nP-" + completeInput(this.noPrograma, 6) + "\t\t\t" +
                    "R E P O R T E	C O M P A R A T I V O	D E	C O N S U M O S \t\t" +
                    "FECHA\t" + completeInput(this.fecha, 11) + "\n\n\n" +
                    "ACME - DIV. NOMINA CONTABILIDAD \tP L A N T A\t" + completeInput(this.planta, 3) +" \t" +
                    completeInput(this.nombrePlanta, 50) + "\t  " + "HOJA " + completeInput(this.hoja, 4) + "\n\n" +
                    "DEPTO. " + completeInput(this.depto, 6) + "\t" + completeInput(this.nombreDepto, 26) + "\n\n\n";
            this.output.write(headerText);
            
            this.output.close();
        } catch (IOException ex) {
            Logger.getLogger(ReportFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void body() {
        //Crea el cuerpo del reporte para listar los productos
    }
    
    public void footer() {
        //Crea el pie del reporte
    }
}
