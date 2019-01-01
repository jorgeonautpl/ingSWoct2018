package tareinformaticaiibim;

import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author JorgeOna
 */
public class TareInformaticaIIBim {
    //private static Object integer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
        // TODO code application logic here
     
        int diaNac, mesNac, anoNac, dia, diaEdad, mesEdad, anoEdad;
       
        do {
            
            String diaNacimiento = JOptionPane.showInputDialog(null, "ingrese el dia");
            diaNac=Integer.parseInt(diaNacimiento);
           
        }while (diaNac>31 || diaNac<1);
        do {
            String mesNacimiento = JOptionPane.showInputDialog(null, "ingrese el mes");
            mesNac=Integer.parseInt(mesNacimiento);
            
        } while (mesNac>12 || mesNac<1);
            String anoNacimiento = JOptionPane.showInputDialog(null, "ingrese el año");
            anoNac=Integer.parseInt(anoNacimiento);
        
       
        Calendar fecha= new GregorianCalendar();
        int diaActual = fecha.get (Calendar.DAY_OF_MONTH);
        int mesActual = fecha.get (Calendar.MONTH);
        int anoActual = fecha.get (Calendar.YEAR);
        
        //operaciones 
        if (diaActual<diaNac){
            diaActual=diaActual+30;
            mesActual=mesActual-1;
            diaEdad=diaActual-diaNac; 
        }else{
            diaEdad=diaActual-diaNac; 
        }
        if(mesActual<mesNac){
            mesActual=mesActual+12;
            anoActual=anoActual-1;
            mesEdad=mesActual-mesNac;
        }else {
            mesEdad=mesActual-mesNac;
        }
        anoEdad=anoActual-anoNac;
        Date fechaActual=new Date (); //System.out.println("siendo hoy: "+ fechaActual);
        
        System.out.println("Su edad es: " + anoEdad + " anos/ " + mesEdad + " meses/ " + diaEdad + " dias ");
        JOptionPane.showMessageDialog(null,"Su edad es: "+anoEdad+" anos/ " + mesEdad + " meses/ " + diaEdad + " dias ");
        aniadirArchivo(diaEdad, mesEdad, anoEdad); //asiganamos las variables
    }catch (Exception ex) {
            System.out.println("Ha habido un error " + ex.toString());
    }
    }
    
    public static void aniadirArchivo(int wdia, int wmes, int wanio) {
		FileWriter flwriter = null;
                File directorio = new File("C:\\TareaIngSoftware");//crea la carpeta del que contiene la tarea
                directorio.mkdir();//verifica si ya existe 
                
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
                        flwriter = new FileWriter("C:\\TareaIngSoftware\\persona.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
     		//escribe los datos en el archivo
                        
		bfwriter.write( "Edad exacta = " + wanio + " años " + wmes + " meses "+ wdia + " dias" +"\n");
		bfwriter.close();
		System.out.println("Archivo modificado satisfactoriamente..");
		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
