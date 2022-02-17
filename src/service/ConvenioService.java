package service;

import dao.ConvenioDao;
import model.Convenio;

import java.util.List;

public class ConvenioService {

    ConvenioDao convenioDao = new ConvenioDao();

    public void insertConvenio(Convenio convenio){
        convenioDao.insertConvenio(convenio);
    }

    public void updateConvenio(Convenio convenio){
        convenioDao.updateConvenio(convenio);
    }

    public void updateStatusConvenio(Long id){
        convenioDao.updateStatusConvenio(id);
    }

    public List<Convenio> findAllConvenio(){
        return convenioDao.findAllConvenio();
    }

    public Convenio findByIdConvenio(Long id){
        return convenioDao.findByIdConvenio(id);
    }

}
