package br.com.ufrj.sisloc.interfaces;

import br.com.ufrj.sisloc.implementação.Locacao;
import br.com.ufrj.sisloc.implementação.Operacao;
import br.com.ufrj.sisloc.implementação.Reserva;

import java.util.Vector;

public interface IRepositorioOperacao {
    void cadastrar(Operacao operacao);
    Vector<Reserva> buscarReservas(long cpf);
    Vector<Locacao> buscarLocacoes(long cpf);
    void deletarReserva(long cpf, int codigo);
    void deletarLocacao(long cpf, int codigo);
    Vector<Locacao> listarLocacoes(long cpf);
    int numeroLocacoes(long cpf);
    int numeroLocacoes(int codigo);
    int numeroLocacoesAtivas(long cpf);
    int numeroLocacoesAtivas(int codigo);
    int numeroReservas(int codigo);

    Vector<Reserva> buscarReservasAtivas(int codigo);
}
