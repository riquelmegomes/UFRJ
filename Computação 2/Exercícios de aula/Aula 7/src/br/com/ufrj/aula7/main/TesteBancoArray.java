package br.com.ufrj.aula7.main;

import br.com.ufrj.aula7.contas.*;

public class TesteBancoArray {
    public static void main(String[] args) {
        Conta minhaConta1 = new ContaPoupanca("04.2021-1");
        Conta minhaConta2 = new ContaPoupanca("04.2021-2");
        BancoArray meuBanco = new BancoArray();

        // TESTE CLASSE CONTA
        System.out.println("Testando classe Conta:");
        System.out.println("O numero da conta 1 é: "+ minhaConta1.numero());
        System.out.println("O numero da conta 2 é: "+ minhaConta2.numero());
        minhaConta1.creditar(1000);
        minhaConta2.creditar(1000);
        System.out.println("1000 reais foram creditados na conta 1 e na conta 2");
        minhaConta1.debitar(500);
        System.out.println("500 reais foram debitados da conta 1");
        System.out.println("Saldo na conta 1: "+ minhaConta1.saldo());
        System.out.println("Saldo na conta 2: "+ minhaConta2.saldo());

        // TESTE CLASSE BANCO (COM ARRAY)
        System.out.println("\nTestando classe BancoArray:");

        // CADASTRANDO CONTAS NO BANCO
        meuBanco.cadastrar(minhaConta1);
        System.out.println("Conta 1 cadastrada no banco!");
        meuBanco.cadastrar(minhaConta2);
        System.out.println("Conta 2 cadastrada no banco!");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("04.2021-2"));

        // CREDITANDO, DEBITANDO E TRANSFERINDO VALORES
        meuBanco.creditar("04.2021-1", 1500);
        System.out.println("1500 reais foram creditados na conta 1");
        meuBanco.debitar("04.2021-2", 500);
        System.out.println("500 reais foram debitados da conta 2");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("04.2021-2"));
        meuBanco.transferir("04.2021-1", "04.2021-2", 1000);
        System.out.println("Foram transferidos 1000 reais da conta 1 para a conta 2");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("04.2021-2"));

        // RENDENDO JUROS NAS CONTAS POUPANÇA, COM TAXA DE JUROS = 0,1
        if(minhaConta1 instanceof ContaPoupanca) {
            meuBanco.renderJuros("04.2021-1");
            System.out.println("\nSaldo com juros da conta 1: "+ meuBanco.saldo("04.2021-1"));
        }
        if(minhaConta2 instanceof ContaPoupanca) {
            meuBanco.renderJuros("04.2021-2");
            System.out.println("Saldo com juros da conta 2: " + meuBanco.saldo("04.2021-2"));
        }
    }
}