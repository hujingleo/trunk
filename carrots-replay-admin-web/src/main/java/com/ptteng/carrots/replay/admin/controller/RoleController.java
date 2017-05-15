package com.ptteng.carrots.replay.admin.controller;

import com.ptteng.carrots.replay.home.model.Manager;
import com.ptteng.carrots.replay.home.model.Role;
import com.ptteng.carrots.replay.home.model.RoleModule;
import com.ptteng.carrots.replay.home.service.ManagerService;
import com.ptteng.carrots.replay.home.service.ModuleService;
import com.ptteng.carrots.replay.home.service.RoleModuleService;
import com.ptteng.carrots.replay.home.service.RoleService;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.RoleUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.ptteng.carrots.home.model.Records;

/**
 * Role  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 *
 */
@Controller
public class RoleController {
	private static final Log log = LogFactory.getLog(RoleController.class);

	@Autowired
	private RoleService roleService;
	@Autowired
	private ManagerService managerService;

	@Autowired
	private RoleModuleService roleModuleService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private CookieUtil cookieUtil;

	@RequestMapping(value = "/web/c/role", method = RequestMethod.GET)
	public String getRoleList(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info("/web/role  to /role/view/roleList");
		return "/role/view/roleList";
	}

	/**
	 * 角色列表
	 */
	@RequestMapping(value = "/a/u/role/", method = RequestMethod.GET)
	public String getRoleJsonList(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer page, Integer size) throws Exception {
		if(page == null){
			page=1;
		}
		if(size == null){
			size=10;
		}
		int start = (page - 1) * size;
		if (start < 0) {
			start = 0;
		}

		log.info("pageList : page= " + start + " , size=" + size);

		try {
			Boolean next = false;
			size+=1;

			List<Long> ids = roleService.getRoleIds(start, size);
			List<Long> totalids = roleService.getRoleIds(0, Integer.MAX_VALUE);

			log.info("get role size is " + ids.size());

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
				model.addAttribute("total",0);

			}

			log.info("next is " + next);
			model.addAttribute("code", 0);
			model.addAttribute("size", size-1);
			model.addAttribute("next", next);
			model.addAttribute("page", page);
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get role list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/admin/role/json/roleListJson";
	}

	@RequestMapping(value = "/web/c/role/{id}", method = RequestMethod.GET)
	public String getRole(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
		log.info("/web/role/" + id + "  to /role/view/roleDeail");
		if (null != id) {
			model.addAttribute("id", id);
		} else {
			model.addAttribute("id", 0);
		}
		return "/role/view/roleDetail";
	}

	

	/**
	 * 修改角色
	 */
	@RequestMapping(value = "/a/u/role/{rid}", method = RequestMethod.PUT)
	public String updateRoleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody Role role) throws Exception {
		log.info("update role : role= " + role);

		try {

			if(role == null){
				log.info("role  is  null ");
				model.addAttribute("code",-1004);
				return  "/data/json";
			}
		
			
			if(StringUtils.isBlank(role.getName())){
				log.info("role name  is  null ");
				model.addAttribute("code",-1004);
				return  "/data/json";
			}
			if (roleService.getObjectById(role.getId()) == null) {
				model.addAttribute("code", -7001);
				return "/data/json";
			}
			
		
			Role r = roleService.getObjectById(role.getId());			
			String userId = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
			r.setName(role.getName());
			role= RoleUtil.convertPermission2String(role);
		
			r.setPermissions(role.getPermissions());
			r.setPermissionsSet(role.getPermissionsSet());
			
			r.setUpdateBy(Long.valueOf(userId));
			
			
			
			roleService.update(r);
			List<Long> roleModuleIds = roleModuleService.getRoleModuleIdsByRid(r.getId(), 0, Integer.MAX_VALUE);
			roleModuleService.deleteList(RoleModule.class, roleModuleIds);
		
			List<RoleModule> roleModules = new ArrayList<RoleModule>();
			log.info("get permission is "+r.getPermissionsSet());
			for(Long moduleId : r.getPermissionsSet().keySet()){
				if(moduleId != null && !"".equals(moduleId)) {
					RoleModule roleModule = new RoleModule();
					roleModule.setCreateBy(Long.valueOf(userId));
					roleModule.setUpdateBy(Long.valueOf(userId));
					roleModule.setRid(role.getId());
					roleModule.setMid(moduleId);
					roleModules.add(roleModule);
				}
			}
			roleModuleService.insertList(roleModules);
			model.addAttribute("code", 0);
			
			} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update role error,id is  " + role.getId());
			model.addAttribute("code", -100000);
		}
		return "/admin/role/json/roleDetailJson";
	}

	/**
	 * 获取单个角色
	 * @param request
	 * @param response
	 * @param model
	 * @param rid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/role/{rid}", method = RequestMethod.GET)
	public String getRoleJson(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model, @PathVariable Long rid)
			throws Exception {

		log.info("get  role : role id = " + rid);

		try {
		//	List<Long>  moduleIds = 	moduleService.getModuleIds(0, Integer.MAX_VALUE);
			List<Long> mids = new ArrayList<Long>();

				model.addAttribute("rid",rid);
				Role role = roleService.getObjectById(rid);
				if (role == null) {
					model.addAttribute("code", -7001);
					return  "/data/json";
				} else {
					
				
					role=RoleUtil.convertString2permission(role);

					
					//model.addAttribute("roleMids", roleModuleIds);
					model.addAttribute("role", role);

			}
			model.addAttribute("code", 0);
		

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("update role error,id is  " +rid);
			model.addAttribute("code", -100000);

		}

		return "/admin/role/json/roleDetailJson";
	}


	@RequestMapping(value = "/a/u/role/stop/{id}", method = RequestMethod.PUT)
	public String stopRole(HttpServletRequest request,
						   HttpServletResponse response, ModelMap model, Role role)
			throws Exception {

		log.info("update role : role= " + role);

		try {
			List<Long> managerIds = managerService.getManagerIdsByRoleIDAndStatus(
					role.getId(), Manager.STATUS_USING, null, null);
			if (managerIds.size() > 0) {
				log.info("manager with status using has this role");
				model.addAttribute("code", -7005);
			} else {
				String userId = cookieUtil.getKeyIdentity(request,
						CookieUtil.USER_ID);
				role.setUpdateBy(Long.valueOf(userId));

				roleService.update(role);

				model.addAttribute("code", 0);

				model.addAttribute("role", role);
			}

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("update role error,id is  " + role.getId());
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}

	/**
	 * 增加角色
	 * @param request
	 * @param response
	 * @param model
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/role", method = RequestMethod.POST)
	public String addRoleJson(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model, @RequestBody Role role)
			throws Exception {

		log.info("add role : name= " + role.getName()+" role modules "+role.getPermissionsSet());

		try {
			if(role == null){
				log.info("role  is  null ");
				model.addAttribute("code",-1004);
				return  "/data/json";
			}
			role=RoleUtil.convertPermission2String(role);
			

		

			//	Role role = new Role();
			//	role.setName(name);
				Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
						CookieUtil.USER_ID));
				role.setCreateBy(uid);
				role.setId(null);
				role.setStatus(Role.STATUS_USING);
				Long roleId = roleService.insert(role);
				List<RoleModule> roleModules = new ArrayList<RoleModule>();

				for (Long moduleId : role.getPermissionsSet().keySet()) {

					if (null != moduleId && !"".equals(moduleId)) {
						RoleModule roleModule = new RoleModule();
						roleModule.setCreateBy(uid);
						roleModule.setUpdateBy(uid);
						roleModule.setRid(roleId);
						roleModule.setMid(Long.valueOf(moduleId));
						roleModules.add(roleModule);
					}

				}
				roleModuleService.insertList(roleModules);

				//model.addAttribute(new Records(roleId,role.getName()));
				model.addAttribute("code", 0);
			
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add role error ");
			model.addAttribute("code", -100000);
		}


		return "/data/json";
	}

	@RequestMapping(value = "/a/u/role/{rid}", method = RequestMethod.DELETE)
	public String deleteRoleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable Long rid) throws Exception {
		log.info("delete role : id= " + rid);
		try {
			if(rid == null ){
				model.addAttribute("code",-1004);
				return "/data/json";
			}
			List<Long> managerIds = managerService.getManagerIdsByRoleID(rid, null, null);
			if (managerIds.size() > 0) {
				log.info("manager has this role");
				model.addAttribute("code", -7004);
			} else {
				if(roleService.getObjectById(rid)==null){
					model.addAttribute("code",-7001);
				}else {
					List<Long> roleModuleIds = roleModuleService.getRoleModuleIdsByRid(rid,0, Integer.MAX_VALUE);
					log.info(" roleMudleids  is  "+roleModuleIds);
					if(roleModuleIds != null && roleModuleIds.size()>0){
						for(Long roleModuleId : roleModuleIds){
							roleModuleService.delete(roleModuleId);
						}
					}
					roleService.delete(rid);
					log.info("delete role success");
					model.addAttribute("code", 0);
				}
			}

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("delete role error,id is  " + rid);
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}


	/**
	 * 批量获取角色详细信息
	 */
	@RequestMapping(value = "/a/u/multi/role", method = RequestMethod.GET)
	public String getMultiRoleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, Long[] ids) throws Exception {
		log.info("get role rid " + ids);
		List<Long> idList = new ArrayList();
		if (ids == null|| ids.length<=0) {
			model.addAttribute("code", 0);
			model.addAttribute("size", 10);
			model.addAttribute("total", 0);
		} else {
			idList = Arrays.asList(ids);
		}
		try {
             if(idList == null || idList.size()<=0){
				 model.addAttribute("code", 0);
				 model.addAttribute("size", 10);
				 model.addAttribute("total", 0);
			 }else {
				 List<Role> roleList = roleService.getObjectsByIds(idList);
				 log.info("get roleList data is " + roleList);
				 log.info("get roleList size is " + roleList.size());

				 if (roleList != null && roleList.size() > 0) {
					 model.addAttribute("code", 0);
					 model.addAttribute("size", 10);
					 model.addAttribute("total", roleList.size());
					 model.addAttribute("roleList", roleList);

				 } else {
					 for(Role r:roleList){
							r=RoleUtil.convertString2permission(r);
					 }
					 
					 model.addAttribute("code", 0);
					 model.addAttribute("size", 10);
					 model.addAttribute("total", 0);
					 model.addAttribute("roleList", roleList);
				 }
			 }
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get role error,id is  " + Arrays.toString(ids));
			model.addAttribute("code", -100000);
		}

		return "/admin/role/json/roleMultiJson";
	}

}

