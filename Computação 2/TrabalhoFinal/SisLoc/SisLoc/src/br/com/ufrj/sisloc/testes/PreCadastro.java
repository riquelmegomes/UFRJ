package br.com.ufrj.sisloc.testes;

import br.com.ufrj.sisloc.implementação.Cliente;
import br.com.ufrj.sisloc.implementação.Filme;
import br.com.ufrj.sisloc.implementação.Locadora;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class PreCadastro {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dataLancamento;
    int numClientes = 3, numFilmes = 3;
    String sinopse = "O Homem-Aranha precisa lidar com as consequências da sua verdadeira identidade ter " +
            "sido descoberta.";

    String sinopse1 = "Uma nova aventura alucinante com ação em escala épica, que se passa em um mundo " +
            "bastante familiar, será vista, mas com uma trama ainda mais provocativa, na qual tudo o que é " +
            "necessário para que a verdade venha à tona está ligado em libertar sua própria mente.";

    String sinopse2 = "O superastro do basquete LeBron James se junta à gangue Looney Tunes para derrotar o " +
            "Goon Squad e salvar seu filho.";

    /* Método responsável por cadastrar automaticamente um certo número de clientes e filmes por meio de uma locadora */
    public void preCadastroCompleto(Locadora locadora) throws ParseException {
        for(int i = 0; i < numClientes; i++) {
            preCadastrarCliente(locadora, i);
        }
        for(int i = 0; i < numFilmes; i++) {
            preCadastrarFilme(locadora, i);
        }
    }

    /* Método responsável por cadastrar um certo cliente que possui atributos pré-determinados */
    public void preCadastrarCliente(Locadora locadora, int n) {
        Cliente cliente;
        switch (n) {
            case 0 -> {
                cliente = new Cliente(11111);
                cliente.setNome("Riquelme Gomes");
                cliente.setEndereco("Jacarepaguá");
            }
            case 1 -> {
                cliente = new Cliente(22222);
                cliente.setNome("Gustavo Lúcio");
                cliente.setEndereco("Taquara");
            }
            case 2 -> {
                cliente = new Cliente(33333);
                cliente.setNome("Rafael Vinicius");
                cliente.setEndereco("Curicica");
            }
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }
        locadora.cadastrarCliente(cliente);
    }

    /* Método responsável por cadastrar um certo filme que possui atributos pré-determinados */
    public void preCadastrarFilme(Locadora locadora, int n) throws ParseException {
        Filme filme = new Filme(999, "");
        Vector<String> generos = new Vector<>();
        Vector<String> atores = new Vector<>();
        Vector<String> produtores = new Vector<>();
        switch (n) {
            case 0 -> {
                filme = new Filme(111, "Homem-Aranha: Sem Volta Para Casa");
                generos.add("Super-herói");  generos.add("Aventura");
                dataLancamento = dateFormat.parse("17/12/2021");
                filme.setDiretor("Jon Watts");   filme.setSinopse(sinopse);
                atores.add("Tom Holland");  atores.add("Zendaya");  atores.add("Benedict Cumberbatch");
                produtores.add("JoAnn Perritano");
            }
            case 1 -> {
                filme.setCodigo(222);  filme.setTitulo("Matrix 4");
                generos.add("Ação");  generos.add("Ficção científica");
                dataLancamento = dateFormat.parse("22/12/2021");
                filme.setDiretor("Lana Wachowski");  filme.setSinopse(sinopse1);
                atores.add("Keanu Reeves");  atores.add("Carrie-Anne Moss");
                produtores.add("Lana Wachowski "); produtores.add("James McTeigue");
            }
            case 2 -> {
                filme.setCodigo(333);  filme.setTitulo("Space Jam: Um Novo Legado");
                generos.add("Animação");  generos.add("Infantil");
                dataLancamento = dateFormat.parse("15/07/2021");
                filme.setDiretor("Malcolm D. Lee");  filme.setSinopse(sinopse2);
                atores.add("LeBron James"); atores.add("Michael B. Jordan");
                produtores.add("Ryan Coogler");
            }
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }
        filme.setDataLancamento(dataLancamento);
        filme.setGenero(generos); filme.setAtores(atores); filme.setProdutores(produtores);
        filme.setPrecoLocacao(15); filme.setNumeroCopias(2); locadora.cadastrarFilme(filme);
    }
}
