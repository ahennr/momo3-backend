/**
 *
 */
package de.terrestris.momo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.terrestris.momo.dao.GroupMemberDao;
import de.terrestris.momo.model.security.GroupMember;
import de.terrestris.momo.service.GroupMemberService;
import de.terrestris.shogun2.rest.AbstractRestController;

/**
 * terrestris GmbH & Co. KG
 * @author ahenn
 * @date 30.03.2017
 *
 */
@RestController
@RequestMapping("/groupmembers")
public class GroupMemberRestConroller<E extends GroupMember, D extends GroupMemberDao<E>, S extends GroupMemberService<E, D>> extends AbstractRestController<E, D, S>{

	/**
	 * Default constructor, which calls the type-constructor
	 */
	@SuppressWarnings("unchecked")
	public GroupMemberRestConroller() {
		this((Class<E>) GroupMember.class);
	}

	/**
	 * Constructor that sets the concrete entity class for the controller.
	 * Subclasses MUST call this constructor.
	 */
	protected GroupMemberRestConroller(Class<E> entityClass) {
		super(entityClass);
	}

	/**
	 * We have to use {@link Qualifier} to define the correct service here.
	 * Otherwise, spring can not decide which service has to be autowired here
	 * as there are multiple candidates.
	 */
	@Override
	@Autowired
	@Qualifier("groupMemberService")
	public void setService(S service) {
		this.service = service;
	}

}
