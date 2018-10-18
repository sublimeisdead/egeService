package ru.nahodka.bi.services.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "appeal_request_state",schema = "public")
@DynamicUpdate
public class AppealRequestState implements Serializable {

    @Id
    @SequenceGenerator(name = "appeal_request_state_id_seq", sequenceName = "appeal_request_state_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "appeal_request_state_id_seq")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    protected Long id;

    @Basic
    @Column(name = "set_at")
    protected Timestamp setAt;

    @Basic
    @Column(name = "request_id")
    protected Integer requestId;

    @Basic
    @Column(name = "state_id")
    protected Integer stateId;

    @Basic
    @Column(name = "comment")
    protected String comment;

    @Basic
    @Column(name = "prev_state_id")
    protected Integer prevStateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getSetAt() {
        return setAt;
    }

    public void setSetAt(Timestamp setAt) {
        this.setAt = setAt;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPrevStateId() {
        return prevStateId;
    }

    public void setPrevStateId(Integer prevStateId) {
        this.prevStateId = prevStateId;
    }
}
