package Utilerias;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ProbandoFilesBytes {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Estudiante estudiantes[] = {new Estudiante("Edy",10,5), new Estudiante("Fabian",7,8)};
        Estudiante arregloEst[] = new Estudiante[10000];
        for (int i = 0; i < 10000; i++) {
            Estudiante estX = new Estudiante("Estudiante"+(i+1), ((int) (Math.random()*10)+1), ((int) (Math.random()*10)+1));
            arregloEst[i] = estX;
        }
        //Flujo basado en Bytes para SALIDA desde el programa, hacia el archivo
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("byes.bit"));
        for (int i = 0; i < 10000; i++) 
            salida.writeObject(arregloEst[i]);
        salida.close();
        //Flujo basado en Bytes para ENTRADA desde el archivo, hacia el programa
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("byes.bit")); 
        for (int i = 0; i < 10000; i++) 
            System.out.println((Estudiante) entrada.readObject());
    }
}
class Estudiante implements Serializable{
    private String nombre;
    private double nota1, nota2;
    public Estudiante(String nombre, double nota1, double nota2) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + '}';
    }
    
}
