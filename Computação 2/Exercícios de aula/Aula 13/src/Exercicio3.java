import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Esse programa lê uma frase e informa o número de ocorrências de cada palavra da frase.
 *  Obs1: Para que funcione corretamente, a frase não deve ter sinais de pontuação.
 *  Obs2: Letras maisculas e minusculas são interpretadas como letras diferentes.   */
public class Exercicio3 {
    public static void main(String[] args) {
        Map<String, Integer> ocorrenciaPorPalavra = new HashMap<>();
        Scanner myScanner = new Scanner(System.in);
        String[] palavras;

        System.out.println("Por favor, escreva uma frase");
        palavras = (myScanner.nextLine()).split(" ");   // Separa as palavras da frase no array de String

        for (String palavra : palavras) {
            int ocorrencias = 0;
            for (String p : palavras) {
                if(palavra.equals(p)) ocorrencias++;  // Conta o número de ocorrências de cada palavra
            }
            ocorrenciaPorPalavra.put(palavra, ocorrencias);
        }

        for (String palavraNoMap : ocorrenciaPorPalavra.keySet()) {
            System.out.println("O número de ocorrências da palavra \""
                    + palavraNoMap + "\" é: " + ocorrenciaPorPalavra.get(palavraNoMap));
        }
    }
}
