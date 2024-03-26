import java.util.ArrayList;

public class BlocoDeNotas {
    private String proprietario;
    private ArrayList<Nota> notas;

    public BlocoDeNotas() {
        this.proprietario = "Zé ninguém";
        this.notas = new ArrayList<Nota>();
    }

    public BlocoDeNotas(String proprietario) {
        this.proprietario = proprietario;
        this.notas = new ArrayList<Nota>();
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public boolean adicionarNota(Nota nota) {
        return this.notas.add(nota);
    }

    public int numeroDeNotas() {
        return this.notas.size();
    }

    public void imprimirNotas() {
        for(int i = 0; i < notas.size(); i++) {
            System.out.println((notas.get(i)).descricaoDetalhada() + "\n");
        }
    }

    public String exibirNota(int posicao) {
        return (notas.get(posicao)).descricaoDetalhada() + "\n";
    }

    public Nota removerNota(int posicao) {
        return notas.remove(posicao);
    }
}