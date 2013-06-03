package cl.pcollaog.annotations.utils.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author pcollaog
 * 
 */
public interface FieldAnnotationUtils {

	/**
	 * @param annotation
	 * @return
	 */
	Field findFirstFieldWithAnnotation(Class<? extends Annotation> annotation);

}
