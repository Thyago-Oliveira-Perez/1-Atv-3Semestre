package br.com.agenda.model;

import java.math.BigDecimal;

public class Convenio extends AbstractEntity{

    private String nomeConvenio;
    private BigDecimal valorConvenio;

    public Convenio() {
    }

    public Convenio(String nomeConvenio, BigDecimal valorConvenio) {
        this.nomeConvenio = nomeConvenio;
        this.valorConvenio = valorConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public BigDecimal getValorConvenio() {
        return valorConvenio;
    }

    public void setValorConvenio(BigDecimal valorConvenio) {
        this.valorConvenio = valorConvenio;
    }

    @Override
    public String toString() {
        return "Model.Convenio{" +
                "nomeConvenio='" + nomeConvenio + '\'' +
                ", valorConvenio=" + valorConvenio +
                '}';
    }
}
