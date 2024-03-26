package br.com.ufrj.aula10.contas;

public abstract class ContaAbstrata {
    protected String numero;
    protected double saldo;

    public ContaAbstrata(String numero){
        this.numero = numero;
        saldo = 0;
    }

    public abstract void debitar(double valor);

    public void creditar(double valor) {
        saldo = saldo + valor;
        System.out.println("R$ "+ valor + " foram creditados na sua conta!");
    }

    public String numero(){
        return numero;
    }

    public double saldo(){
        return saldo;
    }
}
