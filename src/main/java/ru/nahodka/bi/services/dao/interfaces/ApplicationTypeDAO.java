package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.dictionaries.ApplicationType;

import java.util.List;

public interface ApplicationTypeDAO {

    List<ApplicationType> getApplicationTypeList();
}
