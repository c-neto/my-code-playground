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
public class Papel extends Identificador{
    private EnumPapeis descricao;
    
    public Papel(){} //Construtor default
    
    public Papel(Long id, EnumPapeis desc){
       super(id);
       this.setDescricao(desc);
    }    
    
    public EnumPapeis getDescricao() {
        return descricao;
    }

    public void setDescricao(EnumPapeis descricao) {
        this.descricao = descricao;
    }
    
    
}
