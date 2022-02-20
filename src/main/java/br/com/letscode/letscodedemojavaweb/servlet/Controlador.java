package br.com.letscode.letscodedemojavaweb.servlet;

import br.com.letscode.letscodedemojavaweb.dao.BancoDeDados;
import br.com.letscode.letscodedemojavaweb.modelo.Pessoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/controlador") // se colocar só a string ali no () é atribuída ao value;
public class Controlador extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        if (acao.equals("cadastrar-pessoas")) {
            String nome = req.getParameter("nome");
            String sobrenome = req.getParameter("sobrenome");
            String idade = req.getParameter("idade");
            String data = req.getParameter("data");

            Pessoa pessoa = new Pessoa(nome, sobrenome, idade, data);

//            Chamar método responsável
            cadastrar(pessoa);
            res.sendRedirect("/app/controlador?acao=listar-pessoas");


        } else if (acao.equals("listar-pessoas")) {
            listar(req, res);
        } else if (acao.equals("remover-pessoas")) {
            String id = req.getParameter("id");
            remover(id);
        } else if (acao.equals("alterar-pessoas")) {
            String id = req.getParameter("id");
            alterar(id);
        } else if (acao.equals("criar-pessoas-form")) {
//            res.sendRedirect("WEB-INF/formulario.html");  <- essa não funciona pra quem ta dentro do WEB-INF,
//            porque TomCat Bloqueia acesso externo e sendRedirect só redireciona (escreve na URL do browser)
            req.getRequestDispatcher("WEB-INF/view/formulario.html").forward(req, res);
        }
    }

    public void cadastrar(Pessoa pessoa) {
        BancoDeDados bd = new BancoDeDados();
        bd.salvar(pessoa);
    }

    public void listar(HttpServletRequest req, HttpServletResponse res) {
        BancoDeDados bd = new BancoDeDados();
        List<Pessoa> pessoas = bd.listar();

        //Aqui, estamos passando em um atributo da request um Map (chave, valor);
        req.setAttribute("pessoas", bd.listar());
        req.setAttribute("titulo", "Página de Listagem de Pessoas");

        try {
            req.getRequestDispatcher("WEB-INF/view/lista-pessoas.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void remover(String id) {
//        implemetar remover
    }

    private void alterar(String id) {
//        implementar alterar
    }
}
