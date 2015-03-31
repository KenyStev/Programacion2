/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2labprogra1;

/**
 *
 * @author zerokull
 */
public class ClienteAuto {
    private String numPlaca, nombre, modelo;
    private int nextReview;
    private double montoTotal;

    public ClienteAuto(String placa, String cliente, String modelo) {
        numPlaca=placa;
        nombre=cliente;
        this.modelo=modelo;
        nextReview=5000;
        montoTotal=0;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNextReview() {
        return nextReview;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
    
    public void setProximaRevision(){
        nextReview+=5000;
    }
    
    public void incrementarMonto(double monto){
        if(monto>=0){
            montoTotal+=monto;
        }
    }
    
    public void print(){
        System.out.printf("Placa: %s, Cliente: %s, Modelo: %s, Proxima Revesion: %d, Monto Total: %.2f\n",
                numPlaca, nombre, modelo, nextReview, montoTotal);
    }
}
