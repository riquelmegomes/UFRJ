package br.com.ufrj.aula9.bancos;

import br.com.ufrj.aula9.contas.*;

public class BancoArray {
    final private ContaAbstrata[] contas;
    private int indice = 0;


    // CONSTRUTOR DE BANCOARRAY
    public BancoArray() {
        contas = new ContaAbstrata[100];
    }

    // MÉTODO CADASTRAR
    public void cadastrar(ContaAbstrata conta) {
        contas[indice] = conta;
        System.out.println("Conta cadastrada no banco com sucesso!");
        indice++;
    }

    // MÉTODO PROCURAR
    private ContaAbstrata procurar(String numero){
        int i = 0;
        while (i < indice) {
            if (contas[i].numero().equals(numero)) return contas[i];
            else i++;
        }
        return null;
    }

    // MÉTODO DEBITAR
    public void debitar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null)  conta.debitar(valor);
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO CREDITAR
    public void creditar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) conta.creditar(valor);
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO TRANSFERIR
    public void transferir(String numero1, String numero2, double valor) {
        ContaAbstrata conta1 = procurar(numero1), conta2 = procurar(numero2);
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
    public void saldo(String numero) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            System.out.println("O saldo dessa conta é: R$ "+ conta.saldo());
            conta.saldo();
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO RENDER JUROS
    public void renderJuros(String numero){
        double taxaDeJuros = 0.1;
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaPoupanca) ((ContaPoupanca) conta).renderJuros(taxaDeJuros);
            else System.out.println("Desculpe, essa não é uma conta poupança!");
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO RENDER BÔNUS
    public void renderBonus(String numero){
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaEspecial) ((ContaEspecial) conta).renderBonus();
            else System.out.println("Desculpe, essa não é uma conta especial!");
        }
        else System.out.println("Conta Inexistente!");
    }
}
