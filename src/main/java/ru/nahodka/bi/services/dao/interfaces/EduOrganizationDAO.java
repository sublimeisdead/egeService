package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.dictionaries.EduOrganization;

import java.util.List;

public interface EduOrganizationDAO {

    List<EduOrganization> getEduOrganizationList();
}
