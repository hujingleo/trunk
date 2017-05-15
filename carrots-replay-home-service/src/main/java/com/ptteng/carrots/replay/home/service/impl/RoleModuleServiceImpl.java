package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.replay.home.model.RoleModule;
import com.ptteng.carrots.replay.home.service.RoleModuleService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class RoleModuleServiceImpl extends BaseDaoServiceImpl implements RoleModuleService {

 

	private static final Log log = LogFactory.getLog(RoleModuleServiceImpl.class);



		   
		@Override
		public Long insert(RoleModule roleModule)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + roleModule);

		if (roleModule == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		roleModule.setCreateAt(currentTimeMillis);
		roleModule.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(roleModule);
		} catch (DaoException e) {
			log.error(" insert wrong : " + roleModule);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<RoleModule> insertList(List<RoleModule> roleModuleList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (roleModuleList == null ? "null" : roleModuleList.size()));
      
		List<RoleModule> resultList = null;

		if (CollectionUtils.isEmpty(roleModuleList)) {
			return new ArrayList<RoleModule>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RoleModule roleModule : roleModuleList) {
			roleModule.setCreateAt(currentTimeMillis);
			roleModule.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<RoleModule>) dao.batchSave(roleModuleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + roleModuleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(RoleModule.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(RoleModule roleModule)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (roleModule == null ? "null" : roleModule.getId()));

		boolean result = false;

		if (roleModule == null) {
			return true;
		}

		roleModule.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(roleModule);
		} catch (DaoException e) {
			log.error(" update wrong : " + roleModule);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + roleModule);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<RoleModule> roleModuleList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (roleModuleList == null ? "null" : roleModuleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(roleModuleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RoleModule roleModule : roleModuleList) {
			roleModule.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(roleModuleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + roleModuleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + roleModuleList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public RoleModule getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		RoleModule roleModule = null;

		if (id == null) {
			return roleModule;
		}

		try {
			roleModule = (RoleModule) dao.get(RoleModule.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return roleModule;		
		}	
		  
    	   
		@Override
		public List<RoleModule> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<RoleModule> roleModule = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<RoleModule>();
		}

		try {
			roleModule = (List<RoleModule>) dao.getList(RoleModule.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (roleModule == null ? "null" : roleModule.size()));
    
		return roleModule;	
		}







		/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long> getRoleModuleIdsByRid(Long rid, Integer start, Integer limit)throws ServiceException, ServiceDaoException{

		       if(log.isInfoEnabled()){
      log.info(" get ids by rid,start,limit  : " + rid+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getRoleModuleIdsByRid", new Object[] { rid},start,limit, false);


   } catch (DaoException e) {
			log.error(" get ids  wrong by rid,start,limit)  : " + rid+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
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
	public List<Long> getRoleModuleIdsByMid(Long mid, Integer start, Integer limit)throws ServiceException, ServiceDaoException{

		if(log.isInfoEnabled()){
			log.info(" get ids by mid,start,limit  : " + mid+" , "+start+" , "+limit );
		}
		log.info(" mid iii");
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getRoleModuleIdsByMid", new Object[] { mid},start,limit, false);


		} catch (DaoException e) {
			log.error(" get ids  wrong by rid,start,limit)  : " + mid+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if(log.isInfoEnabled()){
			log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
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
	public Integer countRoleModuleIdsByRid(Long rid)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by rid  : " + rid );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getRoleModuleIdsByRid", new Object[] { rid});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by rid)  : " + rid );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
		
	
	
	
		
	@Override
	public List<Long> getRoleModuleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getRoleModuleIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countRoleModuleIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRoleModuleIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRoleModuleIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

