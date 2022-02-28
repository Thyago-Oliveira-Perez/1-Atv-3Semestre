package br.com.agenda.model;

public class Especialidade extends AbstractEntity{

    private Long id;
    private String nomeEspecialidade;

    public Especialidade() {
    }

    public Especialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model.Especialidade{" +
                "nomeEspecialidade='" + nomeEspecialidade + '\'' +
                '}';
    }
}
