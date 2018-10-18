package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.EduOrganizationDAO;
import ru.nahodka.bi.services.model.dictionaries.EduOrganization;

import javax.annotation.Resource;
import java.util.List;

@Repository("EduOrganizationDAO")
@Transactional(rollbackFor = Exception.class)
public class EduOrganizationDAOImpl implements EduOrganizationDAO {

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
    public List<EduOrganization> getEduOrganizationList() {
        return sessionFactory.getCurrentSession().createQuery("select eo from EduOrganization eo").list();
    }
}
