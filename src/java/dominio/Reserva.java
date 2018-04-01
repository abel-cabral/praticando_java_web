/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author jurac
 */
public class Reserva {
    private Date dataCadastro;
    private Date datareserva;
    private int quantidadeDiarias;//Ao contrário do String colocamos int minusculo.
    
    //Agora devo importar os objetos que me relaciono
    private Lider lider;//Relacao lider.1 <- reserva.*
    private Romaria romaria;//Relacao reserva.* -> reserva.1
    
    //Getter and setter de Lider e Romaria
    public Lider getLider() {
        return lider;
    }

    public Romaria getRomaria() {
        return romaria;
    }  
    //FIM
    
    

    //Atraves desses métodos GET and Settes podemos definir os nossos atributos privados
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDatareserva() {
        return datareserva;
    }

    public void setDatareserva(Date datareserva) {
        this.datareserva = datareserva;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public void setQuantidadeDiarias(int quantidadeDiarias) {
        this.quantidadeDiarias = quantidadeDiarias;
    }

    public String getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
