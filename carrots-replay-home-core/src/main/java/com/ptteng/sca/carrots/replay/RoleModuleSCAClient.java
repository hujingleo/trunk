/**
 * 
 */
package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.RoleModule;
import com.ptteng.carrots.replay.home.service.RoleModuleService;

import java.util.List;
import java.util.Map;

public class RoleModuleSCAClient implements RoleModuleService {

    private RoleModuleService roleModuleService;

	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}
	
	
	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService =roleModuleService;
	}
	
	
			   
		@Override
		public Long insert(RoleModule roleModule)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.insert(roleModule);
		          
		
		}	
		  
    	   
		@Override
		public List<RoleModule> insertList(List<RoleModule> roleModuleList)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.insertList(roleModuleList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(RoleModule roleModule)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.update(roleModule);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<RoleModule> roleModuleList)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.updateList(roleModuleList);
		          
		
		}	
		  
    	   
		@Override
		public RoleModule getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<RoleModule> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return roleModuleService.getObjectsByIds(ids);
		          
		
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
		
		return roleModuleService.getRoleModuleIdsByRid(rid, start, limit);
	
	
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

		return roleModuleService.getRoleModuleIdsByMid(mid, start, limit);


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
		
		return roleModuleService.countRoleModuleIdsByRid(rid);
	
	
	}


	
		@Override
	public List<Long> getRoleModuleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleModuleService.getRoleModuleIds(start, limit);
	}

	@Override
	public Integer countRoleModuleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleModuleService.countRoleModuleIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleModuleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return roleModuleService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   roleModuleService.deleteList(clz, ids);
		
	}

//	@Override
//	public Object getObjectByDynamicCondition(Class clz,
//											  Map<String, Object> conditions, Integer start, Integer limit)
//			throws ServiceException, ServiceDaoException {
//		return this.roleModuleService.getObjectByDynamicCondition(clz, conditions, start, limit);
//	}
 
}

