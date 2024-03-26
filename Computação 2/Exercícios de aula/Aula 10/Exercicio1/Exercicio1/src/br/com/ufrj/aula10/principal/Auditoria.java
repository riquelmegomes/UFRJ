package br.com.ufrj.aula10.principal;

import br.com.ufrj.aula10.auditores.AuditorBancoGenerico;
import br.com.ufrj.aula10.bancos.*;
import br.com.ufrj.aula10.contas.Conta;
import br.com.ufrj.aula10.contas.ContaAbstrata;
import br.com.ufrj.aula10.contas.ContaImposto;

public class Auditoria {

    public static void main(String[] args){
        BancoArray bancoArray = new BancoArray();
        BancoVector bancoVector = new BancoVector();
        AuditorBancoGenerico auditor = new AuditorBancoGenerico();
        // (...)
        auditor.auditar(bancoArray);
        System.out.println();
        auditor.auditar(bancoVector);
    }
}