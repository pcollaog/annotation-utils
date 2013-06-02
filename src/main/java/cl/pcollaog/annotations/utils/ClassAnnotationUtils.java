package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

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
public class ClassAnnotationUtils extends AbstractAnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(ClassAnnotationUtils.class);

	/**
	 * @param classToInspect
	 */
	protected ClassAnnotationUtils(Class<?> classToInspect) {
		super(classToInspect);
	}

	public List<Class<?>> find(Class<? extends Annotation> annotationClazz) {
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
