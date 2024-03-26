package br.com.ufrj.aula10.bancos;

import br.com.ufrj.aula10.contas.*;
import br.com.ufrj.aula10.interfaces.IBanco;

public class BancoArray implements IBanco {
    final private ContaAbstrata[] contas;
    private int indice = 0;

    // CONSTRUTOR DE BANCOARRAY
    public BancoArray() {
        contas = new ContaAbstrata[100];
    }

    // MÉTODO SALDO TOTAL
    public double saldoTotal() {
        double somatorio = 0;

        for(ContaAbstrata c : contas) {
            if(c != null) somatorio += c.saldo();
            else break;
        }
        System.out.println("R$ "+ somatorio + " é o saldo total nesse banco");
        return somatorio;
    }

    // MÉTODO NUMERO DE CONTAS
    public int numeroContas() {
        System.out.println("O número de contas nesse banco é: "+ indice);
        return indice;
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
        System.out.println("Conta não encontrada");
        return null;
    }

    // MÉTODO DEBITAR
    public void debitar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null)  conta.debitar(valor);
    }

    // MÉTODO CREDITAR
    public void creditar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) conta.creditar(valor);
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
    }

    // MÉTODO SALDO
    public void saldo(String numero) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            System.out.println("O saldo dessa conta é: R$ "+ conta.saldo());
            conta.saldo();
        }
    }

    // MÉTODO RENDER JUROS
    public void renderJuros(String numero){
        double taxaDeJuros = 0.1;
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaPoupanca) ((ContaPoupanca) conta).renderJuros(taxaDeJuros);
            else System.out.println("Desculpe, essa não é uma conta poupança!");
        }
    }

    // MÉTODO RENDER BÔNUS
    public void renderBonus(String numero){
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaEspecial) ((ContaEspecial) conta).renderBonus();
            else System.out.println("Desculpe, essa não é uma conta especial!");
        }
    }
}
