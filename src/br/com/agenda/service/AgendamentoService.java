package br.com.agenda.service;

import br.com.agenda.model.Agendamento;
import br.com.agenda.dao.AgendamentoDao;

import java.util.List;

public class AgendamentoService {

    AgendamentoDao agendamentoDao = new AgendamentoDao();

    public void insertAgendamento(Agendamento agendamento){
        agendamentoDao.insertAgendamento(agendamento);
    }

    public void updateAgendamento(Agendamento agendamento){
        agendamentoDao.updateAgendamento(agendamento);
    }

    public void updateStatusAgendamento(Long id){
        agendamentoDao.updateStatusAgendamento(id);
    }

    public List<Agendamento> findAllAgendamento(){
        return agendamentoDao.findAllAgendamento();
    }

    public Agendamento findByIdAgendamento(Long id){
        return agendamentoDao.findByIdAgendamento(id);
    }

}
