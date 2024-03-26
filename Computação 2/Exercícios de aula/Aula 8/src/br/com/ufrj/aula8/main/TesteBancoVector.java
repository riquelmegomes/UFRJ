package br.com.ufrj.aula8.main;

import br.com.ufrj.aula8.contas.*;

// RESPOSTA: Sim, foi necessário redefinir o método "creditar" das classes BancoArray e BancoVector,
// para que este método pudesse agora verificar se a conta é uma conta especial e ,em caso afirmativo,
// adicionar o bônus correspondente com base no valor creditado.

public class TesteBancoVector {
    public static void main(String[] args) {
        Conta minhaConta1 = new ContaEspecial("04.2021-1"); // CONTA ESPECIAL!!
        Conta minhaConta2 = new Conta("04.2021-2");
        BancoVector meuBanco = new BancoVector();

        // TESTE CLASSE CONTA
        System.out.println("Testando classe Conta:");
        System.out.println("O numero da conta 1(ESPECIAL) é: "+ minhaConta1.numero());
        System.out.println("O numero da conta 2 é: "+ minhaConta2.numero());
        minhaConta1.creditar(1000);
        minhaConta2.creditar(1000);
        System.out.println("*1000 reais foram creditados na conta 1 e na conta 2*");
        minhaConta1.debitar(500);
        System.out.println("*500 reais foram debitados da conta 1*");
        System.out.println("Saldo na conta 1: R$"+ minhaConta1.saldo());
        System.out.println("Saldo na conta 2: R$"+ minhaConta2.saldo());

        // TESTE CLASSE BANCO (COM VECTOR)
        System.out.println("\nTestando classe BancoVector:");

        // CADASTRANDO CONTAS NO BANCO
        meuBanco.cadastrar(minhaConta1);
        System.out.println("*Conta 1 cadastrada no banco!*");
        meuBanco.cadastrar(minhaConta2);
        System.out.println("*Conta 2 cadastrada no banco!*");
        System.out.println("Saldo na conta 1: R$"+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: R$"+ meuBanco.saldo("04.2021-2"));

        // CREDITANDO VALORES E ADQUIRINDO BÔNUS
        System.out.println("\n*1500 reais foram creditados na conta 1!*");
        meuBanco.creditar("04.2021-1", 1500);   // RECEBE BÔNUS
        System.out.println("*500 reais foram creditados na conta 2!*");
        meuBanco.creditar("04.2021-2", 500);  // NÃO RECEBE BÔNUS
        System.out.println("Saldo na conta 1: R$"+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: R$"+ meuBanco.saldo("04.2021-2"));

        // RENDENDO BÔNUS
        System.out.println("\n*A operação 'Render bônus' foi utilizada na conta 1!*");
        meuBanco.renderBonus("04.2021-1");
        System.out.println("\n*A operação 'Render bônus' foi utilizada na conta 2!*");
        meuBanco.renderBonus("04.2021-2");
        System.out.println("\nSaldo na conta 1: R$"+ meuBanco.saldo("04.2021-1"));
        System.out.println("Saldo na conta 2: R$"+ meuBanco.saldo("04.2021-2"));
    }
}