package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.utils.api.FieldAnnotationUtils;

/**
 * 
 * @author pcollaog
 */
public class FieldAnnotationUtilsImpl extends AnnotationUtils implements
		FieldAnnotationUtils {

	private static final Pattern OBJECT_METHOD = Pattern
			.compile("(equals|getClass|hashCode|clone|toString|annotationType)");

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

	@Override
	public Map<String, Object> findFirstFieldMemeberValues(
			final Class<? extends Annotation> annotation) {
		Field firstField = findFirstFieldWithAnnotation(getClassToInspect(),
				annotation);
		Annotation ann = firstField.getAnnotation(annotation);
		Method[] annMethods = ann.getClass().getDeclaredMethods();
		Map<String, Object> memberValues = new LinkedHashMap<String, Object>();
		for (Method method : annMethods) {
			String methodName = method.getName();
			if (!OBJECT_METHOD.matcher(methodName).matches()) {
				try {
					Object[] args = null;
					Object value = method.invoke(ann, args);
					memberValues.put(methodName, value);
				} catch (Exception e) {
					logger.error("Unexpected Error with member [{}]",
							methodName, e);
				}
			}
		}
		return memberValues;

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

	@Override
	public List<Field> findFieldsWithAnnotation(
			final Class<? extends Annotation> annotation) {
		return findFieldsWithAnnotationRecursive(getClassToInspect(),
				annotation, new ArrayList<Field>());
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
