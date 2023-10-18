/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

/**
 *
 * @author fabriciogmc
 */
public enum EnumPapeis {
    ADMINISTRADOR ("Administrador"), 
    USUARIO_COMUM ("Usuário Comum"), 
    VISITANTE ("Visitante");    
    private final String descricao;        
    EnumPapeis(String valor){
        this.descricao = valor;
    }    
    @Override
    public String toString(){
        return this.descricao;
    }
}
