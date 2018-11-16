package com.csi.training.junit.arquillian.embedded;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestOnEmbeddedEnviroment {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(WebArchive.class, "test.war");
    }

    @Test
    public void testMessagesOnEmbeddedEnvironment(){
        System.out.println("=========================================");
        System.out.println("Ejecución en contenedor embarcado");
        System.out.println("=========================================");
    }
}
