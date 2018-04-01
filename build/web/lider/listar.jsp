<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Lider"%>
<%@page import="persistencia.LiderBD"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="../index.html">Início</a></li>
                <li class="breadcrumb-item active" aria-current="page">Lista de Cadastrados</li>
            </ol>
        </nav>
        <h1>Lista de Lideres</h1>



        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Nascimento</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <!--Abro meu java-->
                    <%
                        ArrayList<Lider> lideres = LiderBD.listar();//Crio de lider usando a dunção listar que fiz em LiderBD
                        //Ao exibir a data, temos ela completa, precisamos formata com o DateSimpleFormat

                        SimpleDateFormat converter = new SimpleDateFormat("dd/MM/yy");//Já criei minha variavel do objeto SimpleDateFormat e passei o formato de saida
                        String nascimento = "Sem Data";

                        for (int i = 0; i < lideres.size(); i++) {//Faço um for para percorrer toda a lista e buscar seus valores.
                            Lider cadaLider = lideres.get(i); //Crio uma variavel da classe Lider, pego minha lista acima criada e insiro o i do for

                            if (cadaLider.getNascimento() != null) {//Não posso tratar um campo nulo, assim farei um tratamento
                                nascimento = converter.format(cadaLider.getNascimento());//Pega minha variavel de data e formata a data atual pra o que especifiquei;
                            }//dentro do for ele fará o teste com cada leitura

                    %>
                    <tr><!-- tr É o determinante de linha e th é o referente a coluna-->                                                
                        <th><%= cadaLider.getNome()%></th><!--Esse é um atalho para escrita direta igual no php <?= -->
                        <th><%= cadaLider.getCpf()%></th>
                        <th><%= cadaLider.getTelefone()%></th>
                        <th><%= nascimento%></th>
                        <th><%= cadaLider.getCidade()%></th>
                        <th><%= cadaLider.getEstado()%></th>
                        <th>
                            <span class="col-md-6">
                                <a href="./cadastro.jsp?cpf=<%=cadaLider.getCpf()%>"><i class="ion-edit text-warning"></i></a>
                            </span>
                            <span class="col-md-6">
                                <a href="./excluir.jsp?cpf=<%=cadaLider.getCpf()%>" onclick="return confirm('Deseja Excluir?')"><i class="ion-trash-b text-danger"></i></a>
                            </span>


                        </th>
                    </tr>
                    <%
                        }
                        //Eu posso emendar o código java e html, neste caso estou costurando as tags <tr> e <th> ao meu for
%>
                </tbody>
            </table>
        </div>

        <!--Bootstrap 4-->
        <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--Fim-->
    </body>
</html>
