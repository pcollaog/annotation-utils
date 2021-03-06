package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import javax.persistence.Id;

import org.junit.Test;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

/**
 * <p>
 * </p>
 * 
 * @author pcollaog
 */
public class FieldAnnotationUtilsImplTest {

	@Test
	public void testFieldWithAnnotation() {
		FieldAnnotationUtilsImpl annotationUtils = new FieldAnnotationUtilsImpl(
				ModelExample1Impl.class);
		Field field = annotationUtils.findFirstFieldWithAnnotation(Id.class);

		assertNotNull(field);
		assertTrue(Integer.class.equals(field.getType()));
	}

}
