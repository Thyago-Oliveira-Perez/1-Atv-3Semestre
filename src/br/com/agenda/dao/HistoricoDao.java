package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Historico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class HistoricoDao {

    private static Connection connection;

    public HistoricoDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_historico_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table historico(\n" +
                "\tid bigint primary key default nextval('seq_historico_id'),\n" +
                "\tcadastrado timestamp not null,\n" +
                "\tatualizado timestamp,\n" +
                "\texcluido timestamp,\n" +
                "\tid_agenda bigint not null,\n" +
                "\tobservacao varchar(255),\n" +
                "\tstatus_agendamento varchar(15) not null,\n" +
                "\tid_paciente bigint,\n" +
                "\tid_secretaria bigint,\n" +
                "\tdata timestamp not null,\n" +
                "\tconstraint fk_id_agenda foreign key(id_agenda) references agenda(id),\n" +
                "\tconstraint fk_id_paciente foreign key(id_paciente) references paciente(id),\n" +
                "\tconstraint fk_id_secretaria foreign key(id_secretaria) references secretaria(id)\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertHistorico(Historico historico){}

    public void updateHistorico(Historico historico){}

    public void updateStatusHistorico(Long id){}

    public List<Historico> findAllHistorico(){
        return null;
    }

    public Historico findByIdHistorico(Long id){
        return null;
    }

}
