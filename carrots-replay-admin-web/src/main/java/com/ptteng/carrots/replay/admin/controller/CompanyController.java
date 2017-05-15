package com.ptteng.carrots.replay.admin.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestBody;
import util.DynamicUtil;
import com.ptteng.carrots.replay.home.model.Company;

import java.util.Arrays;
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

import static com.ptteng.carrots.replay.home.Constant.Constant.*;


@Controller
public class CompanyController {
    private static final Log log = LogFactory.getLog(CompanyController.class);

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;


    /**
     * 动态查询公司列表
     *
     * @param request
     * @param response
     * @param model
     * @param name
     * @param productName
     * @param county
     * @param industry
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/search", method = RequestMethod.GET)
    public String getMulticompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                      String name, String industry, String city, String province,
                                      String county, String productName, String financing, String approved, String freezed, Integer page, Integer size) {

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

    /* 职位id列表 */
        List<Long> companyIdsList = null;
        List<Company> companyList = null;
        List<Long> count = null;
        try {
      /* 组装动态sql */
            Map<String, Object> param = DynamicUtil.getCompanyMangerList(name, industry, province, city,
                    county, productName, financing, approved, freezed);
            log.info("get  param data is " + param);
      /* 通过动态sql查询获得公司ID列表 */
            companyIdsList = companyService.getIdsByDynamicCondition(Company.class, param, start, size);
            count =companyService.getIdsByDynamicCondition(Company.class, param, start, Integer.MAX_VALUE);
            companyList = companyService.getObjectsByIds(companyIdsList);
            log.info("get  company data is " + companyList);
            model.addAttribute("code", 0);
//            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("companyList", companyList);
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get company error,id is  " + companyIdsList, t);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-admin-service/company/json/companyListJson";
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
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.GET)
    public String getCompany(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, @PathVariable Long id) {


        log.info("get company id is "+ id);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Company company = null;
        List<Long> companyTagidsList = null;
        List<CompanyTag> companyTagList = null;
        log.info("get data :id" + id);
        //获取公司
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
            companyTagidsList = companyTagService.getCompanyTagIdsByCompanyId(id, 0, Integer.MAX_VALUE);
            log.info("get companyTagids is" + companyTagidsList);
            //根据标签id获取标签
            companyTagList = companyTagService.getObjectsByIds(companyTagidsList);
            model.addAttribute("companyTagList", companyTagList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get companyTagids error,id is" + id, t);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-admin-service/company/json/companyDetailJson";
    }


    /**
     * 删除公司
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.DELETE)
    public String deleteCompanyJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {


        log.info("get company id is " + id);
        if (id == null) {
            log.info("candidate id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        List<Long> professionIdsList = null;
        List<Long> companyTagIdsList = null;
        log.info("delete company : id= " + id);
        try {
            companyService.delete(id);
            log.info("delete company success");
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete company error,id is  " + id);
            model.addAttribute("code", -6004);

        }
         /* 删除职位信息 */
        Map<String, Object> param = DynamicUtil.getProfessionList(id, null, null, null,
                null, null, null, null, null, null);
        professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, param, 0, Integer.MAX_VALUE);
        try {
            professionService.deleteList(Profession.class, professionIdsList);
            log.info("delete professionList success");
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete professionList error,professionIds is  " + professionIdsList, t);
            model.addAttribute("code", -6004);
            return "/common/fail";
        }
         /* 删除公司标签 */
        companyTagIdsList = companyTagService.getCompanyTagIdsByCompanyId(id, 0, Integer.MAX_VALUE);
        try {
            companyTagService.deleteList(CompanyTag.class, companyTagIdsList);
            log.info("delete companyTagsList success");
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete t companyTagsList error,companyTagIds is  " + companyTagIdsList, t);
            model.addAttribute("code", -6004);
            return "/common/fail";
        }
        return "/common/success";
    }


    /**
     * 修改公司状态
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param type
     * @param status
     * @return
     */
    @RequestMapping(value = "/a/u/company/status/{id}", method = RequestMethod.PUT)
    public String updateCompanyStatus(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable Long id,
                                      String type, String status) {


        log.info("get company id is " + id);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        //入参校验
        if (!FROZEN_STATUS.equals(type) && !APPROVED_STATUS.equals(type)) {
            model.addAttribute("code", -9013);
            log.info("get status error is" + type);
            return "/data/json";
        }
        if (!FROZEN_STATUS.equals(status) && !APPROVED_STATUS.equals(status)) {
            model.addAttribute("code", -9013);
            log.info("get status error is" + status);
            return "/data/json";
        }
        Company companySource = null;
        Company company = null;
        String approvedSource = null;
        List<Long> professionIdsList = null;
        List<Profession> professionList = null;
        log.info("update companyID : " + id);
        log.info("update statusType : " + type);
        log.info("update status : " + status);
        try {
      /* 获取原有公司相关信息 */
            companySource = companyService.getObjectById(id);
            company = companyService.getObjectById(id);
            approvedSource = companySource.getApproved();
            log.info("get companySource is" + companySource);
            log.info("get approvedSource is" + approvedSource);
            //type为0则修改冻结/解冻状态 status 0-解冻 1-冻结 type为1则修改认证/取消状态 status 0-认证 1-解除认证
            if (FROZEN_STATUS.equals(type)) {
                company.setFreezed(status);

            } else if (APPROVED_STATUS.equals(type)) {
                company.setApproved(status);
            }
      /* 当公司状态修改为冻结时,将公司对应在招职位数改为0 */
            if (UN_FREEZE.equals(companySource.getFreezed()) && FROZEN.equals(company.getFreezed())) {
                company.setProfessionCount(0l);
     /* 当公司状态修改为冻结时，修改该公司下所有职位状态为下架 ,上架时间为null*/
                Map<String, Object> param = DynamicUtil.getProfessionList(id, null, null, null,
                        null, null, null, null, null, null);
                professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, param, 0, Integer.MAX_VALUE);
                professionList = professionService.getObjectsByIds(professionIdsList);
                for (Profession profession : professionList) {
          /* 给职位状态赋值为0-下架 */
                    profession.setStatus(SHELEVE_DOWN);
                    profession.setReleaseAt(null);
                }
                //使用updateList方法一次性更新所有职位
                professionService.updateList(professionList);
            }
            //当公司认证状态由未认证修改为认证状态时,更新认证时间
            if (UN_APPROVED.equals(companySource.getApproved()) && APPROVED.equals(company.getApproved())) {
                company.setApprovedAt(System.currentTimeMillis());
            }
            //当公司认证状态由认证修改为未认证状态时,更新认证时间为null
            if (APPROVED.equals(companySource.getApproved()) && UN_APPROVED.equals(company.getApproved())) {
                company.setApprovedAt(null);
            }
            log.info("get companystatus is " + company.getFreezed() + company.getApproved());

            companyService.update(company);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update company status error!!");
            log.error("update company id is  " + id);
            log.error("update status type is  " + type);
            log.error("update status is  " + status);
            model.addAttribute("code", -6003);
            return "/common/fail";
        }
        return "/common/success";
    }


    /**
     * 新增公司(包含新增公司标签)
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company", method = RequestMethod.POST)
    public String addCompanyInfoJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                     @RequestBody Company company, String tag) {

        Long uid = null;
        Long companyId = null;
        CompanyTag companyTag = null;
        log.info("update company : company= " + company);
        log.info("update companyTag:companyTag=" + tag);
        //入参校验
    /* 检查公司名称是否为空 */
        if (company.getName() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
    /* 检查公司标语是否为空 */
        if (company.getSlogan() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
    /* 检查公司人数 */
        if (company.getTotalNum() == null) {
            model.addAttribute("code", -6502);
            return "/common/fail";
        }
    /* 检查公司LOGO */
        if (company.getLogo() == null) {
            model.addAttribute("code", -6509);
            return "/common/fail";
        }
    /* 检查公司介绍 */
        if (company.getSummary() == null) {
            model.addAttribute("code", -6510);
            return "/common/fail";
        }

      /* 从cookie中获取userid */
        uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
        company.setCreateBy(uid);
        company.setUpdateBy(company.getCreateBy());
      /* 获取修改时间戳 */
        try {
            //设置新公司creatAt,updateAt
            company.setCreateAt(System.currentTimeMillis());
            company.setUpdateAt(company.getCreateAt());
      /* 设置新增公司为解冻状态 */
            company.setFreezed(UN_FREEZE);
            //设置新增公司为未认证状态
            company.setApproved(UN_APPROVED);
            //日志输出参数
            log.info("set company data: createAt,updateAt,freezed,approved "
                    + company.getCreateAt() + company.getUpdateAt() + company.getFreezed() + company.getApproved());
        } catch (Throwable t) {
            t.printStackTrace();
            //日志输出异常信息
            log.error(t.getMessage());
            log.error(" set company data error ,company" + t);
            model.addAttribute("code", -1);
            return "/common/fail";
        }
      /* 插入公司记录 */
        try {
            companyId = companyService.insert(company);
            log.info("insert companyId=" + companyId);
            model.addAttribute("companyId", companyId);
            //插入公司标签
            if (null != tag) {
                String[] stringTag = tag.split(",");
                List<String> taglist = Arrays.asList(stringTag);
                for (String t : taglist) {
                    companyTag.setTag(t);
                    companyTag.setCompanyId(companyId);
                    companyTag.setCreateAt(System.currentTimeMillis());
                    companyTag.setUpdateAt(companyTag.getCreateAt());
                    companyTagService.insert(companyTag);
                }
            }
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add companyTag error " + t);
            model.addAttribute("code", -1);
            return "/common/fail";
        }
        return "/common/addsuccess";
    }

    /**
     * 修改公司
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param company
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.PUT)
    public String updateCompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                    @PathVariable Long id, @RequestBody Company company, String tag) {

        log.info("get company id is" + id);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        List<Long> companyTagIdsList = null;
        Long uid = null;
        Company companySource = null;
        CompanyTag companyTag = null;
    /*
     * 检查必输项 获取公司信息
     */
        log.info("update company = " + company);
    /* 检查公司名称 */
        if (company.getName() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
    /* 检查公司标语 */
        if (company.getSlogan() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
    /* 检查公司人数 */
        if (company.getTotalNum() == null) {
            model.addAttribute("code", -6502);
            return "/common/fail";
        }
    /* 检查公司LOGO */
        if (company.getLogo() == null) {
            model.addAttribute("code", -6509);
            return "/common/fail";
        }
    /* 检查公司介绍 */
        if (company.getSummary() == null) {
            model.addAttribute("code", -6510);
            return "/common/fail";
        }
        try {
      /* 获取原有公司相关创建人和创建时间 */
            companySource = companyService.getObjectById(id);
            company.setCreateAt(companySource.getCreateAt());
            company.setCreateBy(companySource.getCreateBy());
      /* 给ID字段赋值 */
            log.info("set company id is :" + id);
            company.setId(id);
      /* 从cookie中获取USERID */
            log.info("get uid = " + uid);
            uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            company.setUpdateBy(uid);
      /*
       * 获取修改时间戳 company.setUpdateAt(System.currentTimeMillis());
       * 判断产品名称是否有值，有则修改公司表中相关字段
       */
            log.info("update company = " + company);
      /* 更新公司记录 */
            companyService.update(company);
            log.info("update companyId=" + id);
            //先删除所有id=companyId的标签
            companyTagIdsList = companyTagService.getCompanyTagIdsByCompanyId(id, 0, Integer.MAX_VALUE);
            try {
                companyTagService.deleteList(CompanyTag.class, companyTagIdsList);
                log.info("delete companyTagsList success");
                model.addAttribute("code", 0);
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("delete t companyTagsList error,companyTagIds is  " + companyTagIdsList, t);
                model.addAttribute("code", -6004);
                return "/common/fail";
            }
            //如果请求参数companyTagList不为空,则添加进去
            //插入公司标签
            if (null != tag) {
                String[] stringTag = tag.split(",");
                List<String> taglist = Arrays.asList(stringTag);
                for (String t : taglist) {
                    companyTag.setTag(t);
                    companyTag.setCompanyId(id);
                    companyTag.setCreateAt(System.currentTimeMillis());
                    companyTag.setUpdateAt(companyTag.getCreateAt());
                    companyTagService.insert(companyTag);
                }
            }
            return "/common/success";
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServiceDaoException e) {
            e.printStackTrace();
        }
        return "/common/success";
    }
}


