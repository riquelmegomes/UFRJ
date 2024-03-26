package br.com.ufrj.aula9.principal;

import br.com.ufrj.aula9.contas.*;
import br.com.ufrj.aula9.bancos.*;

public class TesteBancoVector {
    public static void main(String[] args) {
        ContaAbstrata conta = new Conta("08.2021-1");
        ContaAbstrata contaImposto = new ContaImposto("08.2021-2");
        ContaAbstrata contaPoupanca = new ContaPoupanca("08.2021-3");
        ContaAbstrata contaEspecial = new ContaEspecial("08.2021-4");
        BancoVector meuBanco = new BancoVector();

        // Conta
        meuBanco.cadastrar(conta);
        meuBanco.creditar("08.2021-1",1000);
        meuBanco.debitar("08.2021-1",500);
        meuBanco.saldo("08.2021-1");
        System.out.println();

        // ContaImposto
        meuBanco.cadastrar(contaImposto);
        meuBanco.creditar("08.2021-2",1000);
        meuBanco.debitar("08.2021-2",500);
        meuBanco.saldo("08.2021-2");
        System.out.println();

        // ContaPoupanca
        meuBanco.cadastrar(contaPoupanca);
        meuBanco.creditar("08.2021-3",1000);
        meuBanco.debitar("08.2021-3",500);
        meuBanco.renderJuros("08.2021-3");
        meuBanco.saldo("08.2021-3");
        System.out.println();

        // ContaEspecial
        meuBanco.cadastrar(contaEspecial);
        meuBanco.creditar("08.2021-4",1000);
        meuBanco.debitar("08.2021-4",500);
        meuBanco.saldo("08.2021-4");
        meuBanco.renderBonus("08.2021-4");
        meuBanco.saldo("08.2021-4");

    }
}
