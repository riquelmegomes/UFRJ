package br.com.ufrj.sisloc.execucao;

import br.com.ufrj.sisloc.execucao.suporte.OperacoesEntradas;
import br.com.ufrj.sisloc.execucao.suporte.OperacoesChecagem;
import br.com.ufrj.sisloc.testes.PreCadastro;
import br.com.ufrj.sisloc.implementação.Locadora;
import br.com.ufrj.sisloc.implementação.repositorios.RepositorioCliente;
import br.com.ufrj.sisloc.implementação.repositorios.RepositorioFilme;
import br.com.ufrj.sisloc.implementação.repositorios.RepositorioOperacao;
import br.com.ufrj.sisloc.interfaces.IRepositorioCliente;
import br.com.ufrj.sisloc.interfaces.IRepositorioFilme;
import br.com.ufrj.sisloc.interfaces.IRepositorioOperacao;

import java.text.ParseException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {
        IRepositorioCliente clientes = new RepositorioCliente();
        IRepositorioFilme filmes = new RepositorioFilme();
        IRepositorioOperacao operacoes = new RepositorioOperacao();
        Locadora locadora = new Locadora(clientes, filmes, operacoes);
        OperacoesEntradas entradas = new OperacoesEntradas();
        OperacoesChecagem checagem = new OperacoesChecagem();
        Scanner ler = new Scanner(System.in);
        PreCadastro preCadastro = new PreCadastro();

        System.out.println("\nSeja bem vindo à locadora SisLoc!");

        String escolha = "";
        while(!escolha.equals("0")) {
            System.out.println("""
                
                Certo, o que gostaria de fazer agora? Digite\s
                 0 - Sair.
                 1 - Cadastrar cliente.
                 2 - Atualizar cadastro de um cliente.
                 3 - Remover cliente.
                 4 - Cadastrar filme.
                 5 - Atualizar cadastro de um filme.
                 6 - Remover filme.
                 7 - Locar filme.
                 8 - Devolver filme.
                 9 - Reservar filme.
                10 - Finalizar reserva.
                11 - Ver histórico de locações.
                12 - Ver filmes mais locados.""");
            escolha = ler.nextLine();

            switch (escolha) {
                case "0" -> System.out.println("Muito obrigado por utilizar nossos serviços! :)");

                case "1", "2", "3", "11" -> entradas.receberCpf(locadora, escolha);

                case "4", "5", "6" -> entradas.receberCodigo(locadora, escolha);

                case "7", "8", "9", "10" -> entradas.receberDados(locadora, escolha);

                case "12" -> {
                    System.out.println("Por favor, digite o tamanho da lista de filmes mais locados. ex: 5");
                    String top = ler.nextLine();

                    if(checagem.ehInt(top) && (Integer.parseInt(top) > 0)) {
                        locadora.imprimirFilmesMaisLocados(Integer.parseInt(top)); // converte top para int
                    }
                    else System.out.println("Erro! Esse não é um dígito válido.");
                }

                case "precadastro" -> preCadastro.preCadastroCompleto(locadora);

                default -> System.out.println("Erro! Dígito inválido, por favor digite novamente.");
            }
        }
    }
}