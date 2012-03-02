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
public abstract class MethodAnnotationUtils extends AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(MethodAnnotationUtils.class);

	/**
	 * @param class1
	 * @param class2
	 * @return
	 */
	public static List<Method> findMethodsWithAnnotation(Class<?> clazz,
			Class<? extends Annotation> annotationClass) {

		List<Method> methods = new ArrayList<Method>();

		return findMethodsWithAnnotationRecursive(clazz, annotationClass,
				methods);

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

		if (null != superClass & !superClass.equals(Object.class)) {
			return findMethodsWithAnnotationRecursive(superClass,
					annotationClass, methods);
		}

		return methods;
	}
}
