package ru.nahodka.bi.services.eventservice.endpoint;

import coko.artefacts.x.ege.services._1_0.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.nahodka.bi.services.dao.interfaces.*;
import ru.nahodka.bi.services.eventservice.util.Util;
import ru.nahodka.bi.services.model.*;
import ru.nahodka.bi.services.model.dictionaries.*;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

import static ru.nahodka.bi.services.eventservice.error.Error.*;

@Service
public class EventServiceEndpoint implements EventServicePort {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private EgeResultDAO egeResultDAO;

    @Resource
    private EgeRequestDAO egeRequestDAO;

    @Resource
    private AppealDAO appealDAO;

    @Resource
    private ServiceTypeDAO serviceTypeDAO;

    @Resource
    private ApplicantTypeDAO applicantTypeDAO;

    @Resource
    private AppealHearingTypeDAO appealHearingTypeDAO;

    @Resource
    private ApplicationTypeDAO applicationTypeDAO;

    @Resource
    private AppealResultTypeDAO appealResultTypeDAO;

    @Resource
    private AppealTypeDAO appealTypeDAO;

    @Resource
    private EduOrganizationDAO eduOrganizationDAO;

    @Resource
    private ExaminationPointDAO examinationPointDAO;

    @Resource
    private SubjectDAO subjectDAO;

    @Resource
    private AppealRequestStateDAO appealRequestStateDAO;


    public AppealResponseType registerAppeal(AppealRequestType appealRequest) throws BiException {



        if(appealRequest==null){
            throw emptyAppealRequestException();
        }

        AppealRequestType soapAppealRequest=appealRequest;

        ru.nahodka.bi.services.model.Appeal appealToDB=new ru.nahodka.bi.services.model.Appeal();

        if(soapAppealRequest.getAppeal().getServiceCode().isEmpty()){
            throw emptyServiceCodeException();
        }else{
        appealToDB.setServiceCode(soapAppealRequest.getAppeal().getServiceCode());
        }

        if(soapAppealRequest.getAppeal().getServiceFullName().isEmpty()){
            throw emptyServiceNameException();
        }else {
            appealToDB.setServiceFullName(soapAppealRequest.getAppeal().getServiceFullName());
        }

        if(soapAppealRequest.getAppeal().getIdApplication().isEmpty()){
            throw emptyIdApplicationException();
        }else{
            appealToDB.setIdApplication(soapAppealRequest.getAppeal().getIdApplication());
        }

        appealToDB.setReqId(UUID.randomUUID());

        if(soapAppealRequest.getAppeal().getDateApplication()==null || String.valueOf(soapAppealRequest.getAppeal().getDateApplication()).equals("1900-01-01")){
            throw emptyDateApplicationException();
        }else{
            appealToDB.setDateApplication(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapAppealRequest.getAppeal().getDateApplication()));
        }
        if(Short.valueOf(soapAppealRequest.getAppeal().getAppType())==-2){
            throw emptyAppTypeException();
        }else{
            appealToDB.setAppType(soapAppealRequest.getAppeal().getAppType());
        }

        String snils=soapAppealRequest.getAppeal().getSNILS();
        if(snils.isEmpty()){
            throw emptySNILSException();
        }else if(!snils.matches("\\d{11}")){
                throw snilsFormatException();
        }else {
            appealToDB.setSnils(snils);
        }


            if (soapAppealRequest.getAppeal().getApplicantSurname().getLastNameGr().isEmpty()) {
                throw emptyLastNameGrException();
            }else{
                appealToDB.setExamineeSurname(soapAppealRequest.getAppeal().getApplicantSurname().getLastNameGr());
            }
             if (soapAppealRequest.getAppeal().getApplicantSurname().getLastName().isEmpty()) {
                throw emptyApplicantSurnameException();
            }else {
                 appealToDB.setApplicantSurname(soapAppealRequest.getAppeal().getApplicantSurname().getLastName());
             }


            if(soapAppealRequest.getAppeal().getApplicantName().getFirstNameGr().isEmpty()) {
                throw emptyFirstNameGrException();
            }else {
                appealToDB.setExamineeName(soapAppealRequest.getAppeal().getApplicantName().getFirstNameGr());
            }

            if(soapAppealRequest.getAppeal().getApplicantName().getFirstName().isEmpty()){
            throw emptyApplicantNameException();
            }else{
                appealToDB.setApplicantName(soapAppealRequest.getAppeal().getApplicantName().getFirstName());
            }


                appealToDB.setApplicantPatronymic(soapAppealRequest.getAppeal().getSecondName().getSecondName());
                appealToDB.setExamineePatronymic(soapAppealRequest.getAppeal().getSecondName().getSecondNameGr());


            String pasSerGr=soapAppealRequest.getAppeal().getApplicantPassportSeries().getPasSerGr();
            if(pasSerGr.isEmpty()) {
                throw emptyPassportSeriesException();
            }else if(!pasSerGr.matches("\\d{4}")){
                throw passportSeriesFormatException();
            }
            else{
                appealToDB.setExamineePassportSeries(pasSerGr);
            }
        String pasSer=soapAppealRequest.getAppeal().getApplicantPassportSeries().getPasSer();
        if(pasSer.isEmpty()) {
            throw emptyApplicantPassportSeriesException();
        }else if(!pasSer.matches("\\d{4}")){
            throw passportSeriesFormatException();
        }else{
            appealToDB.setApplicantPassportSeries(pasSer);
        }

        String pasNumGr=soapAppealRequest.getAppeal().getApplicantPassportNumber().getPasNumGr();
        if(pasNumGr.isEmpty()) {
            throw emptyPassportNumberException();
        }else if(!pasNumGr.matches("\\d{6}")){
            throw passportNumberFormatException();
        }else{
            appealToDB.setExamineePassportNumber(pasNumGr);
        }
        String pasNum=soapAppealRequest.getAppeal().getApplicantPassportNumber().getPasNum();
        if(pasNum.isEmpty()) {
            throw emptyApplicantPassportNumberException();
        }else if(!pasNum.matches("\\d{6}")){
            throw passportNumberFormatException();
        }else{
            appealToDB.setApplicantPassportNumber(pasNum);
        }
        String email=soapAppealRequest.getAppeal().getEmailAddress();

        if(email.isEmpty()){

        }else if(!email.matches("[0-9a-zA-Z_.\\-]{2,50}[@]{1}[0-9a-zA-Z_./-]{2,50}[.]{1}[a-zA-Z]{2,5}")){
            throw emailFormatException();
        }else{
            appealToDB.setEmailAddress(email);
        }

            if(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDateGr()==null || String.valueOf(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDateGr()).equals("1900-01-01")){
            throw emptyPassportDateException();
            }else{
                appealToDB.setExamineePasDate(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDateGr()));
            }

            if(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDate()==null || String.valueOf(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDate()).equals("1900-01-01") ) {
                throw emptyApplicantPassportDateException();
            }else {
                appealToDB.setApplicantPasDate(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapAppealRequest.getAppeal().getApplicantPasDate().getPasDate()));
            }

            if(soapAppealRequest.getAppeal().getApplicantPasOrg().getPasOrgGr().isEmpty()){
                throw emptyPassportOrgException();
            }else{
                appealToDB.setExamineePasOrg(soapAppealRequest.getAppeal().getApplicantPasOrg().getPasOrgGr());
            }

            if(soapAppealRequest.getAppeal().getApplicantPasOrg().getPasOrg().isEmpty()){
                throw emptyApplicantPassportOrgException();
            }else {
                appealToDB.setApplicantPasOrg(soapAppealRequest.getAppeal().getApplicantPasOrg().getPasOrg());
            }


        if(soapAppealRequest.getAppeal().getRegion()!=43){
                throw wrongRegionCodeException();
        }else {
            appealToDB.setRegion(soapAppealRequest.getAppeal().getRegion());
        }

            if(soapAppealRequest.getAppeal().getCodSub().isEmpty()){
                throw emptyCodeSubjectException();
            }else{
                appealToDB.setSubject((soapAppealRequest.getAppeal().getCodSub()));
            }

        if(soapAppealRequest.getAppeal().getEduSub().isEmpty()){
            throw emptySubjectTextException();
        }else{
            appealToDB.setSubjectText(soapAppealRequest.getAppeal().getEduSub());
        }

        if(soapAppealRequest.getAppeal().getDateExam()==null ||String.valueOf(soapAppealRequest.getAppeal().getDateExam()).equals("1900-01-01") ){
                throw emptyExamDateException();
        }else{
            appealToDB.setDateExam(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapAppealRequest.getAppeal().getDateExam()));
        }

        if(soapAppealRequest.getAppeal().getCodeSchool().isEmpty()){
                throw emptyCodeSchoolException();
        }else{
            appealToDB.setEduOrganization(soapAppealRequest.getAppeal().getCodeSchool());
        }

        if(soapAppealRequest.getAppeal().getSchool().isEmpty()){
                throw emptySchoolException();
        }else{
            appealToDB.setEduOrganizationText(soapAppealRequest.getAppeal().getSchool());
        }

        if(soapAppealRequest.getAppeal().getCodePlaceExam().isEmpty()){
            throw emptyCodePlaceExamException();
        }else {
            appealToDB.setExaminationPoint(soapAppealRequest.getAppeal().getCodePlaceExam());
        }

        if(soapAppealRequest.getAppeal().getPlaceExam().isEmpty()){
                throw emptyPlaceExamException();
        }else{
            appealToDB.setExaminationPointText(soapAppealRequest.getAppeal().getPlaceExam());
        }

        if(soapAppealRequest.getAppeal().getApRev()==-2){
            throw emptyPresenceException();
        }else {
            appealToDB.setPresence(soapAppealRequest.getAppeal().getApRev());
        }

        if(soapAppealRequest.getAppeal().getApRevText().isEmpty()){
                throw emptyPresenceTextException();
        }else{
                appealToDB.setPresenceText(soapAppealRequest.getAppeal().getApRevText());
        }
        appealToDB.setRequestedAt(new Timestamp(System.currentTimeMillis()));

        appealToDB.setYear(soapAppealRequest.getAppeal().getDateExam().getYear());

        String phone=soapAppealRequest.getAppeal().getPhone();
        if(!phone.isEmpty()){

        }else if(!phone.matches("\\d{10}")) {
            throw phoneFormatException();
        }else{
            appealToDB.setApplicantMobilePhone(phone);
        }
        appealToDB.setCurrentState(1);
        AppealResponseType response=new AppealResponseType();
        response.setMessage("Заявление на апелляцию успешно сохранено");

        appealToDB.setResponsedAt(new Timestamp(System.currentTimeMillis()));

        appealDAO.saveAppealRequest(appealToDB);

        return response;
    }


    public EgeResultsResponseType getEgeResults (EgeResultsRequestType egeResultsRequest) throws BiException {

        if(egeResultsRequest.getEgeResultRequest()==null){
            throw emptyEgeResultException();
        }

        // СОХРАНЕНИЕ ЗАПРОСА В БД
        EgeResultsRequestType.EgeResultRequest soapEgeRequest = egeResultsRequest.getEgeResultRequest();

        EgeRequest egeRequestToDB=new EgeRequest();

        if(soapEgeRequest.getServiceCode().isEmpty()){
            throw emptyServiceCodeException();
        }else{
            egeRequestToDB.setServiceCode(soapEgeRequest.getServiceCode());
        }

        if(soapEgeRequest.getServiceFullName().isEmpty()){
            throw emptyServiceNameException();
        }else{
            egeRequestToDB.setServiceFullName(soapEgeRequest.getServiceFullName());
        }

        if(soapEgeRequest.getIdApplication().isEmpty()){

           throw emptyIdApplicationException();

        }else{
            egeRequestToDB.setIdApplication(soapEgeRequest.getIdApplication());
        }

        Date currentDate=new Date();
        if(currentDate.before(Util.toDate(soapEgeRequest.getDateApplication()))){
            throw wrongDateApplicationException();
        }
        if(String.valueOf(soapEgeRequest.getDateApplication()).equals("1900-01-01")){
            throw emptyDateApplicationException();
        }else{
            egeRequestToDB.setDateApplication(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapEgeRequest.getDateApplication()));
        }

        egeRequestToDB.setReqId(UUID.randomUUID());
        if(soapEgeRequest.getAppType()==-2){
            throw emptyAppTypeException();
        }else{

            egeRequestToDB.setAppType(soapEgeRequest.getAppType());
        }

        String snils=soapEgeRequest.getSNILS();
        if(snils.isEmpty()){
            throw emptySNILSException();
        }else if(!snils.matches("\\d{11}")){
            throw snilsFormatException();
        }else{
            egeRequestToDB.setSnils(snils);
        }



        egeRequestToDB.setApplicantPatronymic(soapEgeRequest.getApplicantPatronymic().getSecondName());
        egeRequestToDB.setExamineePatronymic(soapEgeRequest.getApplicantPatronymic().getSecondNameGr());


        if(soapEgeRequest.getApplicantName().getFirstNameGr().isEmpty()){
            throw emptyFirstNameGrException();
        }else{
            egeRequestToDB.setFirstNameGr(soapEgeRequest.getApplicantName().getFirstNameGr());
        }

        if(soapEgeRequest.getApplicantName().getFirstName().isEmpty()){
            throw emptyApplicantNameException();
        }else{
            egeRequestToDB.setApplicantName(soapEgeRequest.getApplicantName().getFirstName());
        }

        if(soapEgeRequest.getApplicantSurname().getLastNameGr().isEmpty()){
            throw emptyLastNameGrException();
        }else{
            egeRequestToDB.setLastNameGr(soapEgeRequest.getApplicantSurname().getLastNameGr());
        }

        if(soapEgeRequest.getApplicantSurname().getLastName().isEmpty()){
            throw emptyApplicantSurnameException();
        }else{
            egeRequestToDB.setApplicantSurname(soapEgeRequest.getApplicantSurname().getLastName());
        }

        String pasNum=soapEgeRequest.getApplicantPassportNumber().getPasNum();
        if(pasNum.isEmpty()){
            throw emptyApplicantPassportNumberException();
        }else if(!pasNum.matches("\\d{6}")){
            throw passportNumberFormatException();
        }else {
            egeRequestToDB.setApplicantPassportNumber(pasNum);
        }

        String pasNumGr=soapEgeRequest.getApplicantPassportNumber().getPasNumGr();
        if(pasNumGr.isEmpty()){
            throw emptyPassportNumberException();
        }else if(!pasNumGr.matches("\\d{6}")){
            throw passportNumberFormatException();
        }else {
            egeRequestToDB.setExamineePassportNumber(pasNumGr);
        }

        String pasSer=soapEgeRequest.getApplicantPassportSeries().getPasSer();
        if(pasSer.isEmpty()){
            throw emptyApplicantPassportSeriesException();
        }else if(!pasSer.matches("\\d{4}")){
            throw passportSeriesFormatException();
        }else{
            egeRequestToDB.setApplicantPassportSeries(pasSer);
        }

        String pasSerGr=soapEgeRequest.getApplicantPassportSeries().getPasSerGr();
        if(pasSerGr.isEmpty()){
            throw emptyPassportSeriesException();
        }else if(!pasSerGr.matches("\\d{4}")){
            throw passportSeriesFormatException();
        }else{
            egeRequestToDB.setExamineePassportSeries(pasSerGr);
        }

        if(soapEgeRequest.getApplicantPasOrg().getPasOrg().isEmpty()){
            throw emptyApplicantPassportOrgException();
        }else{
            egeRequestToDB.setApplicantPasOrg(soapEgeRequest.getApplicantPasOrg().getPasOrg());
        }

        if(soapEgeRequest.getApplicantPasOrg().getPasOrgGr().isEmpty()){
            throw emptyPassportOrgException();
        }else{
            egeRequestToDB.setExamineePasOrg(soapEgeRequest.getApplicantPasOrg().getPasOrgGr());
        }

        if(String.valueOf(soapEgeRequest.getApplicantPasDate().getPasDate()).equals("1900-01-01")){
            throw emptyApplicantPassportDateException();
        }else{
            egeRequestToDB.setApplicantPasDate(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapEgeRequest.getApplicantPasDate().getPasDate()));
        }

        if(String.valueOf(soapEgeRequest.getApplicantPasDate().getPasDateGr()).equals("1900-01-01")){
            throw emptyPassportDateException();
        }else{
            egeRequestToDB.setExamineePasDate(ru.nahodka.bi.services.eventservice.util.Util.toDate(soapEgeRequest.getApplicantPasDate().getPasDateGr()));
        }


         //   egeRequestToDB.setEmailAddress(soapEgeRequest.getEmailAddress());
        String phone=soapEgeRequest.getMobilePhone();
     //   if(!phone.isEmpty()){}

        if(!phone.matches("\\d{10}") && !phone.isEmpty()) {
            throw phoneFormatException();
        }else{
            egeRequestToDB.setMobilePhone(phone);
        }

        String email=soapEgeRequest.getEmailAddress();


        if(!email.matches("[0-9a-zA-Z_.\\-]{2,50}[@]{1}[0-9a-zA-Z_./-]{2,50}[.]{1}[a-zA-Z]{2,5}")&&!email.isEmpty()){
            throw emailFormatException();
        }else{
            egeRequestToDB.setEmailAddress(email);
        }


        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());


        if(soapEgeRequest.getYearExam()==3000||soapEgeRequest.getYearExam()<2000||soapEgeRequest.getYearExam()>calendar.get(Calendar.YEAR)){
            throw emptyYearExamException();
        }else {
            egeRequestToDB.setYearExam(soapEgeRequest.getYearExam());
        }

        if(soapEgeRequest.getCodeSubject().isEmpty()){
            throw emptyCodeSubjectException();
        }else{
            egeRequestToDB.setCodeSubject(soapEgeRequest.getCodeSubject());
        }

        if(soapEgeRequest.getSubjectText().isEmpty()){
            throw emptySubjectTextException();
        }else{
            egeRequestToDB.setSubjectText(soapEgeRequest.getSubjectText());
        }

        egeRequestToDB.setRequestedAt(timestamp);


       List<EgeResult> egeResults=egeResultDAO.getEgeResult(String.valueOf(soapEgeRequest.getYearExam()),soapEgeRequest.getApplicantPassportSeries().getPasSerGr(),
                                                       soapEgeRequest.getApplicantPassportNumber().getPasNumGr(),String.valueOf(soapEgeRequest.getCodeSubject()));

    //  List<EgeResult> egeResults=egeResultDAO.getEgeResult(String.valueOf(2012),String.valueOf(4520),String.valueOf(564730),String.valueOf(4));
      if(egeResults.size()==0){
          throw emptyEgeResultException();
      }

       EgeResult freshestEgeResult=getFreshestResult(egeResults);

        EgeResultsResponseType.EgeResult egeResult=new EgeResultsResponseType.EgeResult();

        EgeResultsResponseType.EgeResult.Subject egeResultSubject=new EgeResultsResponseType.EgeResult.Subject();
        egeResultSubject.setId(String.valueOf(soapEgeRequest.getCodeSubject()));
        egeResultSubject.setName(freshestEgeResult.getSbj().getName());
        egeResult.setSubject(egeResultSubject);


        egeResult.setTotal(freshestEgeResult.getTotal());
        egeResult.setGrade(freshestEgeResult.getGrade());

       EgeResultsResponseType.EgeResult.PartA egeResultPartA=new EgeResultsResponseType.EgeResult.PartA();
        egeResultPartA.setMask(freshestEgeResult.getMaskA());
        egeResultPartA.setTasksDone(freshestEgeResult.getTasksDoneA());
        egeResult.setPartA(egeResultPartA);

        EgeResultsResponseType.EgeResult.PartB egeResultPartB=new EgeResultsResponseType.EgeResult.PartB();
        egeResultPartB.setMask(freshestEgeResult.getMaskB());
        egeResultPartB.setTasksDone(freshestEgeResult.getTasksDoneB());
        egeResult.setPartB(egeResultPartB);

        EgeResultsResponseType.EgeResult.PartC egeResultPartC=new EgeResultsResponseType.EgeResult.PartC();
        egeResultPartC.setMask(freshestEgeResult.getMaskC());
        egeResultPartC.setTasksDone(freshestEgeResult.getTasksDoneC());
        egeResult.setPartC(egeResultPartC);

        EgeResultsResponseType.EgeResult.PartD egeResultPartD=new EgeResultsResponseType.EgeResult.PartD();
        egeResultPartD.setMask(freshestEgeResult.getMaskD());
        egeResultPartD.setTasksDone(freshestEgeResult.getTasksDoneD());
        egeResult.setPartD(egeResultPartD);

        egeResult.setTasksDone(freshestEgeResult.getTasksDone());
        egeResult.setPersentageTasks(freshestEgeResult.getPercentageTasksDone());

      EgeResultsResponseType.EgeResult.CodeOY egeResultCodeOY=new EgeResultsResponseType.EgeResult.CodeOY();
        egeResultCodeOY.setId(freshestEgeResult.getCodeOy());
        egeResultCodeOY.setName(freshestEgeResult.getEduOrganization().getName());
        egeResult.setCodeOY(egeResultCodeOY);

        EgeResultsResponseType.EgeResult.CodePPE egeResultCodePPE=new EgeResultsResponseType.EgeResult.CodePPE();
        egeResultCodePPE.setId(freshestEgeResult.getCodePpe());
        egeResultCodePPE.setName(freshestEgeResult.getExaminationPoint().getName());
        egeResult.setCodePPE(egeResultCodePPE);

        egeResult.setBlankNumber(freshestEgeResult.getBlankNumber());

        egeResult.setMinMark(freshestEgeResult.getMinMark());
        egeResult.setDateExam(freshestEgeResult.getDate());
        egeResult.setDatePublish(freshestEgeResult.getDatePublish());
        try {
            egeResult.setBlank1(getPathToBlank(freshestEgeResult,freshestEgeResult.getBlank1()));
            egeResult.setBlank2(getPathToBlank(freshestEgeResult,freshestEgeResult.getBlank2()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        egeRequestToDB.setCurrentState((short) 4);
        egeRequestToDB.setResponsedAt(new Timestamp(System.currentTimeMillis()));


        EgeResultsResponseType e=new EgeResultsResponseType();
        e.setEgeResult(egeResult);


        egeRequestToDB.setResponse(jaxbObjectToXML(e));
        egeRequestDAO.saveEgeRequest(egeRequestToDB);

        return e;
    }


    public AppealCancelResponseType cancelAppeal(AppealCancelRequestType appealCancelRequest) throws BiException {

        if(appealCancelRequest==null){
            throw emptyAppealCancelRequest();
        }

        Appeal appealFromDB = appealDAO.findAppealByIdApplication(appealCancelRequest.getIdApplication());
         if(appealFromDB==null){
            throw notFound();
        }

        AppealRequestState appealRequestStateToDB=new AppealRequestState();
        appealRequestStateToDB.setRequestId(Math.toIntExact(appealFromDB.getId()));
        appealRequestStateToDB.setStateId(6);
        appealRequestStateToDB.setComment("Запрос на отмену апелляции с ЕПГУ");
        appealRequestStateToDB.setPrevStateId(appealFromDB.getCurrentState());
        appealRequestStateToDB.setSetAt(new Timestamp(System.currentTimeMillis()));
        appealFromDB.setCurrentState(6);
        appealDAO.updateAppeal(appealFromDB);
        appealRequestStateDAO.saveAppealRequestState(appealRequestStateToDB);


        AppealCancelResponseType appealCancelResponse=new AppealCancelResponseType();
        appealCancelResponse.setMessage("Заявление на отмену апелляции принято");
        return appealCancelResponse;
    }


    public DictionaryContentType getDictionaryContent(DictionaryContentRequestType dictionaryContentRequest) throws BiException {



        if(dictionaryContentRequest==null){
            throw emptyDictionaryContentRequest();
        }

        DictionaryContentType.Dictionary.Records records=new DictionaryContentType.Dictionary.Records();

        DictionaryContentType dictionaryContentSchema=new DictionaryContentType();
        DictionaryContentType.Dictionary dictionary=new DictionaryContentType.Dictionary();


        switch (dictionaryContentRequest.getDictionary().getDictionaryName().toLowerCase())
        {

            case "service_type":
                List<ServiceType> serviceTypes=serviceTypeDAO.getServiceTypeList();

                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(ServiceType st:serviceTypes){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(st.getId()));
                    record.setValue(st.getName());
                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "applicant_type":
                List<ApplicantType> applicantTypes=applicantTypeDAO.getApplicantTypeList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(ApplicantType at: applicantTypes){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(at.getId()));
                    record.setValue(at.getName());
                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "appeal_hearing_type":
                List<AppealHearingType> appealHearingTypes=appealHearingTypeDAO.getAppealHearingTypeList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(AppealHearingType aht: appealHearingTypes){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(aht.getId()));
                    record.setValue(aht.getName());
                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "application_type":
                List<ApplicationType> applicationTypes=applicationTypeDAO.getApplicationTypeList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(ApplicationType at: applicationTypes){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(at.getId()));
                    record.setValue(at.getName());
                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "appeal_result_type":
                List<AppealResultType> appealResultTypes=appealResultTypeDAO.getAppealResultTypeList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(AppealResultType art: appealResultTypes){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(art.getId()));
                    record.setValue(art.getName());
                    records.getRecord().add(record);
                }
                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "appeal_type":
                List<AppealType> appealTypes=appealTypeDAO.getAppealTypeList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(AppealType at: appealTypes){

                  DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(String.valueOf(at.getId()));
                    record.setValue(at.getName());
                    records.getRecord().add(record);
                }
                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "edu_organization":
                List<EduOrganization> eduOrganizations=eduOrganizationDAO.getEduOrganizationList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(EduOrganization eo: eduOrganizations){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(eo.getCode());
                    record.setValue(eo.getName());
                    records.getRecord().add(record);
                }
                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            case "examination_point":
                List<ExaminationPoint> examinationPoints=examinationPointDAO.getExaminationPointList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(ExaminationPoint ep: examinationPoints){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(ep.getCode());
                    record.setValue(ep.getName());
                 record.setAddress(ep.getAddress());
                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;




            case "subject":
                List<Subject> subjects=subjectDAO.getSubjectsList();
                dictionary.setId(dictionaryContentRequest.getDictionary().getDictionaryName());

                for(Subject sbj: subjects){

                    DictionaryContentType.Dictionary.Records.Record record = new DictionaryContentType.Dictionary.Records.Record();
                    record.setId(sbj.getCode());
                    record.setValue(sbj.getName());

                    records.getRecord().add(record);
                }

                dictionary.setRecords(records);
                dictionaryContentSchema.setDictionary(dictionary);

                return dictionaryContentSchema;

            default:
                throw dictionaryNotExistException();



        }


    }


    private EgeResult getFreshestResult(List<EgeResult> list){
        List<Date> listDate = new ArrayList<>();
        int maxIndexOfDate = 0;

        for (EgeResult e : list) {

            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            String dat = e.getDate();
            Date date = null;
            try {
                date = sim.parse(dat);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

            listDate.add(date);

        }

        for (int i = 0; i < listDate.size(); i++) {
            if (listDate.get(maxIndexOfDate).before(listDate.get(i))) {
                maxIndexOfDate = i;
            }
        }

       // EgeResult freshEgeResult = list.get(maxIndexOfDate);
        return list.get(maxIndexOfDate);
    }

    private static String jaxbObjectToXML(EgeResultsResponseType egeResultsResponse){
        String xmlString="";
        try{
            JAXBContext context=JAXBContext.newInstance(EgeResultsResponseType.class);
            Marshaller m =context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            StringWriter sw=new StringWriter();
            m.marshal(egeResultsResponse,sw);
            xmlString=sw.toString();
        }catch (JAXBException e){
            e.printStackTrace();
        }

        return xmlString;
    }

    private String getPathToBlank(EgeResult egeResult, String blank) throws IOException {
        StringBuffer absoluthPath=new StringBuffer().append("http://192.168.1.115/Users/shurupov/Desktop/FRXs/EGE/");
        absoluthPath.append(egeResult.getSubject());
        absoluthPath.append("/");

        String newDateExam=egeResult.getDate().replaceAll("-",".");
        absoluthPath.append(newDateExam);
        absoluthPath.append("/");

        StringBuffer essentialPart=absoluthPath;

        String connectionString="\\\\192.168.1.115\\Users\\shurupov\\Desktop\\FRXs\\EGE\\02\\2018.04.10\\";

        String filePathPagesCount=connectionString+"pagescount.txt";

        List<String> listOfKeys=new ArrayList<>();
        List<String> listOfValues=new ArrayList<>();

        File file = new File(filePathPagesCount);
        String line;

        BufferedReader reader=new BufferedReader(new FileReader(file));

        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(":",2);
            if(parts.length>=2){
                String key=parts[0];
                String value=parts[1];
                listOfKeys.add(key);
                listOfValues.add(value);

            }
        }
        reader.close();

        int lineValue=0;
        int capacityBlank=0;

        for(int i=0;i<listOfKeys.size();i++){
            lineValue=lineValue+Integer.valueOf(listOfValues.get(i));
            if (listOfKeys.get(i).equalsIgnoreCase(blank)) {
                capacityBlank=Integer.valueOf(listOfValues.get(i));
                break;
                }
            }
        List<String> listOfPaths=new ArrayList<>();
        String valueOfLineBlank;
        StringBuffer pathForBlank=new StringBuffer(absoluthPath);
        for(int i=0;i<capacityBlank;i++){
            try(Stream<String> lines= Files.lines(Paths.get(connectionString+"list.txt"))){
             //   valueOfLineBlank=lines.skip(lineValue-i-1).findFirst().get();
                valueOfLineBlank=lines.skip(lineValue-capacityBlank+i).findFirst().get();
            }
            listOfPaths.add(valueOfLineBlank);
            pathForBlank.append(listOfPaths.get(i).substring(0,1));
            pathForBlank.append("/");
            pathForBlank.append(listOfPaths.get(i).substring(1,2));
            pathForBlank.append("/");
            pathForBlank.append(valueOfLineBlank);
            pathForBlank.append(".png;");
            pathForBlank.append(essentialPart);
        }
        return pathForBlank.substring(0,pathForBlank.lastIndexOf(";"));
    }


    @Override
    public NewResponseType manageRequest(NewRequestType newRequest) throws BiException {
        if(newRequest==null){
            throw emptyRequestException();
        }

        if(newRequest.getGetDictionaryContentRequest()!=null){

            NewResponseType response=new NewResponseType();
             response.setGetDictionaryContentResponse(getDictionaryContent(newRequest.getGetDictionaryContentRequest()));
             return response;
        }else if(newRequest.getAppealCancelRequest()!=null){
            NewResponseType response=new NewResponseType();
            response.setAppealCancelResponse(cancelAppeal(newRequest.getAppealCancelRequest()));
            return response;
        }else if(newRequest.getGetEgeResultsRequest()!=null){
            NewResponseType response=new NewResponseType();
            response.setGetEgeResultsResponse(getEgeResults(newRequest.getGetEgeResultsRequest()));
            return response;
        }else if(newRequest.getAppealRequest()!=null){
            NewResponseType response=new NewResponseType();
            response.setAppealResponse(registerAppeal(newRequest.getAppealRequest()));
            return response;
        }else throw unknownRequestException();
    }
}
