package br.com.ufrj.aula10.auditores;

import br.com.ufrj.aula10.interfaces.IBanco;

public class AuditorBancoGenerico {

    public void auditar(IBanco banco) {
        if ((banco.saldoTotal() / banco.numeroContas()) > 500){
            System.out.println("Aprovado!");
        }
        else {
            System.out.println("Não aprovado!");
        }
    }
}
