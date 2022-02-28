package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Historico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDao {

    AgendamentoDao agendamentoDao = new AgendamentoDao();
    PacienteDao pacienteDao = new PacienteDao();
    SecretariaDao secretariaDao = new SecretariaDao();

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

        String sqlCreate = "create table if not exists historico(\n" +
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

    public void insertHistorico(Historico historico){
        String sqlInsert = "insert into historico (cadastro, id_agenda, observacao, " +
                "status_agendamento, id_paciente, id_secretaria) values (now(),?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setLong(1, historico.getAgendamento().getId());
            preparedStatement.setString(2, historico.getObservacao());
            preparedStatement.setString(3, historico.getStatusAgendamento());
            preparedStatement.setLong(4, historico.getPaciente().getId());
            preparedStatement.setLong(5, historico.getSecretaria().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Historico> findAllHistorico(){

        List<Historico> retornoBanco = new ArrayList<>();

        String sqlSelect = "select * from historico;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Historico historico = new Historico();
                historico.setAgendamento(agendamentoDao.findByIdAgendamento(resultSet.getLong("id_agenda")));
                historico.setPaciente(pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente")));
                historico.setSecretaria(secretariaDao.findByIdSecretaria(resultSet.getLong("id_secretaria")));
                historico.setObservacao(resultSet.getString("observacao"));
                historico.setStatusAgendamento(resultSet.getString("status_agendamento"));
                historico.setCadastro(resultSet.getDate("cadastro"));
                historico.setAtualizado(resultSet.getDate("atualizado"));
                historico.setExcluido(resultSet.getDate("excluido"));
                retornoBanco.add(historico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoBanco;
    }

    public Historico findByIdHistorico(Long id){
        Historico historico = new Historico();
        String sqlSelect = "select * from historico;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                historico.setAgendamento(agendamentoDao.findByIdAgendamento(resultSet.getLong("id_agenda")));
                historico.setPaciente(pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente")));
                historico.setSecretaria(secretariaDao.findByIdSecretaria(resultSet.getLong("id_secretaria")));
                historico.setObservacao(resultSet.getString("observacao"));
                historico.setStatusAgendamento(resultSet.getString("status_agendamento"));
                historico.setCadastro(resultSet.getDate("cadastro"));
                historico.setAtualizado(resultSet.getDate("atualizado"));
                historico.setExcluido(resultSet.getDate("excluido"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historico;
    }

}
