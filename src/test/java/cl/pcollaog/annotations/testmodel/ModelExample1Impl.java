package cl.pcollaog.annotations.testmodel;

import javax.persistence.Basic;

/**
 * <p>
 * </p>
 * 
 * <pre>
 * $Id$
 * </pre>
 * 
 * @author pcollaog
 * @version $Revision$
 */
public class ModelExample1Impl extends AbstractModel {

	private String _firstName;

	/**
	 * @return the firstName
	 */
	@Basic
	public final String getFirstName() {
		return _firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	@Basic
	public final void setFirstName(String firstName) {
		_firstName = firstName;
	}

}
