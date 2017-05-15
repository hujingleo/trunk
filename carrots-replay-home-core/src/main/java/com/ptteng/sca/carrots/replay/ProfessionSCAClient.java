package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.ProfessionService;
import java.util.List;
import java.util.Map;

public class ProfessionSCAClient implements ProfessionService {

    private ProfessionService professionService;

	public ProfessionService getProfessionService() {
		return professionService;
	}
	
	
	public void setProfessionService(ProfessionService professionService) {
		this.professionService =professionService;
	}
	
	
			   
		@Override
		public Long insert(Profession profession)throws ServiceException, ServiceDaoException{
		
		return professionService.insert(profession);
		          
		
		}	
		  
    	   
		@Override
		public List<Profession> insertList(List<Profession> professionList)throws ServiceException, ServiceDaoException{
		
		return professionService.insertList(professionList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return professionService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Profession profession)throws ServiceException, ServiceDaoException{
		
		return professionService.update(profession);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Profession> professionList)throws ServiceException, ServiceDaoException{
		
		return professionService.updateList(professionList);
		          
		
		}	
		  
    	   
		@Override
		public Profession getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return professionService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Profession> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return professionService.getObjectsByIds(ids);
		          
		
		}

	@Override
	public Integer countProfessionIdsByCompanyId(Long companyId) throws ServiceException, ServiceDaoException {
		return null;
	}


	@Override
	public List<Long> getProfessionIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionService.getProfessionIds(start, limit);
	}

	@Override
	public Integer countProfessionIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionService.countProfessionIds();
	}

	@Override
	public List<Long> getProfessionIdsByCompanyId(Long companyId, Integer start, Integer limit) throws ServiceException, ServiceDaoException {
		return professionService.getProfessionIdsByCompanyId(companyId,start,limit);
	}


	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   professionService.deleteList(clz, ids);
		
	}
	
/*	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.professionService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}*/


 
}

