package com.ptteng.carrots.replay.home.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ptteng.carrots.replay.home.model.Article;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.service.ArticleService;
import com.ptteng.carrots.replay.home.service.CompanyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;


/**
 *
 */
@Controller
public class ArticleController {
    private static final Log log = LogFactory.getLog(ArticleController.class);

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CompanyService companyService;

    /**
     * 获取最新认证公司的行业大图
     *
     * @param request
     * @param response
     * @param model
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/article/industry", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model)
            {
                List<Long> companyIds = null;
                String industry = null;
                try {
      /* 组装动态sql */
                    Map<String, Object> param = DynamicUtil.getNewlyApprovedCompany();
                    log.info("get  param data is " + param);
      /* 通过动态sql查询获得公司ID列表 ,再查询出公司列表*/
             companyIds = companyService.getIdsByDynamicCondition(Company.class, param, 0, Integer.MAX_VALUE);
            //取第排第一的公司id
            Long companyId = companyIds.get(0);
            log.info("get companyId is "+companyId);
            //根据id获取该公司行业
            Company company = companyService.getObjectById(companyId);
            industry = company.getIndustry();
            log.info("get company, id is " + companyId);
            log.info("get industry,  is " + industry);}
catch (Throwable t) {
    log.error(t.getMessage());
    log.error("get company error,id is  " + companyIds, t);
    model.addAttribute("code", -100000);
}
        //根据行业查出行业大图
                Long articleId = null;
        try {
            Map<String, Object> param2 = DynamicUtil.getArticleByIndustry(industry);
            log.info("get industry data is "+industry);
            List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class, param2, 0, Integer.MAX_VALUE);
            articleId = articleIds.get(0);
            Article article = articleService.getObjectById(articleId);
            log.info("get article data  is " + article);
            model.addAttribute("code", 0);
            model.addAttribute("article", article);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error,id is" + articleId, t);
            model.addAttribute("code", -100000);
        }
        return "/carrots-replay-home-service/article/json/articleDetailJson";
    }
}

