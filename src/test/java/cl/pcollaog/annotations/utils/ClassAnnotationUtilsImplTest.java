package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;
import cl.pcollaog.annotations.utils.api.ClassAnnotationUtils;

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
public class ClassAnnotationUtilsImplTest {

	private Logger logger = LoggerFactory
			.getLogger(ClassAnnotationUtilsImplTest.class);

	@Test
	public void testFindAnnotationOnHierarchy() {
		ClassAnnotationUtils annotationUtils = new ClassAnnotationUtilsImpl(
				ModelExample1Impl.class);

		List<Class<?>> classes = annotationUtils
				.findAnnotationOnHierarchy(Resource.class);

		assertNotNull(classes);
		assertFalse(classes.isEmpty());
		assertTrue(classes.size() == 1);

		for (Class<?> clazz : classes) {
			logger.info("Class found [{}]", clazz.getName());
		}

	}

}
