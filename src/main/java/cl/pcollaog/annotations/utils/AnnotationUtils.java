package cl.pcollaog.annotations.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * 
 * 
 * @author pcollaog
 */
public abstract class AnnotationUtils {

	private static Logger logger = LoggerFactory
			.getLogger(AnnotationUtils.class);

	protected static boolean hasSuperClass(Class<?> superClass) {
		return null != superClass & !superClass.equals(Object.class);
	}

}