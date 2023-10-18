/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabriciogmc
 */
public class Autenticador extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServletContext sc = req.getServletContext();
        if ( nomeUsuario.equals("fabricio") && senha.equals("123")){
            req.setAttribute("nomeUsuario", nomeUsuario);
            req.setAttribute("senha", senha);
            try {
                sc.getRequestDispatcher("/jsp/paginaInicial.jsp").forward(req, resp); 
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }                       
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }    
    }
}