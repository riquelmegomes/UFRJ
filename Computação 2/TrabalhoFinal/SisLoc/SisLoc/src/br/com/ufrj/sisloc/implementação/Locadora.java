package br.com.ufrj.sisloc.implementação;

import br.com.ufrj.sisloc.interfaces.IRepositorioCliente;
import br.com.ufrj.sisloc.interfaces.IRepositorioFilme;
import br.com.ufrj.sisloc.interfaces.IRepositorioOperacao;

import java.util.Vector;

public class Locadora {
    private final IRepositorioFilme filmes;
    private final IRepositorioCliente clientes;
    private final IRepositorioOperacao operacoes;

    // Construtor
    public Locadora(IRepositorioCliente clientes, IRepositorioFilme filmes, IRepositorioOperacao operacoes) {
        this.filmes = filmes;
        this.clientes = clientes;
        this.operacoes = operacoes;
    }

    /* Método responsável pelo cadastro de clientes. Restrição: o sistema não deve permitir o cadastro de clientes
    com o mesmo CPF */
    public void cadastrarCliente(Cliente cliente) {
        this.clientes.cadastrar(cliente);
    }


    /* Método responsável por recuperar um cliente do cadastro ou retornar null em caso não exista */
    public Cliente buscarCliente(long cpf) {
        return this.clientes.buscar(cpf);
    }


    /* Método responsável por atualizar o cadastro de um cliente, caso este já esteja cadastrado */
    public void atualizarCadastroCliente(Cliente cliente) {
        this.clientes.atualizar(cliente);
    }


    /* Método responsável por excluir o cadastro de um cliente particular. Restrição: só podem ser removidos do
    cadastro os clientes que não possuem locações ativas */
    public void removerCliente(long cpf) {
        if((this.operacoes.buscarLocacoes(cpf)).isEmpty()) {
            this.clientes.deletar(cpf);
        }
        else System.out.println("Erro! Este cliente não pode ser removido pois possui locação ativa.");
    }


    /* Método responsável pelo cadastro de filmes. Restrição: o sistema não deve permitir o cadastro de filmes com o
    mesmo código */
    public void cadastrarFilme(Filme filme) {
        this.filmes.cadastrar(filme);
    }


    /* Método responsável por recuperar um filme do cadastro ou retornar null em caso contrário */
    public Filme buscarFilme(int codigo) {
        return this.filmes.buscar(codigo);
    }


    /* Método responsável por atualizar o cadastro de um filme, caso este já esteja cadastrado */
    public void atualizarCadastroFilme(Filme filme) {
        this.filmes.atualizar(filme);
    }


    /* Método responsável por excluir o cadastro de um filme particular. Restrição: só podem ser removidos do cadastro
    os filmes que não possuem locações ativas */
    public void removerFilme(int codigo) {
        Filme filme = this.filmes.buscar(codigo);
        if(filme != null) {
            if (this.operacoes.numeroLocacoesAtivas(codigo) == 0)  this.filmes.deletar(codigo);
            else System.out.println("Erro! Este filme não pode ser removido pois possui locação ativa.");
        }
        else System.out.println("Desculpe, este filme não está cadastrado em nosso sistema.");
    }


    /* Método responsável por realizar a reserva de um determinado filme para um cliente específico. Restrição: só
    podem ser feitas reservas de filmes cadastrados para clientes cadastrados e se não houver cópias do filme
    disponíveis */
    public void reservarFilme(long cpf, int codigo) {
        Cliente cliente = this.clientes.buscar(cpf);
        Filme filme = this.filmes.buscar(codigo);
        int NumeroLocacoesAtivas = this.operacoes.numeroLocacoesAtivas(codigo);

        if((cliente != null) && (filme != null)) {
            if(NumeroLocacoesAtivas == filme.getNumeroCopias()) {
                Operacao reserva = new Reserva(cpf, codigo);
                this.operacoes.cadastrar(reserva);
                System.out.println("Filme reservado com sucesso!");
            }
            else System.out.println("Desculpe, não é possível reservar o filme pois ainda há cópias dele disponíveis.");
        }
        else System.out.println("Erro! Cliente ou filme não cadastrado no sistema.");
    }


    /* Método responsável por alterar o status da reserva de ativa para inativa. Restrição: só podem ser finalizadas
    reservas existentes, isto é, reservas previamente cadastradas de um determinado filme para um cliente específico */
    public void finalizarReservaFilme(long cpf, int codigo) {
        Cliente cliente = this.clientes.buscar(cpf);
        Filme filme = this.filmes.buscar(codigo);

        if((cliente != null) && (filme != null)) {
            this.operacoes.deletarReserva(cpf, codigo);
        }
        else System.out.println("Erro! Cliente ou Filme não cadastrado no sistema.");
    }


    /* Método responsável por realizar a Locação de um filme para um determinado cliente. Restrições: a locação só pode
    ser feita se, ambos, o filme e o cliente forem cadastrados, o filme estiver disponível e se não existir reservas
    ou, no caso de existir reservas, a reserva mais antiga ser a do cliente que deseja realizar a locação */
    public void locarFilme(long cpf, int codigo) {
        Cliente cliente = this.clientes.buscar(cpf);
        Filme filme = this.filmes.buscar(codigo);
        int numLocacoesAtivas = this.operacoes.numeroLocacoesAtivas(codigo);

        if((cliente != null) && (filme != null) && (filme.getNumeroCopias() > numLocacoesAtivas)) {
            if(this.operacoes.numeroReservas(codigo) == 0) {
                Operacao locacao = new Locacao(cpf, codigo);
                this.operacoes.cadastrar(locacao);
                System.out.println("Filme locado com sucesso!");
            }
            else {
                Reserva primeiraReservaAtiva = this.operacoes.buscarReservasAtivas(codigo).get(0);
                if(primeiraReservaAtiva.getCpf() == cpf) {
                    primeiraReservaAtiva.setAtivo(false);
                    Operacao locacao = new Locacao(cpf, codigo);
                    this.operacoes.cadastrar(locacao);
                    System.out.println("Filme locado com sucesso!");
                }
                else System.out.println("Desculpe, este filme está esgotado no momento.");
            }
        }
        else System.out.println("Desculpe! Não foi possível realizar a locação do filme. Verifique se o cliente " +
                "e o filme estão cadastrados, assim como a disponibilidade do filme em questão.");
    }


    /* Método responsável por realizar a devolução de um filme feita por um determinado cliente. Restrição: a devolução
     só pode ser feita se, ambos, o filme e o cliente forem cadastrados e se a locação existir */
    public void devolverFilme(long cpf, int codigo) {
        Cliente cliente = this.clientes.buscar(cpf);
        Filme filme = this.filmes.buscar(codigo);

        if((cliente != null) && (filme != null)) {
            this.operacoes.deletarLocacao(cpf, codigo);
        }
        else System.out.println("Erro! Cliente ou Filme não cadastrado no sistema.");
    }


    /* Método responsável por imprimir o histórico de locações realizadas por um determinado cliente. Restrição: o
    cliente precisa estar cadastrado */
    public void imprimirHistoricoLocacoes(long cpf) {
        if(this.clientes.buscar(cpf) != null) {
            Vector<Locacao> locacoesDoCliente = this.operacoes.listarLocacoes(cpf);
            if(!locacoesDoCliente.isEmpty()) {
                System.out.println("\nHistórico de locações:");
                for(Locacao locacao : locacoesDoCliente) {
                    locacao.imprimir();
                }
            }
            else System.out.println("O cliente ainda não tem locacoes.");
        }
        else System.out.println("Erro! Cliente não cadastrado no sistema.");
    }

    /* Método responsável por ordenar, em um vector, os filmes pelo seu número de locações */
    public Vector<Filme> encontrarFilmesMaisLocados() {
        Vector<Filme> filmesCadastrados = this.filmes.listar();
        Vector<Filme> filmesMaisAlocados = new Vector<>();

        if (filmesCadastrados.isEmpty()) {
            System.out.println("Ainda não há nenhum filme cadastrado.");
        }
        else {
            for (Filme filme : filmesCadastrados) {
                int numLocacoes = this.operacoes.numeroLocacoes(filme.getCodigo());

                // Adiciona os filmes mais alocados ao vector em ordem decrescente
                if (numLocacoes > 0) {
                    if ((filmesMaisAlocados.isEmpty()) ||
                            (numLocacoes >= this.operacoes.numeroLocacoes(filmesMaisAlocados.get(0).getCodigo()))) {
                        filmesMaisAlocados.add(0, filme);
                    }
                    else {
                        for (Filme f : filmesMaisAlocados) {
                            if (numLocacoes >= this.operacoes.numeroLocacoes(f.getCodigo())) {
                                filmesMaisAlocados.add(filmesMaisAlocados.indexOf(f), filme);
                                break;
                            }
                            else if (f == filmesMaisAlocados.lastElement()) {
                                filmesMaisAlocados.add(filme);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return filmesMaisAlocados;
    }

    /* Método responsável por imprimir a lista dos filmes mais locados pela locadora, onde o tamanho da lista é
    indicado pelo argumento int top. */
    public void imprimirFilmesMaisLocados(int top) {
        Vector<Filme> filmesMaisAlocados = encontrarFilmesMaisLocados();

        if(filmesMaisAlocados.size() == 0) {
            System.out.println("Ainda nenhum filme foi locado.");
        }
        else {
            System.out.println(top + " FILMES MAIS LOCADOS:\n");

            // Imprime os 'top' filmes mais locados em ordem.
            for (int i = 0; i < top; i++) {
                System.out.println((i + 1) + "º LUGAR:");
                filmesMaisAlocados.get(i).imprimir();
                System.out.println();

                if ((top > filmesMaisAlocados.size()) && (filmesMaisAlocados.get(i) == filmesMaisAlocados.lastElement())) {
                    System.out.println("Por enquanto somente estes filmes foram locados.");
                    break;
                }
            }
        }
    }
}