package cl.pcollaog.annotations.utils;

import java.lang.reflect.Field;

import javax.persistence.Id;

import org.junit.Assert;
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
public class FieldAnnotationUtilsTest {

	private static Logger logger = LoggerFactory
			.getLogger(FieldAnnotationUtilsTest.class);

	@Test
	public void testFieldWithAnnotation() {
		Field field = FieldAnnotationUtils.findFirstFieldWithAnnotation(
				ModelExample1Impl.class, Id.class);

		logger.info(field.getType().getName());

		Assert.assertTrue(Integer.class.equals(field.getType()));
	}

}
