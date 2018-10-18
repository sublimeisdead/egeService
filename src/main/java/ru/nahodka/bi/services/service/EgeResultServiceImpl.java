package ru.nahodka.bi.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nahodka.bi.services.dao.interfaces.EgeResultDAO;
import ru.nahodka.bi.services.model.EgeResult;

import java.util.List;

@Service
public class EgeResultServiceImpl {
    private EgeResultDAO egeResultDAO;

    public void setEgeResultDAO(EgeResultDAO egeResultDAO){
        this.egeResultDAO=egeResultDAO;
    }


    @Autowired
    public EgeResultServiceImpl(EgeResultDAO egeResultDAO) {
        this.egeResultDAO = egeResultDAO;
    }


    public List<EgeResult> getEgeResults(String year, String passportSeries, String passportNumber, String subjectCode) {
        return egeResultDAO.getEgeResult(year,passportSeries,passportNumber,subjectCode);
    }


}
