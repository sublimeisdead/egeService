package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.AppealRequestStateDAO;
import ru.nahodka.bi.services.model.AppealRequestState;

import javax.annotation.Resource;


@Repository("appealRequestStateDAO")
@Transactional(rollbackFor = Exception.class)
public class AppealRequestStateDAOImpl implements AppealRequestStateDAO {

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
    public AppealRequestState saveAppealRequestState(AppealRequestState appealRequest) {
        sessionFactory.getCurrentSession().save(appealRequest);
        return appealRequest;
    }
}
