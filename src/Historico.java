public class Historico {

    private Agendamento agendamento;
    private Paciente paciente;
    private Secretaria secretaria;
    private String Observacao;
    private StatusAgendamento statusAgendamento;

    public Historico() {
    }

    public Historico(Agendamento agendamento, Paciente paciente, Secretaria secretaria, String observacao, StatusAgendamento statusAgendamento) {
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

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "agendamento=" + agendamento +
                ", paciente=" + paciente +
                ", secretaria=" + secretaria +
                ", Observacao='" + Observacao + '\'' +
                ", statusAgendamento=" + statusAgendamento +
                '}';
    }
}