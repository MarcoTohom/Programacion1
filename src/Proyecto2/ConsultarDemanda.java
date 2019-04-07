package Proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class ConsultarDemanda {
    
    public static void solicitarBusqueda(){
        Scanner sc=new Scanner (System.in);
        String terminoDeBusqueda;
        int tipoBusqueda=0;
        try{
            do {
                System.out.println("Escoja un tipo de búsqueda a buscar:");
                System.out.println("1 Demandante.");
                System.out.println("2 Demandado.");
                System.out.println("3 Juez.");
                System.out.println("4 Volver al menú principal");
                tipoBusqueda=sc.nextInt();
                System.out.println("Ingrese la palabra que desea buscar");
                terminoDeBusqueda=sc.next();
                if (tipoBusqueda>0&&tipoBusqueda<4) {
                    ConsultarDemanda.busqueda(terminoDeBusqueda, tipoBusqueda);
                }else{
                    tipoBusqueda=0;
                }
            } while (tipoBusqueda==0);
            
        }catch(InputMismatchException ime){
            System.out.println("Se ha ingresado un valor erróneo.");
        }
    }

    public static void busqueda(String pTerminoDeBusqueda, int pTipoDeBusqueda) {
        String registro="", archivo="";
        int numeroLinea = 0;
        try {
            
            switch(pTipoDeBusqueda){
                case 1:
                    archivo="demandas.txt";
                    break;
                case 2:
                    archivo="demandas.txt";
                    break;
                case 3:
                    archivo="juez.txt";
            }
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            
            if ("juez.txt".equals(archivo)) {
                while ((registro = br.readLine()) !=null){
                    numeroLinea++;
                    if (registro.contains(pTerminoDeBusqueda)) {
                        String[] campos=registro.split("[|]");
                        System.out.println("Numero de expediente: "+campos[0]);
                        System.out.println("Numero de colegiado de juez: "+campos[1]);
                    }
                }
            }
            while ((registro = br.readLine()) != null) {
                numeroLinea++;
                if (registro.contains(pTerminoDeBusqueda)) {
                    String[] campos=registro.split("[|]");
                    System.out.println("Nombre demandante: "+campos[0]);
                    System.out.println("Nombre demandado: "+campos[1]);
                    System.out.println("Direccion demandado: "+campos[2]);
                    System.out.println("Monto pension: "+campos[3]);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encontró la base de datos");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }
    }
}
