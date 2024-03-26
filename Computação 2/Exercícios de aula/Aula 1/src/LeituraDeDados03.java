import java.util.Scanner;

/** Essa classe testa expressões com operadores matemáticos e comparativos
 * utilizando as variáveis a e b, com valores determinados pelo usuário. */
public class LeituraDeDados03 {

    public static void main(String[] args) {
        double a, b;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Digite um valor para a variável a");
        a = myScanner.nextDouble();
        System.out.println("Digite um valor para a variável b");
        b = myScanner.nextDouble();
        System.out.println("a = "+ a + ", b = "+ b);

        // Operadores matemáticos
        System.out.println("a + b = "+ (a+b));
        System.out.println("a - b = "+ (a-b));
        System.out.println("a * b = "+ (a*b));
        System.out.println("a / b = "+ (a/b));
        System.out.println("a % b = "+ (a%b));
        System.out.println("a++ = "+ (++a));
        System.out.println("a-- = "+ (--a));
        System.out.println("b++ = "+ (++b));
        System.out.println("b-- = "+ (--b));

        // Operadores comparativos
        System.out.println("a == b? "+ (a==b));
        System.out.println("a != b? "+ (a!=b));
        System.out.println("a < b? "+ (a<b));
        System.out.println("a > b? "+ (a>b));
        System.out.println("a <= b? "+ (a<=b));
        System.out.println("a >= b? "+ (a>=b));
        System.out.println("a == 1 && b > 1? "+ (a==1 && b>1));
        System.out.println("a == 1 || b > 1? "+ (a==1 || b>1));
    }
}

