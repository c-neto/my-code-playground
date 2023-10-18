/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabriciogmc
 */
@WebServlet(name = "TagsJSTL", urlPatterns = {"/tagsJSTL"})
public class TagsJSTL extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, 
                      HttpServletResponse res){
        
        List<String> itens = new ArrayList();
        itens.add("Farinha de Trigo");
        itens.add("Sal");
        itens.add("Açúcar");
        itens.add("Ovo");
        req.setAttribute("ingredientes", itens);
        
        try{
        req.getServletContext().getRequestDispatcher("/jsp/tagsjstl.jsp").forward(req, res);
        } catch (IOException ioe){            
        } catch (ServletException se){
            
        }
    }
}
