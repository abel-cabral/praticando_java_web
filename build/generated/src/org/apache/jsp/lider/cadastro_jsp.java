package org.apache.jsp.lider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import persistencia.LiderBD;
import dominio.Lider;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">        \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>          \n");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <nav aria-label=\"breadcrumb\">\n");
      out.write("            <ol class=\"breadcrumb\">\n");
      out.write("                <li class=\"breadcrumb-item\"><a href=\"../index.html\">Início</a></li>\n");
      out.write("                <li class=\"breadcrumb-item active\" aria-current=\"page\">Cadastro</li>\n");
      out.write("            </ol>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container py-5\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-6 offset-md-3\">\n");
      out.write("                <span class=\"anchor\" id=\"formRegister\"></span>\n");
      out.write("                <hr class=\"mb-5\">\n");
      out.write("\n");
      out.write("                <!-- form card register -->\n");
      out.write("                <div class=\"card card-outline-secondary\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h3 class=\"mb-0\">Cadastro de Usuário</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <form class=\"form\" method=\"POST\" action=\"salvar.jsp\" role=\"form\" autocomplete=\"off\"><!--Se não fizermos o teste abaixo, será escrito 'null' nos campos quando formos cadastrar-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputName\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nome\" placeholder=\"Nome Completo\" value=\"");
      out.print( ((lider.getNome() != null) ? lider.getNome() : ""));
      out.write("\" required=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputEmail3\">CPF</label><!--Aqui como nosso id = cpf, nao podemos alterar se nao pode dar conflito, assim bloqueio pelo html a entrada do dado, mas exibo o valor-->\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"cpf\" placeholder=\"CPF sem POntuação\" value=\"");
      out.print( ((lider.getCpf() != null) ? lider.getCpf() : ""));
      out.write('"');
      out.write(' ');
      out.print( ((lider.getCpf() != null) ? "disabled" : ""));
      out.write(" required=\"\" min=\"11\" max=\"11\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputPassword3\">Telefone</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"tel\" placeholder=\"Telefone sem DDD\" value=\"");
      out.print( ((lider.getTelefone() != null) ? lider.getTelefone() : ""));
      out.write("\" required=\"\" min=\"9\" max=\"9\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputPassword3\">Quando você nasceu?</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"data\" placeholder=\"Nascimento\" value=\"");
      out.print( ((tratamentoData != null) ? tratamentoData : ""));
      out.write("\" required=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputVerify3\">Cidade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"cidade\" placeholder=\"Cidade\" value=\"");
      out.print( ((lider.getCidade() != null) ? lider.getCidade() : ""));
      out.write("\" required=\"\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            ");

                                //por causo do nosso teste em option, quando fossemos cadastrar o retorno seria null, assim o .equals retornaria um NullPointerException, pra evitar precisamos dá um valor.
                                String estado = lider.getEstado();
                                if (estado == null) {
                                    estado = "";//No Cadastro mostrará vazio, assim exebindo o default selected 
                                }

                            
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"inputVerify3\">Estado</label>\n");
      out.write("                                <select class=\"custom-select custom-select-lg mb-3\" name=\"estado\" required=\"\">\n");
      out.write("                                    <option selected>Escolha seu Estado</option>\n");
      out.write("                                    <option value=\"RJ\" ");
 if (estado.equals("RJ")) {
                                            out.println("selected");
                                        } 
      out.write(">Rio de Janeiro</option><!--Há forma mais faceis quando temos grandes valores-->\n");
      out.write("                                    <option value=\"SP\" ");
 if (estado.equals("SP")) {
                                            out.println("selected");
                                        } 
      out.write(">São Paulo</option><!-- No java o equals testa o valor de Strings-->\n");
      out.write("                                    <option value=\"BA\" ");
 if (estado.equals("BA")) {
                                            out.println("selected");
                                        } 
      out.write(">Bahia</option>\n");
      out.write("                                    <option value=\"AM\" ");
 if (estado.equals("AM")) {
                                            out.println("selected");
                                        } 
      out.write(">Amazonas</option>\n");
      out.write("                                    <option value=\"RS\" ");
 if (estado.equals("RS")) {
                                            out.println("selected");
                                        }
      out.write(">Rio Grande do Sul</option>\n");
      out.write("                                </select>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success btn-lg float-right\">Registar</button>\n");
      out.write("                                <input type=\"hidden\" name=\"lider\" value=\"");
      out.print( alterar);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                            <input type=\"text\" class='date' name=\"field-name\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /form card register -->\n");
      out.write("\n");
      out.write("            </div>                       \n");
      out.write("        </div>\n");
      out.write("    </div> \n");
      out.write("</div>\n");
      out.write("<!--/col-->\n");
      out.write("</div>\n");
      out.write("<!--Bootstrap 4-->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("<!--Fim-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
