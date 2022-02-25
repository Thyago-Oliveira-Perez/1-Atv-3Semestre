package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Secretaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SecretariaDao {

    private static Connection connection;

    public SecretariaDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_secretaria_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table secretaria(\n" +
                "\n" +
                "\tid bigint primary key default nextval('seq_secretaria_id'),\n" +
                "\tcadastrado timestamp not null,\n" +
                "\tatualizado timestamp,\n" +
                "\texcluido timestamp,\n" +
                "\tnome varchar(50) not null,\n" +
                "\temail varchar(255) not null,\n" +
                "\tlogin varchar(30) not null,\n" +
                "\tsenha varchar(32) not null,\n" +
                "\tcpf varchar(16) not null,\n" +
                "\trg varchar(14) not null,\n" +
                "\tcep varchar(9) not null,\n" +
                "\ttelefone varchar(18) not null,\n" +
                "\tnacionalidade varchar(50) not null,\n" +
                "\tsexo varchar(10) not null,\n" +
                "\tsalario decimal(10,2) not null,\n" +
                "\tdata_contratacao timestamp not null,\n" +
                "\tpis varchar(15) not null\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSecretaria(Secretaria secretaria){}

    public void updateSecretaria(Secretaria secretaria){}

    public void updateStatusSecretaria(Long id){}

    public List<Secretaria> findAllSecretaria(){
        return null;
    }

    public Secretaria findByIdSecretaria(Long id){
        return null;
    }

}
