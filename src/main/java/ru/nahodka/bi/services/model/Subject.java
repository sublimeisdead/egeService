package ru.nahodka.bi.services.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "subject", schema = "public")
@DynamicUpdate
public class Subject {

  //  @Id
  // @OneToOne()
  //  private Long id;

    @Id
    @Column(name = "code",unique = true,nullable = false)
    private String code;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "deleted")
    private boolean deleted;

 //  @OneToOne(mappedBy = "sbj")
 //   private EgeResult egeResult;


/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
/*
    public EgeResult getEgeResult() {
        return egeResult;
    }

    public void setEgeResult(EgeResult egeResult) {
        this.egeResult = egeResult;
    }*/
}
