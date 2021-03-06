package Proyecto2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class AgregarDemanda {

    public static void solicitarAgregarDemanda() {
        //Declaración de las variables
        Scanner sc = new Scanner(System.in);
        String nombreDemandante, nombreDemandado, direccionDemandado, montoPension = "", registro = "";

        //Solicitud de los datos basicos de la demanda
        System.out.println("");
        System.out.println("Nombre del demandante:");
        nombreDemandante = sc.nextLine();
        nombreDemandante = nombreDemandante.toUpperCase();

        System.out.println("Nombre del demandado:");
        nombreDemandado = sc.nextLine();
        nombreDemandado = nombreDemandado.toUpperCase();

        //Se valida de que no esté pre-inscrita la demanda
        if ( BuscarDemanda.buscarDemanda(nombreDemandante) == BuscarDemanda.buscarDemanda(nombreDemandado) ) {
            System.out.println("");
            System.out.println("La demanda ya está registrada en la base de datos");
            Menu.main(nombreDemandante.split("[a]"));
        } else {
            System.out.println("Direccion del demandado:");
            direccionDemandado = sc.nextLine();
            System.out.println("Monto de la pension:");
            montoPension = sc.nextLine();

            //Se quitan los simbolos especiales excepto punto
            montoPension = montoPension.replaceAll("[^0-9]", "");

            //Se agrega todo al registro
            registro = registro.concat(nombreDemandante).concat("|");
            registro = registro.concat(nombreDemandado).concat("|");
            registro = registro.concat(direccionDemandado).concat("|");
            registro = registro.concat(montoPension).concat("|");
            registro = registro.toUpperCase();//Todo se guarda en mayusculas para su fácil búsqueda
            agregarDemanda(registro);
        }
    }

    public static void agregarDemanda(String pRegistro) {
        try {
            FileWriter fw = new FileWriter("demandas.txt", true);
            fw.write(pRegistro);
            fw.write("\r\n");
            fw.close();
        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }
    }
}
