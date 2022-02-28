package br.com.agenda.service;

import br.com.agenda.dao.HistoricoDao;
import br.com.agenda.model.Historico;

import java.util.List;

public class HistoricoService {

    HistoricoDao historicoDao = new HistoricoDao();

    public void insertHistorico(Historico historico){
        historicoDao.insertHistorico(historico);
    }

    public List<Historico> findAllHistorico(){
        return historicoDao.findAllHistorico();
    }

    public Historico findByIdHistorico(Long id){
        return historicoDao.findByIdHistorico(id);
    }

}
