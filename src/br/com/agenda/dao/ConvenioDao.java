package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Convenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDao {

    private static Connection connection;

    public ConvenioDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_convenio_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table if not exists convenio(\n" +
                "\tid bigint primary key default nextval('seq_convenio_id'),\n" +
                "\tcadastrado timestamp not null,\n" +
                "\tatualizado timestamp,\n" +
                "\texcluido timestamp,\n" +
                "\tnome varchar(20) not null,\n" +
                "\tvalor decimal(10,2) not null\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertConvenio(Convenio convenio){
        String sqlInsert = "insert into convenio (nome_convenio, atualizado, excluido, cadastrado, valor)" +
                "values (?, now(), ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, convenio.getNomeConvenio());
            preparedStatement.setBigDecimal(2, convenio.getValorConvenio());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateConvenio(Convenio convenio, Long id){
        String sqlInsert = "update convenio set nome_convenio = ?, atualizado = now(), valor =?" +
                "where id_convenio = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, convenio.getNomeConvenio());
            preparedStatement.setBigDecimal(2, convenio.getValorConvenio());
            preparedStatement.setLong(3, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusConvenio(Boolean status, Long id){
        String sqlInsert = "update convenio set ativo = ?" +
                "where id_convenio = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Convenio> findAllConvenio(){
        List<Convenio> retornoBanco = new ArrayList<>();

        String sqlUpdate = "select * from convenio;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Convenio convenio = new Convenio();
                convenio.setNomeConvenio(resultSet.getString("nome_convenio"));
                convenio.setValorConvenio(resultSet.getBigDecimal("valor"));
                convenio.setCadastro(resultSet.getDate("cadastrado"));
                convenio.setExcluido(resultSet.getDate("excluido"));
                convenio.setAtualizado(resultSet.getDate("atualizado"));
                retornoBanco.add(convenio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornoBanco;
    }

    public Convenio findByIdConvenio(Long id){

        Convenio convenio = new Convenio();
        String sqlUpdate = "select * from convenio where id_convenio = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                convenio.setNomeConvenio(resultSet.getString("nome_convenio"));
                convenio.setValorConvenio(resultSet.getBigDecimal("valor"));
                convenio.setCadastro(resultSet.getDate("cadastrado"));
                convenio.setExcluido(resultSet.getDate("excluido"));
                convenio.setAtualizado(resultSet.getDate("atualizado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convenio;
    }

}
