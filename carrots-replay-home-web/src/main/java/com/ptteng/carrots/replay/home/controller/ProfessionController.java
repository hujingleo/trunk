package com.ptteng.carrots.replay.home.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.CompanyService;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import com.ptteng.carrots.replay.home.service.ProfessionService;
import com.ptteng.carrots.replay.home.vo.ProfessionInfo;
import javassist.bytecode.stackmap.BasicBlock;
import javassist.expr.NewArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;


@Controller
public class ProfessionController {
    private static final Log log = LogFactory.getLog(ProfessionController.class);

    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private CompanyService companyService;


    /**
     * 职位信息列表
     *
     * @param request
     * @param response
     * @param model
     * @param companyName
     * @param name
     * @param experience
     * @param compensation
     * @param status
     * @param releaseAt
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Test
    @RequestMapping(value = "/a/professionInfo/search", method = RequestMethod.GET)
    public String getMultiProfessionInfoJson(HttpServletRequest request, HttpServletResponse response,
                                             ModelMap model, String companyName, String name, String province, String city,
                                             String county, String recommend, String industry, String experience, String compensation, String status, Long releaseAt, Integer page, Integer size) throws Exception {
        /*page默认1，size默认10*/
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 8;
        }
    /*查询从start开始*/
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }

		/*职位id列表*/
        List<Long> professionIdList = null;
        List<Long> count = null;
        try {
            /*组装动态sql*/
            Map<String, Object> param = DynamicUtil.getProfessionList(companyName, name, province, city
                    , county, recommend, industry, experience, compensation, status, releaseAt);
            log.info("get  param data is " + param);
            /*通过动态sql查询获得职位id列表*/
            professionIdList = professionService.getIdsByDynamicCondition(Profession.class,
                    param, start, size);

            count = professionService.getIdsByDynamicCondition(
                    Profession.class, param, 0, Integer.MAX_VALUE);
//如果查出0条数据,则直接返回页面
            if(count.size()==0){
                model.addAttribute("code", 0);
                model.addAttribute("page", page);
                model.addAttribute("size", size);
                model.addAttribute("total", count.size());
                return "/carrots-replay-home-service/profession/json/professionListJson";
            }

            List<Profession> professionList = professionService
                    .getObjectsByIds(professionIdList);
            log.info("get professionList ids is" + professionIdList);

            List<HashMap<String,Object>> professionDataList = new ArrayList<HashMap<String,Object>>();
            //遍历职位列表,将每个职位的职位信息和公司信息以及公司标签都添加到map里面去
            for (Profession profession : professionList) {
                HashMap<String , Object> professionDataMap = new HashMap<String , Object>();
                String companyTags = null;
                Long companyId = profession.getCompanyId();
               Company company =companyService.getObjectById(companyId);
                log.info("get company id is"+companyId);
                Map<String, Object> paramTagIds = DynamicUtil.getCompanyTagIdsByCompanyId(companyId);
                List<Long> companyTagsIdList = companyTagService.getIdsByDynamicCondition( CompanyTag.class, paramTagIds, 0, Integer.MAX_VALUE);
                List<CompanyTag>  companyTagsList = companyTagService.getObjectsByIds(companyTagsIdList);

                for ( CompanyTag companyTag :companyTagsList){
                    String tag = companyTag.getTag();
                    companyTags = tag+","+companyTags;
                }
                log.info("get companyTagIds is "+companyTagsIdList);
                professionDataMap.put("professionId",profession.getId());
                professionDataMap.put("professionName",profession.getName());
                professionDataMap.put("professionEducation",profession.getEducation());
                professionDataMap.put("professionExperience",profession.getExperience());
                professionDataMap.put("professionCompensation",profession.getCompensation());
                professionDataMap.put("professionResponsibility",profession.getResponsibility());
                professionDataMap.put("professionRequisite",profession.getRequisite());
                professionDataMap.put("professionReleaseAt",profession.getReleaseAt());
                professionDataMap.put("companyId",company.getId());
                professionDataMap.put("companyIndustry",company.getIndustry());
                professionDataMap.put("companyName",company.getName());
                professionDataMap.put("companyLogo", company.getLogo());
                professionDataMap.put("companyTags",companyTags);
                professionDataList.add(professionDataMap);
            }
            log.info("get professionDataList data is " + professionDataList);
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("professionDataList", professionDataList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get professionDataList error,id is  " + professionIdList);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/profession/json/professionDataListJson";
    }

    /**
     * 获取职位列表
     * @param request
     * @param response
     * @param model
     * @param companyName
     * @param name
     * @param province
     * @param city
     * @param county
     * @param recommend
     * @param industry
     * @param experience
     * @param compensation
     * @param status
     * @param releaseAt
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/profession/search", method = RequestMethod.GET)
    public String getMultiProfessionJson(HttpServletRequest request, HttpServletResponse response,
                                         ModelMap model, String companyName, String name, String province, String city,
                                         String county, String recommend, String industry, String experience, String compensation, String status, Long releaseAt, Integer page, Integer size) throws Exception {
        /*page默认1，size默认10*/
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 8;
        }
    /*查询从start开始*/
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }

		/*职位id列表*/
        List<Long> professionIds = null;
        List<Long> count = null;
        try {
            /*组装动态sql*/
            Map<String, Object> param = DynamicUtil.getProfessionList(companyName, name, province, city
                    , county, recommend, industry, experience, compensation, status, releaseAt);
            log.info("get  param data is " + param);
            /*通过动态sql查询获得职位id列表*/
            professionIds = professionService.getIdsByDynamicCondition(Profession.class,
                    param, start, size);

            count = professionService.getIdsByDynamicCondition(
                    Profession.class, param, 0, Integer.MAX_VALUE);
            if(count.size()==0){
                model.addAttribute("code", 0);
                model.addAttribute("page", page);
                model.addAttribute("size", size);
                model.addAttribute("total", count.size());
                return "/carrots-replay-home-service/profession/json/professionListJson";
            }


            List<Profession> professionList = professionService
                    .getObjectsByIds(professionIds);
            log.info("get professionList ids is" + professionIds);
            log.info("get  profession data is " + professionList);
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("professionList", professionList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get profession error,id is  " + professionIds);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/profession/json/professionListJson";
    }

    /**
     * 获取职位明细信息
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/profession/{id}", method = RequestMethod.GET)
    public String getProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        if (id == null) {
            log.info("profession id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Profession profession = null;
        CompanyTag companyTag = null;
        Long companyId = null;
        try {
            //根据id获取职业对象
            profession = professionService.getObjectById(id);
            model.addAttribute("code", 0);
            model.addAttribute("profession", profession);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get profession error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        try {
            //获取职位标签,职位标签只能通过职位表的公司标签id来获取
            //首先将String类型的公司标签id封装进数组
            String[] tagsId = profession.getTagId().split(",");
            //再将数组转成集合list,因为接下来要要用到的getObjectsByIds()方法只接收list类型id
            List list = Arrays.asList(tagsId);
            //调用getObjectsByIds()方法,这个方法能够接收多个id,返回包含多个标签的list
            List<CompanyTag> professionTagList = companyTagService.getObjectsByIds(list);
            model.addAttribute("professionTagList", professionTagList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get companyTagList error,professionId is  " + id);
            model.addAttribute("code", -100000);
        }
        try {
             companyId = profession.getCompanyId();
            Company company = companyService.getObjectById(companyId);
            model.addAttribute("company",company);
        }catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get company error,id is  " + companyId);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/profession/json/professionDetailJson";
    }
}
