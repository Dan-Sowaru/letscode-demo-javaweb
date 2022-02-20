package br.com.letscode.letscodedemojavaweb.modelo.acao;

import br.com.letscode.letscodedemojavaweb.dao.BancoDeDados;
import br.com.letscode.letscodedemojavaweb.modelo.Pessoa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListarPessoas {

    private final HttpServletRequest req;
    private final HttpServletResponse res;

    public ListarPessoas(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    public String executar() {

        BancoDeDados bd = new BancoDeDados();
        List<Pessoa> pessoas = bd.listar();

        //Aqui, estamos passando em um atributo da request um Map (chave, valor);
        req.setAttribute("pessoas", bd.listar());
        req.setAttribute("titulo", "Página de Listagem de Pessoas");

        return "forward:lista-pessoas.jsp";
    }
}
