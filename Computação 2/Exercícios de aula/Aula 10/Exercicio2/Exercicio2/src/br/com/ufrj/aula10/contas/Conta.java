package br.com.ufrj.aula10.contas;

public class Conta extends ContaAbstrata {

    public Conta (String numero){
        super(numero);
    }

    public void debitar(double valor){
        if (valor <= super.saldo()) {
            saldo = saldo - valor;
            System.out.println("R$ "+ valor + " foram debitados da sua conta!");
        }
        else System.out.println("Saldo insuficiente!");
    }
}