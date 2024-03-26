package br.com.ufrj.aula10.bancos;

import br.com.ufrj.aula10.contas.*;
import br.com.ufrj.aula10.interfaces.IBanco;

import java.util.Vector;

public class BancoVector implements IBanco {
    final private Vector<ContaAbstrata> contas;

    // CONSTRUTOR DE BANCO VECTOR
    public BancoVector() {
        contas = new Vector<>();
    }

    // MÉTODO SALDO TOTAL
    public double saldoTotal() {
        double somatorio = 0;

        for(ContaAbstrata c : contas) {
            somatorio += c.saldo();
        }
        System.out.println("R$ "+ somatorio + " é o saldo total nesse banco");
        return somatorio;
    }

    // MÉTODO NUMERO DE CONTAS
    public int numeroContas() {
        int total = contas.size();
        System.out.println("O número de contas nesse banco é: "+ total);
        return total;
    }

    // MÉTODO CADASTRAR
    public void cadastrar(ContaAbstrata conta) {
        contas.add(conta);
        System.out.println("Conta cadastrada no banco com sucesso!");
    }

    // MÉTODO PROCURAR
    private ContaAbstrata procurar(String numero) {
        for (ContaAbstrata c : contas) {
            if (c.numero().equals(numero)) return c;
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