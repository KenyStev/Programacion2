/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabProgra2;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author KenyStev
 */
public class Residencial {
    private String nombre;
    private Residencia primerCasa;

    // acqua
    public Residencial(String nombre) {
        this.nombre = nombre;
        this.primerCasa = null;
    }
    
    // bit
    public boolean numeroDisponible(int num){
        Residencia tmp = primerCasa;
        
        while(tmp != null){
            if(tmp.num==num)return false;
            tmp = tmp.derecha;
        }
        return true;
    }
    
    // crazy
    public boolean construirResidencia(int num, String nombreFamilia){
        if(numeroDisponible(num)){
            Residencia obj = new Residencia(num, nombreFamilia);
            
            if(primerCasa==null){
                primerCasa = obj;
            }else{
                Residencia tmp = primerCasa;
                
                while(tmp.derecha != null){
                    tmp = tmp.derecha;
                }
                
                tmp.derecha = obj;
                obj.izquierda = tmp;
            }
            return true;
        }
        return false;
    }
    
    // debug
    public void agregarInquilinoEn(int num, String inquilino){
        Residencia tmp = primerCasa;
        
        while(tmp!=null){
            if(tmp.num==num){
                tmp.addInquilino(inquilino);
                break;
            }
            tmp = tmp.derecha;
        }
    }
    
    // equals
    public boolean InformacionCasa(int num){
        Residencia tmp = primerCasa;
        
        while(tmp!=null){
            if(tmp.num==num){
                tmp.print();
                if(tmp.izquierda!=null)
                    System.out.println("Vecinos Izquierda: "+tmp.izquierda.nameFamily);
                if(tmp.derecha!=null)
                    System.out.println("Vecinos Derecha: "+tmp.derecha.nameFamily);
                return true;
            }
            tmp = tmp.derecha;
        }
        return false;
    }
    
    // fock
    public void backup(String filePath)throws IOException{
        RandomAccessFile rBack = new RandomAccessFile(filePath, "rw");
        
        Residencia tmp = primerCasa;
        
        while(tmp!=null){
            rBack.writeInt(tmp.num);
            rBack.writeUTF(tmp.nameFamily);
            rBack.writeInt(tmp.inquilinos.size());
            
            for(String inquilino : tmp.inquilinos){
                rBack.writeUTF(inquilino);
            }
            
            tmp = tmp.derecha;
        }
    }
    
    // garbage
    public void reloadFromBackup(String filePath)throws IOException{
        RandomAccessFile rBack = new RandomAccessFile(filePath, "rw");
        
        primerCasa = null;
        
        while(rBack.getFilePointer() < rBack.length()){
            int num = rBack.readInt();
            String nameFamily = rBack.readUTF();
            construirResidencia(num, nameFamily);
            
            int cont=0, cantInquilinos = rBack.readInt();
            
            while(cont<cantInquilinos){
                agregarInquilinoEn(num, rBack.readUTF());
                cont++;
            }
        }
    }
}
