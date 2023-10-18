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
public class Identificador {
    private Long id;

    public Identificador(){}
    public Identificador(Long id){
        this.setId(id);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
