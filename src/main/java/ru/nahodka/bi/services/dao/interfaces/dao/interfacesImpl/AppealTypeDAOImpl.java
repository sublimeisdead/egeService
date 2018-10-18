package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.AppealTypeDAO;
import ru.nahodka.bi.services.model.dictionaries.AppealType;

import javax.annotation.Resource;
import java.util.List;

@Repository("AppealTypeDAO")
@Transactional(rollbackFor = Exception.class)
public class AppealTypeDAOImpl implements AppealTypeDAO {

    private SessionFactory sessionFactory;
    private MessageSource messageSource;


    @Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AppealType> getAppealTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select at from AppealType at").list();
    }
}
