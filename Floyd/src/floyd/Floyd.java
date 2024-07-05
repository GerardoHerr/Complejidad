/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package floyd;

import java.util.Scanner;

/**
 *
 * @author GERARDO
 */
public class Floyd {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        final int inf = 10000;
        Scanner entra = new Scanner(System.in);
        System.out.println("prueba");
        System.out.println("Ingrese la cantidad de nodo que tiene el grafo");
        int n = entra.nextInt();
        String linea = "";
        System.out.println("Rellene la matriz de Distancia");
        for (int i = 1; i <= n; i++) {
            if (i == 1){
                for (int t = 1; t <= n; t++) {
                    System.out.print(" " +  t + " ");
                }                
            }
        }
        for (int j = 1; j <= n; j++) {
                if (j == 1){
                    System.out.println(" ");  
                }
                System.out.println(j);
        }
        System.out.println("considere los 0 porfavor, para ingresar infinito ingrese '-1'");
        int [][] matrizD = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println("fila" + (i+1));
            for (int j = 0; j < n; j++) {
                matrizD[i][j] = entra.nextInt();
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizD[i][j] == -1){
                    matrizD[i][j] = inf;
                }
                System.out.print( " " + (matrizD[i][j] == inf ? "-" : matrizD[i][j]));
            }
        }
        
        int [][] matrizS = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
                    matrizS[i][j] = 0;
                } else {
                    matrizS[i][j] = (j+1); //j+1 para el de posiciones
                }
            }
        }
        System.out.println("-----------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matrizS[i][j] + " ");
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {               
                    if ((matrizD[k][j] + matrizD[i][k]) < matrizD[i][j]) {
                        matrizD[i][j] = (matrizD[k][j] + matrizD[i][k]);
                        matrizS = cambiarPosicion(i, j, matrizS, k);
                    }                       
                }
                
            }
            System.out.println("");
            System.out.println("======================= " + k + "====================");
            System.out.println("====================== Matriz Distancia =================");
            for (int i = 0; i < n; i++) {
                System.out.println("");
                for (int j = 0; j < n; j++) {
                    //System.out.print(" " + matrizD[i][j] + " ");
                    System.out.print( " " + (matrizD[i][j] == inf ? "-" : matrizD[i][j]));
                }
            }
            System.out.println("");
            System.out.println("====================== Matriz Posicion =================");
            for (int i = 0; i < n; i++) {
                System.out.println("");
                for (int j = 0; j < n; j++) {
                    System.out.print(" " + matrizS[i][j] + " ");
                }
            }
        }
        
        
    }
    
    public static int [][] cambiarPosicion(int i, int j, int [][] matriz, int k){
        matriz[i][j] = k+1;
        return matriz;
    }   
}
