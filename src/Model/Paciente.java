package Model;

import java.util.Date;

public class Paciente extends Pessoa {

    private Convenio convenio;
    private TipoAtendimento tipoAtendimento;
    private Date dataVencimentoConv;
    private String numeroCartaoConv;

    public Paciente() {
    }

    public Paciente(Convenio convenio, TipoAtendimento tipoAtendimento, Date dataVencimentoConv, String numeroCartaoConv) {
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

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
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

    @Override
    public String toString() {
        return "Model.Paciente{" +
                "convenio=" + convenio +
                ", tipoAtendimento=" + tipoAtendimento +
                ", dataVencimentoConv=" + dataVencimentoConv +
                ", numeroCartaoConv='" + numeroCartaoConv + '\'' +
                '}';
    }
}
