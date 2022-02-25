package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AgendamentoDao {

    private static Connection connection;

    public AgendamentoDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){

        String sqlSeq = "create sequence seq_agenda_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table agenda(\n" +
                "\n" +
                "\tid bigint primary key default nextval('seq_agenda_id'),\n" +
                "\tcadastrado timestamp not null,\n" +
                "\tatualizado timestamp,\n" +
                "\texcluido timestamp,\n" +
                "\tid_paciente bigint not null,\n" +
                "\tid_medico bigint not null,\n" +
                "\tstatus_agendamento varchar(15) not null,\n" +
                "\tdata_agendamento timestamp not null,\n" +
                "\tencaixe boolean not null,\n" +
                "\tconstraint fk_id_paciente foreign key(id_paciente) references paciente(id),\n" +
                "\tconstraint fk_id_medico foreign key(id_medico) references medico(id)\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAgendamento(Agendamento agendamento){}

    public void updateAgendamento(Agendamento agendamento){}

    public void updateStatusAgendamento(Long id){}

    public List<Agendamento> findAllAgendamento(){
        return null;
    }

    public Agendamento findByIdAgendamento(Long id){
        return null;
    }

}
