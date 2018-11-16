package com.csi.training.junit.arquillian.managed;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestOnManagedEnvironment {
	
	private static final Logger LOG = Logger.getLogger(TestOnManagedEnvironment.class);

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(WebArchive.class, "test.war");
    }

    @Test
    public void testMessagesOnManagedEnvironment(){
    	LOG.info("=========================================");
    	LOG.info("Ejecución en contenedor administrado");
    	LOG.info("=========================================");
    }
}
