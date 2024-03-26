package br.com.ufrj.aula10.principal;

import br.com.ufrj.aula10.auditores.AuditorBancoGenerico;
import br.com.ufrj.aula10.bancos.*;
import br.com.ufrj.aula10.contas.Conta;
import br.com.ufrj.aula10.contas.ContaAbstrata;

public class Auditoria {

    public static void main(String[] args){
        AuditorBancoGenerico auditor = new AuditorBancoGenerico();
        VectorContas repositorio = new VectorContas();
        BancoIndependente bancoIndependente = new BancoIndependente(repositorio);
        ContaAbstrata conta = new Conta("08.2021-1");

        // (...)

        bancoIndependente.cadastrar(conta);
        auditor.auditar(bancoIndependente);
    }
}
