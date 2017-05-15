package com.ptteng.carrots.replay.home.controller;
import java.util.ArrayList;
import java.util.Arrays;
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
	@RequestMapping(value = "/a/companyTag/{id}", method = RequestMethod.GET)
	public String getCompanyTagsJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : companyId= " + id);
		if (id == null) {
			log.info("companyTag id is null");
			model.addAttribute("code", -10008);
			return "/common/fail";
		}
		try {

			List<Long> companyTagsIdList = companyTagService.getCompanyTagIdsByCompanyId(id, 0, 10);
			List<CompanyTag> companyTagsList=companyTagService.getObjectsByIds(companyTagsIdList);

			log.info("get companyTagList data id is " + companyTagsIdList);

			model.addAttribute("code", 0);
			model.addAttribute("companyTagList", companyTagsList);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get companyTagList error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-replay-home-service/companyTag/json/companyTagListJson";
	}
}

