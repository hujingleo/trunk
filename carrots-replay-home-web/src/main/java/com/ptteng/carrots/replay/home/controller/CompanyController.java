package com.ptteng.carrots.replay.home.controller;


import com.ptteng.carrots.replay.home.model.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.CompanyService;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import com.ptteng.carrots.replay.home.service.ProfessionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;

import static com.ptteng.carrots.replay.home.Constant.Constant.APPROVED;
import static com.ptteng.carrots.replay.home.Constant.Constant.UN_APPROVED;


@Controller
public class CompanyController {
    private static final Log log = LogFactory.getLog(CompanyController.class);

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyTagService companyTagService;


    /**
     * 动态查询公司列表
     *
     * @param request
     * @param response
     * @param model
     * @param name
     * @param city
     * @param industry
     * @param financing
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/search", method = RequestMethod.GET)
    public String getMulticompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                      String name, String city, String industry, String financing, String approved,Integer page, Integer size) {

        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 12;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
    /* 职位id列表 */
        List<Long> ids = null;
        List<Long> companyIds = null;
        try {
      /* 组装动态sql */
            Map<String, Object> param = DynamicUtil.getCompanyMangerList(name, city, industry,
                    financing,approved );
            log.info("get  param data is " + param);
      /* 通过动态sql查询获得公司ID列表 ,再查询出公司列表*/
            ids = companyService.getIdsByDynamicCondition(Company.class, param, start, size);
            List<Company> companyList = companyService.getObjectsByIds(ids);
            companyIds = companyService.getIdsByDynamicCondition(Company.class, param, 0, Integer.MAX_VALUE);
            log.info("get  company data is " + companyList);
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", companyIds.size());
            model.addAttribute("companyList", companyList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get company error,id is  " + ids, t);
            model.addAttribute("code", -100000);
        }

        return "/carrots-replay-home-service/company/json/companyListJson";
    }


    /**
     * 查询公司详细信息
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/{id}", method = RequestMethod.GET)
    public String getCompany(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, @PathVariable Long id) {
        Company company = null;
        CompanyTag companyTag = null;
        log.info("get data :id" + id);
        //获取公司
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        try {
            company = companyService.getObjectById(id);
            log.info("get company data is" + company);
            model.addAttribute("company", company);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get company error,id is" + id, t);
            model.addAttribute("code", -100000);
        }
        //接下来获取公司标签
        try {
            //根据公司id取公司标签,公司id和标签是一对多关系
            //首先获取标签id
            Map<String, Object> paramTagIds = DynamicUtil.getCompanyTagIdsByCompanyId(id);
            List<Long> companyTagsIdList = companyTagService.getIdsByDynamicCondition( CompanyTag.class, paramTagIds, 0, Integer.MAX_VALUE);
            List<CompanyTag>  companyTagList = companyTagService.getObjectsByIds(companyTagsIdList);
            log.info("get companyTagids is" + companyTagsIdList);

            model.addAttribute("companyTagList", companyTagList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get companyTagids error,id is" + id, t);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/company/json/companyDetailJson";
    }


    /**
     * 获取公司logo列表
     * @param request
     * @param response
     * @param model
     * @param approved
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/logo/list", method = RequestMethod.GET)
    public String getCompanyLogoList(HttpServletRequest request , HttpServletResponse response ,ModelMap model,String approved,Integer page, Integer size) throws Exception {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 8;
        }
        List<Long> companyIds = null;

        String name = null;
        String city = null;
        String industry = null;
        String financing = null;
        List<Long> ids = null;
        //如果请求参数为1则查询普通公司logo
        if (UN_APPROVED.equals(approved)) {
            log.info("get approved data is " + approved);
            try {
                List<Company> companyList = null;
                Map<String, Object> param = DynamicUtil.getGeneralCompanyList(approved);
                log.info("get param is" + param);
                companyIds = companyService.getIdsByDynamicCondition(Company.class, param, page, size);
                companyList = companyService.getObjectsByIds(companyIds);
                model.addAttribute("size",size);
                model.addAttribute("companyList", companyList);
                log.info("get companyList ids is " + companyIds);
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("get companyList error,id is" + companyIds, t);
                model.addAttribute("code", -100000);
            }
            return "/carrots-replay-home-service/company/json/companyLogoListJson";
        }
        //否则查询认证公司logo
        log.info("get approved data is " + approved);
        try {
      /* 组装动态sql */
            Map<String, Object> param = DynamicUtil.getCompanyMangerList(name, city, industry,
                    financing,approved );
            log.info("get  param data is " + param);
      /* 通过动态sql查询获得公司ID列表 */
            List<Company> companyList = null;
            ids = companyService.getIdsByDynamicCondition(Company.class, param, 0, size);
            companyList = companyService.getObjectsByIds(ids);
            companyIds = companyService.getIdsByDynamicCondition(Company.class, param, 0, Integer.MAX_VALUE);
            log.info("get  company data is " + companyList);
            model.addAttribute("code", 0);
            model.addAttribute("size",size);
            model.addAttribute("companyList", companyList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get company error,id is  " + ids, t);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/company/json/companyLogoListJson";
    }



    /**
     * 获取热招公司职位列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/hotCompanyProfession/search", method = RequestMethod.GET)
    public String getMultiProfessionJson(HttpServletRequest request, HttpServletResponse response,
                                         ModelMap model) throws Exception {
//这个接口展示的是轮播图的四个公司热招职位列表,page和size是固定的,所以不需要传参
//先获取最新发布职位的认证公司4个
        String approved = APPROVED;
        List<Company> companyList = null;
        List<Long> companyIdList = null;
        List<Long> professionIdList = null;
        List<Profession> professionList = null;
        Map<String, Object> param = DynamicUtil.getCompanyMangerList(null, null, null, null, approved);
        log.info("get  param data is " + param);
      /* 通过动态sql查询获得公司ID列表,只取前四个 */
        try {
            companyIdList = companyService.getIdsByDynamicCondition(Company.class, param, 0, 3);
            companyList = companyService.getObjectsByIds(companyIdList);
            log.info("get companyids is" +companyIdList);
            model.addAttribute("companyList", companyList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get companyList error,id is  " + companyIdList);
            model.addAttribute("code", -100000);
        }

        List<HashMap<String,Object>> hotCompanyProfessionList = new ArrayList<HashMap<String,Object>>();


        try {
            for (Company company : companyList) {
                Long companyId = company.getId();
                HashMap<String , Object> hotCompanyProfessionMap = new HashMap<String , Object>();
                Map<String, Object> paramProfessionIds = DynamicUtil.getProfessionIdsByCompanyId(companyId);
                professionIdList = professionService.getIdsByDynamicCondition(Profession.class, paramProfessionIds,0, Integer.MAX_VALUE);
                log.info("get professionIds is " + professionIdList);
                professionList = professionService.getObjectsByIds(professionIdList);
                log.info("get professionList is " + professionList);
                String professions = "";
                for ( Profession profession  :professionList){
                    String professionName = profession.getName();
                    professions = professionName+","+professions;
                }
                hotCompanyProfessionMap.put("companyName",company.getName());
                hotCompanyProfessionMap.put("companyLogo",company.getLogo());
                hotCompanyProfessionMap.put("companyIndustry",company.getIndustry());
                hotCompanyProfessionMap.put("companyFinacing",company.getFinacing());
                hotCompanyProfessionMap.put("companyCity",company.getCity());
                hotCompanyProfessionMap.put("professions",professions);
                hotCompanyProfessionList.add(hotCompanyProfessionMap);
            }
            model.addAttribute("code", 0);
            model.addAttribute("hotCompanyProfessionList",hotCompanyProfessionList);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("for companyId error,data  is  " + companyIdList);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/company/json/hotCompanyProfessionListJson";
    }
}



