package com.csi.training.junit.arquillian.remote;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestOnRemoteEnvironment {

	private static final Logger LOG = Logger.getLogger(TestOnRemoteEnvironment.class);
	
    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(WebArchive.class, "test.war");
    }

    @Test
    public void testMessagesOnRemoteEnvironment(){
    	LOG.info("=========================================");
    	LOG.info("Ejecucion en contenedor remoto");
    	LOG.info("=========================================");
    }
}
