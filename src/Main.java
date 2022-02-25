import br.com.agenda.dao.*;

public class Main {

    public static void main(String[] args) {

        AgendamentoDao agendamentoDao = new AgendamentoDao();
        ConvenioDao convenioDao= new ConvenioDao();
        EspecialidadeDao especialidadeDao = new EspecialidadeDao();
        HistoricoDao historicoDao = new HistoricoDao();
        MedicoDao medicoDao = new MedicoDao();
        PacienteDao pacienteDao = new PacienteDao();
        SecretariaDao secretariaDao = new SecretariaDao();

        agendamentoDao.createTable();
        convenioDao.createTable();
        especialidadeDao.createTable();
        historicoDao.createTable();
        medicoDao.createTable();
        pacienteDao.createTable();
        secretariaDao.createTable();

        System.out.println("Hello World");
    }
}
