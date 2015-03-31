/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrepaso1prg2;

/**
 *
 * @author KenyStev
 */
public abstract class CuentaBancaria {
    protected int numCuenta;
    protected String client;
    protected double saldo;

    public CuentaBancaria(int numCuenta, String client) {
        this.numCuenta = numCuenta;
        this.client = client;
        this.saldo = 500;
    }
    
    protected abstract boolean retiro(double monto);

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getClient() {
        return client;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void deposit(double monto){
        saldo+=monto; 
    }
    
    @Override
    public String toString() {
        return "numCuenta=" + numCuenta + ", client=" + client + ", saldo=" + saldo;
    }
}
