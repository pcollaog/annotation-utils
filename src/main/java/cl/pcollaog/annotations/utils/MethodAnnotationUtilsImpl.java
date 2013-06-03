package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.utils.api.MethodAnnotationUtils;

/**
 * 
 * @author pcollaog
 */
public class MethodAnnotationUtilsImpl extends AnnotationUtils implements
		MethodAnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(MethodAnnotationUtilsImpl.class);

	/**
	 * @param type
	 */
	protected MethodAnnotationUtilsImpl(Class<?> type) {
		super(type);
	}

	@Override
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
