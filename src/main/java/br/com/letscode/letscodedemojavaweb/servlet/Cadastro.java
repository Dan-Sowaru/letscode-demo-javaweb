package br.com.letscode.letscodedemojavaweb.servlet;

import br.com.letscode.letscodedemojavaweb.dao.BancoDeDados;
import br.com.letscode.letscodedemojavaweb.modelo.Pessoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;


@WebServlet(name = "cadastro", value = "/cadastro")
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String idade = req.getParameter("idade");
        String data = req.getParameter("data");

        Pessoa pessoaModelo = new Pessoa(nome, sobrenome, idade, data);

        BancoDeDados bd = new BancoDeDados();
        bd.salvar(pessoaModelo);


//        Só usa esse abaixo se não tiver o getRequestDispatcher lá debaixo.
//
//        res.setContentType("text/html");
//
//        PrintWriter writer = res.getWriter();
//        writer.println("Página de cadastro acessada");
//        for (Pessoa pessoa : bd.listar()) {
//            writer.println("<ul>");
//            writer.println("<li>nome: " + pessoa.getNome() + "</li>");
//            writer.println("<li>sobrenome: " + pessoa.getSobrenome() + "</li>");
//            writer.println("<li>idade: " + pessoa.getIdade() + "</li>");
//            writer.println("<li>data: " + pessoa.getData() + "</li>");
//            writer.println("</ul>");
//        }


//        Aqui, estamos passando em um atributo da request um Map (chave, valor);
        req.setAttribute("pessoas", bd.listar());

        req.getRequestDispatcher("WEB-INF/listar-pessoas.jsp").forward(req, res);
    }

}
