package ru.nahodka.bi.services.dao.interfaces;

import ru.nahodka.bi.services.model.EgeRequest;

import java.io.Serializable;

public interface EgeRequestDAO {

    Serializable saveEgeRequest(EgeRequest egeRequest);
}
