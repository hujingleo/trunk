package com.ptteng.carrots.replay.admin.controller;

import com.ptteng.carrots.replay.home.model.Module;

import com.ptteng.carrots.replay.home.model.Records;
import com.ptteng.carrots.replay.home.service.ModuleService;
import com.ptteng.carrots.replay.home.service.RoleModuleService;
import com.ptteng.carrots.replay.home.service.RoleService;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.CookieConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Module  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 *
 */
@Controller
public class ModuleController {
	private static final Log log = LogFactory.getLog(ModuleController.class);

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private CookieUtil cookieUtil;

	@Autowired
	private RoleService roleService;

	@Autowired
    private RoleModuleService roleModuleService;



	@RequestMapping(value = "/web/c/module", method = RequestMethod.GET)
	public String getModuleIdsByTypeList(HttpServletRequest request, HttpServletResponse response, ModelMap model, String type) throws Exception {
		log.info("/web/module  to /module/view/moduleList");
		return "/module/view/moduleList";
	}


	/**
	 * 返回id
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/id/{id}", method = RequestMethod.GET)
	public String getModule(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {
		log.info("/web/module/" + id + "  to /module/view/moduleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		model.addAttribute("code", 0);
		return "/module/view/moduleDetail";
	}

	/**
	 * 查询模块列表
	 */

	@RequestMapping(value = "/a/u/module/", method = RequestMethod.GET)
	public String getModuleIdsByTypeJsonList(HttpServletRequest request,
											 HttpServletResponse response, ModelMap model, Integer page,
											 Integer size, String type) throws Exception {
		if (page==null) {
			page = 1;
		}
		if (size==null) {
			size = 10;
		}

		int start = (page - 1) * size;
		if (start < 0) {
			start = 0;
		}

		log.info("pageList : page= " + start + " , size=" + size);

		try {

			List<Long> ids=null;
			List<Long> totalids = new ArrayList<Long>();
			Boolean next = false;
			size+=1;

			if ((type!=null)&&(!"".equals(type))) {
				ids= moduleService.getModuleIdsByType(type, start,size);
				totalids= moduleService.getModuleIdsByType(type, 0, Integer.MAX_VALUE);
			}else {
				ids=moduleService.getModuleIds(start,size);
				totalids=moduleService.getModuleIds(0, Integer.MAX_VALUE);

			}


			log.info("get countModuleIdsByType size is " + ids.size());

			if(ids!=null && ids.size()>0){

				if (size.equals(ids.size())) {
					next = true;
					log.info("ss  "+ids.subList(0,size-1));
					model.addAttribute("ids", ids.subList(0,size-1));
				}else{
					log.info("ss  "+ids.subList(0,ids.size()));
					model.addAttribute("ids", ids.subList(0, ids.size()));
				}
				int totalCnt = totalids.size();

				//model.addAttribute("page",page);
				model.addAttribute("total",totalCnt);
			}else{
				model.addAttribute("ids", ids);
			}

			model.addAttribute("code", 0);
			model.addAttribute("size", size-1);

			model.addAttribute("page",page);

			model.addAttribute("next", next);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get module list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/admin/module/json/moduleListJson";
	}


	/**
	 * 批量获取模块详细信息
	 * @param request
	 * @param response
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/multi/module", method = RequestMethod.GET)
	public String getMultiModuleJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
		log.info("get module mid " + ids);
		List<Long> idList = new ArrayList();
		if (ids == null|| ids.length<=0) {
			model.addAttribute("code", 0);
			model.addAttribute("total", 0);
			model.addAttribute("size", 10);

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			if(idList==null ||  idList.size()<=0){
				model.addAttribute("code", 0);
				model.addAttribute("total", 0);
				model.addAttribute("size", 10);
			}else {
				List<Module> moduleList = moduleService.getObjectsByIds(idList);
				log.info("get moduleList data is " + moduleList.size());

				if (moduleList != null && moduleList.size() > 0) {
					int totalPage = 0;
					int totalCnt = moduleList.size();
					if (totalCnt > 0) {
						totalPage = totalCnt / 10 + 1;
					}

					model.addAttribute("code", 0);

//					model.addAttribute("size", 10);
					model.addAttribute("total", moduleList.size());
					model.addAttribute("moduleList", moduleList);

				} else {
					model.addAttribute("code", 0);
					model.addAttribute("total", 0);
					model.addAttribute("moduleList", moduleList);
				}
			}
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get module error,id is  " + Arrays.toString(ids));
			model.addAttribute("code", -100000);
		}

		return "/admin/module/json/moduleMultiJson";
	}

	/**
	 * 根据ID查找模块
	 * @param request
	 * @param response
	 * @param model
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{mid}", method = RequestMethod.GET)
	public String getModuleJson(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, @PathVariable Long mid)
			throws Exception {

		log.info("get data : id= " + mid);
		try {
			    List<Long> rmids =  roleModuleService.getRoleModuleIdsByMid(mid, 0, Integer.MAX_VALUE);
			    log.info(" rmids is  "+rmids);
				Module module = moduleService.getObjectById(mid);

				if(module == null ){
					model.addAttribute("code", -8002);
					log.info("get data : id is  null");
					return  "/data/json";
				}else {
					log.info("get module data is " + module);
					model.addAttribute("module", module);
				}

			model.addAttribute("mid", mid);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get module error,id is  " + mid);
			model.addAttribute("code", -100000);
		}

		return "/admin/module/json/moduleDetailJson";
	}

	/**
	 * 修改模块
	 * @param request
	 * @param response
	 * @param model
	 * @param module
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{mid}", method = RequestMethod.PUT)
	public String updateModuleJson(HttpServletRequest request,
								   HttpServletResponse response, ModelMap model, Module module) throws Exception {

		log.info("update module : module= " + module);

		try {
			String userId = cookieUtil.getKeyIdentity(request,
					CookieUtil.USER_ID);
           Module m = moduleService.getObjectById(module.getId());
			if(m==null){
				log.info("module is null ");
				model.addAttribute("code", -8002);
				return "/data/json";
			}else {
				if (module == null) {
					log.info("module is null ");
					model.addAttribute("code", -1004);
					return "/data/json";
				}

				if (module.getName() == null || module.getName().trim().equals("")) {
					log.info("name is null ");
					model.addAttribute("code", -8000);
					return "/data/json";
				}
				if (module.getName().length() > 30 || module.getName().length() < 0) {
					log.info("name is null ");
					model.addAttribute("code", -8001);
					return "/data/json";
				}


				module.setCreateBy(m.getCreateBy());
				module.setCreateAt(m.getCreateAt());
				module.setUpdateBy(Long.parseLong(userId));
				moduleService.update(module);

				model.addAttribute("code", 0);

				model.addAttribute("module", module);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update module error,id is  " + module.getId());
			model.addAttribute("code", -100000);

		}

		return "/admin/module/json/moduleDetailJson";
	}

	@RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
	public String addModuleJson(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, Module module) throws Exception {

		log.info("update module : module= " + module);

		try {
			if(module.getName() == null || module.getName().trim().equals("")){
             log.info("name is null ");
				model.addAttribute("code",-8000);
				return "/data/json";
			}
           if(module.getName().length()> 30 || module.getName().length()<0){
			   log.info("name is null ");
			   model.addAttribute("code",-8001);
			   return "/data/json";
		   }

			module.setId(null);

			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
					CookieUtil.USER_ID));

			log.info("curr login user id " + uid);

			module.setUpdateBy(uid);
			module.setCreateBy(uid);

			Long id = moduleService.insert(module);
			
			

			log.info("insert success id " + id);

			request.setAttribute(CookieConstant.Rsponse_Model_Records, new Records(id,module.getName()));
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add module error ");
			model.addAttribute("code", -100000);
		}

		return "/data/json";
	}


	@RequestMapping(value = "/a/u/module/{mid}", method = RequestMethod.DELETE)
	public String deleteModuleJson(HttpServletRequest request,
								   HttpServletResponse response, ModelMap model, @PathVariable Long mid)
			throws Exception {

		log.info("delete module : id= " + mid);
		try {
			if(mid == null) {
				model.addAttribute("code", -1004);
			}else {
				Module module = moduleService.getObjectById(mid);

				if(module == null ){
					model.addAttribute("code", -8002);
					log.info("get data : id is  null");
				}else {
                    List<Long> roleModulesIds =  roleModuleService.getRoleModuleIdsByMid(mid, 0, Integer.MAX_VALUE);
					log.info("rolemodulesIds   " + roleModulesIds + "size   " + roleModulesIds.size());
					if(roleModulesIds != null && roleModulesIds.size()> 0){

                     model.addAttribute("code",-8003);
					}else {
						moduleService.delete(mid);
						log.info("add module success");
						model.addAttribute("code", 0);
					}

				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete module error,id is  " + mid);
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}


}

