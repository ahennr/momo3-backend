package de.terrestris.momo.dao;

import org.springframework.stereotype.Repository;

import de.terrestris.momo.model.security.GroupMember;
import de.terrestris.shogun2.dao.GenericHibernateDao;

/**
 *
 * @author Andre Henn
 * @author terrestris GmbH & Co. KG
 *
 * @param <E>
 */
@Repository("groupMemberStateDao")
public class GroupMemberDao<E extends GroupMember> extends GenericHibernateDao<E, Integer> {

	/**
	 * Public default constructor for this DAO.
	 */
	@SuppressWarnings("unchecked")
	public GroupMemberDao() {
		super((Class<E>) GroupMember.class);
	}

	/**
	 * Constructor that has to be called by subclasses.
	 *
	 * @param clazz
	 */
	protected GroupMemberDao(Class<E> clazz) {
		super(clazz);
	}

}
