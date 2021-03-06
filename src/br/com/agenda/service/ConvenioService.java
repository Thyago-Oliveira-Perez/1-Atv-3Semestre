package br.com.agenda.service;

import br.com.agenda.dao.ConvenioDao;
import br.com.agenda.model.Convenio;

import java.util.List;

public class ConvenioService {

    ConvenioDao convenioDao = new ConvenioDao();

    public void insertConvenio(Convenio convenio){
        convenioDao.insertConvenio(convenio);
    }

    public void updateConvenio(Convenio convenio, Long id){
        convenioDao.updateConvenio(convenio, id);
    }

    public void updateStatusConvenio(Boolean status, Long id){
        convenioDao.updateStatusConvenio(status, id);
    }

    public List<Convenio> findAllConvenio(){
        return convenioDao.findAllConvenio();
    }

    public Convenio findByIdConvenio(Long id){
        return convenioDao.findByIdConvenio(id);
    }

}
