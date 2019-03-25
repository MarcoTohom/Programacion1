package Proyecto1;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Inciso1 {

    public static void main(String[] args) {
        //Declaración de variables
        String entrada = "", aux = "aux", vectorEntrada[];
        Scanner escaner = new Scanner(System.in);
        //Ciclo de petición de números
        do {
            System.out.print("Ingrese un número:");
            aux = escaner.next();
            if (!("z".equalsIgnoreCase(aux))) {
                aux = aux.replaceAll("[^0-9]", "");
                if (!("".equalsIgnoreCase(aux))) {
                    entrada = entrada.concat(aux).concat("@");
                }
            }
        } while (!("z".equalsIgnoreCase(aux)));
        //Conversión de la variable String "entrada" a un vector del mismo tipo "vectorEntrada"
        vectorEntrada = entrada.split("[^0-9]");
        //Mensajes primarios en relación a si no se ingresaron números o sólo se ingresó uno.
        if (entrada.isEmpty()) {
            System.out.println("No se ingresaron números.");
        } else {
            calcular(vectorEntrada);
        }
    }

    public static void calcular(String[] str) {
        //Se declaran los vectores con el tamaño del vector recibido
        int tamano = str.length;
        Integer[] numeros = new Integer[tamano], valores = new Integer[tamano], contador = new Integer[tamano];
        Integer mayor = 0, menor = 9999999, posicionMayor = 0, posicionMenor = 0;
        //Se inicializan los vectores. numeros con los valores convertidos del Strign recibido, valores con null y contador con ceros
        for (int i = 0; i < tamano; i++) {
            numeros[i] = Integer.valueOf(str[i]);
            valores[i] = null;
            contador[i] = 0;
        }
        //Se cargan los valores no repetidos del vector numeros al vector valores
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (Objects.equals(valores[j], numeros[i])) {
                    contador[j]++;
                    j = tamano;
                } else {
                    if (valores[j] == null) {
                        valores[j] = numeros[i];
                        contador[j]++;
                        j = tamano;
                    }
                }
            }
        }
        /*
        Se busca en el vector contador cuál es el que se ha repetido más veces y cuál es el que se ha repetido menos veces
        Para ello se inicializó menor con un número muy grande y menor con cero. Así, cuando contador[i] sea menor a "menor"
        cambiará su valor al de contador[i] y se guarda la posición en posicionMenor. De igual manera con el mayor.
         */
        for (int i = 0; i < tamano; i++) {
            if (contador[i] != 0) {
                if (contador[i] < menor) {
                    menor = contador[i];
                    posicionMenor = i;
                }
                if (contador[i] > mayor) {
                    mayor = contador[i];
                    posicionMayor = i;
                }
            }
        }
        /* DESCOMENTARIZAR PARA VER EXPRESAMENTE LA POSICIÓN DE LAS POSICIONES EN LAS QUE ESTÁN LOS VALORES DE EL QUE MÁS SE
        REPITE Y DEL QUE MENOS SE REPITE
        System.out.println("posicion mayor:" + posicionMayor);
        System.out.println("posicion menor:" + posicionMenor);
         */
        System.out.println("El numero que mas veces se repitió fue el " + valores[posicionMayor] + " apareciendo " + contador[posicionMayor] + " veces");
        System.out.println("El numero que menos veces se repitió fue el " + valores[posicionMenor] + " apareciendo " + contador[posicionMenor] + " veces");
        /*
        DESCOMENTARIZAR PARA VER LAS TABLAS DE LOS VALORES DE LOS VECTORES numeros[], valores[] y contador[]
        for (int i = 0; i < tamano; i++) {
            System.out.println("Numero ingresado: " + numeros[i] + "\tValor: " + valores[i] + "\tContador: " + contador[i]);
        }
         */
    }
}
