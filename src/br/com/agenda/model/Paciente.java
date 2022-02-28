package br.com.agenda.model;

import java.util.Date;

public class Paciente extends Pessoa {

    private Convenio convenio;
    private String tipoAtendimento;
    private Date dataVencimentoConv;
    private String numeroCartaoConv;
    private Long id_convenio;
    private String n_cartao_convenio;
    private Date data_vencimento;

    public Paciente() {
    }

    public Paciente(Convenio convenio, String tipoAtendimento, Date dataVencimentoConv, String numeroCartaoConv) {
        this.convenio = convenio;
        this.tipoAtendimento = tipoAtendimento;
        this.dataVencimentoConv = dataVencimentoConv;
        this.numeroCartaoConv = numeroCartaoConv;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Date getDataVencimentoConv() {
        return dataVencimentoConv;
    }

    public void setDataVencimentoConv(Date dataVencimentoConv) {
        this.dataVencimentoConv = dataVencimentoConv;
    }

    public String getNumeroCartaoConv() {
        return numeroCartaoConv;
    }

    public void setNumeroCartaoConv(String numeroCartaoConv) {
        this.numeroCartaoConv = numeroCartaoConv;
    }

    public Long getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(Long id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getN_cartao_convenio() {
        return n_cartao_convenio;
    }

    public void setN_cartao_convenio(String n_cartao_convenio) {
        this.n_cartao_convenio = n_cartao_convenio;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "convenio=" + convenio +
                ", tipoAtendimento='" + tipoAtendimento + '\'' +
                ", dataVencimentoConv=" + dataVencimentoConv +
                ", numeroCartaoConv='" + numeroCartaoConv + '\'' +
                ", id_convenio=" + id_convenio +
                ", n_cartao_convenio='" + n_cartao_convenio + '\'' +
                ", data_vencimento=" + data_vencimento;
    }
}