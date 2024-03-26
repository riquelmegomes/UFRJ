package br.com.ufrj.aula9.contas;

public class ContaImposto extends ContaAbstrata {

    public ContaImposto (String numero){
        super(numero);
    }

    public void debitar(double valor){
        double taxaDeImposto = 0.001;
        if (valor <= super.saldo()) {
            saldo = saldo - (valor + (valor * taxaDeImposto));
            System.out.println("Devido aos impostos, R$ "+ (valor + (valor * taxaDeImposto)) +
                    " foram debitados da sua ContaImposto!");
        }
        else System.out.println("Saldo insuficiente!");
    }
}