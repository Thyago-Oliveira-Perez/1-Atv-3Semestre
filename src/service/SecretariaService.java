package service;

import dao.SecretariaDao;
import model.Secretaria;

import java.util.List;

public class SecretariaService {

    SecretariaDao secretariaDao = new SecretariaDao();

    public void insertSecretaria(Secretaria secretaria){
        secretariaDao.insertSecretaria(secretaria);
    }

    public void updateSecretaria(Secretaria secretaria){
        secretariaDao.updateSecretaria(secretaria);
    }

    public void updateStatusSecretaria(Long id){
        secretariaDao.updateStatusSecretaria(id);
    }

    public List<Secretaria> findAllSecretaria(){
        return secretariaDao.findAllSecretaria();
    }

    public Secretaria findByIdSecretaria(Long id){
        return secretariaDao.findByIdSecretaria(id);
    }


}
