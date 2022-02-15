import java.util.List;

public class Medico extends Pessoa{

    private String especialidade;
    private String crm;
    private int cargaHoraria;
    private List<AgendaDeHorarios> agendaDeHorarios;

    public Medico() {
    }

    public Medico(String especialidade, String crm, int cargaHoraria, List<AgendaDeHorarios> agendaDeHorarios) {
        this.especialidade = especialidade;
        this.crm = crm;
        this.cargaHoraria = cargaHoraria;
        this.agendaDeHorarios = agendaDeHorarios;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<AgendaDeHorarios> getAgendaDeHorarios() {
        return agendaDeHorarios;
    }

    public void setAgendaDeHorarios(List<AgendaDeHorarios> agendaDeHorarios) {
        this.agendaDeHorarios = agendaDeHorarios;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidade='" + especialidade + '\'' +
                ", crm='" + crm + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", agendaDeHorarios=" + agendaDeHorarios +
                '}';
    }
}
