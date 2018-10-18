package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.dictionaries.ServiceType;

import java.util.List;

public interface ServiceTypeDAO {

    List<ServiceType> getServiceTypeList();
}
