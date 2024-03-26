import java.util.Scanner;
public class FibonacciRecursivo {

    public static long Fibonacci(long n) {
        return((n < 2) ? n : Fibonacci(n - 1) + Fibonacci(n - 2));
    }

    public static void main(String[] args) {
        long numero, resposta, tempoInicial, tempoTotal;
        Scanner meuScanner = new Scanner(System.in);

        while(true) {
            System.out.print("\nDigite um numero: ");
            numero = meuScanner.nextInt();
            tempoInicial = System.currentTimeMillis();
            resposta = Fibonacci(numero);
            tempoTotal = (System.currentTimeMillis() - tempoInicial);

            System.out.printf("fib(%d) = %d\n", numero, resposta);
            System.out.println("Tempo para calcular: " + tempoTotal + " milissegundos.");
        }
    }
}