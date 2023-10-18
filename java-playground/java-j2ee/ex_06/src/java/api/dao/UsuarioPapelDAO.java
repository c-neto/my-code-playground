/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Papel;
import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public interface UsuarioPapelDAO {
    //Todos os papeis vinculados a um usuário.
    public List<Long> findByUsuario(Usuario u); 
    
    //Todos os usuários vinculados a um papel.
    public List<Long> findByPapel(Papel p);
}
