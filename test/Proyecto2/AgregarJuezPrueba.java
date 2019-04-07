package Proyecto2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class AgregarJuezPrueba {
    public static void solicitarAgregarJuez(){
        Scanner sc = new Scanner (System.in);
        String numeroColegiadoJuez = "", registro = "";
        int linea=0;
        boolean agregar = false;
        linea=BuscarDemandaPrueba.buscarDemanda();
        if (linea==-1) {
            System.out.println("");
            System.out.println("No se encontró la demanda para asignarle juez");
        }else{
            System.out.println("");
            System.out.println("Ingrese el numero de colegiado del juez");
            numeroColegiadoJuez = sc.next();
            registro = registro.concat(String.valueOf(linea)).concat("|");
            registro = registro.concat(numeroColegiadoJuez).concat("|");
            AgregarJuezPrueba.agregarJuez(registro);
        }
    }
    public static void agregarJuez(String pRegistro){
        try{
            FileWriter fw = new FileWriter("jueces.txt",true);
            fw.write(pRegistro);
            fw.write("\r\n");
            fw.close();
        }catch(IOException ioe){
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }
    }
}
