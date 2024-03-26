public class Principal {
    public static void main(String[] args) {

        // Teste classe Nota
        System.out.println("Testando classe Nota...\n");
        Nota nota1 = new Nota("12/08/2021 - 12:00", "Essa é a descricão da nota 1.");
        Nota nota2 = new Nota("14/08/2021 - 14:00", "Essa é a descrição da nota 2.");
        System.out.println(nota1.descricaoDetalhada() + "\n");
        System.out.println(nota2.descricaoDetalhada() + "\n");

        // Teste classe BlocoDeNotas
        System.out.println("Testando classe BlocoDeNotas...\n");
        BlocoDeNotas bloco = new BlocoDeNotas();
        System.out.println("Proprietário: "+ bloco.getProprietario());
        bloco.setProprietario("Riquelme Gomes");
        System.out.println("Novo proprietário: "+ bloco.getProprietario());
        bloco.adicionarNota(nota1);
        bloco.adicionarNota(nota2);
        System.out.println("O número de notas no bloco é: "+ bloco.numeroDeNotas() + "\n");
        System.out.println("Imprimindo notas do bloco...\n");
        System.out.println("Nota 1\n"+ bloco.exibirNota(0));
        System.out.println("Nota 2\n"+ bloco.exibirNota(1));
        bloco.removerNota(1);
        System.out.println("Nota 2 removida!");
        System.out.println("Imprimindo notas do bloco...\n");
        bloco.imprimirNotas();

    }
}
