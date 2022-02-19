package br.com.letscode.letscodedemojavaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Formulario extends HttpServlet {

//    servlet cria uma camada de Web Container;
//    servlet manipula as requests e responses;
//    Ela quem recebe os requests;
//    o value é o "endereço"


//    sobrescrevemos o método doGet da classe pai HttpServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        despacha essa request para.WEB-INF/formulario.html e encaminha a request e response;
        req.getRequestDispatcher("WEB-INF/formulario.html").forward(req, res);

    }

}
