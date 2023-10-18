/*
Perceber que no redirecionamento da resposta diretórios devem
ser iniciados por "/"
 */
package web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabriciogmc
 */
public class Login extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){        
        ServletContext sc = req.getServletContext();
        try{
        sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}
