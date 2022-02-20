package br.com.letscode.letscodedemojavaweb.modelo.acao;

public class CadastrarPessoasForm {


    //    retorna a String do endereço pra que o Controlador faça sua parte que é redirecionar. Não cabe ao Model redirecionar.
    public String executar() {
//            res.sendRedirect("WEB-INF/formulario.html");  <- essa não funciona pra quem ta dentro do WEB-INF,
//            porque TomCat Bloqueia acesso externo e sendRedirect só redireciona (escreve na URL do browser)
        return "forward:formulario.html";

    }
}
