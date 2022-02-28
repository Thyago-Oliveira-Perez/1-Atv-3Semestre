import br.com.agenda.dao.*;
import br.com.agenda.model.Agendamento;
import br.com.agenda.model.Paciente;
import br.com.agenda.model.Sexo;
import br.com.agenda.model.StatusAgendamento;

public class Main {

    public static void main(String[] args) {

        Paciente paciente = new Paciente();

        AgendamentoDao agendamentoDao = new AgendamentoDao();
        ConvenioDao convenioDao= new ConvenioDao();
        EspecialidadeDao especialidadeDao = new EspecialidadeDao();
        HistoricoDao historicoDao = new HistoricoDao();
        MedicoDao medicoDao = new MedicoDao();
        PacienteDao pacienteDao = new PacienteDao();
        SecretariaDao secretariaDao = new SecretariaDao();

        System.out.println("Hello World");
    }
}
