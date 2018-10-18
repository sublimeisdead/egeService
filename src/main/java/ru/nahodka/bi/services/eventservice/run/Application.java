package ru.nahodka.bi.services.eventservice.run;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Application {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9082);

        WebAppContext root = new WebAppContext("webapp", "/");

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // fix for Windows, so Jetty doesn't lock files
            root.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        }

        root.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*taglibs.*\\.jar$");

         server.setHandler(root);
        server.start();

/*
    Application application=new Application();
  //  application.getEgeResultByParameters("2015","4520","564730","12");
   // application.getEgeresult(1175389L);
        List<EgeRequest> egeRequest=application.getEgeRequest(40L);
        egeRequest.toString();



    }

    public static EgeResult getTestEgeResult(){
        EgeResult egeResult=new EgeResult();
        egeResult.setActual("''");
        egeResult.setAuditorium("123");
        egeResult.setBlank1("qw");
        egeResult.setBlank2("sd");
        egeResult.setBlankNumber("234");
        egeResult.setClassroom("rtrt");
        egeResult.setCodeAte("codeate");
        egeResult.setCodeOy("codeoy");
        egeResult.setCodePpe("codeppe");
        egeResult.setDate("2015-06-08 4:55:55+03");
        egeResult.setFilename("dfgdfgdfgdfgdfg");
        egeResult.setGender("m");
        egeResult.setGrade("grade");
        egeResult.setMaskA("---------------------------");
        egeResult.setMaskB("-12+02+--2+-");
        egeResult.setMaskC("maskc");
        egeResult.setMaskD("''");
        egeResult.setTasksDone("12");
        egeResult.setTasksDoneA("45");
        egeResult.setTasksDoneB("45");
        egeResult.setTasksDoneC("50");
        egeResult.setTasksDoneD("40");
        return egeResult;

    }

    public void getEgeresult(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try {
            transaction=session.beginTransaction();
            EgeResult result= (EgeResult) session.createQuery("select  g from EgeResult  g " +
                    "where g.id = :id").setParameter("id", id).uniqueResult();
            System.out.println(result.toString());
            transaction.commit();
        }catch (HibernateException ex){
            transaction.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

    }

    public void getEgeResultByParameters(String year,String passportSeries,String passportNumber,String subjectCode){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try {
            transaction=session.beginTransaction();
            List<EgeResult> result= session.createQuery("select  g from EgeResult  g " +
                    "where g.year = :year and g.passportSeries = :passportSeries and g.passportNumber = :passportNumber and g.subject = :subject"  )
                    .setParameter("year", year).setParameter("passportSeries",passportSeries)
                    .setParameter("passportNumber",passportNumber).setParameter("subject",subjectCode).list();
            System.out.println(result.toString());
            transaction.commit();
        }catch (HibernateException ex){
            transaction.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

    }

    public List<EgeRequest> getEgeRequest(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        List<EgeRequest> result = null;

        try {
            transaction=session.beginTransaction();
             result= session.createQuery("select g from EgeRequest  g " +
                    "where g.id = :id "  )
                    .setParameter("id", id).list();
            System.out.println(result.toString());

            transaction.commit();
        }catch (HibernateException ex){
            transaction.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

        return result;

        */
    }


}
