package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Lider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//ISSO AQUI É UM 'BANCO DE DADOS' XML.  
public class LiderBD {

    private static ArrayList<Lider> lista = new ArrayList<>();//Cria nosso Array
    private static final String caminho = "D:\\banco\\";//Altera o caminho do arquivo salvo. Obs variavel global.

    //Lider é a classe que criamos, e novo lider é o objeto que recebemos nos parametros quando este método for chamado
    public static void inserir(Lider novoLider) {//Void usamos quando o método não devolve nada
        lerXml();//Chamamos nossa função que faz a leitura do xml para a memória;
        lista.add(novoLider);
        salvarXml();
    }

    public static void alterar(Lider alterarLider) {
        excluir(alterarLider.getCpf());
        inserir(alterarLider);
    }

    public static void excluir(String cpf) {//Se espero um sim e um não eu devo pedir um boolean ao inves de void

//Vai percorrer toda nossa lista
        lerXml();
        for (int i = 0; i < lista.size(); i++) {
            Lider buscar = lista.get(i);
            //Ele vai percorrer todo o array. Comparando cpf de cada objeto que achar, no fim se for igual ao declarado ele exclui.
            if (buscar.getCpf().equals(cpf)) {
                //remove isso na lista na posição que ele está na array list                
                lista.remove(i);
                salvarXml();
                break;//Com break ele para de percorrer o resto da lista, poupa tempo e recurso 
            }
        }
    }

    public static ArrayList<Lider> listar() {//Nesse caso precisamos de um retorno, por isso esperamos um array
        lerXml();
        return lista;//Se esperamos um retorno precisamos definir um

    }

    /*Pega o que esta no xml e coloca na lista, nosso vetor.*/
    public static void lerXml() {
        File arquivo = new File(caminho + "arquivo.xml");//Cria o xml ou faz referencia a um arquivo que já existe          

        if (arquivo.exists()) {//Testa para ver se ele existe, caso sim apenas lemos.
            XStream xstream = new XStream();
            xstream.alias("lider", Lider.class);//  defini o apelido para a tag no xml. Obs usar aspas duplas            
            lista = (ArrayList<Lider>) xstream.fromXML(arquivo);//Converte a lista em xml

        } else {
            lista = new ArrayList<Lider>();
        }
    }

    public static void salvarXml() {
        XStream xstream = new XStream();
        xstream.alias("lider", Lider.class);

        try (FileWriter escritor = new FileWriter(caminho + "arquivo.xml")) {
            escritor.write(xstream.toXML(lista));
            escritor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Lider getByCpf(String cpf) {//Temos que declarar Que tipo de parametro vamos receber ex Int, String
        lerXml();
        for (int i = 0; i < lista.size(); i++) {
            Lider buscar = lista.get(i);
            //Ele vai percorrer todo o array. Comparando cpf de cada objeto que achar, no fim se for igual ao declarado ele exclui.
            if (buscar.getCpf().equals(cpf)) {
                //remove isso na lista na posição que ele está na array list                
                return buscar;//Nessa caso ele retorna o objeto já existente encontrado 
            }
        }
        return null;//caso não encontre nada retorna null, assim iniciando um novo objeto
    }

}//Chave de fechamento da classe

