/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1labprg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class Empresa {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    
    private Empleado search(int code){
        for (Empleado empleado : empleados) {
            if(empleado.getCode()==code)
                return empleado;
        }
        return null;
    }
    
    public boolean addEmpleado(int code, String name, double salario, TypeEmploye type){
        if(search(code)==null){
            switch(type){
                case NORMAL: empleados.add(new Empleado(code, name, salario) {
                    
                    @Override
                    protected double pago() {
                        return salario - (0.035 * salario);
                    }
                });                                                                         return true;
                case TEMPORAL: empleados.add(new EmpleadoTemporal(code, name, salario));    return true;
                case PORVENTA: empleados.add(new EmpleadoVentas(code, name, salario));      return true;
            }
        }
        return false;
    }
    
    public boolean payEmploye(int code){
        Empleado temp = search(code);
        if(temp!=null){
            System.out.println("Pago del Empleado "+temp.getName()+": "+temp.pago());
            return true;
        }
        return false;
    }
    
    public boolean recordSales(int code, double venta){
        Empleado temp = search(code);
        if(temp instanceof EmpleadoVentas){
            ((EmpleadoVentas)temp).actualizarVenta(venta);
            return true;
        }
        return false;
    }
    
    public boolean extendsContract(int code){
        Empleado temp = search(code);
        if(temp instanceof EmpleadoTemporal){
            Scanner scan = new Scanner(System.in);
            System.out.print("Ingrese la nueva fecha (year month day) separada por espacios: ");
            ((EmpleadoTemporal)temp).extendContrato(scan.nextInt(), scan.nextInt(), scan.nextInt());
            return true;
        }
        return false;
    }
    
    public void list(){
        int Emp=0, EmpVent=0, EmpTemp=0;
        for (Empleado e : empleados) {
            if(!(e instanceof EmpleadoTemporal) && !(e instanceof EmpleadoVentas))
                Emp++;
            if(e instanceof EmpleadoTemporal)
                EmpTemp++;
            if(e instanceof EmpleadoVentas)
                EmpVent++;
            System.out.println(e);
        }
        System.out.println("--CANTIDAD DE EMPLEADOS--");
        System.out.println("-Empleados: "+Emp);
        System.out.println("-Empleados por Ventas: "+EmpVent);
        System.out.println("-Empleado Temporal: "+ EmpTemp);
    }
}
