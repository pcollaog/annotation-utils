package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * 
 * 
 * @author pcollaog
 */
public abstract class AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(AnnotationUtils.class);

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
