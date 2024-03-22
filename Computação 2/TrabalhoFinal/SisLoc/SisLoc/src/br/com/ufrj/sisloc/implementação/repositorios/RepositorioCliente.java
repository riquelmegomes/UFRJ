package br.com.ufrj.sisloc.implementação.repositorios;

import br.com.ufrj.sisloc.implementação.Cliente;
import br.com.ufrj.sisloc.interfaces.IRepositorioCliente;
import java.util.Vector;

public class RepositorioCliente implements IRepositorioCliente {
    private final Vector<Cliente> clientes;

    // Construtor
    public RepositorioCliente() {
        clientes = new Vector<>();
    }

    @Override
    /* Método responsável por cadastrar um cliente. Restrição: não são cadastrados clientes com o mesmo CPF, isto é o
    CPF é um identificador único. */
    public void cadastrar(Cliente cliente) {
        Cliente clienteBuscado = buscar(cliente.getCpf());
        if(clienteBuscado == null) {
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }
        else System.out.println("Erro! Cliente já cadastrado em nosso sistema.");
    }

    @Override
    /* Método responsável por procurar um cliente pelo seu CPF. Retorna o cliente solicitado ou null em caso contrário  */
    public Cliente buscar(long cpf) {
        for(Cliente cliente : clientes) {
            if(cliente.getCpf() == cpf) return cliente;
        }
        return null;
    }

    @Override
    /* Método responsável por fazer a atualização do cliente. Restrição: a atualização só ocorre se o cliente já
    estiver cadastrado. */
    public void atualizar(Cliente cliente) {
        if(buscar(cliente.getCpf()) != null) {
            for(int i = 0; i < clientes.size(); i++) {
                if(clientes.get(i).getCpf() == cliente.getCpf()) {
                    clientes.set(i, cliente);
                    System.out.println("Cliente atualizado com sucesso!");
                }
            }
        }
        else System.out.println("Erro! Cliente não encontrado.");
    }

    @Override
    /* Método responsável por deletar um cliente. Restrição: o cliente só é deletado se já estiver cadastrado. */
    public void deletar(long cpf) {
        Cliente clienteBuscado = buscar(cpf);
        if(clienteBuscado != null) {
            clientes.remove(clienteBuscado);
            System.out.println("Cliente removido com sucesso!");
        }
        else System.out.println("Erro! Cliente não cadastrado em nosso sistema.");
    }

    @Override
    /* Método responsável por retornar a lista de todos os clientes cadastrados. */
    public Vector<Cliente> listar() {
        return clientes;
    }
}
