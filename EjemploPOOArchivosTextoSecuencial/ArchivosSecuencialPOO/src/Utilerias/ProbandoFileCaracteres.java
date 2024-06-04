package Utilerias;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
public class ProbandoFileCaracteres {
    public static void main(String[] args) throws FileNotFoundException {
        Formatter salida = new Formatter("User.csv"); //Flujo de salida desde el .java hacia el archivo
        for (int i = 0; i < 10000; i++) 
            salida.format("%s%d;%d;%d\n", "Estudiante",(i+1), ((int) (Math.random()*10)+1), ((int) (Math.random()*10)+1) );
        salida.close();
        Formatter salidaNotas = new Formatter("Promedios.csv");
        Scanner entrada = new Scanner(new File("User.csv"));//Fluo de entrada desde el archivo hacia el progrma
        for (int i = 0; i < 10000; i++) {
            String linea = entrada.nextLine();
            String datos[] = linea.split(";");
            double nota1 = Double.parseDouble(datos[1]); 
            double nota2 = Double.parseDouble(datos[2]); 
            System.out.println(datos[0]+" "+nota1+" "+nota2);
            salidaNotas.format("%s;%.2f;%.2f;%.2f\n",datos[0],nota1,nota2,((nota1+nota2)/2));
        }
        entrada.close();
        salidaNotas.close();
    }
}
