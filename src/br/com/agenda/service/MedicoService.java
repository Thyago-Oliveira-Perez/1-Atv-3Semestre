package br.com.agenda.service;

import br.com.agenda.dao.MedicoDao;
import br.com.agenda.model.Medico;

import java.util.List;

public class MedicoService {

    MedicoDao medicoDao = new MedicoDao();

    public void insertMedico(Medico medico){
        medicoDao.insertMedico(medico);
    }

    public void updateMedico(Medico medico, Long id){
        medicoDao.updateMedico(medico, id);
    }

    public void updateStatusMedico(Boolean status, Long id){
        medicoDao.updateStatusMedico(status, id);
    }

    public List<Medico> findAllMedico(){
        return medicoDao.findAllMedico();
    }

    public Medico findByIdMedico(Long id){
        return medicoDao.findByIdMedico(id);
    }

}
