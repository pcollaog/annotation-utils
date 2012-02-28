package cl.pcollaog.annotations.utils;

import java.lang.reflect.Field;

import javax.persistence.Id;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

/**
 * <p>
 * </p>
 * 
 * @author pcollaog
 */
public class AnnotationUtilsTest {

	private static Logger logger = LoggerFactory
			.getLogger(AnnotationUtilsTest.class);

	@Before
	public void before() {
		logger.info("Inicializando");
	}

	@Test
	public void testFieldWithAnnotation() {
		Field field = AnnotationUtils.findFieldWithAnnotation(
				ModelExample1Impl.class, Id.class);

		logger.info(field.getType().getName());

		Assert.assertTrue(Integer.class.equals(field.getType()));
	}

}
