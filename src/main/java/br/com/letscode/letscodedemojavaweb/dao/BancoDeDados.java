package br.com.letscode.letscodedemojavaweb.dao;

import br.com.letscode.letscodedemojavaweb.modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa) {
        BancoDeDados.pessoas.add(pessoa);
    }

    public List<Pessoa> listar() {
        return BancoDeDados.pessoas;
    }

}
