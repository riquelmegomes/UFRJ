package br.com.ufrj.aula9.contas;

public class ContaEspecial extends Conta {

    private double bonus;

    public ContaEspecial(String numero){
        super(numero);
        bonus = 0;
    }

    public void renderBonus(){
        System.out.println("Parabéns! Você rendeu um bônus de R$"+ bonus +" na sua conta!");
        super.creditar(bonus);
        bonus = 0;
    }

    public void creditar(double valor){
        double taxaDeBonus = 0.01;
        super.creditar(valor);
        bonus += (valor * taxaDeBonus);
        System.out.println("Parabéns! Agora sua ContaEspecial " +
                "possui um bônus de R$ "+ bonus);
    }
}