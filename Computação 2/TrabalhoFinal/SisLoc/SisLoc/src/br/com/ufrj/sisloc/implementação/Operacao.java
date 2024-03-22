package br.com.ufrj.sisloc.implementação;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operacao {
    private Date data;
    private long cpf;
    private int codigo;
    private boolean ativo;

    // Construtor
    public Operacao(long cpf, int codigo) {
        data = new Date();
        this.cpf = cpf;
        this.codigo = codigo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return this.data;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    /* Método que imprime um resumo da operação, isto é, seus atributos  */
    public void imprimir() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nCódigo: " + this.codigo  + "\nData: " + df.format(this.data) + "\nAtiva: " + this.ativo);
    }
}