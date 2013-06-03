package cl.pcollaog.annotations.utils;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Basic;

import org.junit.Assert;
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
public class MethodAnnotationUtilsImplTest {

	private static Logger logger = LoggerFactory
			.getLogger(MethodAnnotationUtilsImplTest.class);

	@Test
	public void testFindMethodsWithAnnotation() {
		List<Method> methods = MethodAnnotationUtilsImpl.findMethodsWithAnnotation(
				ModelExample1Impl.class, Basic.class);

		logger.info("Size Array {}", methods.size());

		Assert.assertTrue(methods.size() == 2);
	}
}
