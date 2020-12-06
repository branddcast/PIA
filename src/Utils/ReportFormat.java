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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AETERNAM113
 */
public class ReportFormat extends FormattingInputs{
    private String noPrograma = "000000";
    private final String fecha = formatDate(new Date(Calendar.getInstance().getTimeInMillis()));
    private String planta = "000";
    private String nombrePlanta = "";
    private String hoja = "0000";
    private String depto = "000000";
    private String nombreDepto = "";
    private String codigo = "000000";
    private String descripcion = "";
    private int almacenConsumo = 0;
    private int almacenImporte = 0;
    private int prodConsumo = 0;
    private int prodImporte = 0;
    private int difConsumo = 0;
    private int difImporte = 0;
    private String aFavorDe = "";
    private int totalalmacen = 0;
    private int totalAFavorAlmacen = 0;
    private int totalProd = 0;
    private int totalAFavorProd = 0;
    private int precioUnitario = 0;
    private int totalAlmacenImporte = 0;
    private int totalProdImporte = 0;
    
    PrintWriter out;
    FileWriter output;

    public ReportFormat(File file) throws IOException{
        this.openFile(file);
    }

    public String getNoPrograma() {
        return noPrograma;
    }

    public void setNoPrograma(String noPrograma) {
        this.noPrograma = noPrograma;
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

    public int getAlmacenConsumo() {
        return almacenConsumo;
    }

    public void setAlmacenConsumo(int almacenConsumo) {
        this.almacenConsumo = almacenConsumo;
    }

    public int getAlmacenImporte() {
        return almacenImporte;
    }

    public void setAlmacenImporte(int almacenImporte) {
        this.almacenImporte = almacenImporte;
    }

    public int getProdConsumo() {
        return prodConsumo;
    }

    public void setProdConsumo(int prodConsumo) {
        this.prodConsumo = prodConsumo;
    }

    public int getProdImporte() {
        return prodImporte;
    }

    public void setProdImporte(int prodImporte) {
        this.prodImporte = prodImporte;
    }

    public int getDifConsumo() {
        return difConsumo;
    }

    public void setDifConsumo(int difConsumo) {
        this.difConsumo = difConsumo;
    }

    public int getDifImporte() {
        return difImporte;
    }

    public void setDifImporte(int difImporte) {
        this.difImporte = difImporte;
    }

    public String getaFavorDe() {
        return aFavorDe;
    }

    public void setaFavorDe(String aFavorDe) {
        this.aFavorDe = aFavorDe;
    }

    public int getTotalalmacen() {
        return totalalmacen;
    }

    public void setTotalalmacen(int totalalmacen) {
        this.totalalmacen = totalalmacen;
    }

    public int getTotalAFavorAlmacen() {
        return totalAFavorAlmacen;
    }

    public void setTotalAFavorAlmacen(int totalAFavorAlmacen) {
        this.totalAFavorAlmacen = totalAFavorAlmacen;
    }

    public int getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(int totalProd) {
        this.totalProd = totalProd;
    }

    public int getTotalAFavorProd() {
        return totalAFavorProd;
    }

    public void setTotalAFavorProd(int totalAFavorProd) {
        this.totalAFavorProd = totalAFavorProd;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getTotalAlmacenImporte() {
        return totalAlmacenImporte;
    }

    public void setTotalAlmacenImporte(int totalAlmacenImporte) {
        this.totalAlmacenImporte = totalAlmacenImporte;
    }

    public int getTotalProdImporte() {
        return totalProdImporte;
    }

    public void setTotalProdImporte(int totalProdImporte) {
        this.totalProdImporte = totalProdImporte;
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
                    "DEPTO. " + completeInput(this.depto, 6) + "\t" + completeInput(this.nombreDepto, 26) + "\n\n\n" +
                    "\tPRODUCTO\t\t     REPORTE ALMACEN\t\t REPORTE PRODUCCION\t\t  DIFERENCIA ENTRE REPORTES\n\n" +
                    "CODIGO      DESCRIPCION\t\t  CONSUMO\tIMPORTE \tCONSUMO       IMPORTE\t     CONSUMO\t   IMPORTE   \tA FAVOR DE\n" +
                    "------\t---------------------\t-----------   -----------     -----------   -----------    -----------   -----------   ------------\n";
            this.output.write(headerText);
        } catch (IOException ex) {
            Logger.getLogger(ReportFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void body() {
        
        this.almacenImporte = this.almacenConsumo * this.precioUnitario;
        this.totalAlmacenImporte += this.almacenImporte;
        this.prodImporte = this.prodConsumo * this.precioUnitario;
        this.totalProdImporte += this.prodImporte;
        this.difConsumo = Math.abs(this.almacenConsumo - this.prodConsumo);
        this.difImporte = this.difConsumo * this.precioUnitario;
        
        if( this.almacenConsumo > this.prodConsumo ){
            this.aFavorDe = "ALMACEN";
            this.totalAFavorAlmacen += this.difImporte;
        }else if( this.almacenConsumo < this.prodConsumo ){
            this.aFavorDe = "PRODUCCION";
            this.totalAFavorProd += this.difImporte;
        }else
            this.aFavorDe = "";
        
        try {
            String bodyText = completeInput(this.codigo, 6) + "\t" + completeInput(this.descripcion, 21) + "\t" + completeInput(this.almacenConsumo, 11) + "   " + completeInput(this.almacenImporte, 11) +
                    "     " + completeInput(this.prodConsumo, 11) + "   " + completeInput(this.prodImporte, 11) + "    " + completeInput(this.difConsumo, 11) + "   " +
                    completeInput(this.difImporte, 11) + "   " + completeInput(this.aFavorDe, 12) + "\n";
            this.output.write(bodyText);
            
        } catch (IOException ex) {
            Logger.getLogger(ReportFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void footer() {
        
        
        
        try {
            String footerText = "\n\n\nTOTAL DEL DEPTO.\t" + completeInput(this.depto, 6) + "\t" + completeInput(this.nombreDepto, 26) + "\n\n\n" +
                    "ALMACEN \tIMPORTE     " + completeInput(this.totalAlmacenImporte, 12) + "     DIFERENCIA A FAVOR     " + completeInput(this.totalAFavorAlmacen, 11) + "\n\n" +
                    "PRODUCCION \tIMPORTE     " + completeInput(this.totalProdImporte, 12) + "     DIFERENCIA A FAVOR     " + completeInput(this.totalAFavorProd, 11) +
                    "\n\n";
            this.output.write(footerText);
            this.output.close();
        } catch (IOException ex) {
            Logger.getLogger(ReportFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
