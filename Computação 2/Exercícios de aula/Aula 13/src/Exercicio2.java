import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* Esse programa lê uma frase e informa o número de palavras não repetidas da frase.
 *  Obs1: Para que funcione corretamente, a frase não deve ter sinais de pontuação.
 *  Obs2: Letras maisculas e minusculas são interpretadas como letras diferentes.   */
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String[] palavras;

        System.out.println("Por favor, escreva uma frase");
        palavras = (myScanner.nextLine()).split(" ");   // Separa as palavras da frase no array de String

        Set<String> palavrasDiferentes = new HashSet<>(Arrays.asList(palavras));
        // O set não irá contabilizar palavras repetidas

        System.out.println("O número de palavras não repetidas da frase é: " + palavrasDiferentes.size());
    }
}
