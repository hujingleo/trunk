package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Records;
import com.ptteng.carrots.replay.home.service.RecordsService;

import java.util.List;
import java.util.Map;

/**
 * Created by liangxj on 2016/7/2.
 */
public class RecordsSCAClient implements RecordsService {

    private RecordsService recordsService;

    public RecordsService getRecordsService() {
        return recordsService;
    }

    public void setRecordsService(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @Override
    public Long insert(Records records) throws ServiceException, ServiceDaoException {
        return recordsService.insert(records);
    }

    @Override
    public List<Records> insertList(List<Records> recordsList) throws ServiceException, ServiceDaoException {
        return recordsService.insertList(recordsList);
    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        return false;
    }

    @Override
    public boolean update(Records records) throws ServiceException, ServiceDaoException {
        return false;
    }

    @Override
    public boolean updateList(List<Records> recordsList) throws ServiceException, ServiceDaoException {
        return false;
    }

    @Override
    public Records getObjectById(Long id) throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public List<Records> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        return recordsService.getObjectsByIds(ids);
    }

    @Override
    public List<Long> getRecordsIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return recordsService.getRecordsIds(start,limit);
    }

    @Override
    public Integer countRecordsIds() throws ServiceException, ServiceDaoException {
        return recordsService.countRecordsIds();
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1) throws ServiceException, ServiceDaoException {
        return recordsService.getIdsByDynamicCondition(aClass,map,integer,integer1);
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        return recordsService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {

    	 recordsService.deleteList(clz, ids);
    }
//	@Override
//	public Object getObjectByDynamicCondition(Class clz,
//                                              Map<String, Object> conditions, Integer start, Integer limit)
//			throws ServiceException, ServiceDaoException {
//		return this.recordsService.getObjectByDynamicCondition(clz, conditions, start, limit);
//	}

}
