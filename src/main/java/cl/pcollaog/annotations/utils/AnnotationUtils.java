package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.utils.api.ClassAnnotationUtils;
import cl.pcollaog.annotations.utils.api.FieldAnnotationUtils;
import cl.pcollaog.annotations.utils.api.MethodAnnotationUtils;

/**
 * <p>
 * </p>
 * 
 * @author pcollaog
 */
public abstract class AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(AnnotationUtils.class);

	private Class<?> _classToInspect;

	/**
	 * 
	 * @param classToInspect
	 *            class to be inspected
	 */
	protected AnnotationUtils(Class<?> classToInspect) {
		_classToInspect = classToInspect;
	}

	/**
	 * 
	 * @param classToInspect
	 * @return
	 */
	public static ClassAnnotationUtils createClassAnnotationUtils(
			Class<?> classToInspect) {
		return new ClassAnnotationUtilsImpl(classToInspect);
	}

	/**
	 * 
	 * @param classToInspect
	 * @return
	 */
	public static FieldAnnotationUtils createFieldAnnotationUtils(
			Class<?> classToInspect) {
		return new FieldAnnotationUtilsImpl(classToInspect);
	}

	/**
	 * 
	 * @param classToInspect
	 * @return
	 */
	public static MethodAnnotationUtils createMethodAnnotationUtils(
			Class<?> classToInspect) {
		return new MethodAnnotationUtilsImpl(classToInspect);
	}

	/**
	 * 
	 * @param superClass
	 * @return
	 */
	protected static boolean hasSuperClass(Class<?> superClass) {
		return null != superClass & !superClass.equals(Object.class);
	}

	/**
	 * @return the classToInspect
	 */
	public final Class<?> getClassToInspect() {
		return _classToInspect;
	}

	/**
	 * Search {@code annotation} on hierarchy of {@code classToInspect}
	 * 
	 * @param classToInspect
	 *            class to be inspected
	 * @param annotation
	 *            to be search
	 * @return list with all classes that contains {@code annotation}
	 */
	public static List<Class<?>> findAnnotationOnHierarchy(
			Class<?> classToInspect, Class<? extends Annotation> annotation) {
		logger.debug("Creating instance of", ClassAnnotationUtilsImpl.class);
		ClassAnnotationUtils annotationUtils = new ClassAnnotationUtilsImpl(
				classToInspect);
		return annotationUtils.findAnnotationOnHierarchy(annotation);
	}

	/**
	 * Find first field annotated with {@code annotation} on hierarchy
	 * 
	 * @param classToInspect
	 * @param annotation
	 * @return first field with {@code annotation}
	 */
	public static Field findFirstFieldAnnotated(Class<?> classToInspect,
			Class<? extends Annotation> annotation) {
		FieldAnnotationUtilsImpl annotationUtils = new FieldAnnotationUtilsImpl(
				classToInspect);
		return annotationUtils.findFirstFieldWithAnnotation(annotation);
	}

	/**
	 * 
	 * @param classToInspect
	 * @param annotation
	 * @return
	 */
	public static List<Method> findMethodsWithAnnotation(
			Class<?> classToInspect, Class<? extends Annotation> annotation) {
		MethodAnnotationUtilsImpl annotationUtils = new MethodAnnotationUtilsImpl(
				classToInspect);
		return annotationUtils.findMethodsWithAnnotation(annotation);
	}

}