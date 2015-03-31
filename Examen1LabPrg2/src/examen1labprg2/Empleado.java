/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1labprg2;

import java.util.Date;

/**
 *
 * @author KenyStev
 */
public abstract class Empleado {
    protected int code;
    protected String name;
    protected Date contratacion;
    protected double salario;

    public Empleado(int code, String name, double salario) {
        this.code = code;
        this.name = name;
        this.salario = salario;
        contratacion = new Date();
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getContratacion() {
        return contratacion;
    }
    
    protected abstract double pago();

    @Override
    public String toString() {
        return "code=" + code + ", name=" + name;
    }
    
}
