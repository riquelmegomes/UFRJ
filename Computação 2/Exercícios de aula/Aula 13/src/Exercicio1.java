import java.util.ArrayList;
import java.util.Scanner;

/* Esse programa recebe uma frase e escreve a frase invertida (da última palavra para a primeira).
 * Obs: Para que funcione corretamente, a frase não deve ter sinais de pontuação. */
public class Exercicio1 {
    public static void main(String[] args) {
        ArrayList<String> fraseInvertida = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        String[] palavras;

        System.out.println("Por favor, escreva uma frase");
        palavras = (myScanner.nextLine()).split(" ");   // Separa as palavras da frase no array de String

        for(String palavra : palavras) {
            fraseInvertida.add(0, palavra);  // Adiciona as palavras ao ArrayList em ordem invertida
        }

        for(String p : fraseInvertida) {
            System.out.print(p + " ");
        }

    }
}
