/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrepaso1prg2;

import java.util.Calendar;

/**
 *
 * @author KenyStev
 */
public final class CuentaAhorro extends CuentaBancaria{
    private Calendar ultimaFecha;
    private boolean activa;
    public static final double TASA_INTERES=0.2;

    public CuentaAhorro(int numCuenta, String client) {
        super(numCuenta, client);
        ultimaFecha=Calendar.getInstance();
        activa=true;
    }

    @Override
    public void deposit(double monto) {
        if(activa)
            super.deposit(monto);
        else
            super.deposit(monto-(monto*0.1));
        ultimaFecha = Calendar.getInstance();
        activa=true;
    }

    @Override
    protected boolean retiro(double monto) {
        if(activa){
            if(saldo>=monto){
                saldo-=monto;
                ultimaFecha = Calendar.getInstance();
                return true;
            }
            return false;
        }else{
            activa=true;
            return saldo>=monto;
        }
    }
    
    public final void desactivar(){
        Calendar now=Calendar.getInstance();
        now.add(Calendar.MONTH, -6);
        if(ultimaFecha.before(now))
            activa=false;
    }

    @Override
    public String toString() {
        return "AHORRO "+super.toString()+(activa?"ACTIVADA":"DESACTIVADA");
    }
    
}
