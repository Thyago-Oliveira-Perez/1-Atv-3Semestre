package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Agendamento;
import br.com.agenda.model.StatusAgendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {

    PacienteDao pacienteDao = new PacienteDao();
    MedicoDao medicoDao = new MedicoDao();

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

        String sqlCreate = "create table if not exists agenda(\n" +
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

    public void insertAgendamento(Agendamento agendamento){
        String sqlInsert = "insert into agenda (cadastro," +
                "id_paciente, id_medico, status_agendamento, data_agendamento, encaixe) " +
                "values  (now(), ?, ?, ?, now(), ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setLong(1, agendamento.getPaciente().getId());
            preparedStatement.setLong(2, agendamento.getMedico().getId());
            preparedStatement.setString(3, agendamento.getStatusAgendamento());
            preparedStatement.setBoolean(4, agendamento.getEncaixe());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAgendamento(Agendamento agendamento, Long id){
        String sqlUpdate = "update agendamente set atualizado = now(), id_medico = ?," +
                "status_agendamento = ?, encaixe = ? where id_agenda = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setLong(1, agendamento.getMedico().getId());
            preparedStatement.setString(2, agendamento.getStatusAgendamento());
            preparedStatement.setBoolean(3, agendamento.getEncaixe());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusAgendamento(String status, Long id){
        String sqlUpdate = "update agendamente set status_agendamento = ? where id_agenda = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, status);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Agendamento> findAllAgendamento(){
        List<Agendamento> retornoBanco = new ArrayList<>();

        String sqlSelect = "select * from agenda;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Agendamento agendamento = new Agendamento();
                agendamento.setId(resultSet.getLong("id_agenda"));
                agendamento.setCadastro(resultSet.getDate("cadastro"));
                agendamento.setAtualizado(resultSet.getDate("atualizado"));
                agendamento.setExcluido(resultSet.getDate("excluido"));
                agendamento.setPaciente(pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente")));
                agendamento.setMedico(medicoDao.findByIdMedico(resultSet.getLong("id_medico")));
                agendamento.setStatusAgendamento(resultSet.getString("status_agendamento"));
                agendamento.setEncaixe(resultSet.getBoolean("encaixe"));
                retornoBanco.add(agendamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoBanco;
    }

    public Agendamento findByIdAgendamento(Long id){
        Agendamento agendamento = new Agendamento();
        String sqlSelect = "select * from agenda;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                agendamento.setId(resultSet.getLong("id_agenda"));
                agendamento.setCadastro(resultSet.getDate("cadastro"));
                agendamento.setAtualizado(resultSet.getDate("atualizado"));
                agendamento.setExcluido(resultSet.getDate("excluido"));
                agendamento.setPaciente(pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente")));
                agendamento.setMedico(medicoDao.findByIdMedico(resultSet.getLong("id_medico")));
                agendamento.setStatusAgendamento(resultSet.getString("status_agendamento"));
                agendamento.setEncaixe(resultSet.getBoolean("encaixe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendamento;
    }

}
