package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.Appeal;

import java.io.Serializable;

public interface AppealDAO {

    Serializable saveAppealRequest(Appeal appealRequest);
}
