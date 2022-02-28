package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Medico;
import br.com.agenda.model.Paciente;
import br.com.agenda.model.Sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDao {

    EspecialidadeDao especialidadeDao = new EspecialidadeDao();

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

        String sqlCreate = "create table if not exists medico(\n" +
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

    public void insertMedico(Medico medico){
        String sqlInsert = "insert into medico (nome_medico, email, login, senha, " +
                "cpf, rg, cep, telefone, nacionalidade, sexo, id_especialidade, " +
                "crm, consultorio, porcent_participacao, ativo, cadastrado) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getLogin());
            preparedStatement.setString(4, medico.getSenha());
            preparedStatement.setString(5, medico.getCpf());
            preparedStatement.setString(6, medico.getRg());
            preparedStatement.setString(7, medico.getCep());
            preparedStatement.setString(8, medico.getTelefone());
            preparedStatement.setString(9, medico.getNacionalidade());
            preparedStatement.setString(10, medico.getSexo());
            preparedStatement.setLong(11, medico.getEspecialidade().getId());
            preparedStatement.setString(12, medico.getCrm());
            preparedStatement.setString(13, medico.getConsultorio());
            preparedStatement.setBigDecimal(14, medico.getPorcentParticipacao());
            preparedStatement.setBoolean(15, medico.getAtivo());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMedico(Medico medico, Long id){
        String sqlUpdate = "update medico\n" +
                "set nome_medico = ?, email = ?, login = ?, senha = ?, cpf = ?, rg = ?," +
                "cep = ?, telefone = ?, nacionalidade = ?, sexo = ?, id_especialidade = ?, crm = ?," +
                "consultorio = ?, porcent_participacao = ?" +
                "where id_medico = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getLogin());
            preparedStatement.setString(4, medico.getSenha());
            preparedStatement.setString(5, medico.getCpf());
            preparedStatement.setString(6, medico.getRg());
            preparedStatement.setString(7, medico.getCep());
            preparedStatement.setString(8, medico.getTelefone());
            preparedStatement.setString(9, medico.getNacionalidade());
            preparedStatement.setString(10, medico.getSexo());
            preparedStatement.setLong(11, medico.getEspecialidade().getId());
            preparedStatement.setString(12, medico.getCrm());
            preparedStatement.setString(13, medico.getConsultorio());
            preparedStatement.setBigDecimal(14, medico.getPorcentParticipacao());
            preparedStatement.setLong(15, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusMedico(Boolean status, Long id){
        String sqlUpdate = "UPDATE medico\n" +
                "SET ativo = ?\n" +
                "WHERE id_medico = ?;";
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

    public List<Medico> findAllMedico(){
        List<Medico> retornoBanco = new ArrayList<>();

        String sqlSelect = "select * from medico;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Medico medico = new Medico();
                medico.setId(resultSet.getLong("id_medico"));
                medico.setNome(resultSet.getString("nome_medico"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setRg(resultSet.getString("rg"));
                medico.setCep(resultSet.getString("cep"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "MASCULINO":
                        medico.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        medico.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        medico.setSexo(Sexo.outro.valor);
                }
                medico.setEspecialidade(especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidae")));
                medico.setCrm(resultSet.getString("crm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcentParticipacao(resultSet.getBigDecimal("porcent_participacao"));
                medico.setCadastro(resultSet.getDate("cadastrado"));
                medico.setAtualizado(resultSet.getDate("atualizado"));
                medico.setExcluido(resultSet.getDate("excluido"));
                medico.setAtivo(resultSet.getBoolean("ativo"));
                retornoBanco.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornoBanco;
    }

    public Medico findByIdMedico(Long id){

        Medico medico = new Medico();
        String sqlSelect = "select * from medico where id_medico = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                medico.setId(resultSet.getLong("id_medico"));
                medico.setNome(resultSet.getString("nome_medico"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setRg(resultSet.getString("rg"));
                medico.setCep(resultSet.getString("cep"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "MASCULINO":
                        medico.setSexo(Sexo.masculino.valor);
                    case "FEMININO":
                        medico.setSexo(Sexo.feminino.valor);
                    case "OUTRO":
                        medico.setSexo(Sexo.outro.valor);
                }
                medico.setEspecialidade(especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidae")));
                medico.setCrm(resultSet.getString("crm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcentParticipacao(resultSet.getBigDecimal("porcent_participacao"));
                medico.setCadastro(resultSet.getDate("cadastrado"));
                medico.setAtualizado(resultSet.getDate("atualizado"));
                medico.setExcluido(resultSet.getDate("excluido"));
                medico.setAtivo(resultSet.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

}
