package service;

import dao.MedicoDao;
import model.Medico;

import java.util.List;

public class MedicoService {

    MedicoDao medicoDao = new MedicoDao();

    public void insertMedico(Medico medico){
        medicoDao.insertMedico(medico);
    }

    public void updateMedico(Medico medico){
        medicoDao.updateMedico(medico);
    }

    public void updateStatusMedico(Long id){
        medicoDao.updateStatusMedico(id);
    }

    public List<Medico> findAllMedico(){
        return medicoDao.findAllMedico();
    }

    public Medico findByIdMedico(Long id){
        return medicoDao.findByIdMedico(id);
    }

}
