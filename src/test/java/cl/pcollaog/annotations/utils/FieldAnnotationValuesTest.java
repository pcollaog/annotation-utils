package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.persistence.Column;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

/**
 * @author pcollaog
 * 
 */
public class FieldAnnotationValuesTest {

	private static Logger logger = LoggerFactory
			.getLogger(FieldAnnotationValuesTest.class);

	private static final Pattern OBJECT_METHOD = Pattern
			.compile("(equals|getClass|hashCode|clone|toString|annotationType)");

	@Test
	public void test() {
		FieldAnnotationUtils annotationUtils = new FieldAnnotationUtils(
				ModelExample1Impl.class);

		Class<? extends Annotation> annotationType = Column.class;

		Field field = annotationUtils
				.findFirstFieldWithAnnotation(annotationType);

		Annotation columnAnnotation = field.getAnnotation(annotationType);

		Method[] anntMethods = columnAnnotation.getClass().getDeclaredMethods();

		Map<String, Object> memberValues = new LinkedHashMap<String, Object>();
		for (Method method : anntMethods) {
			String methodName = method.getName();
			if (!OBJECT_METHOD.matcher(methodName).matches()) {
				logger.debug("Method Name [{}]", methodName);
				try {
					Object[] args = null;
					Object value = method.invoke(columnAnnotation, args);
					memberValues.put(methodName, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		assertNotNull(field);
		assertEquals(String.class, field.getType());
	}
}
