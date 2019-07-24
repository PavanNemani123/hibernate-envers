package com.envers.spring.boot.rest.listener;


import org.hibernate.envers.RevisionListener;


public class EntityRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        System.out.println("New revision is created: " + o);
    }
}
