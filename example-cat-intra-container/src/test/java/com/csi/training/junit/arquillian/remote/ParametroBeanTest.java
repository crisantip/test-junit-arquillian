package com.csi.training.junit.arquillian.remote;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.ConfigurableMavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import ec.gob.sri.catastro.tributario.logica.catalogo.sistema.ParametroBean;
import ec.gob.sri.catastro.tributario.logica.catalogo.sistema.RequisitoBean;
import ec.gob.sri.catastro.tributario.logica.util.excepcion.EntidadNoExisteExcepcion;
import ec.gob.sri.catastro.tributario.modelo.catalogo.Requisito;

@RunWith(Arquillian.class)
public class ParametroBeanTest {

	private static final Logger LOG = Logger.getLogger(ParametroBeanTest.class);

	@Inject
	ParametroBean parametroBean;
	
	@Inject
	RequisitoBean requisitoBean;
	
	@Deployment
	public static Archive<?> deploy() {
		
		
		ConfigurableMavenResolverSystem configureResolver = Maven.configureResolver();
		configureResolver.workOffline(true);
		
		Archive<?> testArchive = ShrinkWrap.create(WebArchive.class, "test.war")
				//Maven coordinates in canonical form -> groupId:artifactId:packaging:classifier:version
				//.addAsLibraries(getLibraries("ec.gob.sri:ruc:jar:jee7:5.0-SNAPSHOT"))
				.addAsLibraries(getLibraries("ec.gob.sri.catastro-tributario:sri-catastro-tributario-util"))
				.addAsLibraries(getLibraries("ec.gob.sri.catastro-tributario:sri-catastro-tributario-logica"))
				.addAsLibraries(getLibraries("ec.gob.sri.catastro-tributario:sri-catastro-tributario-cliente"))
				.addAsLibraries(getLibraries("ec.gob.sri:sri-seguridad-intranet"))
				.addAsWebInfResource("jboss-deployment-structure.xml", "jboss-deployment-structure.xml");
		return testArchive;
	}
	
	private static File[] getLibraries(String gav) {
		return Maven.configureResolver()
		.workOffline(true)
        .loadPomFromFile("pom.xml")
        .resolve(gav)
        .withTransitivity()
        .as(File.class);
	}

	@Test
	public void testGetParam() throws InterruptedException, EntidadNoExisteExcepcion {
		LOG.info("=========================================");
		LOG.info("Parametros");
		LOG.info("=========================================");

		List<Requisito> requisitos = requisitoBean.obtenerRequisitos();
		LOG.info("# Requisitos: " + requisitos.size());
		
		// Parametro parametro = parametroBean.obtenerParametroVigentePorNombre(
		// ConstantesUtil.PARAMETRO_CODIGOS_TIPO_LUGAR,
		// ConstantesUtil.PARAMETRO_CODIGO_INSCRIPCION_POR_CONTRIBUYENTE);
		// LOG.info("Nombre del parametro: " + parametro.getNombre());
		// LOG.info("Valor del parametro: " + parametro.getValor());
	}
}
