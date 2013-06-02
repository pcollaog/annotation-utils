package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.junit.Test;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

/**
 * @author pcollaog
 * 
 */
public class AbstractAnnotationUtilsTest {

	@Test
	public void findAnnotationOnHierarchy() {
		List<Class<?>> list = AbstractAnnotationUtils
				.findAnnotationOnHierarchy(ModelExample1Impl.class,
						Resource.class);
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void findFirstFieldAnnotated() {
		Field field = AbstractAnnotationUtils.findFirstFieldAnnotated(
				ModelExample1Impl.class, Id.class);
		assertNotNull(field);
		assertEquals(Integer.class, field.getType());
		assertEquals("_id", field.getName());
	}
}
