<%@page import="persistencia.LiderBD"%>
<%
//Declaro minha variavel que receber� o valor enviado
    String idUsuario = request.getParameter("cpf");
    //Tenta Apagar a informa��o no xml
    try {
        LiderBD.excluir(idUsuario);
        response.sendRedirect("./listar.jsp");//Ao ter a resposta encaminha o cliente pra outra p�gina, obs � mais leve.
    } catch (Exception e) {//Se der erro trata assim
        out.println("Eu falhei em apagar esses dados.");
    }
%>