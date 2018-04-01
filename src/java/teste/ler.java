/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dominio.Lider;
import persistencia.LiderBD;

/**
 *
 * @author jurac
 */
public class ler {
    public static void main(String[] args) {
        Lider lider = new Lider();        
        lider.getNome();        
        lider.getCpf();        
        lider.getEstado();        
        lider.getTelefone();                
        lider.getCidade();         
        LiderBD.listar();
       
        
        
        System.out.println("");//Escreve na tela o resultado
    }
    
}
