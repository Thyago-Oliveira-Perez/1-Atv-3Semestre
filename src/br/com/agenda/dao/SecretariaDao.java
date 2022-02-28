package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Paciente;
import br.com.agenda.model.Secretaria;
import br.com.agenda.model.Sexo;

import java.sql.*;
import java.util.ArrayList;
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

        String sqlCreate = "create table if not exists secretaria(\n" +
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

    public void insertSecretaria(Secretaria secretaria){
        String sqlInsert = "insert into secretaria (nome_secretaria, email, login, senha, " +
                "cpf, rg, cep, telefone, nacionalidade, sexo, salario, " +
                "data_contratacao, pis, ativo) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, secretaria.getNome());
            preparedStatement.setString(2, secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4, secretaria.getSenha());
            preparedStatement.setString(5, secretaria.getCpf());
            preparedStatement.setString(6, secretaria.getRg());
            preparedStatement.setString(7, secretaria.getCep());
            preparedStatement.setString(8, secretaria.getTelefone());
            preparedStatement.setString(9, secretaria.getNacionalidade());
            preparedStatement.setString(10, secretaria.getSexo());
            preparedStatement.setBigDecimal(11, secretaria.getSalario());
            preparedStatement.setDate(12, (Date) secretaria.getDataContratacao());
            preparedStatement.setString(13, secretaria.getPis());
            preparedStatement.setBoolean(14, secretaria.getAtivo());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSecretaria(Secretaria secretaria, Long id){
        String sqlUpdate = "update secretaria\n" +
                "set nome_secretaria = ?, email = ?, login = ?, senha = ?, cpf = ?, rg = ?," +
                "cep = ?, telefone = ?, nacionalidade = ?, sexo = ?, salario = ?, ativo = ?\n" +
                "where id_secretaria = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, secretaria.getNome());
            preparedStatement.setString(2, secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4, secretaria.getSenha());
            preparedStatement.setString(5, secretaria.getCpf());
            preparedStatement.setString(6, secretaria.getRg());
            preparedStatement.setString(7, secretaria.getCep());
            preparedStatement.setString(8, secretaria.getTelefone());
            preparedStatement.setString(9, secretaria.getNacionalidade());
            preparedStatement.setString(10, secretaria.getSexo());
            preparedStatement.setBigDecimal(11, secretaria.getSalario());
            preparedStatement.setBoolean(12, secretaria.getAtivo());
            preparedStatement.setLong(13, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusSecretaria(Boolean status, Long id){
        String sqlUpdate = "UPDATE secretaria\n" +
                "SET ativo = ?\n" +
                "WHERE id_secretaria = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Secretaria> findAllSecretaria(){
        List<Secretaria> retornoBanco = new ArrayList<>();

        String sqlSelect = "select * from secretaria;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Secretaria secretaria = new Secretaria();
                secretaria.setId(resultSet.getLong("id_paciente"));
                secretaria.setNome(resultSet.getString("nome_paciente"));
                secretaria.setEmail(resultSet.getString("email"));
                secretaria.setLogin(resultSet.getString("login"));
                secretaria.setSenha(resultSet.getString("senha"));
                secretaria.setCpf(resultSet.getString("cpf"));
                secretaria.setRg(resultSet.getString("rg"));
                secretaria.setCep(resultSet.getString("cep"));
                secretaria.setTelefone(resultSet.getString("telefone"));
                secretaria.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "MASCULINO":
                        secretaria.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        secretaria.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        secretaria.setSexo(Sexo.outro.valor);
                }
                secretaria.setSalario(resultSet.getBigDecimal("salario"));
                secretaria.setDataContratacao(resultSet.getDate("data_contratacao"));
                secretaria.setPis(resultSet.getString("pis"));
                secretaria.setCadastro(resultSet.getDate("cadastrado"));
                secretaria.setAtualizado(resultSet.getDate("atualizado"));
                secretaria.setExcluido(resultSet.getDate("excluido"));
                secretaria.setAtivo(resultSet.getBoolean("ativo"));
                retornoBanco.add(secretaria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornoBanco;
    }

    public Secretaria findByIdSecretaria(Long id){
        Secretaria secretaria = new Secretaria();

        String sqlSelect = "select * from secretaria where id_secretaria = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                secretaria.setId(resultSet.getLong("id_paciente"));
                secretaria.setNome(resultSet.getString("nome_paciente"));
                secretaria.setEmail(resultSet.getString("email"));
                secretaria.setLogin(resultSet.getString("login"));
                secretaria.setSenha(resultSet.getString("senha"));
                secretaria.setCpf(resultSet.getString("cpf"));
                secretaria.setRg(resultSet.getString("rg"));
                secretaria.setCep(resultSet.getString("cep"));
                secretaria.setTelefone(resultSet.getString("telefone"));
                secretaria.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "MASCULINO":
                        secretaria.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        secretaria.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        secretaria.setSexo(Sexo.outro.valor);
                }
                secretaria.setSalario(resultSet.getBigDecimal("salario"));
                secretaria.setDataContratacao(resultSet.getDate("data_contratacao"));
                secretaria.setPis(resultSet.getString("pis"));
                secretaria.setCadastro(resultSet.getDate("cadastrado"));
                secretaria.setAtualizado(resultSet.getDate("atualizado"));
                secretaria.setExcluido(resultSet.getDate("excluido"));
                secretaria.setAtivo(resultSet.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secretaria;
    }

}
