package com.envers.spring.boot.rest.model;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.envers.spring.boot.rest.listener.EntityRevisionListener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@RevisionEntity(value = EntityRevisionListener.class)
public class RevisionsEntity {

    @Id
    @GeneratedValue
    @RevisionNumber
    private Long revisionId;

    @RevisionTimestamp
    private Date revisionDate;

    public RevisionsEntity(Long revisionId, Date revisionDate) {
        this.revisionId = revisionId;
        this.revisionDate = revisionDate;
    }

    public RevisionsEntity() { }

    public Long getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(Long revisionId) {
        this.revisionId = revisionId;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    @Override
    public String toString() {
        return "RevisionsEntity{" +
                "revisionId=" + revisionId +
                ", revisionDate=" + revisionDate +
                '}';
    }
}
