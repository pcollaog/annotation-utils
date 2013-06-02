package cl.pcollaog.annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * </p>
 * 
 * 
 * @author pcollaog
 */
public abstract class AbstractAnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(AbstractAnnotationUtils.class);

	private Class<?> _classToInspect;

	/**
	 * 
	 * @param classToInspect
	 *            class to be inspected
	 */
	protected AbstractAnnotationUtils(Class<?> classToInspect) {
		_classToInspect = classToInspect;
	}

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
		logger.debug("Creating instance of", ClassAnnotationUtils.class);
		ClassAnnotationUtils annotationUtils = new ClassAnnotationUtils(
				classToInspect);
		return annotationUtils.find(annotation);
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
		FieldAnnotationUtils annotationUtils = new FieldAnnotationUtils(
				classToInspect);
		return annotationUtils.findFirstFieldWithAnnotation(annotation);
	}

}