package br.com.agenda.service;

import br.com.agenda.model.Agendamento;
import br.com.agenda.dao.AgendamentoDao;

import java.util.List;

public class AgendamentoService {

    AgendamentoDao agendamentoDao = new AgendamentoDao();

    public void insertAgendamento(Agendamento agendamento){
        agendamentoDao.insertAgendamento(agendamento);
    }

    public void updateAgendamento(Agendamento agendamento, Long id){
        agendamentoDao.updateAgendamento(agendamento, id);
    }

    public void updateStatusAgendamento(String status, Long id){
        agendamentoDao.updateStatusAgendamento(status, id);
    }

    public List<Agendamento> findAllAgendamento(){
        return agendamentoDao.findAllAgendamento();
    }

    public Agendamento findByIdAgendamento(Long id){
        return agendamentoDao.findByIdAgendamento(id);
    }

}
