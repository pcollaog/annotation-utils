package cl.pcollaog.annotations.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * 
 * @author pcollaog
 */
public class AnnotationUtilsTest {

	private static Logger logger = LoggerFactory
			.getLogger(AnnotationUtilsTest.class);

	@Test
	public void testFieldWithAnnotation() {
		logger.debug("SLF4");
	}

}
