package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.ExaminationPointDAO;
import ru.nahodka.bi.services.model.dictionaries.ExaminationPoint;

import javax.annotation.Resource;
import java.util.List;

@Repository("ExaminationPointDAO")
@Transactional(rollbackFor = Exception.class)
public class ExaminationPointDAOImpl implements ExaminationPointDAO {

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
    public List<ExaminationPoint> getExaminationPointList() {
        return sessionFactory.getCurrentSession().createQuery("select ep from ExaminationPoint ep").list();
    }
}
