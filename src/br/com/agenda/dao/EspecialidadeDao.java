package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDao {

    private static Connection connection;

    public EspecialidadeDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_especialidade_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table if not exists especialidade(\n" +
                "\tid bigint primary key default nextval('seq_especialidade_id'),\n" +
                "\tcadastrado timestamp not null,\n" +
                "\tatualizado timestamp,\n" +
                "\texcluido timestamp,\n" +
                "\tnome varchar(50) not null\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEspecialidade(Especialidade especialidade){
        String sqlInsert = "insert into especialidade (nome_especialidade, cadastrado) " +
                "values (?, now());";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, especialidade.getNomeEspecialidade());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEspecialidade(Especialidade especialidade, Long id){
        String sqlUpdate = "update especialidade set nome_especialidade = ? where id_especialidade = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, especialidade.getNomeEspecialidade());
            preparedStatement.setLong(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusEspecialidade(Boolean status, Long id){
        String sqlUpdate = "update especialidade set ativo = ? where id_especialidade = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setLong(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Especialidade> findAllEspecialidade(){
        List<Especialidade> retornoBanco = new ArrayList<>();
        String sqlSelect = "select * from especialidade;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setId(resultSet.getLong("id_especialidade"));
                especialidade.setNomeEspecialidade(resultSet.getString("nome_especialidade"));
                especialidade.setAtualizado(resultSet.getDate("atualizado"));
                especialidade.setExcluido(resultSet.getDate("excluido"));
                especialidade.setCadastro(resultSet.getDate("cadastrado"));
                retornoBanco.add(especialidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornoBanco;
    }

    public Especialidade findByIdEspecialidade(Long id){
        Especialidade especialidade = new Especialidade();

        String sqlSelect = "select * from especialidade where id_especialidae = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidade;
    }

}
