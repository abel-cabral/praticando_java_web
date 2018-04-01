package persistencia;

import dominio.Reserva;
import java.util.ArrayList;

/**
 *
 * @author jurac
 */
public class ReservaBD {
    private static ArrayList<Reserva> lista = new ArrayList<>();

    //Lider é a classe que criamos, e novo lider é o objeto que recebemos nos parametros quando este método for chamado
    public static void inserir(Reserva novaReserva) {//Void usamos quando o método não devolve nada
        lista.add(novaReserva);
    }

    public static void alterar(Reserva alterarReserva) {        
        excluir(alterarReserva.getCpf());
        inserir(alterarReserva);
    }

    public static void excluir(String cpf) {
        //Vai percorrer toda nossa lista
        for(int i=0; i < lista.size(); i++){            
            Reserva buscar = lista.get(i);
            //Ele vai percorrer todo o array. Comparando cpf de cada objeto que achar, no fim se for igual ao declarado ele exclui.
            if(buscar.getCpf().equals(cpf)){
                //remove isso na lista na posição que ele está na array list
                lista.remove(i);
                break;//Com break ele para de percorrer o resto da lista, poupa tempo e recurso
            }
        }            
    }
    
}
