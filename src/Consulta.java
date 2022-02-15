import java.util.Date;

public class Consulta {

    private Date data;
    private Paciente paciente;
    private Medico medico;
    private Boolean ativo;
    private Boolean encaixe;

    public Consulta() {
    }

    public Consulta(Date data, Paciente paciente, Medico medico, Boolean ativo, Boolean encaixe) {
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.ativo = ativo;
        this.encaixe = encaixe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
                "data=" + data +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", ativo=" + ativo +
                ", encaixe=" + encaixe +
                '}';
    }
}
