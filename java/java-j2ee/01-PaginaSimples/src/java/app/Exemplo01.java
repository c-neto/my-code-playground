/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author fabriciogmc
 */
public class Exemplo01 extends GenericServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) 
           throws ServletException, IOException {        
        Integer a, b, c;
        a = 1;
        b = 2;
        c = a+b;
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.print(c.toString()+ " <br/>");
        pw.close();
    }    
}
