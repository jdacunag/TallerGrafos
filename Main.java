
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        //pedir la cantidad de paises con los colores
        Scanner scan = new Scanner(System.in);
        System.out.println("¡¡Teorema de los cuatro colores!!");
        System.out.println();
        System.out.println("Con cuantos paises va a trabajar: ");
        int NumPaises = scan.nextInt();

      //usaremos la matriz de adyacencia del grafo, para asi leer que paises son adyacentes entre si
        int[][] matrizGrafo = new int[NumPaises][NumPaises];
        for(int i = 0; i < NumPaises; i++){
            for(int j = 0; j < NumPaises; j++){
                if(i == j){
                  matrizGrafo[i][j] = 0;
                } 
                else{
                  System.out.println("Oprima 1 si el pais " + (i + 1) + " es adyacente con el pais " + (j + 1) + ", sino oprima 0...");
                  Scanner scan2 = new Scanner(System.in);
                  matrizGrafo[i][j] = scan2.nextInt();
                }
            }
        }

        //poner los colores que vamos a utilizar
        String coloresPaises[] = {"Amarillo", "Azul", "Morado", "Verde"};
        int[] paisCol = new int[NumPaises];
      
        for(int i = 0; i < NumPaises; i++){
          paisCol[i] = i + 1;
        }

        //asignaremos colores, usando el teorema de los 4 colores a cada pais
        int[] color = new int[NumPaises];
        for(int i = 0; i < NumPaises; i++){
          color[i] = 0;
        }
        int otro = 0;
            for (int i = 0; i < NumPaises; i++){
            otro = color[i] + 1;
            color[i] = otro;
            for(int j = 0; j < NumPaises; j++){
                if(matrizGrafo[i][j] == 1 && color[j] == otro){
                  otro = otro + 1;
                  color[i] = otro;
                  j = -1;
                }
            }
        }
        //imprimir en pantalla que color tendria cada pais segun el grafo con la matriz de adyacencia
        for(int i = 0; i < NumPaises; i++){
         System.out.println("Pais " + (i + 1) + " seria de color " + coloresPaises[color[i] - 1]);
        }
    }
}