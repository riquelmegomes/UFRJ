package br.com.ufrj.aula8.contas;

public class Conta {
    protected String numero;
    protected double saldo;

    public Conta(String numero){
        this.numero = numero;
        saldo = 0;
    }
    public void creditar(double valor){
        saldo = saldo + valor;
    }
    public void debitar(double valor){
        if (valor <= saldo) saldo = saldo - valor;
        else System.out.println("Saldo insuficiente!");
    }
    public String numero(){
        return numero;
    }
    public double saldo(){
        return saldo;
    }
}