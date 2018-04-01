<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="persistencia.LiderBD"%>
<%@page import="dominio.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String atualizacao = request.getParameter("lider");

    String nome = request.getParameter("nome");//Cria variavel, requisita um parametro que é onde o valor do post tá
    String cpf = request.getParameter("cpf");
    String tel = request.getParameter("tel");
    String cidade = request.getParameter("cidade");
    String nascimento = request.getParameter("data");
    String estado = request.getParameter("estado");

    //Conversor de data
    SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");//Primeiro instanciamos o objeto que vai formatar a data e passamos os parametros de data que queremos    
    Date nova;//crio a variavel
    try {//tento formatar nascimento pra ela
        nova = formatar.parse(nascimento);//Essa variavel recebe o valor da nova variavel que foi convertida para o padrao que escolhemos;
    } catch (Exception e) {//caso flahe coloco essa data
        nova = formatar.parse("26/06/1992");//Essa variavel recebe o valor da nova variavel que foi convertida para o padrao que escolhemos;
    }

    //Salvando no XML
    Lider lider;//aqui eu crio uma variavel da classe Lider, mas nao a chamo;

    if (atualizacao.equals("null")) {//Aqui o sistema sabera se deve cadastar ou atualizar um Lider
        lider = new Lider();//Aqui defino o novo objeto, assim um novo cadastro
    } else {//Lider é a classe de objeto, lider é o nome do novo objeto e new Lider que dizer que estamos criando ele;        
        lider = LiderBD.getByCpf(atualizacao);//Aqui eu chamo a função que atualiza
    }

    lider.setNome(nome);//Deminimos os valores de Set de Lider    
    lider.setTelefone(tel);
    lider.setNascimento(nova);//Precisamos ver se o padrão de entrada bate, esse a data ntem que ser transformado
    lider.setCidade(cidade);
    lider.setEstado(estado);

    try {//Tenta executar o inserir
        //Agora precisamos fazer outro teste, para saber se devemos criar um novo objeto ou salvar em cima de um listado
        if (atualizacao.equals("null")) {//Aqui o sistema sabera se deve cadastar ou atualizar um Lider
            lider.setCpf(cpf);//Defino o cpf aqui, pois não quero alterar o cpf que já existe.
            LiderBD.inserir(lider);//Esse puxa os valores preenchidos no objeto lider e grava um novo Lider
            response.sendRedirect("./listar.jsp");
        } else {//Lider é a classe de objeto, lider é o nome do novo objeto e new Lider que dizer que estamos criando ele;        
            LiderBD.alterar(lider);//Esse aqui vai atualizar.        
            response.sendRedirect("./listar.jsp");
        }
    } catch (Exception e) {//caso não consiga faz isso
        out.println("Não consegui cadastrar, consulte administrador do sistema.");
    }
%>

