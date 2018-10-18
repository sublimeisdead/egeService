package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.ApplicationTypeDAO;
import ru.nahodka.bi.services.model.dictionaries.ApplicationType;

import javax.annotation.Resource;
import java.util.List;

@Repository("ApplicationTypeDAO")
@Transactional(rollbackFor = Exception.class)
public class ApplicationTypeDAOImpl implements ApplicationTypeDAO {

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
    public List<ApplicationType> getApplicationTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select at from ApplicationType at").list();
    }
}
