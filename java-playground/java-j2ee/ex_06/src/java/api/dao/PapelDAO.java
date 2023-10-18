/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.EnumPapeis;
import api.modelo.Papel;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public interface PapelDAO {
    public Papel insert(Papel papel);
    public Papel findById(Long id);
    public Papel findByDescricao(EnumPapeis desc);
    public List<Papel> findAll();
    public Papel update(Papel papelA, Papel N);
    public boolean delete(Papel papel);    
}
