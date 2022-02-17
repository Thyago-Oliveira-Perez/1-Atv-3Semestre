package service;

import dao.PacienteDao;
import model.Paciente;

import java.util.List;

public class PacienteService {

    PacienteDao pacienteDao = new PacienteDao();

    public void insertPaciente(Paciente paciente){
        pacienteDao.insertPaciente(paciente);
    }

    public void updatePaciente(Paciente paciente){
        pacienteDao.updatePaciente(paciente);
    }

    public void updateStatusPaciente(Long id){
        pacienteDao.updateStatusPaciente(id);
    }

    public List<Paciente> findAllPaciente(){
        return pacienteDao.findAllPaciente();
    }

    public Paciente findByIdPaciente(Long id){
        return pacienteDao.findByIdPaciente(id);
    }

}
