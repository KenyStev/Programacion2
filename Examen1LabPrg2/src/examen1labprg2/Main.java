/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1labprg2;

import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner scan = new Scanner(System.in);
        int opt;
        
        do{
            System.out.printf("---MENU---\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    "1. Agregar Empleado",
                    "2. Pagar Empleado",
                    "3. Registrar Venta",
                    "4. Extender Contrato",
                    "5. Listar",
                    "6. Salir");
            System.out.print("Ingrese su opcion: ");
            opt=scan.nextInt();
            switch(opt){
                case 1: //Agregar Empleado
                    System.out.print("Ingrese el codigo: ");
                    int code = scan.nextInt();
                    System.out.print("Ingrese en Nombre: ");
                    String name = scan.next();
                    System.out.print("Ingrese el Salario: ");
                    double salario = scan.nextDouble();
                    System.out.println("Tipos Validos");
                    for (TypeEmploye emp : TypeEmploye.values())
                        System.out.print("-"+emp.name());
                    System.out.print("\nIngrese el Tipo: ");
                    TypeEmploye type = TypeEmploye.valueOf(scan.next().toUpperCase());
                    if(empresa.addEmpleado(code, name, salario, type))
                        System.out.println("Empleado "+name+" agregado con Exito!!!");
                    else
                        System.out.println("No se pudo agregar al Empleado: "+name);
                    break;
                case 2: //Pagar Empleado
                    System.out.print("Ingrese el codigo: ");
                    if(empresa.payEmploye(scan.nextInt()))
                        System.out.println("Pagado con Exito!!");
                    else
                        System.out.println("No sepudo efectuar el Pago!");
                    break;
                case 3: //Registrar Venta
                    System.out.print("Ingrese el codigo: ");
                    int c = scan.nextInt();
                    System.out.print("Ingrese el monto de la venta: ");
                    if(empresa.recordSales(c, scan.nextDouble()))
                        System.out.println("Ventas Registradas Exitosamente!!!");
                    else
                        System.out.println("No se Pudieron registrar las ventas!!");
                    break;
                case 4: //Extender Contrato
                    System.out.print("Ingrese el codigo");
                    if(empresa.extendsContract(scan.nextInt()))
                        System.out.println("Contrato Extendido Exitosamente!!!");
                    else
                        System.out.println("No se Pudo Extender el Contrato!!!");
                    break;
                case 5: //Listar
                    empresa.list();
                    break;
            }
        }while(opt!=6);
        System.out.println("\n\n!!!!-MUCHAS GRACIAS POR USAR NUESTRO SOFTWARE-!!!");
    }
    
}
