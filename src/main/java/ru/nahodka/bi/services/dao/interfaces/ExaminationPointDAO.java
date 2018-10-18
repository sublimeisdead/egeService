package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.dictionaries.ExaminationPoint;

import java.util.List;

public interface ExaminationPointDAO {

    List<ExaminationPoint> getExaminationPointList();
}
