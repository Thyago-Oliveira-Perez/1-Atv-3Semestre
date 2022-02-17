package service;

import dao.EspecialidadeDao;
import model.Especialidade;

import java.util.List;

public class EspecialidadeService {

    EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    public void insertEspecialidade(Especialidade especialidade){
        especialidadeDao.insertEspecialidade(especialidade);
    }

    public void updateEspecialidade(Especialidade especialidade){
        especialidadeDao.updateEspecialidade(especialidade);
    }

    public void updateStatusEspecialidade(Long id){
        especialidadeDao.updateStatusEspecialidade(id);
    }

    public List<Especialidade> findAllEspecialidade(){
        return especialidadeDao.findAllEspecialidade();
    }

    public Especialidade findByIdEspecialidade(Long id){
        return especialidadeDao.findByIdEspecialidade(id);
    }

}
