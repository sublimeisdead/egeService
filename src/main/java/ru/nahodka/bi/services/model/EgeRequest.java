
package ru.nahodka.bi.services.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "request",schema = "public")
@DynamicUpdate
@TypeDefs( {@TypeDef( name= "json", typeClass = JsonStringType.class)})

public class EgeRequest implements Serializable {

    @Id
    @SequenceGenerator(name = "request_id_seq", sequenceName = "request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "request_id_seq")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    protected Long id;


    @Basic
    @Column(name = "service_code")
    protected String serviceCode;


    @Basic
    @Column(name = "service_name")
    protected String serviceFullName;


    @Basic
    @Column(name = "id_application")
    private String idApplication;


    @Basic
    @Column(name = "req_id")
    protected UUID reqId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date")
    protected Date dateApplication;


    @Basic
    @Column(name = "applicant_type")
    protected Short appType;


    @Basic
    @Column(name = "applicant_esia_id")
    protected String applicantEsiaId;


    @Basic
    @Column(name = "applicant_snils")
    protected String snils;

    @Basic
    @Column(name = "applicant_surname")
    protected String applicantSurname;


    @Basic
    @Column(name = "applicant_name")
    protected String applicantName;


    @Basic
    @Column(name = "applicant_patronymic")
    protected String applicantPatronymic;


    @Basic
    @Column(name = "applicant_passport_series")
    protected String applicantPassportSeries;


    @Basic
    @Column(name = "applicant_passport_number")
    protected String applicantPassportNumber;


    @Basic
    @Column(name = "applicant_email")
    protected String emailAddress;


    @Basic
    @Column(name = "applicant_pas_date")
    protected Date applicantPasDate;


    @Basic
    @Column(name = "applicant_pas_org")
    protected String applicantPasOrg;


    @Basic
    @Column(name = "applicant_mobile_phone")
    protected String mobilePhone;


    @Basic
    @Column(name = "applicant_equals_examinee")
    protected Boolean applicantEqualsExaminee;


    @Basic
    @Column(name = "examinee_surname")
    protected String lastNameGr;


    @Basic
    @Column(name = "examinee_name")
    protected String firstNameGr;


    @Basic
    @Column(name = "examinee_patronymic")
    protected String examineePatronymic;


    @Basic
    @Column(name = "examinee_passport_series")
    protected String examineePassportSeries;


    @Basic
    @Column(name = "examinee_passport_number")
    protected String examineePassportNumber;


    @Basic
    @Column(name = "year")
    protected String yearExam;


    @Basic
    @Column(name = "subject")
    protected String codeSubject;


    @Basic
    @Column(name = "subject_text")
    protected String subjectText;


    @Basic
    @Column(name = "requested_at")
    protected Timestamp requestedAt;


    @Basic
    @Column(name = "responsed_at")
    protected Timestamp responsedAt;

    @Basic
    @Column(name = "response_xml",length = 2147483647)
   protected String response;

    @Basic
    @Column(name = "examinee_pas_org")
    protected String examineePasOrg;


    @Basic
    @Column(name = "examinee_pas_date")
    protected Date examineePasDate;



    @Basic
    @Column(name = "current_state")
    protected Short currentState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceFullName() {
        return serviceFullName;
    }

    public void setServiceFullName(String serviceFullName) {
        this.serviceFullName = serviceFullName;
    }

    public String getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(String idApplication) {
        this.idApplication = idApplication;
    }

    public UUID getReqId() {
        return reqId;
    }

    public void setReqId(UUID reqId) {
        this.reqId = reqId;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public Short getAppType() {
        return appType;
    }

    public void setAppType(Short appType) {
        this.appType = appType;
    }

    public String getApplicantEsiaId() {
        return applicantEsiaId;
    }

    public void setApplicantEsiaId(String applicantEsiaId) {
        this.applicantEsiaId = applicantEsiaId;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getApplicantSurname() {
        return applicantSurname;
    }

    public void setApplicantSurname(String applicantSurname) {
        this.applicantSurname = applicantSurname;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantPatronymic() {
        return applicantPatronymic;
    }

    public void setApplicantPatronymic(String applicantPatronymic) {
        this.applicantPatronymic = applicantPatronymic;
    }

    public String getApplicantPassportSeries() {
        return applicantPassportSeries;
    }

    public void setApplicantPassportSeries(String applicantPassportSeries) {
        this.applicantPassportSeries = applicantPassportSeries;
    }

    public String getApplicantPassportNumber() {
        return applicantPassportNumber;
    }

    public void setApplicantPassportNumber(String applicantPassportNumber) {
        this.applicantPassportNumber = applicantPassportNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getApplicantPasDate() {
        return applicantPasDate;
    }

    public void setApplicantPasDate(Date applicantPasDate) {
        this.applicantPasDate = applicantPasDate;
    }

    public String getApplicantPasOrg() {
        return applicantPasOrg;
    }

    public void setApplicantPasOrg(String applicantPasOrg) {
        this.applicantPasOrg = applicantPasOrg;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Boolean getApplicantEqualsExaminee() {
        return applicantEqualsExaminee;
    }

    public void setApplicantEqualsExaminee(Boolean applicantEqualsExaminee) {
        this.applicantEqualsExaminee = applicantEqualsExaminee;
    }

    public String getLastNameGr() {
        return lastNameGr;
    }

    public void setLastNameGr(String lastNameGr) {
        this.lastNameGr = lastNameGr;
    }

    public String getFirstNameGr() {
        return firstNameGr;
    }

    public void setFirstNameGr(String firstNameGr) {
        this.firstNameGr = firstNameGr;
    }

    public String getExamineePatronymic() {
        return examineePatronymic;
    }

    public void setExamineePatronymic(String examineePatronymic) {
        this.examineePatronymic = examineePatronymic;
    }

    public String getExamineePassportSeries() {
        return examineePassportSeries;
    }

    public void setExamineePassportSeries(String examineePassportSeries) {
        this.examineePassportSeries = examineePassportSeries;
    }

    public String getExamineePassportNumber() {
        return examineePassportNumber;
    }

    public void setExamineePassportNumber(String examineePassportNumber) {
        this.examineePassportNumber = examineePassportNumber;
    }

    public String getYearExam() {
        return yearExam;
    }

    public void setYearExam(String yearExam) {
        this.yearExam = yearExam;
    }

    public String getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(String codeSubject) {
        this.codeSubject = codeSubject;
    }

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    public Timestamp getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Timestamp requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Timestamp getResponsedAt() {
        return responsedAt;
    }

    public void setResponsedAt(Timestamp responsedAt) {
        this.responsedAt = responsedAt;
    }

    public Short getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Short currentState) {
        this.currentState = currentState;
    }

    public String getResponse() {
        return response;
    }

    public String getExamineePasOrg() {
        return examineePasOrg;
    }

    public void setExamineePasOrg(String examineePasOrg) {
        this.examineePasOrg = examineePasOrg;
    }

    public Date getExamineePasDate() {
        return examineePasDate;
    }

    public void setExamineePasDate(Date examineePasDate) {
        this.examineePasDate = examineePasDate;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}



