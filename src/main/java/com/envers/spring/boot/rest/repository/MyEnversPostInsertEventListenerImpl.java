package com.envers.spring.boot.rest.repository;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;

public class MyEnversPostInsertEventListenerImpl extends EnversPostInsertEventListenerImpl{

	private static final long serialVersionUID = -5739688790187191368L;

	protected MyEnversPostInsertEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onPostInsert(PostInsertEvent event) {
		super.onPostInsert(event);
	}

}
