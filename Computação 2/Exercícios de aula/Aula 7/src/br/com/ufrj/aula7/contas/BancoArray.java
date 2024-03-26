package br.com.ufrj.aula7.contas;

public class BancoArray {
    private Conta[] contas;
    private int indice = 0;
    private double taxaDeJuros = 0.1;

    // MÉTODO BANCO COM ARRAY
    public BancoArray() {
        contas = new Conta[100];
    }

    // MÉTODO CADASTRAR
    public void cadastrar(Conta conta) {
        contas[indice] = conta;
        indice++;
    }

    // MÉTODO PROCURAR
    private Conta procurar(String numero){
        int i = 0;
        while (i < indice) {
            if (contas[i].numero().equals(numero)) return contas[i];
            else i++;
        }
        return null;
    }

    // MÉTODO DEBITAR
    public void debitar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) {
            if (valor <= conta.saldo()) conta.debitar(valor);
            else System.out.println("Saldo insuficiente!");
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO CREDITAR
    public void creditar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) conta.creditar(valor);
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO TRANSFERIR
    public void transferir(String numero1, String numero2, double valor) {
        Conta conta1 = procurar(numero1);
        Conta conta2 = procurar(numero2);
        if (conta1 != null && conta2 != null) {
            if (valor <= conta1.saldo()) {
                conta1.debitar(valor);
                conta2.creditar(valor);
            }
            else System.out.println("Saldo insuficiente!");
        }
        else System.out.println("Conta Inexistente!");
    }

    // MÉTODO SALDO
    public double saldo(String numero) {
        Conta conta = procurar(numero);
        if (conta != null) return conta.saldo();
        else System.out.println("Conta Inexistente!");
        return 0;
    }

    // MÉTODO RENDER JUROS
    public void renderJuros(String numero){
        Conta conta = procurar(numero);
        if (conta != null) creditar(numero, saldo(numero)*taxaDeJuros);
        else System.out.println("Conta Inexistente!");
    }
}
