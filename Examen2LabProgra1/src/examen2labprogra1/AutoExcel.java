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
public class AutoExcel {
    private Scanner scan = new Scanner(System.in);
    private ClienteAuto clientes[];

    public AutoExcel(int max) {
        clientes = new ClienteAuto[max];
    }
    
    private int posVacia(){
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i]==null){
                return i;
            }
        }
        return -1;
    }
    
    private ClienteAuto buscarPlaca(String placa){
        for (ClienteAuto cliente : clientes) {
            if (cliente != null && cliente.getNumPlaca().equals(placa)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void agregarCliente(String placa){
        int index = posVacia();
        ClienteAuto cliente = buscarPlaca(placa);
        if(index>=0){
            if(cliente==null){
                System.out.print("Ingrese el nombre: ");
                String nombre = scan.next();
                System.out.print("Ingrese el Modelo: ");
                String model = scan.next();
                clientes[index] = new ClienteAuto(placa, nombre, model);
            }else{
                System.out.println("Ya existe un cliente con ese numero de placa!");
            }
        }else{
            System.out.println("Arreglo lleno!");
        }
    }
    
    public void atenderRevision(String placa){
        ClienteAuto cliente = buscarPlaca(placa);
        if(cliente!=null){
            System.out.println("Atendiendo la revision: "+cliente.getNextReview()+" del cliente: "+cliente.getNombre());
            System.out.print("Ingrese el monto a pagar para esta revision: ");
            double monto = scan.nextDouble();
            cliente.incrementarMonto(monto);
            cliente.setProximaRevision();
        }else{
            System.out.println("No existe un Cliente con este numero de placa!");
        }
    }
    
    public void removerClientesCompletos(){
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i]!=null && clientes[i].getNextReview()>=100000){
                clientes[i]=null;
            }
        }
    }
    
    public void listarClientes(){
        for (ClienteAuto cliente : clientes) {
            if(cliente!=null){
                cliente.print();
            }
        }
    }
}
