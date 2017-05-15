package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;

import com.ptteng.carrots.replay.home.model.Manager;
import com.ptteng.carrots.replay.home.service.ManagerService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ManagerServiceImpl extends BaseDaoServiceImpl implements ManagerService {



	private static final Log log = LogFactory.getLog(ManagerServiceImpl.class);



	@Override
	public Long insert(Manager manager) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + manager);
		}
		if (manager == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		manager.setCreateAt(currentTimeMillis);
		manager.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(manager);
		} catch (DaoException e) {
			log.error(" insert wrong : " + manager);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert data success : " + result);
		}
		return result;
	}

	@Override
	public List<Manager> insertList(List<Manager> managerList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (managerList == null ? "null" : managerList.size()));
		}
		List<Manager> resultList = null;

		if (CollectionUtils.isEmpty(managerList)) {
			return new ArrayList<Manager>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Manager manager : managerList) {
			manager.setCreateAt(currentTimeMillis);
			manager.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Manager>) dao.batchSave(managerList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + managerList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : "
					+ (resultList == null ? "null" : resultList.size()));
		}
		return resultList;

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" delete data : " + id);
		}
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Manager.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" delete data success : " + id);
		}
		return result;

	}

	@Override
	public boolean update(Manager manager) throws ServiceException,
			ServiceDaoException {

		log.info(" update data : " + (manager == null ? "null" : manager.getId()));

		boolean result = false;

		if (manager == null) {
			return true;
		}

		manager.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(manager);
		} catch (DaoException e) {
			log.error(" update wrong : " + manager);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + manager);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Manager> managerList) throws ServiceException,
			ServiceDaoException {

		log.info(" update lists : "
				+ (managerList == null ? "null" : managerList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(managerList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Manager manager : managerList) {
			manager.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(managerList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + managerList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + managerList.size());
		}
		return result;
	}

	@Override
	public Manager getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Manager manager = null;

		if (id == null) {
			return manager;
		}

		try {
			manager = (Manager) dao.get(Manager.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return manager;
	}

	@Override
	public List<Manager> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Manager> manager = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Manager>();
		}

		try {
			manager = (List<Manager>) dao.getList(Manager.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (manager == null ? "null" : manager.size()));
		}
		return manager;
	}

	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getManagerIdsByName(String name, Integer start,
										  Integer limit) throws ServiceException, ServiceDaoException {


		log.info(" get ids by name,start,limit  : " + name + " , " + start
				+ " , " + limit);

		List<Long> idList = new ArrayList();

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		if(name==null){
			log.info("name is null ,so return direct ");
			return idList;
		}

		try {
			idList = dao.getIdList("getManagerIdsByName", new Object[] { name },
					start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + name + " , "
					+ start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getManagerIdsByRoleID(Long roleID, Integer start,
											Integer limit) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by roleID,start,limit  : " + roleID + " , "
					+ start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getManagerIdsByRoleID",
					new Object[] { roleID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + roleID
					+ " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getManagerIdsByRoleIDAndStatus(Long roleID, String status,
													 Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by roleID,status,start,limit  : " + roleID
					+ " , " + status + " , " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getManagerIdsByRoleIDAndStatus",
					new Object[] { roleID, status }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + roleID
					+ " , " + status + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	@Override
	public List<Long> getManagerIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start
				+ " , " + limit);
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		// dao.excuteSimpleSql(arg0, arg1)

		try {
			idList = dao.getIdList("getManagerIdsAll", new Object[]{}, start,
					limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , "
					+ limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countManagerIds() throws ServiceException, ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getManagerIdsAll", new Object[]{});
		} catch (DaoException e) {
			log.error(" count by getManagerIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

	@Override
	public List<Long> getManagerIdsByCondition(Map<String, Object> conditions,
											   Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		String sql = "select id from Manager where ";
		try {
			Set<String> fieldSet = conditions.keySet();
			for (String field : fieldSet) {
				sql += field + "='" + conditions.get(field) + "'";
				sql += " and ";
			}
			sql = sql.substring(0, sql.length() - " and ".length());

			sql += " limit " + start + "," + limit;

			log.info("sql:" + sql);

			Object o = dao.excuteSimpleSql(sql, Manager.class);
			if (o instanceof List) {
				return (List<Long>) o;
			} else {
				List<Long> ids = new ArrayList();
				BigInteger id = (BigInteger) o;
				ids.add(id.longValue());
				return ids;
			}
		} catch (DaoException e) {
			log.error(" count by getManagerIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
	}

}

