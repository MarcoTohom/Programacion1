package Proyecto3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Marco Antonio Lares Tohom
 */
public class AgregarEvento {
    static void AgregarEvento(int year, int month, int day, int hour, String artist, int numberOfPeople){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("eventos.bin", true));
            dos.write(year);
            dos.write(month);
            dos.write(day);
            dos.write(hour);
            dos.writeUTF(artist);
            dos.write(numberOfPeople);
            dos.close();
        } catch (FileNotFoundException fnfe) {
            
        } catch (IOException ioe) {
            
        }
    }
}
