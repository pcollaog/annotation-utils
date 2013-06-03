package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.utils.api.FieldAnnotationUtils;

/**
 * 
 * @author pcollaog
 */
public class FieldAnnotationUtilsImpl extends AnnotationUtils implements
		FieldAnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(FieldAnnotationUtilsImpl.class);

	/**
	 * @param classToInspect
	 */
	protected FieldAnnotationUtilsImpl(Class<?> classToInspect) {
		super(classToInspect);
	}

	@Override
	public Field findFirstFieldWithAnnotation(
			final Class<? extends Annotation> annotation) {
		return findFirstFieldWithAnnotation(getClassToInspect(), annotation);
	}

	private Field findFirstFieldWithAnnotation(final Class<?> clazz,
			final Class<? extends Annotation> annotationClass) {

		logger.debug("Classname [{}]", clazz.getName());

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(annotationClass)) {
				return field;
			}
		}

		Class<?> superClass = clazz.getSuperclass();

		if (hasSuperClass(superClass)) {
			return findFirstFieldWithAnnotation(superClass, annotationClass);
		}
		return null;
	}

	public List<Field> findFieldsWithAnnotation(final Class<?> clazz,
			final Class<? extends Annotation> annotationClass) {

		List<Field> fieldsList = new ArrayList<Field>();

		return findFieldsWithAnnotationRecursive(clazz, annotationClass,
				fieldsList);
	}

	/**
	 * @param clazz
	 * @param annotationClass
	 * @param fields
	 * @return
	 */
	private static List<Field> findFieldsWithAnnotationRecursive(
			Class<?> clazz, Class<? extends Annotation> annotationClass,
			List<Field> fieldsList) {

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(annotationClass)) {
				fieldsList.add(field);
			}
		}

		Class<?> superClass = clazz.getSuperclass();

		if (hasSuperClass(superClass)) {
			return findFieldsWithAnnotationRecursive(superClass,
					annotationClass, fieldsList);
		}

		return fieldsList;
	}
}
