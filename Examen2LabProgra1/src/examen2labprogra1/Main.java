/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package examen2labprogra1;

import java.util.Scanner;

/**
 *
 * @author zerokull
 */
public class Main {
    static AutoExcel Excel = new AutoExcel(100);
    
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        String placa="";
        while(true){
            System.out.printf("\n*** MENU ***\n%s\n%s\n%s\n%s\n",
                    "1-Agregar Clientes", "2- Atender Clientes",
                    "3- Listar Clientes","4- Remover Clientes Completos", "5- Salir");
            System.out.print("Escoja su opcion: ");
            int opt = scan.nextInt();
            if(opt==5)
                break;
            if(opt==1 || opt==2){
                System.out.print("Ingrese Placa: ");
                placa=scan.next();
            }
            switch(opt){
                case 1: addCliente(placa); break;
                case 2: atenderCliente(placa); break;
                case 3: listarClientes(); break;
                case 4: removerCompletos(); break;
            }
        }
    }
    
    public static void addCliente(String placa){
        Excel.agregarCliente(placa);
    }
    
    public static void atenderCliente(String placa){
        Excel.atenderRevision(placa);
    }
    
    public static void listarClientes(){
        Excel.listarClientes();
    }
    
    public static void removerCompletos(){
        Excel.removerClientesCompletos();
    }
}
