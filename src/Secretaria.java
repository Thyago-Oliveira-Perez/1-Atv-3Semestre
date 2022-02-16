import java.math.BigDecimal;
import java.util.Date;

public class Secretaria extends Pessoa {

    private String pis;
    private Date dataContratacao;
    private BigDecimal salario;

    public Secretaria() {
    }

    public Secretaria(String pis, Date dataContratacao, BigDecimal salario) {
        this.pis = pis;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "pis='" + pis + '\'' +
                ", dataContratacao=" + dataContratacao +
                ", salario=" + salario +
                '}';
    }
}