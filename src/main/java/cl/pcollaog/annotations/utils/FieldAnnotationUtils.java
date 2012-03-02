package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * <p>
 * $Id$
 * </p>
 * 
 * @author pcollaog
 * @version $Revision$
 */
public abstract class FieldAnnotationUtils extends AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(FieldAnnotationUtils.class);

	public static Field findFieldWithAnnotation(final Class<?> clazz,
			final Class<? extends Annotation> annotationClass) {

		logger.debug("Classname [{}]", clazz.getName());

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(annotationClass)) {
				return field;
			}
		}

		Class<?> superClass = clazz.getSuperclass();

		if (null != superClass) {
			return findFieldWithAnnotation(superClass, annotationClass);
		}

		return null;
	}
}
