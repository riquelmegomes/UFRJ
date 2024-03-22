import java.util.Scanner;

public class Principal {

    //Fatorial
    public static int Fatorial(int n) {
        if(n < 2) return 1;
        return n*Fatorial(n-1);
    }

    //Fibonnaci
    public static int Fibonacci(int n) {
        if(n < 2) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {
        int numero;

        System.out.println("Digite um número.");
        Scanner myscanner = new Scanner(System.in);
        numero = myscanner.nextInt();
        System.out.printf("Fatorial(%d) = %d\n", numero, Fatorial(numero));
        System.out.printf("Fibonaccil(n%d) = %d\n", numero, Fibonacci(numero));
    }
}
