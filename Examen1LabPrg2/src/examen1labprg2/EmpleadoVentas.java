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
public class EmpleadoVentas extends Empleado{
    private double[] ventasMensuales;

    public EmpleadoVentas(int code, String name, double salario) {
        super(code, name, salario);
        ventasMensuales = new double[12];
    }

    @Override
    protected double pago() {
        return ventasMensuales[mesIndex()]*0.02 + salario;
    }
    
    private int mesIndex(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }
    
    public void actualizarVenta(double v){
        ventasMensuales[mesIndex()] +=v;
    }
    
    public double ventaAnual(){return ventaAnual(0);}
    public double ventaAnual(int index){
        if(index<ventasMensuales.length){
            return ventasMensuales[index] + ventaAnual(index+1);
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Venta Anual: "+ventaAnual() + ", Tipo: Por Ventas";
    }
}
