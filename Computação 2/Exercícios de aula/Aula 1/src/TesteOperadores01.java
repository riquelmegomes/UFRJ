
/** Essa classe testa expressões com operadores matemáticos e comparativos
 * utilizando as variáveis a = 3 e b = 6 . */
public class TesteOperadores01 {

    public static void main(String[] args) {
        int a = 3, b = 6;

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
