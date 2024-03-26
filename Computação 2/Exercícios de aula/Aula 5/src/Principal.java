import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Conta minhaConta1 = new Conta("28.2021-1");
        Conta minhaConta2 = new Conta("28.2021-2");
        Banco meuBanco = new Banco();

        // Testando classe Conta
        System.out.println("O número da conta 1 é: "+ minhaConta1.numero());
        System.out.println("O número da conta 2 é: "+ minhaConta2.numero());
        minhaConta1.creditar(1000);
        minhaConta2.creditar(1000);
        minhaConta1.debitar(500);
        System.out.println("Saldo na conta 1: "+ minhaConta1.saldo());
        System.out.println("Saldo na conta 2: "+ minhaConta2.saldo());

        // TESTANDO CLASSE BANCO
        meuBanco.cadastrar(minhaConta1);
        meuBanco.cadastrar(minhaConta2);
        meuBanco.creditar("28.2021-1", 1500);
        meuBanco.debitar("28.2021-1", 1000);
        meuBanco.transferir("28.2021-1", "28.2021-2", 1000);
        System.out.println("Saldo na conta 1: "+ meuBanco.saldo("28.2021-1"));
        System.out.println("Saldo na conta 2: "+ meuBanco.saldo("28.2021-2"));

    }
}
