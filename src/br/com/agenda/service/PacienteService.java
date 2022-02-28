package br.com.agenda.service;

import br.com.agenda.model.Paciente;
import br.com.agenda.dao.PacienteDao;

import java.util.List;

public class PacienteService {

    PacienteDao pacienteDao = new PacienteDao();

    public void insertPaciente(Paciente paciente){
        pacienteDao.insertPaciente(paciente);
    }

    public void updatePaciente(Paciente paciente, int id){
        pacienteDao.updatePaciente(paciente, id);
    }

    public void updateStatusPaciente(Boolean status, Long id){
        pacienteDao.updateStatusPaciente(status, id);
    }

    public List<Paciente> findAllPaciente(){
        return pacienteDao.findAllPaciente();
    }

    public Paciente findByIdPaciente(Long id){
        return pacienteDao.findByIdPaciente(id);
    }

}
