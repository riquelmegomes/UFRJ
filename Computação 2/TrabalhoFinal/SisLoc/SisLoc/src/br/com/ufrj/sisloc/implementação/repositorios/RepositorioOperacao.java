package br.com.ufrj.sisloc.implementação.repositorios;

import br.com.ufrj.sisloc.interfaces.IRepositorioOperacao;
import br.com.ufrj.sisloc.implementação.Reserva;
import br.com.ufrj.sisloc.implementação.Locacao;
import br.com.ufrj.sisloc.implementação.Operacao;
import java.util.Vector;

public class RepositorioOperacao implements IRepositorioOperacao {
    private final Vector<Operacao> operacoes;

    // Construtor
    public RepositorioOperacao() {
        operacoes = new Vector<>();
    }

    @Override
    /* Método responsável por cadastrar operações de reserva ou locação, e alterar status da locação para ativo. */
    public void cadastrar(Operacao operacao) {
        if(!operacoes.contains(operacao)) {
            operacoes.add(operacao);
            operacao.setAtivo(true);
        }
        else System.out.println("Erro! Operação já cadastrada em nosso sistema.");
    }

    @Override
    /* Método responsável por procurar reservas ativas realizadas pelo cliente que possui um determinado CPF. */
    public Vector<Reserva> buscarReservas(long cpf) {
        Vector<Reserva> reservasAtivas = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Reserva) && (operacao.getCpf() == cpf) && (operacao.isAtivo())) {
                reservasAtivas.add((Reserva) operacao);
            }
        }
        return reservasAtivas;
    }

    @Override
    /* Método responsável por procurar as locações ativas realizadas pelo cliente que possui um determinado CPF. */
    public Vector<Locacao> buscarLocacoes(long cpf) {
        Vector<Locacao> locacoesAtivas = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Locacao) && (operacao.getCpf() == cpf) && (operacao.isAtivo())) {
                locacoesAtivas.add((Locacao) operacao);
            }
        }
        return locacoesAtivas;
    }

    @Override
    /* Método responsável por alterar o status da reserva do filme de código específico por um cliente de CPF
    particular como inativa. */
    public void deletarReserva(long cpf, int codigo) {
        Vector<Reserva> reservasAtivas = buscarReservas(cpf);
        if(!reservasAtivas.isEmpty()) {
            for(Reserva reserva : reservasAtivas) {
                if((reserva.getCpf() == cpf) && (reserva.getCodigo() == codigo)) {
                    reserva.setAtivo(false);
                    System.out.println("Reserva finalizada com sucesso!");
                }
                else System.out.println("Desculpe, não há reservas com esse código.");
            }
        }
        else System.out.println("Desculpe, não há reservas ativas para esse cpf.");
    }

    @Override
    /* Método responsável por alterar o status da locação do filme de código específico por um cliente de CPF
    particular como inativa. */
    public  void deletarLocacao(long cpf, int codigo) {
        Vector<Locacao> locacoesAtivas = buscarLocacoes(cpf);
        if(!locacoesAtivas.isEmpty()) {
            for(Locacao locacao : locacoesAtivas) {
                if((locacao.getCpf() == cpf) && (locacao.getCodigo() == codigo)) {
                    locacao.setAtivo(false);
                    System.out.println("Filme devolvido com sucesso!");
                }
                else System.out.println("Desculpe, não há locações com esse código.");
            }
        }
        else System.out.println("Desculpe, não há locações ativas para esse cpf.");
    }

    @Override
    /* Método responsável por listar todas as locações (ativas e inativas) realizadas pelo cliente que possui
    um determinado CPF. */
    public Vector<Locacao> listarLocacoes(long cpf) {
        Vector<Locacao> locacoesPeloCpf = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Locacao) && (operacao.getCpf() == cpf)) {
                locacoesPeloCpf.add((Locacao) operacao);
            }
        }
        return locacoesPeloCpf;
    }

    @Override
    /* Método que retorna o número total de locações(ativas e inativas) realizadas por um cliente de CPF específico. */
    public int numeroLocacoes(long cpf) {
        return listarLocacoes(cpf).size();
    }

    @Override
    /* Método que retorna o número total de locações (ativas e inativas) que foram feitas do filme de código
    particular. */
    public  int numeroLocacoes(int codigo) {
        Vector<Locacao> locacoesPeloCodigo = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Locacao) && (operacao.getCodigo() == codigo)) {
                locacoesPeloCodigo.add((Locacao) operacao);
            }
        }
        return locacoesPeloCodigo.size();
    }

    @Override
    /* Método que retorna o número total de locações ativas realizadas por um cliente de CPF específico. */
    public int numeroLocacoesAtivas(long cpf) {
        return buscarLocacoes(cpf).size();
    }

    @Override
    /* Método que retorna o número total de locações ativas que foram feitas do filme de código particular. */
    public int numeroLocacoesAtivas(int codigo) {
        Vector<Locacao> locacoesAtivas = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Locacao) && (operacao.getCodigo() == codigo) && (operacao.isAtivo())) {
                locacoesAtivas.add((Locacao) operacao);
            }
        }
        return locacoesAtivas.size();
    }

    @Override
    /* Método que retorna o número total de reservas ativas para o filme de código particular. */
    public int numeroReservas(int codigo) {
        Vector<Reserva> reservasAtivas = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Reserva) && (operacao.getCodigo() == codigo) && (operacao.isAtivo())) {
                reservasAtivas.add((Reserva) operacao);
            }
        }
        return reservasAtivas.size();
    }

    /*  Método que retorna as reservas ativas de um filme de código específico. */
    public Vector<Reserva> buscarReservasAtivas(int codigo) {
        Vector<Reserva> reservasAtivas = new Vector<>();
        for(Operacao operacao : operacoes) {
            if((operacao instanceof Reserva) && (operacao.getCodigo() == codigo) && (operacao.isAtivo())) {
                reservasAtivas.add((Reserva) operacao);
            }
        }
        return reservasAtivas;
    }

}