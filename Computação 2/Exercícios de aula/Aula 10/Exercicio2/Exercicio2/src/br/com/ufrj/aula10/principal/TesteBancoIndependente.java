package br.com.ufrj.aula10.principal;

import br.com.ufrj.aula10.auditores.AuditorBancoGenerico;
import br.com.ufrj.aula10.bancos.*;
import br.com.ufrj.aula10.contas.*;

public class TesteBancoIndependente {
    public static void main(String[] args) {
        ContaAbstrata conta = new Conta("08.2021-1");
        ContaAbstrata contaImposto = new ContaImposto("08.2021-2");
        ContaAbstrata contaPoupanca = new ContaPoupanca("08.2021-3");
        ContaAbstrata contaEspecial = new ContaEspecial("08.2021-4");
        AuditorBancoGenerico auditor = new AuditorBancoGenerico();
        VectorContas repositorio = new VectorContas();
        BancoIndependente meuBanco = new BancoIndependente(repositorio);


        // Cadastrando todas as contas no BancoIndependente
        meuBanco.cadastrar(conta);
        meuBanco.cadastrar(contaImposto);
        meuBanco.cadastrar(contaPoupanca);
        meuBanco.cadastrar(contaEspecial);
        System.out.println();

        // Creditando 500 reais em todas as contas
        meuBanco.creditar("08.2021-1",500);
        meuBanco.creditar("08.2021-2", 500);
        meuBanco.creditar("08.2021-3", 500);
        meuBanco.creditar("08.2021-4", 500);
        meuBanco.numeroContas();
        meuBanco.saldoTotal();
        System.out.println();

        // Removendo a contaImposto do BancoIndependente
        meuBanco.remover("08.2021-2");
        System.out.println();

        // Debitando 500 da ContaPoupanaa, que ficará com saldo igual a 0
        meuBanco.debitar("08.2021-3", 500);
        System.out.println();

        // Transferindo 250 reais da Conta para a ContaPoupanca
        meuBanco.transferir("08.2021-1","08.2021-3", 250);
        System.out.println();

        // Vendo saldo na ContaPoupanca após a transferência
        meuBanco.saldo("08.2021-3");
        System.out.println();

        // Rendendo juros na ContaPoupanca
        meuBanco.renderJuros("08.2021-3");
        System.out.println();

        // Rendendo bônus na ContaEspecial
        meuBanco.renderBonus("08.2021-4");
        System.out.println();

        // Auditando BancoIndependente
        auditor.auditar(meuBanco);
    }
}
