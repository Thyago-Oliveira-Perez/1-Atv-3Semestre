package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MedicoDao {

    private static Connection connection;

    public MedicoDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_medico_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table medico(\n" +
                "\n" +
                "\tid bigint primary key default nextval('seq_medico_id'),\n" +
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
                "\tid_especialidade bigint not null,\n" +
                "\tcrm varchar(20) not null,\n" +
                "\tconsultorio varchar(40) not null,\n" +
                "\tporcen_participacao decimal(10,2) not null,\n" +
                "\tconstraint fk_id_especialidade foreign key(id_especialidade) references especialidade(id)\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMedico(Medico medico){}

    public void updateMedico(Medico medico){}

    public void updateStatusMedico(Long id){}

    public List<Medico> findAllMedico(){
        return null;
    }

    public Medico findByIdMedico(Long id){
        return null;
    }

}
