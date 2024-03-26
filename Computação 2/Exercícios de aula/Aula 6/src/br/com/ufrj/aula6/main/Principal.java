package br.com.ufrj.aula6.main;

import br.com.ufrj.aula6.contas.*;

public class Principal {
    public static void main(String[] args) {
        Conta minhaConta1 = new Conta("02.2021-1");
        Conta minhaConta2 = new Conta("02.2021-2");
        BancoVector meuBanco = new BancoVector();

        // TESTE CLASSE CONTA
        System.out.println("Testando classe Conta:");
        System.out.println("O número da conta 1 é: "+ minhaConta1.numero());
        System.out.println("O número da conta 2 é: "+ minhaConta2.numero());
        minhaConta1.creditar(1000);
        minhaConta2.creditar(1000);
        System.out.println("1000 reais foram creditados na conta 1 e na conta 2");
        minhaConta1.debitar(500);
        System.out.println("500 reais foram debitados da conta 1");
        System.out.println("Saldo na conta 1: "+ minhaConta1.saldo());
        System.out.println("Saldo na conta 2: "+ minhaConta2.saldo());

        // TESTE CLASSE BANCO (COM VECTOR)
        System.out.println("\nTestando classe BancoVector:");

        // CADASTRANDO CONTAS NO BANCO
        meuBanco.cadastrar(minhaConta1);
        System.out.println("Conta 1 cadastrada no banco!");
        meuBanco.cadastrar(minhaConta2);
        System.out.println("Conta 2 cadastrada no banco!");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("02.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("02.2021-2"));

        // CREDITANDO E DEBITANDO VALORES
        meuBanco.creditar("02.2021-1", 1500);
        System.out.println("1500 reais foram creditados na conta 1");
        meuBanco.debitar("02.2021-1", 1000);
        System.out.println("1000 reais foram debitados da conta 1");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("02.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("02.2021-2"));

        // TRANSFERINDO VALORES
        meuBanco.transferir("02.2021-1", "02.2021-2", 1000);
        System.out.println("Foram transferidos 1000 reais da conta 1 para a conta 2");
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("02.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("02.2021-2"));
    }
}
