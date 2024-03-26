import java.util.Scanner;

/** Essa classe executa todos os programas exemplo
 * referentes às estruturas de controle. */
public class EstruturasDeControle04 {

    // PROGRAMA TERNÁRIO COM IF...ELSE
    public static void TernarioIfElse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        short valor1 = scanner.nextShort();
        System.out.println("Digite o segundo valor: ");
        short valor2 = scanner.nextShort();
        short menor = 0;
        if(valor1<valor2){
            menor = valor1;
        }
        else{
            menor = valor2;
        }
        System.out.println("Este é o menor valor: "+menor);
    }

    // PROGRAMA SWITCH
    public static void Switch() {
        System.out.println("Digite a opcao: ");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();
        switch(opt) {
            case 1: System.out.println("Opt - 1");
                break;
            case 2: System.out.println("Opt - 2");
                break;
            default:System.out.println("Erro");
                break;

        }
    }

    // PROGRAMA WHILE
    public static void Enquanto() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println("Tecle um numeral: ");
        int opt = scanner.nextInt();
        while(opt != 5) {
            System.out.println("Tente novamente");
            System.out.println("Tecle um numeral: ");
            opt = scanner.nextInt();
        }
        System.out.println("Acertou!!!");
    }

    // PROGRAMA FAÇA...ENQUANTO
    public static void FacaEnquanto() {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("Tecle um numeral: ");
            opt = scanner.nextInt();
        }
        while(opt != 5);
        System.out.println("Acertou!!!");
    }

    // PROGRAMA PARA
    public static void Para() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o máximo: ");
        int max = scanner.nextInt();
        for(int i = 0; i < max; i++){
            System.out.println("Número " + i);
        }
    }

    // PROGRAMA BREAK
    public static void Break() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println("Digite um número: ");
        int max = scanner.nextInt();
        int i = 0;
        for (i = 0; i < max; i++) {
            if (i == (max/2)) {
                break; // sai do for
            }
            System.out.println("for: i = " + i);
        }
        System.out.println("for final: i = " + i);
    }

    // PROGRAMA CONTINUE
    public static void Continue() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println("Digite um número: ");
        int max = scanner.nextInt();
        int i = 0;
        for (i = 0; i < max; i++) {
            if (i == 7) {
                continue; // retorna ao for 1
            }
            System.out.println("for: i = " + i);
        }
        System.out.println("for final: i = " + i);
    }

    // MAIN
    public static void main(String[] args) {
        TernarioIfElse();
        System.out.print("\n");
        Switch();
        System.out.print("\n");
        Enquanto();
        System.out.print("\n");
        FacaEnquanto();
        System.out.print("\n");
        Para();
        System.out.print("\n");
        Break();
        System.out.print("\n");
        Continue();

    }
}