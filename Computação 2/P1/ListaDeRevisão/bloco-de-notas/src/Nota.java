public class Nota {
    private String tempoDeAgendamento;
    private String descricao;

    public Nota(String tempoDeAgendamento, String descricao){
        this.tempoDeAgendamento = tempoDeAgendamento;
        this.descricao = descricao;
    }

    public String descricaoDetalhada() {
        return (tempoDeAgendamento + "\n"+ descricao);
    }
}
