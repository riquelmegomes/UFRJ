package br.com.ufrj.sisloc.interfaces;

import br.com.ufrj.sisloc.implementação.Cliente;
import java.util.Vector;

public interface IRepositorioCliente {
    void cadastrar(Cliente cliente);
    Cliente buscar(long cpf);
    void atualizar(Cliente cliente);
    void deletar(long cpf);
    Vector<Cliente> listar();
}