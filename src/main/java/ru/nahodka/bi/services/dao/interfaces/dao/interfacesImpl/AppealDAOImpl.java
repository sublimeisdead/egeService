package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.AppealDAO;
import ru.nahodka.bi.services.model.Appeal;

import javax.annotation.Resource;
import java.io.Serializable;

@Repository("appealRequestDAO")
@Transactional(rollbackFor = Exception.class)
public class AppealDAOImpl implements AppealDAO {

    private SessionFactory sessionFactory;
    private MessageSource messageSource;


    @Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Resource(name="sessionFactory2")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable saveAppealRequest(Appeal appealRequest) {
        return sessionFactory.getCurrentSession().save(appealRequest);
    }
}
