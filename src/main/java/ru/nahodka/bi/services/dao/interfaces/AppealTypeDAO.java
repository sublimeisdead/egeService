package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.dictionaries.AppealType;

import java.util.List;

public interface AppealTypeDAO {

    List<AppealType> getAppealTypeList();
}
