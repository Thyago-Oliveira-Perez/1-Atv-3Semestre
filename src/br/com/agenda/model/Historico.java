package br.com.agenda.model;

public class Historico extends AbstractEntity{

    private Agendamento agendamento;
    private Paciente paciente;
    private Secretaria secretaria;
    private String Observacao;
    private String statusAgendamento;

    public Historico() {
    }

    public Historico(Agendamento agendamento, Paciente paciente, Secretaria secretaria, String observacao, String statusAgendamento) {
        this.agendamento = agendamento;
        this.paciente = paciente;
        this.secretaria = secretaria;
        Observacao = observacao;
        this.statusAgendamento = statusAgendamento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    @Override
    public String toString() {
        return "Model.Historico{" +
                "agendamento=" + agendamento +
                ", paciente=" + paciente +
                ", secretaria=" + secretaria +
                ", Observacao='" + Observacao + '\'' +
                ", statusAgendamento=" + statusAgendamento +
                '}';
    }
}