package br.com.agenda.model;

import java.math.BigDecimal;

public class Medico extends Pessoa{

    private Especialidade especialidade;
    private String crm;
    private BigDecimal porcentParticipacao;

    public Medico() {
    }

    public Medico(Especialidade especialidade, String crm, BigDecimal porcentParticipacao) {
        this.especialidade = especialidade;
        this.crm = crm;
        this.porcentParticipacao = porcentParticipacao;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public BigDecimal getPorcentParticipacao() {
        return porcentParticipacao;
    }

    public void setPorcentParticipacao(BigDecimal porcentParticipacao) {
        this.porcentParticipacao = porcentParticipacao;
    }
}
