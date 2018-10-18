package ru.nahodka.bi.services.model.dictionaries;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

//образовательное учреждение
@Entity
@Table(name = "edu_organization", schema = "public")
@DynamicUpdate
public class EduOrganization {

    @Id
    @Column(name = "code",unique = true,nullable = false)
    private String code;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    @Basic
    @Column(name = "deleted",nullable = false)
    private Boolean deleted;

 //   @OneToOne(mappedBy = "eduOrganization")
 //   private EgeResult egeResult;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
/*
    public EgeResult getEgeResult() {
        return egeResult;
    }

    public void setEgeResult(EgeResult egeResult) {
        this.egeResult = egeResult;
    }
    */
}
