package br.com.ufrj.sisloc.implementação;

public class Reserva extends Operacao{
    private int prioridade;

    // Construtor
    public Reserva(long cpf, int codigo) {
        super(cpf, codigo);
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return this.prioridade;
    }
}
