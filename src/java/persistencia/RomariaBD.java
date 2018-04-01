/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Romaria;
import java.util.ArrayList;

/**
 *
 * @author jurac
 */
public class RomariaBD {
    private static ArrayList<Romaria> lista = new ArrayList<>();

    //Lider é a classe que criamos, e novo lider é o objeto que recebemos nos parametros quando este método for chamado
    public static void inserir(Romaria novaRomaria) {//Void usamos quando o método não devolve nada
        lista.add(novaRomaria);
    }

    public static void alterar(Romaria alterarRomaria) {        
        excluir(alterarRomaria.getCodigo());
        inserir(alterarRomaria);
    }

    public static void excluir(int codigo) {
        //Vai percorrer toda nossa lista
        for(int i=0; i < lista.size(); i++){            
            Romaria buscar = lista.get(i);
            //Ele vai percorrer todo o array. Comparando cpf de cada objeto que achar, no fim se for igual ao declarado ele exclui.
            
            if(buscar.getCodigo() == (codigo)){//equals é comparar string para interios usamos ==
                //remove isso na lista na posição que ele está na array list
                lista.remove(i);
                break;//Com break ele para de percorrer o resto da lista, poupa tempo e recurso
            }
        }            
    }
}
