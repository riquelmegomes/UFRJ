package br.com.ufrj.sisloc.execucao.suporte;

import br.com.ufrj.sisloc.implementação.Locadora;

import java.text.ParseException;
import java.util.Scanner;

public class OperacoesEntradas {
    OperacoesChecagem checagem = new OperacoesChecagem();
    Scanner ler = new Scanner(System.in);
    OperacoesProcedimentos procedimentos = new OperacoesProcedimentos();


    public void receberCpf(Locadora locadora, String escolha) {
        System.out.println("Por favor, digite o CPF do cliente.");
        String cpf = ler.nextLine();

        if (checagem.ehLong(cpf)) {
            long longCPF = Long.parseLong(cpf);  // converte o cpf de string para long

            switch (escolha) {
                case "1" -> procedimentos.realizarCadastroCliente(locadora, longCPF);  // cadastrar
                case "2" -> procedimentos.atualizacaoCliente(locadora, longCPF);  // atualizar
                case "3" -> locadora.removerCliente(longCPF);  // remover
                case "11" -> locadora.imprimirHistoricoLocacoes(longCPF);  // ver histórico de locações
            }
        }
        else System.out.println("Erro! Esse não é um código válido.");
    }


    public void receberCodigo(Locadora locadora, String escolhaAcao) throws ParseException {
        System.out.println("Por favor, digite o código do filme.");
        String codigo = ler.nextLine();

        if (checagem.ehInt(codigo)) {
            int longCodigo = Integer.parseInt(codigo);  // converte o código de string para int

            switch (escolhaAcao) {
                case "4" -> procedimentos.realizarCadastroFilme(locadora, longCodigo); // cadastrar
                case "5" -> procedimentos.atualizacaoCadastroFilme(locadora, longCodigo); // atualizar
                case "6" -> locadora.removerFilme(longCodigo); // remover
            }
        }
        else System.out.println("Erro! Esse não é um código válido.");
    }


    public void receberDados(Locadora locadora, String escolhaAcao) {
        System.out.println("Por favor, digite o CPF do cliente.");
        String cpf = ler.nextLine();
        System.out.println("Por favor, digite o código do filme.");
        String codigo = ler.nextLine();

        if (checagem.ehLong(cpf) && checagem.ehInt(codigo)) {
            long longCPF = Long.parseLong(cpf);  // converte o cpf de string para long
            int intCodigo = Integer.parseInt(codigo);  // converte o código de string para int

            switch (escolhaAcao) {
                case "7" -> locadora.locarFilme(longCPF, intCodigo); // locar
                case "8" -> locadora.devolverFilme(longCPF, intCodigo); // devolver
                case "9" -> locadora.reservarFilme(longCPF, intCodigo); // reservar
                case "10" -> locadora.finalizarReservaFilme(longCPF, intCodigo); // finalizar reserva
            }
        }
        else System.out.println("Erro! CPF ou código inválido.");
    }
}
