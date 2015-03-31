/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabProgra2;

import java.util.ArrayList;

/**
 *
 * @author KenyStev
 */
public class Residencia {
    public int num;
    public String nameFamily;
    public ArrayList<String> inquilinos;
    
    public Residencia izquierda, derecha;

    public Residencia(int num, String nameFamily) {
        this.num = num;
        this.nameFamily = nameFamily;
        this.inquilinos = new ArrayList<>();
        this.izquierda = null;
        this.derecha = null;
    }
    
    public void addInquilino(String nombre){
        inquilinos.add(nombre);
    }
    
    public void print(){
        System.out.println("Numero de Casa: "+num+" Familia: "+nameFamily);
        for (String inquilino : inquilinos) {
            System.out.println("- "+inquilino);
        }
    }
}
