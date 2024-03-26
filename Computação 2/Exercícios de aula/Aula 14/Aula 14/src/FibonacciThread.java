import java.util.Scanner;

// Resposta: Sim, fica mais rápido.

public class FibonacciThread implements Runnable {
    public long resposta;
    final private long numero;

    public FibonacciThread(long n) {
        this.numero = n;
    }

    @Override
    public void run() {
        if (numero < 2) resposta = numero;
        else {
            FibonacciThread f1 = new FibonacciThread(numero - 1);
            FibonacciThread f2 = new FibonacciThread(numero - 2);
            Thread t1 = new Thread(f1);
            Thread t2 = new Thread(f2);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resposta = f1.resposta + f2.resposta;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long numero, resposta, tempoInicial, tempoTotal;
        Scanner meuScanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite um numero: ");
            numero = meuScanner.nextInt();
            FibonacciThread fibonacci = new FibonacciThread(numero);
            Thread thread = new Thread(fibonacci);

            tempoInicial = System.currentTimeMillis();
            thread.start();
            thread.join();
            resposta = fibonacci.resposta;
            tempoTotal = (System.currentTimeMillis() - tempoInicial);

            System.out.printf("fib(%d) = %d\n", numero, resposta);
            System.out.println("Tempo para calcular: " + tempoTotal + " milissegundos.");
        }
    }
}

