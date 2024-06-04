package Utilerias;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
import paquete1.Profesor;
public class ProbandoArchivos {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Profesor profesores[] = {new Profesor("Ivan","Auxiliar")
                                ,new Profesor("David","Principal")
                                ,new Profesor("Augusto","Estrella")
                                ,new Profesor("Pablo","Principal")};
        Formatter flujoSalida = new Formatter("MiPrueba.txt"); //Flujo salida desde el programa hacia el archivo
        for(Profesor profeAux : profesores)
            flujoSalida.format("%s %s\n", profeAux.obtenerNombre(), profeAux.obtenerTipo());
        flujoSalida.close();
        Scanner flujoEntrada = new Scanner(new File("MiPrueba.txt")); //Flujo de entrada desde el archivia hacia el programa
        Profesor profesor1 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        Profesor profesor2 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        /*System.out.println(profesor1);
        System.out.println(profesor2);*/
        //Flujo de SALIDA basada en bytes, para escribir Objetos en Archivos
        ObjectOutputStream flujoSalida2 = new ObjectOutputStream(new FileOutputStream("Profes.prof"));
        flujoSalida2.writeObject(new Profes("Issac","Principal"));
        flujoSalida2.close();
        //Flujo de ENTRADA basada en bytes, para leer Objetos del Archivos
        ObjectInputStream flujoEntrada2 = new ObjectInputStream(new FileInputStream("Profes.prof"));
        System.out.println((Profes) flujoEntrada2.readObject());
    }
}

class Profes implements Serializable{
    private String nombre, tipo;
    public Profes(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Profes{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
}

