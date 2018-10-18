package ru.nahodka.bi.services.model;

import org.hibernate.annotations.DynamicUpdate;
import ru.nahodka.bi.services.model.dictionaries.EduOrganization;
import ru.nahodka.bi.services.model.dictionaries.ExaminationPoint;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "result", schema = "public")
@DynamicUpdate
public class EgeResult implements Serializable {


    @Id
    @SequenceGenerator(name = "result_id_seq", sequenceName = "result_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "result_id_seq")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    protected Long id;

    @Basic
    @Column(name = "number", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String number;

    @Basic
    @Column(name = "region", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String region;

    @Basic
    @Column(name = "surname", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String surname;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String name;

    @Basic
    @Column(name = "patronymic", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String patronymic;

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String gender;

    @Basic
    @Column(name = "variant", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String variant;

    @Basic
    @Column(name = "total", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String total;

    @Basic
    @Column(name = "rating", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String rating;

    @Basic
    @Column(name = "grade", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String grade;

    @Basic
    @Column(name = "auditorium", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String auditorium;

    @Basic
    @Column(name = "classroom", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String classroom;


    @Basic
    @Column(name = "subject", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String subject;

    @Basic
    @Column(name = "year", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String year;

    @Basic
    @Column(name = "actual", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String actual;

    @Basic
    @Column(name = "filename", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String filename;

    @Basic
    @Column(name = "passport_series", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String passportSeries;

    @Basic
    @Column(name = "passport_number", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String passportNumber;

    @Basic
    @Column(name = "old_variant", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String oldVariant;

    @Basic
    @Column(name = "mask_a", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String maskA;

    @Basic
    @Column(name = "mask_b", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String maskB;

    @Basic
    @Column(name = "mask_c", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String maskC;

    @Basic
    @Column(name = "mask_d", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String maskD;

    @Basic
    @Column(name = "tasks_done", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String tasksDone;

    @Basic
    @Column(name = "percentage_tasks_done", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String percentageTasksDone;

    @Basic
    @Column(name = "tasks_done_a", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String tasksDoneA;

    @Basic
    @Column(name = "tasks_done_b", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String tasksDoneB;

    @Basic
    @Column(name = "tasks_done_c", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String tasksDoneC;

    @Basic
    @Column(name = "tasks_done_d", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String tasksDoneD;

    @Basic
    @Column(name = "code_ate", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String codeAte;

    @Basic
    @Column(name = "code_ppe", nullable = false, insertable = false, updatable = false, length = 2147483647)
    protected String codePpe;

    @Basic
    @Column(name = "code_oy", nullable = false, length = 2147483647,insertable = false,updatable = false)
    protected String codeOy;

    @Basic
    @Column(name = "regional_id", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String regionalId;

    @Basic
    @Column(name = "blank_number", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String blankNumber;

    @Basic
    @Column(name = "min_mark", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String minMark;

    @Basic
    @Column(name = "uploaded_string", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String uploadedString;

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected String date;

    @Basic
    @Column(name = "uploaded_at", nullable = false, insertable = true, updatable = true, length = 2147483647)
    protected Date uploadedAt;

    @Basic
    @Column(name = "blank1", nullable = true, insertable = true, updatable = true, length = 2147483647)
    protected String blank1;

    @Basic
    @Column(name = "blank2", nullable = true, insertable = true, updatable = true, length = 2147483647)
    protected String blank2;

    @Basic
    @Column(name = "date_publish")
    protected String datePublish;

    @OneToOne
    @JoinColumn(name = "subject",foreignKey = @ForeignKey(name = "result_subject_fkey"),updatable = false,insertable = false)
    protected Subject sbj;

    @OneToOne
    @JoinColumn(name = "code_ppe",foreignKey = @ForeignKey(name = "result_ppe_fkey"),updatable = false,insertable = false)
    protected ExaminationPoint examinationPoint;

   @OneToOne
   @JoinColumn(name = "code_oy",foreignKey = @ForeignKey(name = "result_oy_fkey"),updatable = false,insertable = false)
    protected EduOrganization eduOrganization;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Subject getSbj() {
        return sbj;
    }

    public void setSbj(Subject sbj) {
        this.sbj = sbj;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getOldVariant() {
        return oldVariant;
    }

    public void setOldVariant(String oldVariant) {
        this.oldVariant = oldVariant;
    }

    public String getMaskA() {
        return maskA;
    }

    public void setMaskA(String maskA) {
        this.maskA = maskA;
    }

    public String getMaskB() {
        return maskB;
    }

    public void setMaskB(String maskB) {
        this.maskB = maskB;
    }

    public String getMaskC() {
        return maskC;
    }

    public void setMaskC(String maskC) {
        this.maskC = maskC;
    }

    public String getMaskD() {
        return maskD;
    }

    public void setMaskD(String maskD) {
        this.maskD = maskD;
    }

    public String getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(String tasksDone) {
        this.tasksDone = tasksDone;
    }

    public String getPercentageTasksDone() {
        return percentageTasksDone;
    }

    public void setPercentageTasksDone(String percentageTasksDone) {
        this.percentageTasksDone = percentageTasksDone;
    }

    public String getTasksDoneA() {
        return tasksDoneA;
    }

    public void setTasksDoneA(String tasksDoneA) {
        this.tasksDoneA = tasksDoneA;
    }

    public String getTasksDoneB() {
        return tasksDoneB;
    }

    public void setTasksDoneB(String tasksDoneB) {
        this.tasksDoneB = tasksDoneB;
    }

    public String getTasksDoneC() {
        return tasksDoneC;
    }

    public void setTasksDoneC(String tasksDoneC) {
        this.tasksDoneC = tasksDoneC;
    }

    public String getTasksDoneD() {
        return tasksDoneD;
    }

    public void setTasksDoneD(String tasksDoneD) {
        this.tasksDoneD = tasksDoneD;
    }

    public String getCodeAte() {
        return codeAte;
    }

    public void setCodeAte(String codeAte) {
        this.codeAte = codeAte;
    }

    public String getCodePpe() {
        return codePpe;
    }

    public void setCodePpe(String codePpe) {
        this.codePpe = codePpe;
    }

    public String getCodeOy() {
        return codeOy;
    }

    public void setCodeOy(String codeOy) {
        this.codeOy = codeOy;
    }

    public String getRegionalId() {
        return regionalId;
    }

    public void setRegionalId(String regionalId) {
        this.regionalId = regionalId;
    }

    public String getBlankNumber() {
        return blankNumber;
    }

    public void setBlankNumber(String blankNumber) {
        this.blankNumber = blankNumber;
    }

    public String getMinMark() {
        return minMark;
    }

    public void setMinMark(String minMark) {
        this.minMark = minMark;
    }

    public String getUploadedString() {
        return uploadedString;
    }

    public void setUploadedString(String uploadedString) {
        this.uploadedString = uploadedString;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1;
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2;
    }

    public ExaminationPoint getExaminationPoint() {
        return examinationPoint;
    }

    public void setExaminationPoint(ExaminationPoint examinationPoint) {
        this.examinationPoint = examinationPoint;
    }

    public EduOrganization getEduOrganization() {
        return eduOrganization;
    }

    public void setEduOrganization(EduOrganization eduOrganization) {
        this.eduOrganization = eduOrganization;
    }

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }
}
