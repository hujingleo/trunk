package com.ptteng.carrots.replay.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CompanyTagController {
	private static final Log log = LogFactory.getLog(CompanyTagController.class);

	@Autowired
	private CompanyTagService companyTagService;


	/**
	 *获取公司标签列表
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/companyTag/list/{id}", method = RequestMethod.GET)
	public String getCompanyTagsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id,Integer page,Integer size)
			throws Exception {

		if (page == null) {
			page = 1;
		}
		if (size == null) {
			size = 10;
		}
		int start = (page - 1) * size;
		if (start < 0) {
			start = 0;
		}

		log.info("get data : companyId= " + id);
		try {

			List<Long> companyTagsIdList = companyTagService.getCompanyTagIdsByCompanyId(id, 0, Integer.MAX_VALUE);
			List<CompanyTag> companyTagsList=companyTagService.getObjectsByIds(companyTagsIdList);

			log.info("get companyTagsList data is " + companyTagsList);

			model.addAttribute("code", 0);
			model.addAttribute("page", 1);
			model.addAttribute("size", companyTagsList.size());
			model.addAttribute("total", companyTagsList.size());
			model.addAttribute("companyTagList", companyTagsList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get companyTagList error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-replay-admin-service/companyTag/json/companyTagListJson";
	}
}

