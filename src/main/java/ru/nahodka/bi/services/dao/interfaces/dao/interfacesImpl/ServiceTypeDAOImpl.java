package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.ServiceTypeDAO;
import ru.nahodka.bi.services.model.dictionaries.ServiceType;

import javax.annotation.Resource;
import java.util.List;

@Repository("ServiceTypeDAO")
@Transactional(rollbackFor = Exception.class)
public class ServiceTypeDAOImpl implements ServiceTypeDAO {

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
    public List<ServiceType> getServiceTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select st from ServiceType st").list();
    }
}
