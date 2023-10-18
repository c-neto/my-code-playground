/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabriciogmc
 */
public class Exemplo02 extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        String nome = req.getParameter("nome"); 
        String resNome = "Seu nome é: " + nome;
        try{
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();            
            pw.write(resNome); pw.close();
        } 
        catch (Exception e){}
    }
}
