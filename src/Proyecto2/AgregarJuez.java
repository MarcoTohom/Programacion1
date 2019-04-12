package Proyecto2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class AgregarJuez {

    public static void solicitarAgregarJuez() {
        Scanner sc = new Scanner(System.in);
        String numeroColegiadoJuez = "", registro = "";
        int lineaDemanda = 0, lineaJuez = 0;

        lineaDemanda = BuscarDemanda.solicitarBuscarDemanda();
        if (lineaDemanda != -1) {
            
            lineaJuez = BuscarDemanda.buscarJuez(lineaDemanda);

            if (lineaJuez != -1) {
                System.out.println("");
                System.out.println("Ingrese el numero de colegiado del juez");
                numeroColegiadoJuez = sc.next();
                numeroColegiadoJuez = numeroColegiadoJuez.replaceAll("[^0-9]", "");
                registro = registro.concat(String.valueOf(lineaDemanda)).concat("|");
                registro = registro.concat(numeroColegiadoJuez).concat("|");
                AgregarJuez.agregarJuez(registro);
            } else {
                System.out.println("");
                System.out.println("El juez ya se encuentra asignado.");
            }
        }
    }

    public static void agregarJuez(String pRegistro) {
        try {
            FileWriter fw = new FileWriter("jueces.txt", true);
            fw.write(pRegistro);
            fw.write("\r\n");
            fw.close();
        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }
    }
}
