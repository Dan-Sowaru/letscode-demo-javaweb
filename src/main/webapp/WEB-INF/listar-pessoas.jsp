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

    <%-- out.println() é o mesmo que <%=    --%>
    <% out.println(titulo); %>

    <%--precisa fazer o cast porque o request não sabe o formato que está recebendo.--%>
    <% List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas"); %>


    <%
        for(Pessoa pessoa : pessoas) {
    %>
        <ul>
            <li>Nome: <%= pessoa.getNome() %></li>
            <li>Sobrenome: <%= pessoa.getSobrenome() %></li>
            <li>Idade: <%= pessoa.getIdade() %></li>
            <li>Data: <%= pessoa.getData() %></li>
        </ul>
    <%
        }
    %>
    </body>
</html>

