package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Paciente;
import br.com.agenda.model.Sexo;

import javax.lang.model.element.PackageElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private static Connection connection;

    public PacienteDao() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSeq(){
        String sqlSeq = "create sequence seq_paciente_id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSeq);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sqlCreate = "create table if not exists paciente(\n" +
                "\tid bigint primary key default nextval('seq_paciente_id'),\n" +
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
                "\ttipo_atendimento varchar(11) not null,\n" +
                "\tid_convenio bigint not null,\n" +
                "\tnumero_cartao_convenio varchar(20) not null,\n" +
                "\tdata_vencimento timestamp not null,\n" +
                "\tconstraint fk_id_convenio foreign key(id_convenio) references convenio(id)\n" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPaciente(Paciente paciente){

        String sqlInsert = "insert into paciente (nome_paciente, email, login, senha, " +
                "cpf, rg, cep, telefone, nacionalidade, sexo, tipo_atendimento, ativo, " +
                "cadastrado) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4, paciente.getSenha());
            preparedStatement.setString(5, paciente.getCpf());
            preparedStatement.setString(6, paciente.getRg());
            preparedStatement.setString(7, paciente.getCep());
            preparedStatement.setString(8, paciente.getTelefone());
            preparedStatement.setString(9, paciente.getNacionalidade());
            preparedStatement.setString(10, paciente.getSexo());
            preparedStatement.setString(11, paciente.getTipoAtendimento());
            preparedStatement.setBoolean(12, paciente.getAtivo());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatePaciente(Paciente paciente, int id){
        String sqlUpdate = "update paciente\n" +
                "set nome_paciente = ?, email = ?, login = ?, senha = ?, cpf = ?, rg = ?," +
                "cep = ?, telefone = ?, nacionalidade = ?, sexo = ?, tipo_atendimento = ?, " +
                "id_convenio = ?, n_cartao_convenio = ?, data_vencimento = ?, ativo = ?\n" +
                "where id_paciente = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4, paciente.getSenha());
            preparedStatement.setString(5, paciente.getCpf());
            preparedStatement.setString(6, paciente.getRg());
            preparedStatement.setString(7, paciente.getCep());
            preparedStatement.setString(8, paciente.getTelefone());
            preparedStatement.setString(9, paciente.getNacionalidade());
            preparedStatement.setString(10, paciente.getSexo());
            preparedStatement.setString(11, paciente.getTipoAtendimento());
            preparedStatement.setInt(12, paciente.getId_convenio().intValue());
            preparedStatement.setString(13, paciente.getN_cartao_convenio());
            preparedStatement.setLong(14, paciente.getData_vencimento().getTime());
            preparedStatement.setBoolean(15, paciente.getAtivo());
            preparedStatement.setInt(16, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusPaciente(Boolean status, Long id){
        String sqlUpdate = "UPDATE paciente\n" +
                "SET ativo = ?\n" +
                "WHERE id_paciente = ?;";
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

    public List<Paciente> findAllPaciente(){
        List<Paciente> retornoBanco = new ArrayList<>();

        String sqlSelect = "select * from paciente;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Paciente paciente = new Paciente();
                paciente.setId(resultSet.getLong("id_paciente"));
                paciente.setNome(resultSet.getString("nome_paciente"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setLogin(resultSet.getString("login"));
                paciente.setSenha(resultSet.getString("senha"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setRg(resultSet.getString("rg"));
                paciente.setCep(resultSet.getString("cep"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "MASCULINO":
                        paciente.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        paciente.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        paciente.setSexo(Sexo.outro.valor);
                }
                paciente.setTipoAtendimento(resultSet.getString("tipo_atendimento"));
                paciente.setId_convenio(resultSet.getLong("id_convenio"));
                paciente.setN_cartao_convenio(resultSet.getString("n_cartao_convenio"));
                paciente.setData_vencimento(resultSet.getDate("data_vencimento"));
                paciente.setCadastro(resultSet.getDate("cadastrado"));
                paciente.setAtualizado(resultSet.getDate("atualizado"));
                paciente.setExcluido(resultSet.getDate("excluido"));
                paciente.setAtivo(resultSet.getBoolean("ativo"));
                retornoBanco.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoBanco;
    }

    public Paciente findByIdPaciente(Long id){
        Paciente paciente = new Paciente();
        String sqlSelect = "select * from paciente where id_paciente = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                preparedStatement.setLong(1, id);
                paciente.setId(resultSet.getLong("id_paciente"));
                paciente.setNome(resultSet.getString("nome_paciente"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setLogin(resultSet.getString("login"));
                paciente.setSenha(resultSet.getString("senha"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setRg(resultSet.getString("rg"));
                paciente.setCep(resultSet.getString("cep"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")) {
                    case "MASCULINO":
                        paciente.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        paciente.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        paciente.setSexo(Sexo.outro.valor);
                }
                paciente.setTipoAtendimento(resultSet.getString("tipo_atendimento"));
                paciente.setId_convenio(resultSet.getLong("id_convenio"));
                paciente.setN_cartao_convenio(resultSet.getString("n_cartao_convenio"));
                paciente.setData_vencimento(resultSet.getDate("data_vencimento"));
                paciente.setCadastro(resultSet.getDate("cadastrado"));
                paciente.setAtualizado(resultSet.getDate("atualizado"));
                paciente.setExcluido(resultSet.getDate("excluido"));
                paciente.setAtivo(resultSet.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

}
