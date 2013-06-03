package cl.pcollaog.annotations.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import javax.persistence.Column;

import org.junit.Test;

import cl.pcollaog.annotations.testmodel.ModelExample1Impl;
import cl.pcollaog.annotations.utils.api.FieldAnnotationUtils;

/**
 * @author pcollaog
 * 
 */
public class FieldAnnotationValuesTest {

	@Test
	public void findFirstFieldMemeberValues() {
		FieldAnnotationUtils annotationUtils = new FieldAnnotationUtilsImpl(
				ModelExample1Impl.class);
		Map<String, Object> result = annotationUtils
				.findFirstFieldMemeberValues(Column.class);

		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("", result.get("name"));
		assertEquals(100, result.get("length"));
		assertFalse((Boolean) result.get("nullable"));
		assertFalse((Boolean) result.get("unique"));
	}

}
