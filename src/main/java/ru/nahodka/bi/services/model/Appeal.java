package ru.nahodka.bi.services.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "request_appeal",schema = "public")
@DynamicUpdate
//@TypeDefs( {@TypeDef( name= "json", typeClass = JsonStringType.class)})
public class Appeal implements Serializable {

    @Id
    @SequenceGenerator(name = "request_appeal_id_seq", sequenceName = "request_appeal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "request_appeal_id_seq")
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
    @Column(name = "region")
    protected Integer region;


    @Basic
    @Column(name = "subject")
    protected Long subject;

    @Basic
    @Column(name = "subject_text")
    protected String subjectText;


    @Basic
    @Column(name = "exam_date")
    protected Date dateExam;

    @Basic
    @Column(name = "edu_organization")
    protected Long eduOrganization;


    @Basic
    @Column(name = "edu_organization_text")
    protected String eduOrganizationText;

    @Basic
    @Column(name = "examination_point")
    protected Long examinationPoint;


    @Basic
    @Column(name = "examination_point_text")
    protected String examinationPointText;

    @Basic
    @Column(name = "presence")
    protected Integer presence;

    @Basic
    @Column(name = "requested_at")
    protected Timestamp requestedAt;


    @Basic
    @Column(name = "responsed_at")
    protected Timestamp responsedAt;

    @Basic
    @Column(name = "registered_at")
    protected Timestamp registeredAt;

    @Basic
    @Column(name = "registrar")
    protected Long registrar;

    @Basic
    @Column(name = "reg_number")
    protected String regNumber;

    @Basic
    @Column(name = "canceled_at")
    protected Timestamp canceledAt;

    @Basic
    @Column(name = "commission")
    protected Integer commission;

    @Basic
    @Column(name = "result")
    protected Integer result;

    @Basic
    @Column(name = "current_state")
    protected Integer currentState;

    @Basic
    @Column(name = "state_transferred")
    protected Boolean stateTransferred;

    @Basic
    @Column(name = "applicant_mobile_phone")
    protected String applicantMobilePhone;
//new fields
    @Basic
    @Column(name = "year")
    protected Integer year;

    @Basic
    @Column(name = "applicant_equals_examinee")
    protected Boolean applicantEqualsExaminee;

    @Basic
    @Column(name = "prev_result")
    protected Integer prevResult;

    @Basic
    @Column(name = "new_result")
    protected Integer newResult;

    @Basic
    @Column(name = "presence_text")
    protected String presenceText;

    @Basic
    @Column(name = "result_text")
    protected String resultText;

    @Basic
    @Column(name = "examinee_surname")
    protected String examineeSurname;

    @Basic
    @Column(name = "examinee_name")
    protected String examineeName;

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
    @Column(name = "examinee_pas_org")
    protected String examineePasOrg;

    @Basic
    @Column(name = "examinee_pas_date")
    protected Date examineePasDate;










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

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    public Long getEduOrganization() {
        return eduOrganization;
    }

    public void setEduOrganization(Long eduOrganization) {
        this.eduOrganization = eduOrganization;
    }

    public String getEduOrganizationText() {
        return eduOrganizationText;
    }

    public void setEduOrganizationText(String eduOrganizationText) {
        this.eduOrganizationText = eduOrganizationText;
    }

    public Long getExaminationPoint() {
        return examinationPoint;
    }

    public void setExaminationPoint(Long examinationPoint) {
        this.examinationPoint = examinationPoint;
    }

    public String getExaminationPointText() {
        return examinationPointText;
    }

    public void setExaminationPointText(String examinationPointText) {
        this.examinationPointText = examinationPointText;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
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

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Long getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Long registrar) {
        this.registrar = registrar;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Timestamp getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Timestamp canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public Boolean getStateTransferred() {
        return stateTransferred;
    }

    public void setStateTransferred(Boolean stateTransferred) {
        this.stateTransferred = stateTransferred;
    }

    public String getApplicantMobilePhone() {
        return applicantMobilePhone;
    }

    public void setApplicantMobilePhone(String applicantMobilePhone) {
        this.applicantMobilePhone = applicantMobilePhone;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getApplicantEqualsExaminee() {
        return applicantEqualsExaminee;
    }

    public void setApplicantEqualsExaminee(Boolean applicantEqualsExaminee) {
        this.applicantEqualsExaminee = applicantEqualsExaminee;
    }

    public Integer getPrevResult() {
        return prevResult;
    }

    public void setPrevResult(Integer prevResult) {
        this.prevResult = prevResult;
    }

    public Integer getNewResult() {
        return newResult;
    }

    public void setNewResult(Integer newResult) {
        this.newResult = newResult;
    }

    public String getPresenceText() {
        return presenceText;
    }

    public void setPresenceText(String presenceText) {
        this.presenceText = presenceText;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getExamineeSurname() {
        return examineeSurname;
    }

    public void setExamineeSurname(String examineeSurname) {
        this.examineeSurname = examineeSurname;
    }

    public String getExamineeName() {
        return examineeName;
    }

    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
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
}
