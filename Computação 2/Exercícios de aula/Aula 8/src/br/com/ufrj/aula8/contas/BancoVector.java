package br.com.ufrj.aula8.contas;

import java.util.Vector;

public class BancoVector {
    private Vector<Conta> vetorContas;
    private int indice = 0;
    private double taxaDeJuros = 0.1;
    private double bonus;
    private double taxaDeBonus = 0.01;

    // MÉTODO BANCO COM VECTOR
    public BancoVector() {
        vetorContas = new Vector<>(100);
    }

    // MÉTODO CADASTRAR
    public void cadastrar(Conta conta) {
        vetorContas.add(conta);
        indice++;
    }

    // MÉTODO PROCURAR
    private Conta procurar(String numero) {
        for (int i = 0; i < indice; i++) {
            if (vetorContas.get(i).numero().equals(numero)) return vetorContas.get(i);
        }
        return null;
    }

    // MÉTODO DEBITAR
    public void debitar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) {
            if (valor <= conta.saldo()) conta.debitar(valor);
            else System.out.println("Saldo insuficiente!");
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO CREDITAR
    public void creditar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
            if(conta instanceof ContaEspecial) bonus += (valor * taxaDeBonus);
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO TRANSFERIR
    public void transferir(String numero1, String numero2, double valor) {
        Conta conta1 = procurar(numero1), conta2 = procurar(numero2);
        if (conta1 != null && conta2 != null) {
            if (valor <= conta1.saldo()) {
                conta1.debitar(valor);
                conta2.creditar(valor);
            }
            else System.out.println("Saldo insuficiente!");
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO SALDO
    public double saldo(String numero) {
        Conta conta = procurar(numero);
        if (conta != null) return conta.saldo();
        else System.out.println("Conta Inexistente!");
        return 0;
    }

    // MÉTODO RENDER JUROS
    public void renderJuros(String numero){
        Conta conta = procurar(numero);
        if (conta != null) creditar(numero, saldo(numero)*taxaDeJuros);
        else System.out.println("Conta Inexistente!");
    }

    public void renderBonus(String numero){
        Conta conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaEspecial) {
                System.out.println("Parabéns! Você rendeu um bônus de R$"+ bonus +" na sua conta!");
                creditar(numero, bonus);
                bonus = 0;
            }
            else System.out.println("Desculpe, essa não é uma conta especial!");
        }
        else System.out.println("Conta Inexistente!");
    }
}
