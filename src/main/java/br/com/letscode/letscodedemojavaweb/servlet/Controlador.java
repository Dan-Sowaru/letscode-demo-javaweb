package br.com.letscode.letscodedemojavaweb.servlet;

import br.com.letscode.letscodedemojavaweb.modelo.acao.CadastrarPessoas;
import br.com.letscode.letscodedemojavaweb.modelo.acao.CadastrarPessoasForm;
import br.com.letscode.letscodedemojavaweb.modelo.acao.ListarPessoas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controlador") // se colocar só a string ali no () é atribuída ao value;
public class Controlador extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        String path = null;

        if (acao.equals("cadastrar-pessoas")) {
            CadastrarPessoas cadastrarPessoas = new CadastrarPessoas(req, res);
            path = cadastrarPessoas.executar();

        } else if (acao.equals("listar-pessoas")) {
            ListarPessoas listarPessoas = new ListarPessoas(req, res);
            listarPessoas.executar();
            path = listarPessoas.executar();

        } else if (acao.equals("remover-pessoas")) {
//            implementar

        } else if (acao.equals("alterar-pessoas")) {
//            implementar

        } else if (acao.equals("cadastrar-pessoas-form")) {
            CadastrarPessoasForm cadastrarPessoasForm = new CadastrarPessoasForm();
            path = cadastrarPessoasForm.executar();

        }
        String[] metodoECaminho = path.split(":");
        if (metodoECaminho[0].equals("forward")) {
            req.getRequestDispatcher("WEB-INF/view/" + metodoECaminho[1]).forward(req, res);
        } else {
            res.sendRedirect(metodoECaminho[1]);
        }
    }

}
