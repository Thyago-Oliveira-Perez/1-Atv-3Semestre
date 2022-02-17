package Model;

import java.util.Date;

public class Agendamento {

    private Paciente paciente;
    private Secretaria secretaria;
    private Medico medico;
    private StatusAgendamento statusAgendamento;
    private Date dataAbertura;
    private Date dataConfirmacao;
    private Date dataCancelamento;
    private Date dataRecusado;
    private String Observacao;
    private Boolean encaixe;

    public Agendamento() {
    }

    public Agendamento(Paciente paciente, Secretaria secretaria, Medico medico, StatusAgendamento statusAgendamento, Date dataAbertura, Date dataConfirmacao, Date dataCancelamento, Date dataRecusado, String observacao, Boolean encaixe) {
        this.paciente = paciente;
        this.secretaria = secretaria;
        this.medico = medico;
        this.statusAgendamento = statusAgendamento;
        this.dataAbertura = dataAbertura;
        this.dataConfirmacao = dataConfirmacao;
        this.dataCancelamento = dataCancelamento;
        this.dataRecusado = dataRecusado;
        Observacao = observacao;
        this.encaixe = encaixe;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(Date dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Date getDataRecusado() {
        return dataRecusado;
    }

    public void setDataRecusado(Date dataRecusado) {
        this.dataRecusado = dataRecusado;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public Boolean getEncaixe() {
        return encaixe;
    }

    public void setEncaixe(Boolean encaixe) {
        this.encaixe = encaixe;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente +
                ", secretaria=" + secretaria +
                ", medico=" + medico +
                ", statusAgendamento=" + statusAgendamento +
                ", dataAbertura=" + dataAbertura +
                ", dataConfirmacao=" + dataConfirmacao +
                ", dataCancelamento=" + dataCancelamento +
                ", dataRecusado=" + dataRecusado +
                ", Observacao='" + Observacao + '\'' +
                ", encaixe=" + encaixe +
                '}';
    }
}
