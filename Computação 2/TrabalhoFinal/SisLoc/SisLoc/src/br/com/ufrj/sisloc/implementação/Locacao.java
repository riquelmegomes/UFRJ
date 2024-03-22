package br.com.ufrj.sisloc.implementação;

public class Locacao extends Operacao{
    private int periodo;

    // Construtor
    public Locacao(long cpf, int codigo) {
        super(cpf, codigo);
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getPeriodo() {
        return this.periodo;
    }
}
