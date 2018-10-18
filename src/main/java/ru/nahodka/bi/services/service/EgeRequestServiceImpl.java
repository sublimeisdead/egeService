package ru.nahodka.bi.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nahodka.bi.services.dao.interfaces.EgeRequestDAO;
import ru.nahodka.bi.services.model.EgeRequest;

import java.io.Serializable;

@Service
public class EgeRequestServiceImpl {
    private EgeRequestDAO egeRequestDAO;

    public void setEgeRequestDAO(EgeRequestDAO egeRequestDAO) {
        this.egeRequestDAO = egeRequestDAO;
    }

    @Autowired
    public EgeRequestServiceImpl(EgeRequestDAO egeRequestDao) {
        this.egeRequestDAO = egeRequestDao;
    }

    public Serializable saveEgeRequest(EgeRequest egeRequest){
        return egeRequestDAO.saveEgeRequest(egeRequest);
    }

}
