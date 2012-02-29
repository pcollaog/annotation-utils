package cl.pcollaog.annotations.testmodel;

import javax.persistence.Id;

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
public abstract class AbstractModel {

	@Id
	private Integer _id;

	/**
	 * @return the id
	 */
	public final Integer getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(Integer id) {
		_id = id;
	}

}
