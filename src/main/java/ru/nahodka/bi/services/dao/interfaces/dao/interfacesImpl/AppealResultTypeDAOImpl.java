package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.AppealResultTypeDAO;
import ru.nahodka.bi.services.model.dictionaries.AppealResultType;

import javax.annotation.Resource;
import java.util.List;

@Repository("AppealResultTypeDAO")
@Transactional(rollbackFor = Exception.class)
public class AppealResultTypeDAOImpl implements AppealResultTypeDAO {

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
    public List<AppealResultType> getAppealResultTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select art from AppealResultType art").list();
    }
}
