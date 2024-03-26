package br.com.ufrj.aula10.principal;

import br.com.ufrj.aula10.bancos.*;
import br.com.ufrj.aula10.contas.*;

public class TesteBancoArray {
    public static void main(String[] args) {
        ContaAbstrata conta = new Conta("08.2021-1");
        ContaAbstrata contaImposto = new ContaImposto("08.2021-2");
        ContaAbstrata contaPoupanca = new ContaPoupanca("08.2021-3");
        ContaAbstrata contaEspecial = new ContaEspecial("08.2021-4");
        BancoArray meuBanco = new BancoArray();

        // Creditando 500 reais em todas as contas
        conta.creditar(500);
        contaImposto.creditar(500);
        contaPoupanca.creditar(500);
        contaEspecial.creditar(500);
        System.out.println();

        // Cadastrando todas as contas no meuBanco
        meuBanco.cadastrar(conta);
        meuBanco.cadastrar(contaImposto);
        meuBanco.cadastrar(contaPoupanca);
        meuBanco.cadastrar(contaEspecial);
        System.out.println();

        // Agora há 4 contas no Banco, e um saldo total de 2.000 reais
        meuBanco.numeroContas();
        meuBanco.saldoTotal();

    }
}