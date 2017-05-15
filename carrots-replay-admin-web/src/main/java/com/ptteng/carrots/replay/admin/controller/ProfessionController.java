package com.ptteng.carrots.replay.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.CompanyService;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import com.ptteng.carrots.replay.home.service.ProfessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import static com.ptteng.carrots.replay.home.Constant.Constant.*;
import static java.lang.String.valueOf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class ProfessionController {

    private static final Log log = LogFactory.getLog(ProfessionController.class);

    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;


    /**
     * 职位列表查询
     *
     * @param request
     * @param response
     * @param model
     * @param companyName
     * @param name
     * @param education
     * @param experience
     * @param compensation
     * @param status
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/search", method = RequestMethod.GET)
    public String getMultiProfessionJson(HttpServletRequest request, HttpServletResponse response,
                                         ModelMap model, String companyName, String name, String category,
                                         String experience, String education, String compensation, String status, Long startAt, Long endAt, Integer page, Integer size) throws Exception {
        /*page默认1，size默认10*/
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
    /*查询从start开始*/
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }

		/*职位id列表*/
        List<Long> professionIdsList = null;
        List<Profession> professionList = null;
        List<Long> count = null;
        try {
            /*组装动态sql*/
            Map<String, Object> param = DynamicUtil.getProfessionList(null, companyName, name,
                    category, experience, education, compensation, status, startAt, endAt);
            log.info("get  param data is " + param);
            /*通过动态sql查询获得职位id列表*/
            professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, param, start, size);
            count = professionService.getIdsByDynamicCondition(Profession.class, param, start, Integer.MAX_VALUE);
            professionList = professionService.getObjectsByIds(professionIdsList);
            log.info("get  profession data is " + professionList);
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("professionList", professionList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get profession error,id is  " + professionIdsList);
            model.addAttribute("code", -100000);
        }

        return "/carrots-replay-admin-service/profession/json/professionListJson";
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
    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.GET)
    public String getProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id) {

        log.info("get data : id= " + id);
        if (id == null) {
            log.info("profession id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Profession profession = null;
        CompanyTag companyTag = null;
        List<Long> companyTagidsList = null;
        List<CompanyTag> professionTagList = null;
        List<CompanyTag> companyTagList = null;
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
            professionTagList = companyTagService.getObjectsByIds(list);
            //接下来获取对应公司的全部标签
            companyId = profession.getCompanyId();
            log.info("get company id =" + companyId);
            companyTagidsList = companyTagService.getCompanyTagIdsByCompanyId(companyId, 0, Integer.MAX_VALUE);
            companyTagList = companyTagService.getObjectsByIds(companyTagidsList);
            model.addAttribute("professionTagList", professionTagList);
            model.addAttribute("companyTagList", companyTagList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get companyTag error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-admin-service/profession/json/professionDetailJson";
    }


    /**
     * 删除职位
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.DELETE)
    public String deleteProfessionJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get profession id is " + id);
        if (id == null) {
            log.info("profession id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Profession profession = null;
        Long companyId = null;
        Company company = null;
        Integer professionNum = null;
        try {
            profession = professionService.getObjectById(id);
            companyId = profession.getCompanyId();
            log.info("get profession date, profession is " + profession);
            log.info("get companyId is " + companyId);
            //删除前判断职位状态是否为上架,若为上架则返回异常
            if (SHELEVE_UP.equals(profession.getStatus())) {
                model.addAttribute("code", -6511);
                return "/data/json";
            }
            log.info("delete profession : id= " + id);
            professionService.delete(id);
            log.info(" delete profession success");
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete profession error,id is  " + id);
            model.addAttribute("code", -6004);
            return "/common/fail";
        }
        //删除成功后更新公司职位数
        try {
            log.info("get companyId is " + companyId);
            company = companyService.getObjectById(companyId);
            Map<String, Object> param = DynamicUtil.getProfessionCount(companyId, SHELEVE_UP);
            List<Long> professionCountList = professionService.getIdsByDynamicCondition(Profession.class, param, 0, Integer.MAX_VALUE);
            Long professionCount = Long.valueOf(professionCountList.size());
            company.setProfessionCount(professionCount);
            companyService.update(company);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete profession error,id is  " + id);
            model.addAttribute("code", -6004);
            return "/common/fail";
        }
        model.addAttribute("code", 0);
        return "/data/json";
    }


    /**
     * 修改职位状态
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/status/{id}", method = RequestMethod.PUT)
    public String updateProfessionStatusJson(HttpServletRequest request,
                                             HttpServletResponse response, ModelMap model, @PathVariable Long id, String status)
            throws Exception {

        log.info("get profession id is " + id);
        if (id == null) {
            log.info("profession id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Profession professionSource = null;
        Profession profession = null;
        String statusSoure = null;
        String newStatus = null;
        Long companyId = null;
        Company company = null;
        log.info("get status is " + status);
        if (!SHELEVE_DOWN.equals(status) && !SHELEVE_UP.equals(status)) {
            model.addAttribute("code", -9013);
            log.info("get status error is" + status);
            return "/data/json";
        }
        try {
            professionSource = professionService.getObjectById(id);
            statusSoure = professionSource.getStatus();
            profession = professionService.getObjectById(id);
            company = companyService.getObjectById(profession.getCompanyId());
            log.info("get prfession data is" + profession.toString());
            /*上架前判断公司是否冻结，若冻结返回freezed异常,*/
            if (SHELEVE_UP.equals(status) && FROZEN.equals(company.getFreezed())) {
                model.addAttribute("code", -6511);
                return "/data/json";
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update professionStatus error, company is freezed id is "
                    + profession.getCompanyId());
        }
        try {
            profession.setStatus(status);
            profession.setId(id);
            profession.setName(professionSource.getName());
            profession.setCompanyId(professionSource.getCompanyId());
            profession.setCompanyName(professionSource.getCompanyName());
            profession.setCompanyLogo(professionSource.getCompanyLogo());
            profession.setRecommend(professionSource.getRecommend());
            profession.setUpdateAt(System.currentTimeMillis());
            professionService.update(profession);
            newStatus = profession.getStatus();
            log.info("update professionStatus sucess now is " + newStatus);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update profession error, professionId is  " + id);
            model.addAttribute("code", -100000);
        }
        //*如果职位状态由下架改为上架,则职业和公司最新职位发布时间 更新,另外公司在招职位数+1*/
        if (SHELEVE_UP.equals(newStatus) && SHELEVE_DOWN.equals(statusSoure)) {
            try {
                profession.setReleaseAt(System.currentTimeMillis());
                professionService.update(profession);
                log.info("update profession releaseAt : releaseAt= " + profession.getReleaseAt());
                companyId = profession.getCompanyId();
                // Company company = companyService.getObjectById(companyId);
                company.setReleaseAt(profession.getReleaseAt());
                //公司在招职位数更新
                Map<String, Object> param = DynamicUtil.getProfessionCount(companyId, SHELEVE_UP);
                List<Long> professionCountList = professionService.getIdsByDynamicCondition(Profession.class, param, 0, Integer.MAX_VALUE);
                Long professionCount = Long.valueOf(professionCountList.size());
                company.setProfessionCount(professionCount);
                log.info("set company professionCount is " + professionCount);
                //需要更新公司
                companyService.update(company);
                log.info("update company releaseAt : releaseAt= " + company.getReleaseAt());
                log.info("update company professionCount = " + company.getProfessionCount());
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("update releaseAt and professionCount error, companyId is  "
                        + companyId);
            }
            log.info("update profession success");
            model.addAttribute("code", 0);
        }
        //*如果职位状态由上架改为下架,则公司最新职位发布时间更新,另外公司在招职位数-1*/
        if (SHELEVE_DOWN.equals(newStatus) && SHELEVE_UP.equals(statusSoure)) {
            try {
                companyId = profession.getCompanyId();
                Map<String, Object> param = DynamicUtil.getProfessionCount(companyId, SHELEVE_UP);
                log.info("get companyId is " + companyId);
                List<Long> professionCountList = professionService.getIdsByDynamicCondition(Profession.class, param, 0, Integer.MAX_VALUE);
                Long professionCount = Long.valueOf(professionCountList.size());
                Long professionReleaseId = professionCountList.get(0);
                Profession p = professionService.getObjectById(professionReleaseId);
                company.setReleaseAt(p.getReleaseAt());
                company.setProfessionCount(professionCount);
                log.info("set company professionCount is " + professionCount);
                //更新职位发布时间
                profession.setReleaseAt(null);
                professionService.update(profession);
                companyService.update(company);
                log.info("get company professionCount is " + company.getProfessionCount());
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("updateprofession error, companyId is  "
                        + companyId);
            }
            log.info("update profession success");
            model.addAttribute("code", 0);

        }
        return "/data/json";
    }

    /**
     * 更新职位信息
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param profession
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.PUT)
    public String updateProfessionJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model,
                                       @PathVariable Long id,
                                       @RequestBody Profession profession) throws Exception {

        log.info(" profession = " + profession);
        log.info("get profession id is " + id);
        if (id == null) {
            log.info("profession id is null");
            model.addAttribute("code", -10008);
            return "/common/fail";
        }
        Company company = null;
        Profession professionSource = null;
        Long uid = null;
        /*入参校验*/
        if (null == profession.getName()) {
            model.addAttribute("code", -9002);
            return "data/json";
        }
        if (null == profession.getCompanyName()) {
            model.addAttribute("code", -9002);
            return "data/json";
        }
        professionSource = professionService.getObjectById(id);
        /*获取职位的creatBy，createAt*/
        try {
            //职位的createBy,createAt维持原来不变
            profession.setCreateBy(professionSource.getCreateBy());
            profession.setCreateAt(professionSource.getCreateAt());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("set createBy and creatAt error,id is  " + id);
            model.addAttribute("code", -6003);
        }
        try {
            log.info("update profession : profession= " + profession);
            company = companyService.getObjectById(professionSource.getCompanyId());
            log.info("update profession : company= " + company);

            //获取uid
//        try {
            uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
                    com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            log.info("get uid = " + uid);
            profession.setUpdateBy(uid);
            profession.setUpdateAt(System.currentTimeMillis());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("set profession updateBy and updateAt error,id is  " + professionSource.getId());
            model.addAttribute("code", -6003);
        }
        try {
            //职位的id,companyLogo,status,recommend,companyId维持原来不变
            profession.setId(professionSource.getId());
            profession.setCompanyLogo(professionSource.getCompanyLogo());
            profession.setStatus(professionSource.getStatus());
            profession.setRecommend(professionSource.getRecommend());
            profession.setCompanyId(professionSource.getCompanyId());
            professionService.update(profession);
            log.info("update profession = " + profession);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update profession  error,id is  " + profession.getId());
            model.addAttribute("code", -6003);
        }
        return "/data/json";
    }

    /**
     * 新增职位
     *
     * @param request
     * @param response
     * @param model
     * @param profession
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession", method = RequestMethod.POST)
    public String addProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model,
                                    @RequestBody Profession profession) throws Exception, Throwable {

        log.info("insert profession : profession= " + profession.toString());


			/*入参校验*/
        if (null == profession.getCompanyName()) {
            model.addAttribute("code", -9015);
            return "data/json";
        }

        if (null == profession.getName()) {
            model.addAttribute("code", -9002);
            return "data/json";
        }
        Long companyId = null;
        Company company = null;
        Long uid = null;
        Long professionId = null;
        String name = profession.getCompanyName();
        try {
            log.info("start to get company data, companyId============== "
                    + profession.getCompanyId());
            Map<String, Object> param = DynamicUtil.getCompanyMangerList(name, null, null, null,
                    null, null, null, null, null);
            List<Long> companyIds = companyService.getIdsByDynamicCondition(Company.class, param, 0, Integer.MAX_VALUE);
            companyId = companyIds.get(0);
            company = companyService.getObjectById(companyId);
            log.info(" get company data, company date ============== "
                    + company);
            profession.setCompanyId(companyId);
            profession.setCompanyLogo(company.getLogo());
            profession.setRecommend(UN_RECOMMEND);
            /*验证公司冻结状态，如果公司冻结，新增职位为下架状态*/
            if (FROZEN.equals(company.getFreezed())) {
                profession.setStatus(SHELEVE_DOWN);
            }//如果公司状态为解冻,则新增职位状态设置为上架状态
            else if (UN_FREEZE.equals(company.getFreezed())) {
                profession.setStatus(SHELEVE_UP);
                //如果上架职位则更新职业和公司最新职位上架时间和在招职位数
                profession.setReleaseAt(System.currentTimeMillis());
                company.setReleaseAt(profession.getReleaseAt());
                //接下来更新公司的在招职位数
                companyId = profession.getCompanyId();
                log.info("get company id is " + companyId);
                Map<String, Object> param2 = DynamicUtil.getProfessionCount(companyId, SHELEVE_UP);
                List<Long> professionCountList = professionService.getIdsByDynamicCondition(Profession.class, param2, 0, Integer.MAX_VALUE);
                Long professionCount = Long.valueOf(professionCountList.size());
                company.setProfessionCount(professionCount);
                log.info("set company releaseAt is " + company.getReleaseAt());
                log.info("set company professionCount is " + company.getProfessionCount());
                log.info("update profession status : profession status = "
                        + profession.getStatus());
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add profession error ");
            model.addAttribute("code", -6002);
        }
            /*从cookie获取createBy和updateBy*/
        try {
            uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
                    com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            profession.setCreateBy(uid);
            profession.setUpdateBy(uid);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get uid is  " + uid);
        }
        profession.setCreateAt(System.currentTimeMillis());
        profession.setUpdateAt(profession.getCreateAt());

        try {
            log.info("insert profession : profession= " + profession);
            professionId = professionService.insert(profession);
            companyService.update(company);
            model.addAttribute("code", 0);
            model.addAttribute("professionId", professionId);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("insert profession error,  id is  " + professionId);
        }

        return "/data/professionIdJson";
    }
}

