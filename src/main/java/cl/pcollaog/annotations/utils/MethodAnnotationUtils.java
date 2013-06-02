package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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
public class MethodAnnotationUtils extends AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(MethodAnnotationUtils.class);

	/**
	 * @param type
	 */
	protected MethodAnnotationUtils(Class<?> type) {
		super(type);
	}

	/**
	 * @param annotation
	 * @param class1
	 * @param class2
	 * @return
	 */
	public List<Method> findMethodsWithAnnotation(
			Class<? extends Annotation> annotation) {
		List<Method> methodsFound = findMethodsWithAnnotationRecursive(
				getClassToInspect(), annotation, new ArrayList<Method>());

		if (logger.isDebugEnabled()) {
			for (Method method : methodsFound) {
				logger.debug("Method Found [{}]", method.getName());
			}
		}
		return methodsFound;
	}

	private static List<Method> findMethodsWithAnnotationRecursive(
			final Class<?> clazz,
			final Class<? extends Annotation> annotationClass,
			final List<Method> methods) {

		Method[] classMethods = clazz.getDeclaredMethods();

		for (Method method : classMethods) {
			if (method.isAnnotationPresent(annotationClass)) {
				methods.add(method);
			}
		}

		Class<?> superClass = clazz.getSuperclass();

		if (hasSuperClass(superClass)) {
			return findMethodsWithAnnotationRecursive(superClass,
					annotationClass, methods);
		}

		return methods;
	}
}
