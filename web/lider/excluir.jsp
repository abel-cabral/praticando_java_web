<%@page import="persistencia.LiderBD"%>
<%
//Declaro minha variavel que receberá o valor enviado
    String idUsuario = request.getParameter("cpf");
    //Tenta Apagar a informação no xml
    try {
        LiderBD.excluir(idUsuario);
        response.sendRedirect("./listar.jsp");//Ao ter a resposta encaminha o cliente pra outra página, obs é mais leve.
    } catch (Exception e) {//Se der erro trata assim
        out.println("Eu falhei em apagar esses dados.");
    }
%>