/**
 * 
 */
package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Role;
import com.ptteng.carrots.replay.home.service.RoleService;


import java.util.List;
import java.util.Map;

public class RoleSCAClient implements RoleService {

	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public Long insert(Role role) throws ServiceException, ServiceDaoException {

		return roleService.insert(role);

	}

	@Override
	public List<Role> insertList(List<Role> roleList) throws ServiceException,
			ServiceDaoException {

		return roleService.insertList(roleList);

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		return roleService.delete(id);

	}

	@Override
	public boolean update(Role role) throws ServiceException,
			ServiceDaoException {

		return roleService.update(role);

	}

	@Override
	public boolean updateList(List<Role> roleList) throws ServiceException,
			ServiceDaoException {

		return roleService.updateList(roleList);

	}

	@Override
	public Role getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		return roleService.getObjectById(id);

	}

	@Override
	public List<Role> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		return roleService.getObjectsByIds(ids);

	}

	@Override
	public List<Long> getRoleIdsByName(String name, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleService.getRoleIdsByName(name, start, limit);
	}

	@Override
	public List<Long> getRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleService.getRoleIds(start, limit);
	}

	@Override
	public Integer countRoleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleService.countRoleIds();
	}


	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleService.fakeDelete(clz, id);
	}



	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		roleService.deleteList(clz, ids);

	}
//
//	@Override
//	public Object getObjectByDynamicCondition(Class clz,
//											  Map<String, Object> conditions, Integer start, Integer limit)
//			throws ServiceException, ServiceDaoException {
//		return this.roleService.getObjectByDynamicCondition(clz, conditions, start, limit);
//	}
}

