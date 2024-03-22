package br.com.ufrj.sisloc.implementação;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;

    // Construtor
    public Cliente(long cpf) {
        this.cpf = cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    /* Método que imprime uma descrição do cliente contendo seu nome e endereço. */
    public void imprimir() {
        System.out.println("Nome: " + getNome() +
                "\nEndereço: " + getEndereco());
    }
}
