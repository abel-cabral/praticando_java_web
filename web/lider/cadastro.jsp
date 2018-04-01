<%@page import="java.text.SimpleDateFormat"%>
<%@page import="persistencia.LiderBD"%>
<%@page import="dominio.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        

    </head>
    <body>          

        <%
            Lider lider = null;//Se eu add new Lider significa que quero criar outro objeto ou seja não editar o que tenho.
            String tratamentoData = "";

            String alterar = request.getParameter("cpf");
            if (alterar != null) {
                lider = LiderBD.getByCpf(alterar);
                SimpleDateFormat converter = new SimpleDateFormat("dd/MM/yyyy");
                tratamentoData = converter.format(lider.getNascimento());
            } else {
                lider = new Lider();//Caso não hava um retorno eu crio um novo objeto
            }
        %>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="../index.html">Início</a></li>
                <li class="breadcrumb-item active" aria-current="page">Cadastro</li>
            </ol>
        </nav>
        <div class="container py-5">

            <div class="col-md-6 offset-md-3">
                <span class="anchor" id="formRegister"></span>
                <hr class="mb-5">

                <!-- form card register -->
                <div class="card card-outline-secondary">
                    <div class="card-header">
                        <h3 class="mb-0">Cadastro de Usuário</h3>
                    </div>
                    <div class="card-body">
                        <form class="form" method="POST" action="salvar.jsp" role="form" autocomplete="off"><!--Se não fizermos o teste abaixo, será escrito 'null' nos campos quando formos cadastrar-->
                            <div class="form-group">
                                <label for="inputName">Nome</label>
                                <input type="text" class="form-control" name="nome" placeholder="Nome Completo" value="<%= ((lider.getNome() != null) ? lider.getNome() : "")%>" required="">
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3">CPF</label><!--Aqui como nosso id = cpf, nao podemos alterar se nao pode dar conflito, assim bloqueio pelo html a entrada do dado, mas exibo o valor-->
                                <input type="text" class="form-control" name="cpf" placeholder="CPF sem Pontuação" value="<%= ((lider.getCpf() != null) ? lider.getCpf() : "")%>" <%= ((lider.getCpf() != null) ? "disabled" : "")%> required="" minlength="11" maxlength="11" pattern="[0-9]{11}" >
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3">Telefone</label>
                                <input type="text" class="form-control" name="tel" placeholder="Telefone sem DDD" value="<%= ((lider.getTelefone() != null) ? lider.getTelefone() : "")%>" required="" minlength="9" maxlength="9" pattern="[0-9]{9}">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3">Quando você nasceu?</label>
                                <input type="date" class="form-control" name="data" placeholder="Nascimento" value="<%= ((tratamentoData != null) ? tratamentoData : "")%>" required="">
                            </div>
                            <div class="form-group">
                                <label for="inputVerify3">Cidade</label>
                                <input type="text" class="form-control" name="cidade" placeholder="Cidade" value="<%= ((lider.getCidade() != null) ? lider.getCidade() : "")%>" required="">
                            </div>

                            <%
                                //por causo do nosso teste em option, quando fossemos cadastrar o retorno seria null, assim o .equals retornaria um NullPointerException, pra evitar precisamos dá um valor.
                                String estado = lider.getEstado();
                                if (estado == null) {
                                    estado = "";//No Cadastro mostrará vazio, assim exebindo o default selected 
                                }

                            %>

                            <div class="form-group">
                                <label for="inputVerify3">Estado</label>
                                <select class="custom-select custom-select-lg mb-3" name="estado" required="">
                                    <option selected>Escolha seu Estado</option>
                                    <option value="RJ" <% if (estado.equals("RJ")) {
                                            out.println("selected");
                                        } %>>Rio de Janeiro</option><!--Há forma mais faceis quando temos grandes valores-->
                                    <option value="SP" <% if (estado.equals("SP")) {
                                            out.println("selected");
                                        } %>>São Paulo</option><!-- No java o equals testa o valor de Strings-->
                                    <option value="BA" <% if (estado.equals("BA")) {
                                            out.println("selected");
                                        } %>>Bahia</option>
                                    <option value="AM" <% if (estado.equals("AM")) {
                                            out.println("selected");
                                        } %>>Amazonas</option>
                                    <option value="RS" <% if (estado.equals("RS")) {
                                            out.println("selected");
                                        }%>>Rio Grande do Sul</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-lg float-right">Registar</button>
                                <input type="hidden" name="lider" value="<%= alterar%>">
                            </div>
                        </form>                           
                    </div>
                </div>
                <!-- /form card register -->

            </div>                       
        </div>
    </div> 
</div>
<!--/col-->
</div>
<!--Bootstrap 4-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!--Fim-->
</body>
</html>
