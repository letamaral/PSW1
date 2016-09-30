/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.io.Serializable;

/**
 *
 * @author rafa
 */
public class Estrela implements Serializable{
    
    private String Nome;
    
    private String Constelacao;
    
    private int Distancia_da_Terra;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getConstelacao() {
        return Constelacao;
    }

    public void setConstelacao(String Constelacao) {
        this.Constelacao = Constelacao;
    }

    public int getDistancia_da_Terra() {
        return Distancia_da_Terra;
    }

    public void setDistancia_da_Terra(int Distancia_da_Terra) {
        this.Distancia_da_Terra = Distancia_da_Terra;
    }
    
    public boolean persiste() {
        return false; 
    }
    
}
