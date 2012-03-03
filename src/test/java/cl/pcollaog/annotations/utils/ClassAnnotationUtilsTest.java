package cl.pcollaog.annotations.utils;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;

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
public class ClassAnnotationUtilsTest {

	private Logger logger = LoggerFactory
			.getLogger(ClassAnnotationUtilsTest.class);

	@Test
	public void testFind() {
		List<Class<?>> classes = ClassAnnotationUtils.find(
				ModelExample1Impl.class, Resource.class);

		for (Class<?> clazz : classes) {
			logger.info("Class found [{}]", clazz.getName());
		}

	}
}
