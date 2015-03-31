/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1labprg2;

import java.util.Calendar;

/**
 *
 * @author KenyStev
 */
public class EmpleadoTemporal extends Empleado{
    private Calendar fechaFinContrato;

    public EmpleadoTemporal(int code, String name, double salario) {
        super(code, name, salario);
        fechaFinContrato = Calendar.getInstance();
    }

    @Override
    protected double pago() {
        Calendar c = Calendar.getInstance();
        if(c.compareTo(fechaFinContrato)<=0){
            return salario;
        }
        return 0;
    }

    public Calendar getFechaFinContrato() {
        return fechaFinContrato;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fecha fin de contrato: " + fechaFinContrato.getTime() + ", Tipo: Temporal";
    }
    
    public void extendContrato(int y, int m, int d){
        Calendar now = Calendar.getInstance();
        now.set(y, m-1, d);
        if(now.after(fechaFinContrato)){
            fechaFinContrato = now;
        }
    }
}
