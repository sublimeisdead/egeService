package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.EgeResult;

import java.util.List;

public interface EgeResultDAO {


   List<EgeResult> getEgeResult(String year, String passportSeries, String passportNumber, String subjectCode);
}
