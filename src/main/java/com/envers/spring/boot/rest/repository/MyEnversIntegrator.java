package com.envers.spring.boot.rest.repository;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversIntegrator;
import org.hibernate.envers.event.spi.EnversListenerDuplicationStrategy;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class MyEnversIntegrator extends EnversIntegrator {

	private AuditConfiguration enversConfiguration;

	@Override
	public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		final EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
		listenerRegistry.addDuplicationStrategy(EnversListenerDuplicationStrategy.INSTANCE);

		enversConfiguration = AuditConfiguration.getFor(configuration,
				serviceRegistry.getService(ClassLoaderService.class));

		if (enversConfiguration.getEntCfg().hasAuditedEntities()) {
			listenerRegistry.appendListeners(EventType.POST_UPDATE,
					new MyEnversPostUpdateEventListenerImpl(enversConfiguration));
			
			listenerRegistry.appendListeners(EventType.POST_INSERT,
					new MyEnversPostInsertEventListenerImpl(enversConfiguration));

		}

	}

}
