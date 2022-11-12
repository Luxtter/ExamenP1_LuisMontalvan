/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1_p1_luismontalvan;

import java.util.Scanner;
/**
 *
 * @author luism
 */
public class Examen1_P1_LuisMontalvan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        OUTER:
        do{
            Scanner pochita= new Scanner(System.in);
            System.out.print("Menu----------------------------\n1)Conjuntos\n2)Cifrado por substitucion\n3)Sobre\n4)Salir\nPorfavor elija una opcion: ");
            int opc= pochita.nextInt();
            switch(opc){
                case 1:
                    //Le falta que sean comparados por comas
                    Conjuntos();
                    break;
                case 2:
                    CifradoPorSubstitucion();
                    break;
                case 3:
                    Sobre();
                    break;
                case 4:
                    break OUTER;
                default:
                    System.out.println("Opcion no valida, elija otra");
            }
        }while(true);
    }
    public static void Conjuntos(){
        Scanner pochita= new Scanner(System.in);
        String primerConjunto;
        String segundoConjunto;
        System.out.print("Conjuntos-----------------------\nIngrese el primer conjunto: ");
        primerConjunto= pochita.next();
        System.out.print("Ingrese el segundo conjunto: ");
        segundoConjunto= pochita.next();
        boolean resp=CompararConjuntos(primerConjunto,segundoConjunto);
        if(resp==true){
            System.out.println("Ambos conjuntos son iguales");
        }else{
            System.out.println("Los conjuntos no son iguales");
            UnionInter(primerConjunto,segundoConjunto);
        }
    }
    public static boolean CompararConjuntos(String conjuntoA, String conjuntoB){
        int largoA= conjuntoA.length();
        int largoB= conjuntoB.length();
        int chara1=0;
        int chara2=0;
        int bandera=0;
        boolean resp=false;
        if(largoA==largoB){
            for (int i = 0; i < largoA; i++) {
                chara1= conjuntoA.charAt(i);
                  for (int j = 0; j < largoB; j++) {
                      chara2= conjuntoB.charAt(j);
                      if(chara1==chara2){
                          bandera++;
                      }
                  }
            }
            if(bandera==largoB){
               resp= true;  
            }else{
                resp= false;
            }
        }else{
            resp= false;
        }
        return resp;
    }
    public static void UnionInter(String conjuntoA, String conjuntoB){
        int largoA= conjuntoA.length();
        int largoB= conjuntoB.length();
        int chara1=0;
        int chara2=0;
        String union= "";
        String inter= "";
        int bandera= 0;
        if(largoA>largoB){
            for (int i = 0; i < largoA; i++) {
                chara1= conjuntoA.charAt(i);
                    for (int j = 0; j < largoB; j++) {
                        chara2= conjuntoB.charAt(j);
                        if(chara1==chara2){
                            inter+= conjuntoA.charAt(i);
                        }else{
                            union+= conjuntoA.charAt(i); 
                        }
                    }
            }
        }else{
          for (int i = 0; i < largoB; i++) {
                chara1= conjuntoB.charAt(i);
                    for (int j = 0; j < largoA; j++) {
                        chara2= conjuntoA.charAt(j);
                        if(chara1==chara2){
                            inter+= conjuntoB.charAt(i);
                        }else if(bandera==0){
                            union+= conjuntoB.charAt(i);
                            bandera++;
                        }
                    }
                    bandera=0;
            }  
        }
        System.out.println("Union: C= {"+union+"}");
        System.out.println("Interseccion: D= {"+inter+"]");
    }
    public static void CifradoPorSubstitucion(){
        Scanner pochita= new Scanner(System.in);
        System.out.print("Cifrado por substitucion--------\nIngrese una cadena: ");
        String cadena= pochita.next();
        cadena= cadena.toLowerCase();
        String codificado= "";
        String letra2= "";
        letra2+= (char)(97);
        char letra= 97;
        System.out.println(letra2);
        int largo= cadena.length();
        int posicion=0;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < 1; j++) {
              posicion+= cadena.charAt(i);
                if(posicion<109){
                    posicion=(97-posicion)+122;
                    codificado+= (char)(posicion);
                }else if(posicion>111){
                    posicion=(97-posicion)+122;
                    codificado+= (char)(posicion);
                    System.out.print(codificado);
                    codificado="";
                }else{
                    codificado+= (char)(posicion);
                    System.out.print(codificado);
                    codificado="";
                }
                codificado="";
            }
            
        }
        System.out.println(codificado);
        
    }
    public static void Sobre(){
        Scanner pochita= new Scanner(System.in);
        Scanner lelouch= new Scanner(System.in);
        int tamaño= pochita.nextInt();
        tamaño*= 2;
        int posicion2=4;
        int posicion=0;
        int posicionFor=0;
        String contorno= lelouch.next();
        for (int i = 0; i <= tamaño; i++) {
            System.out.print(contorno+" ");
        }
        System.out.println("");
        for (int i = 0; i < tamaño-1; i++) {
            System.out.print(contorno+" ");
            if(i<((tamaño/2)+1)){
                for (int j = 0; j < tamaño/2; j++){
                    posicionFor= j;
                    posicion=i;
                    if(posicionFor==posicion){
                        System.out.print(contorno+" ");
                        posicion+=2;
                    }else{
                        System.out.print("  ");
                    }
                    for (int k = 7; k < tamaño; k++){
                    posicionFor= k;
                    posicion=tamaño-i;
                    if(posicionFor==posicion){
                        System.out.print(contorno+" ");
                        posicion+=2;
                    }else{
                        System.out.print("  ");
                    }
                    }
                    
                }
                System.out.print(contorno+" ");
            }else if(i>((tamaño/2)+1)){
                for (int j = 0; j < tamaño/2; j++) {
                    System.out.print(" ");
                    posicionFor= j;
                    posicion=i;
                    if(posicionFor==posicion){
                        System.out.print("  ");
                    }
                }
            }else{
                for (int j = 0; j < tamaño-2; j++) {
                    posicionFor= j;
                    posicion=(tamaño/2)+1;
                    if(posicionFor==posicion){
                        System.out.print(contorno+" ");
                    }else{
                        System.out.print(" ");
                    }
            }
            
        }
       System.out.println("");
       posicion2--;
    }
    }
}
