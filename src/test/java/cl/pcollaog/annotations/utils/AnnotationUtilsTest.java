package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Basic;
import javax.persistence.Id;

import org.junit.Test;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

/**
 * @author pcollaog
 * 
 */
public class AnnotationUtilsTest {

	@Test
	public void findAnnotationOnHierarchy() {
		List<Class<?>> list = AnnotationUtils.findAnnotationOnHierarchy(
				ModelExample1Impl.class, Resource.class);
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void findFirstFieldAnnotated() {
		Field field = AnnotationUtils.findFirstFieldAnnotated(
				ModelExample1Impl.class, Id.class);
		assertNotNull(field);
		assertEquals(Integer.class, field.getType());
		assertEquals("_id", field.getName());
	}

	@Test
	public void findMethodsWithAnnotation() {
		List<Method> methods = AnnotationUtils.findMethodsWithAnnotation(
				ModelExample1Impl.class, Basic.class);

		assertNotNull(methods);
		assertFalse(methods.isEmpty());

	}
}
