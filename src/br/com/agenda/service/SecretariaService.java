package br.com.agenda.service;

import br.com.agenda.model.Secretaria;
import br.com.agenda.dao.SecretariaDao;

import java.util.List;

public class SecretariaService {

    SecretariaDao secretariaDao = new SecretariaDao();

    public void insertSecretaria(Secretaria secretaria){
        secretariaDao.insertSecretaria(secretaria);
    }

    public void updateSecretaria(Secretaria secretaria, Long id){
        secretariaDao.updateSecretaria(secretaria, id);
    }

    public void updateStatusSecretaria(Boolean status, Long id){
        secretariaDao.updateStatusSecretaria(status, id);
    }

    public List<Secretaria> findAllSecretaria(){
        return secretariaDao.findAllSecretaria();
    }

    public Secretaria findByIdSecretaria(Long id){
        return secretariaDao.findByIdSecretaria(id);
    }


}
