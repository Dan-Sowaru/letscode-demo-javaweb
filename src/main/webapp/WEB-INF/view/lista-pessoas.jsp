<%@ page import="br.com.letscode.letscodedemojavaweb.modelo.Pessoa" %>
<%@ page import="java.util.List" %>
<%
    String titulo = "Lista de Pessoas";
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Lista de Pessoas</title>
    </head>
    <body>

        <%--
         <% out.println(titulo) %>;
                        OU
                 <%= titulo %>

                 Ou ainda o h3 abaixo:
                 Lá na Request do Cadastro ele passa o atributo "titulo" na requisição e recebe aqui agora.
        --%>

        <h3> ${ titulo }</h3>

        <%--precisa fazer o cast porque o request não sabe o formato que está recebendo.--%>
        <% List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas"); %>

        <table width="500" border="1px">
            <tr>
                <th>NOME</th>
                <th>SOBRENOME</th>
                <th>IDADE</th>
                <th>DATA</th>
            </tr>


            <%
                for (Pessoa pessoa : pessoas) {
            %>
            <tr>
                <td><%= pessoa.getNome() %>
                </td>
                <td><%= pessoa.getSobrenome() %>
                </td>
                <td><%= pessoa.getIdade() %>
                </td>
                <td><%= pessoa.getData() %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <button onclick="window.location.href='/app/controlador?acao=cadastrar-pessoas-form'">
            CADASTRAR NOVO
        </button>
    </body>
</html>

