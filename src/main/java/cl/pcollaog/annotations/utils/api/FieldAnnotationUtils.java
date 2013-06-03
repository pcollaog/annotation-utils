package cl.pcollaog.annotations.utils.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

	/**
	 * @param annotation
	 * @return
	 */
	Map<String, Object> findFirstFieldMemeberValues(
			Class<? extends Annotation> annotation);

	/**
	 * @param clazz
	 * @param annotationClass
	 * @return
	 */
	List<Field> findFieldsWithAnnotation(Class<? extends Annotation> annotation);

}
