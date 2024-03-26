package br.com.ufrj.aula9.contas;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero){
        super(numero);
    }

    public void renderJuros(double taxa){
        double valorRecebido = saldo()*taxa;
        System.out.println("Parabéns! Você recebeu um valor de R$ "
                + valorRecebido + " na sua ContaPoupanca!");
        creditar(valorRecebido);
    }
}