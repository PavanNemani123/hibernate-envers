package com.envers.spring.boot.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.event.spi.PostUpdateEvent;

import com.envers.spring.boot.rest.model.City;

public class MyEnversPostUpdateEventListenerImpl extends EnversPostUpdateEventListenerImpl {

	private static final long serialVersionUID = -7249199945851585670L;

	@PersistenceContext
	private EntityManager entityManager;

	protected MyEnversPostUpdateEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {

		if (event.getEntity() instanceof City) {
			
			System.out.println("event stopped");

		}

	}

}
