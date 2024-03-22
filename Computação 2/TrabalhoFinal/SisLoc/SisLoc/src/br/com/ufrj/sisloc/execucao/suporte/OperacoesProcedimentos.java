package br.com.ufrj.sisloc.execucao.suporte;

import br.com.ufrj.sisloc.implementação.Cliente;
import br.com.ufrj.sisloc.implementação.Filme;
import br.com.ufrj.sisloc.implementação.Locadora;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class OperacoesProcedimentos {
    OperacoesChecagem checagem = new OperacoesChecagem();
    Scanner ler = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /* Método responsável por cadastrar um cliente em uma locadora. */
    public void realizarCadastroCliente(Locadora locadora, Long cpf) {
        Cliente clienteBuscado = locadora.buscarCliente(cpf);

        if (clienteBuscado == null) {
            Cliente novoCliente = new Cliente(cpf);

            System.out.println("Por favor, digite o nome do cliente.");
            novoCliente.setNome(ler.nextLine());

            System.out.println("Por favor, digite o endereço do cliente.");
            novoCliente.setEndereco(ler.nextLine());

            locadora.cadastrarCliente(novoCliente);
            novoCliente.imprimir();
        }
        else System.out.println("Desculpe, este CPF já está cadastrado em nosso sistema.");
    }

    /* Método responsável por atualizar o cadastro de um cliente em uma locadora. */
    public void atualizacaoCliente(Locadora locadora, Long cpf) {
        Cliente clienteBuscado = locadora.buscarCliente(cpf);

        if (clienteBuscado == null) {
            System.out.println("Desculpe, este cliente não está cadastrado em nosso sistema.");
        }
        else {
            String escolhaAtualizacao = "";
            while (!escolhaAtualizacao.equals("0")) {
                System.out.println("""

                                        O que gostaria de atualizar? Digite
                                        0 - Para voltar
                                        1 - Nome
                                        2 - Endereço""");

                escolhaAtualizacao = ler.nextLine();
                switch (escolhaAtualizacao) {
                    case "0" -> {
                    }
                    case "1" -> {
                        System.out.println("Digite um novo nome para o cadastro.");
                        clienteBuscado.setNome(ler.nextLine());
                        locadora.atualizarCadastroCliente(clienteBuscado);
                        clienteBuscado.imprimir();
                    }
                    case "2" -> {
                        System.out.println("Digite um novo endereço para o cadastro.");
                        clienteBuscado.setEndereco(ler.nextLine());
                        locadora.atualizarCadastroCliente(clienteBuscado);
                        clienteBuscado.imprimir();
                    }
                    default -> System.out.println("Dígito inválido. Por favor, tente novamente.");
                }
            }
        }
    }

    /* Método responsável por cadastrar novos gêneros para um filme */
    public void cadastraGeneros(Vector<String> generos, Filme filme) {
        System.out.println("Por favor, digite um gênero do filme.");
        generos.add(ler.nextLine());
        String escolha = "";
        while (!escolha.equals("0")) {
            System.out.println("Gostaria de adicionar mais um gênero para o filme ?\n0 - Não\n1 - Sim");
            escolha = ler.nextLine();
            switch (escolha) {
                case "0" -> {}
                case "1" -> {
                    System.out.println("Por favor, digite mais um gênero do filme.");
                    generos.add(ler.nextLine());
                }
                default -> System.out.println("Dígito inválido! Por favor, tente novamente.");
            }
        }
        filme.setGenero(generos);
    }

    /* Método responsável por cadastrar novos gêneros para um filme */
    public void cadastraAtores(Vector<String> atores, Filme filme) {
        System.out.println("Por favor, digite um ator/atriz do filme.");
        atores.add(ler.nextLine());
        String escolha = "";
        while (!escolha.equals("0")) {
            System.out.println("Gostaria de adicionar mais um ator ou atriz para o filme ?\n0 - Não\n1 - Sim");
            escolha = ler.nextLine();
            switch (escolha) {
                case "0" -> {}
                case "1" -> {
                    System.out.println("Por favor, digite mais um ator/atriz do filme.");
                    atores.add(ler.nextLine());
                }
                default -> System.out.println("Dígito inválido! Por favor, tente novamente.");
            }
        }
        filme.setAtores(atores);
    }

    public void cadastraProdutores(Vector<String> produtores, Filme filme) {
        System.out.println("Por favor, digite um produtor do filme.");
        produtores.add(ler.nextLine());
        String escolha = "";
        while (!escolha.equals("0")) {
            System.out.println("Gostaria de adicionar mais um produtor para o filme ?\n0 - Não\n1 - Sim");
            escolha = ler.nextLine();
            switch (escolha) {
                case "0" -> {}
                case "1" -> {
                    System.out.println("Por favor, digite mais um produtor do filme.");
                    produtores.add(ler.nextLine());
                }
                default -> System.out.println("Dígito inválido! Por favor, tente novamente.");
            }
        }
        filme.setProdutores(produtores);
    }

    /* Método responsável por cadastrar um filme em uma locadora. */
    public void realizarCadastroFilme(Locadora locadora, int codigo) throws ParseException {
        Filme filmeBuscado = locadora.buscarFilme(codigo);

        if (filmeBuscado == null) {
            // Cadastra o título
            System.out.println("Por favor, digite o titulo do filme.");
            String titulo = ler.nextLine();
            Filme novoFilme;
            novoFilme = new Filme(codigo, titulo);

            // Cadastra a sinopse
            System.out.println("Por favor, digite a sinopse do filme.");
            novoFilme.setSinopse(ler.nextLine());

            // Cadastra o diretor
            System.out.println("Por favor, digite o nome do diretor do filme.");
            novoFilme.setDiretor(ler.nextLine());

            // Cadastra os gêneros
            Vector<String> generos = new Vector<>();
            cadastraGeneros(generos, novoFilme);

            // Cadastra os atores
            Vector<String> atores = new Vector<>();
            cadastraAtores(atores, novoFilme);

            // Cadastra os produtores
            Vector<String> produtores = new Vector<>();
            cadastraProdutores(produtores, novoFilme);

            // Cadastra a data de lançamento
            System.out.println("Por favor, digite a data de lançamento do filme " +
                    "no formato: dd/MM/aaaa.");
            String data = ler.nextLine();
            while (checagem.ehDate(data)) {
                System.out.println("Data inválida! Por favor, digite novamente no formato: " +
                        "dd/MM/aaaa.");
                data = ler.nextLine();
            }
            Date dataLancamento = dateFormat.parse(data);
            novoFilme.setDataLancamento(dataLancamento);

            // Cadastra o preço de locação
            System.out.println("Por favor, digite o preço de locação do filme.");
            String precoLocacao = ler.nextLine();
            while (checagem.ehFloat(precoLocacao)) {
                System.out.println("Preço inválido! Por favor, digite novamente.");
                precoLocacao = ler.nextLine();
            }
            novoFilme.setPrecoLocacao(Float.parseFloat(precoLocacao)); // converte para float

            // Cadastra o número de cópias
            System.out.println("Por favor, digite o número de cópias do filme.");
            String numeroCopias = ler.nextLine();
            while (!checagem.ehInt(numeroCopias)) {
                System.out.println("Número de cópias inválido! Por favor, digite novamente.");
                numeroCopias = ler.nextLine();
            }
            novoFilme.setNumeroCopias(Integer.parseInt(numeroCopias)); // converte para int

            locadora.cadastrarFilme(novoFilme);
            novoFilme.imprimir();
        }
        else System.out.println("Desculpe, este filme já está cadastrado em nosso sistema.");
    }

    /* Método responsável por atualizar o cadastro de umfilme em uma locadora. */
    public void atualizacaoCadastroFilme(Locadora locadora, int codigo) throws ParseException {
        Filme filmeBuscado = locadora.buscarFilme(codigo);

        if (filmeBuscado == null) {
            System.out.println("Desculpe, este filme não está cadastrado em nosso sistema.");
        }
        else {
            String escolhaAtualizacao = "";
            while (!escolhaAtualizacao.equals("0")) {
                System.out.println("""

                                        O que gostaria de atualizar agora? Digite
                                        0 - Para voltar
                                        1 - Título
                                        2 - Sinopse
                                        3 - Diretor
                                        4 - Gêneros
                                        5 - Atores
                                        6 - Produtores
                                        7 - Data de lançamento
                                        8 - Preço de locação
                                        9 - Número de cópias""");

                escolhaAtualizacao = ler.nextLine();
                switch (escolhaAtualizacao) {
                    case "0" -> {}
                    case "1" -> {
                        System.out.println("Digite um novo título para o filme.");
                        filmeBuscado.setTitulo(ler.nextLine());
                    }
                    case "2" -> {
                        System.out.println("Digite uma nova sinopse para o filme.");
                        filmeBuscado.setSinopse(ler.nextLine());
                    }
                    case "3" -> {
                        System.out.println("Digite o nome do diretor do filme.");
                        filmeBuscado.setDiretor(ler.nextLine());
                    }
                    case "4" -> {
                        Vector<String> generos = filmeBuscado.getGenero();
                        generos.removeAllElements();
                        cadastraGeneros(generos, filmeBuscado);
                    }
                    case "5" -> {
                        Vector<String> atores = filmeBuscado.getAtores();
                        atores.removeAllElements();
                        cadastraAtores(atores, filmeBuscado);
                    }
                    case "6" -> {
                        Vector<String> produtores = filmeBuscado.getProdutores();
                        produtores.removeAllElements();
                        cadastraProdutores(produtores, filmeBuscado);
                    }
                    case "7" -> {
                        System.out.println("Digite a nova data de lançamento do filme no formato: " +
                                "dd/MM/yyyy.");
                        String data = ler.nextLine();
                        while (checagem.ehDate(data)) {
                            System.out.println("Data inválida! Por favor, digite novamente no " +
                                    "formato: dd/MM/yyyy.");
                            data = ler.nextLine();
                        }
                        Date dataLancamento = dateFormat.parse(data);
                        filmeBuscado.setDataLancamento(dataLancamento);
                    }
                    case "8" -> {
                        System.out.println("Digite o novo preço de locação do filme.");
                        String precoLocacao = ler.nextLine();
                        while (checagem.ehFloat(precoLocacao)) {
                            System.out.println("Preço inválido! Por favor, digite novamente.");
                            precoLocacao = ler.nextLine();
                        }
                    }
                    case "9" -> {
                        System.out.println("Digite o novo número de cópias do filme.");
                        String numeroCopias = ler.nextLine();
                        while (!checagem.ehInt(numeroCopias)) {
                            System.out.println("Número de cópias inválido! Por favor, digite " +
                                    "novamente.");
                            numeroCopias = ler.nextLine();
                        }
                        filmeBuscado.setNumeroCopias(Integer.parseInt(numeroCopias));
                    }
                    default -> System.out.println("Dígito inválido. Por favor, tente novamente.");
                }
                locadora.atualizarCadastroFilme(filmeBuscado);
                filmeBuscado.imprimir();
            }
        }
    }
}