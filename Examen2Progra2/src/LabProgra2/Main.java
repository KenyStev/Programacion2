/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabProgra2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class Main {

    static Residencial vidaEnDosEstados = new Residencial("#vidaEnDosEstados");
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opt = 0, num;
        String name;
        do {
            try {

                System.out.printf("\n\n---MENU---\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        "1. Construir Residencia",
                        "2. Agregar Inquilino En",
                        "3. Informacion Casa",
                        "4. backup",
                        "5. reload From Backup",
                        "6. Salir");
                System.out.print("Ingrese su opcion: ");
                opt = scan.nextInt();
                switch (opt) {
                    case 1: //Construir Residencia
                        System.out.print("Ingrese numero-casa: ");
                        num = scan.nextInt();
                        System.out.print("Ingrese Nombre de Familya: ");
                        name = scan.next();
                        
                        if(vidaEnDosEstados.construirResidencia(num, name))
                            System.out.println("Casa Construida!!");
                        else
                            System.out.println("Casa No Construida -> Ya existe una casa con ese numero!!");
                        break;
                    case 2: //Agregar Inquilino En
                        System.out.print("Ingrese numnero-casa: ");
                        num = scan.nextInt();
                        System.out.print("Ingrese nombre de inquilino: ");
                        name = scan.next();
                        vidaEnDosEstados.agregarInquilinoEn(num, name);
                        break;
                    case 3: //Informacion Casa
                        System.out.print("Ingrese numero-casa: ");
                        num = scan.nextInt();
                        
                        if(!vidaEnDosEstados.InformacionCasa(num))
                            System.out.println("No existe una casa con ese numero!");
                        break;
                    case 4: //backup
                        System.out.println("Ingrese el Path: ");
                        name = scan.next();
                        vidaEnDosEstados.backup(name);
                        break;
                    case 5: //reloadFromBackup
                        System.out.println("Ingrese el Path: ");
                        name = scan.next();
                        vidaEnDosEstados.reloadFromBackup(name);
                        break;
                }

            } catch (IOException e) {
                System.out.println("filepath malo!");
            } 
            catch(InputMismatchException e){
                System.out.println("Favor Ingrese un numero");
                scan.next();
            }
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (opt != 6);
    }
}
