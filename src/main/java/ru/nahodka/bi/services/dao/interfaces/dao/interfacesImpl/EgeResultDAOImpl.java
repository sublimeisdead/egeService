package ru.nahodka.bi.services.dao.interfaces.dao.interfacesImpl;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nahodka.bi.services.dao.interfaces.EgeResultDAO;
import ru.nahodka.bi.services.model.EgeResult;

import javax.annotation.Resource;
import java.util.List;


@Repository("egeResultDAO")
@Transactional
public class EgeResultDAOImpl implements EgeResultDAO {

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
    public List<EgeResult> getEgeResult(String year, String passportSeries, String passportNumber, String subjectCode) {
        return sessionFactory.getCurrentSession().createQuery("select  g from EgeResult  g " +
                "where g.year = :year and g.passportSeries = :passportSeries and g.passportNumber = :passportNumber and g.subject = :subject"  )
                .setParameter("year", year).setParameter("passportSeries",passportSeries)
                .setParameter("passportNumber",passportNumber).setParameter("subject",subjectCode).list();
    }



 /*   @Autowired
    public EgeResultDAOImpl(SessionFactory sessionFactory, MessageSource messageSource) {
        this.sessionFactory = sessionFactory;
        this.messageSource = messageSource;
    }
 */

}
