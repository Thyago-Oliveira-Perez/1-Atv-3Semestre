import java.util.List;
import java.util.Date;

public class AgendaDeHorarios {

    private List<Date> horarios;

    public List<Date> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Date> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "AgendaDeHorarios{" +
                "horarios=" + horarios +
                '}';
    }
}
