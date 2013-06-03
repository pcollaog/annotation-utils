package cl.pcollaog.annotations.utils.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author pcollaog
 * 
 */
public interface MethodAnnotationUtils {

	/**
	 * @param annotation
	 * @return
	 */
	List<Method> findMethodsWithAnnotation(
			Class<? extends Annotation> annotation);

}
