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
public class teste {
    public static void main(String[] args) {
        Lider lider = new Lider();//chamamos a classe intanciamos a variavel e executamos a classe;
        lider.setNome("Abel Cabral de Arruda");        
        lider.setCpf("152.424.847-99");        
        lider.setEstado("Rio de Janeiro");        
        lider.setTelefone("(21)9693-69662");                
        lider.setCidade("Niterói"); 
        LiderBD.inserir(lider);
        
        System.out.println("Usuário Cadastrado no Sistema");//Escreve na tela o resultado
        
        
    }
    
}
