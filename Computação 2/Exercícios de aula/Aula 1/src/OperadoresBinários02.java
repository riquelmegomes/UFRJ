/** Essa classe testa o funcionamento dos operadores binários
 * para as variáveis a = 3 e b = 6 . */
public class OperadoresBinários02 {

    public static void main(String[] args) {
        int a = 3, b = 6;

        System.out.println("a = "+ a + ", b = "+ b);
        System.out.println("~a = "+ (~a));
        System.out.println("a & b = "+ (a&b));
        System.out.println("a | b = "+ (a|b));
        System.out.println("a ^ b = "+ (a^b));
        System.out.println("2 >> a = "+ (2>>a));
        System.out.println("a << 2 = "+ (a<<2));
        System.out.println("2 >> b = "+ (2>>b));
        System.out.println("b << 2 = "+ (b<<2));
    }
}
