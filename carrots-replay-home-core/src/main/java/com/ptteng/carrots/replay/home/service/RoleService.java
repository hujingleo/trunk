package com.ptteng.carrots.replay.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

import com.ptteng.carrots.replay.home.model.Role;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface RoleService extends BaseDaoService {










	public Long insert(Role role)throws ServiceException, ServiceDaoException;



	public List<Role> insertList(List<Role> roleList)throws ServiceException, ServiceDaoException;



	public boolean delete(Long id)throws ServiceException, ServiceDaoException;



	public boolean update(Role role)throws ServiceException, ServiceDaoException;



	public boolean updateList(List<Role> roleList)throws ServiceException, ServiceDaoException;



	public Role getObjectById(Long id)throws ServiceException, ServiceDaoException;



	public List<Role> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;



	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRoleIdsByName(String name, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;





	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countRoleIds() throws ServiceException, ServiceDaoException;




}

