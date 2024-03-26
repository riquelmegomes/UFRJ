package br.com.ufrj.aula10.bancos;

import br.com.ufrj.aula10.contas.*;
import br.com.ufrj.aula10.interfaces.*;

public class BancoIndependente implements IBanco {
    final private IRepositorioConta contas;

    // Construtor
    public BancoIndependente(IRepositorioConta contas) {
        this.contas = contas;
    }

    public double saldoTotal() {
        ContaAbstrata[] arraySuporte = this.contas.listar();
        double somatorio = 0;

        for(ContaAbstrata c : arraySuporte) {
            somatorio += c.saldo();
        }
        System.out.println("R$ "+ somatorio + " é o saldo total nesse banco");
        return somatorio;
    }

    public int numeroContas() {
        int total = this.contas.numero();
        System.out.println("O número de contas nesse banco é: "+ total);
        return total;
    }

    public void cadastrar(ContaAbstrata conta) {
        this.contas.inserir(conta);
    }

    public void remover(String numero){
        this.contas.remover(numero);
    }

    private ContaAbstrata procurar(String numero) {
        return this.contas.procurar(numero);
    }

    public void debitar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null)  conta.debitar(valor);
    }

    public void creditar(String numero, double valor) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) conta.creditar(valor);
    }

    public void transferir(String origem, String destino, double valor) {
        ContaAbstrata conta1 = procurar(origem), conta2 = procurar(destino);
        if (conta1 != null && conta2 != null) {
            if (valor <= conta1.saldo()) {
                conta1.debitar(valor);
                conta2.creditar(valor);
            }
            else System.out.println("Saldo insuficiente!");
        }
    }

    public void saldo(String numero) {
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            System.out.println("O saldo dessa conta é: R$ "+ conta.saldo());
            conta.saldo();
        }
    }

    public void renderJuros(String numero){
        double taxaDeJuros = 0.1;
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaPoupanca) ((ContaPoupanca) conta).renderJuros(taxaDeJuros);
            else System.out.println("Desculpe, essa não é uma conta poupança!");
        }
    }

    public void renderBonus(String numero){
        ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            if(conta instanceof ContaEspecial) ((ContaEspecial) conta).renderBonus();
            else System.out.println("Desculpe, essa não é uma conta especial!");
        }
    }
}
