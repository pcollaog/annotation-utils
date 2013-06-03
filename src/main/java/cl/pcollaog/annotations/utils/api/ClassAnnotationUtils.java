package cl.pcollaog.annotations.utils.api;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author pcollaog
 * 
 */
public interface ClassAnnotationUtils {

	/**
	 * Search {@code annotation} on hierarchy of {@code classToInspect}
	 * 
	 * @param annotation
	 *            to be search
	 * @return list with all classes that contains {@code annotation}
	 */
	List<Class<?>> findAnnotationOnHierarchy(
			Class<? extends Annotation> annotation);

}
