package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.EgeRequestDAO;
import ru.nahodka.bi.services.model.EgeRequest;

import javax.annotation.Resource;
import java.io.Serializable;

@Repository("egeRequestDAO")
@Transactional(rollbackFor = Exception.class)
public class EgeRequestDAOImpl implements EgeRequestDAO {

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
    public Serializable saveEgeRequest(EgeRequest egeRequest) {
        return sessionFactory.getCurrentSession().save(egeRequest);
    }
}
