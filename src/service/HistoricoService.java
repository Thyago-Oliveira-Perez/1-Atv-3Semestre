package service;

import dao.HistoricoDao;
import model.Historico;

import java.util.List;

public class HistoricoService {

    HistoricoDao historicoDao = new HistoricoDao();

    public void insertHistorico(Historico historico){
        historicoDao.insertHistorico(historico);
    }

    public void updateHistorico(Historico historico){
        historicoDao.updateHistorico(historico);
    }

    public void updateStatusHistorico(Long id){
        historicoDao.updateStatusHistorico(id);
    }

    public List<Historico> findAllHistorico(){
        return historicoDao.findAllHistorico();
    }

    public Historico findByIdHistorico(Long id){
        return historicoDao.findByIdHistorico(id);
    }

}
