package ru.nahodka.bi.services.model.dictionaries;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "applicant_type", schema = "public")
@DynamicUpdate
public class ApplicantType {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
