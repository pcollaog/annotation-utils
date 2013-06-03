package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.utils.api.ClassAnnotationUtils;

/**
 * 
 * @author pcollaog
 */
public class ClassAnnotationUtilsImpl extends AnnotationUtils implements
		ClassAnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(ClassAnnotationUtilsImpl.class);

	/**
	 * @param classToInspect
	 */
	protected ClassAnnotationUtilsImpl(Class<?> classToInspect) {
		super(classToInspect);
	}

	@Override
	public List<Class<?>> findAnnotationOnHierarchy(
			Class<? extends Annotation> annotationClazz) {
		return findAnnotationRecursive(getClassToInspect(), annotationClazz,
				new ArrayList<Class<?>>());
	}

	/**
	 * @param clazz
	 * @param annotationClass
	 * @param classes
	 * @return
	 */
	private static List<Class<?>> findAnnotationRecursive(Class<?> clazz,
			Class<? extends Annotation> annotationClass, List<Class<?>> classes) {

		logger.debug("Classname [{}]", clazz.getName());

		if (clazz.isAnnotationPresent(annotationClass)) {
			classes.add(clazz);
		}

		Class<?> superclass = clazz.getSuperclass();
		if (hasSuperClass(superclass)) {
			return findAnnotationRecursive(superclass, annotationClass, classes);
		}

		return classes;
	}
}
