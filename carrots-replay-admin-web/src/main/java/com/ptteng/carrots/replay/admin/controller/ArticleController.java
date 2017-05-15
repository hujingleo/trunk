package com.ptteng.carrots.replay.admin.controller;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ptteng.carrots.replay.home.model.Article;
import com.ptteng.carrots.replay.home.model.Manager;
import com.ptteng.carrots.replay.home.service.ArticleService;
import com.ptteng.carrots.replay.home.service.ManagerService;
import com.ptteng.common.storage.util.ImgStorageUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import util.DynamicUtil;

import static com.ptteng.carrots.replay.home.Constant.Constant.SHELEVE_DOWN;
import static com.ptteng.carrots.replay.home.Constant.Constant.SHELEVE_UP;


@Controller
public class ArticleController {
    private static final Log log = LogFactory.getLog(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ImgStorageUtil imgStorageUtil;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;

    /**
     * 获取文章列表
     *
     * @param request
     * @param response
     * @param model
     * @param type
     * @param title
     * @param industry
     * @param status
     * @param author
     * @param startAt
     * @param endAt
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/search", method = RequestMethod.GET)
    public String getMultiArticleJson(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, String type, String title, String industry,
                                      String status, String author, Long startAt, Long endAt, Integer page, Integer size) throws Exception {

        if (page == null || page <= 0) {
            page = 1;
        }

        if (size == null || size <= 0) {
            size = 10;
        }

        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        List<Article> articleList = null;
        try {

            Map<String, Object> param = DynamicUtil.getArticleList(title,
                    author, startAt, endAt, type, status, industry);
            List<Long> ids = articleService.getIdsByDynamicCondition(
                    Article.class, param, start, size);
            List<Long> count = articleService.getIdsByDynamicCondition(
                    Article.class, param, 0, Integer.MAX_VALUE);
            articleList = articleService.getObjectsByIds(ids);
            model.addAttribute("code", 0);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("articleList", articleList);
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get article error");
            model.addAttribute("code", -100000);
        }

        return "/carrots-replay-admin-service/article/json/articleListJson";
    }


    /**
     * 删除内容
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.DELETE)
    public String deleteArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete article : id= " + id);
        try {
            articleService.delete(id);
            log.info("delete article success");
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete article error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        return "/data/json";
    }


    /**
     * 修改文章上下架状态
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/status", method = RequestMethod.PUT)
    public String updateArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Long id,
                                    String status) throws Exception {
        if (id == null) {
            model.addAttribute("code", -1000);
            log.info("put article status error and id is null");
            return "/data/json";
        }
        Article article = articleService.getObjectById(id);
        //Integer status = article.getStatus();
        log.info("update article status : article id ,status = " + id + " , "
                + status);
        try {
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
                    com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            //更新修改者
            article.setUpdateBy(uid);
            // 修改status
            article.setStatus(status);
            //更新article
            articleService.update(article);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update article error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        return "/data/json";
    }


    /**
     * 新增内容
     *
     * @param request
     * @param response
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
    public String addArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, Article article)
            throws Exception {

        log.info("insert article : article= " + article);

        try {
            if (article == null) {
                model.addAttribute("code", -1004);
                return "/data/json";
            }
            String status = article.getStatus();
            if (status == null) {
                model.addAttribute("code", -9016);
                return "/data/json";
            }
            if (status != "1" && status != "0") {
                model.addAttribute("code", -4020);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getImg())) {

                model.addAttribute("code", -4014);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getTitle() == null)) {

                model.addAttribute("code", -9017);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getType() == null)) {

                model.addAttribute("code", -9018);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getUrl() == null)) {

                model.addAttribute("code", -9019);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getTitle())) {
                model.addAttribute("code", -4015);
                return "common/success";
            }


            // 默认下架
            if (!SHELEVE_UP.equals(article.getStatus())) {
                article.setStatus(SHELEVE_DOWN);
            }
            log.info("===============================" + article.getStatus());
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
                    com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            article.setCreateBy(uid);
            article.setUpdateBy(uid);
            Long aid = articleService.insert(article);
            //article.setId(aid);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add article error ");
            model.addAttribute("code", -100000);
        }

        return "/data/json";
    }


    /**
     * 单个查询展示内容
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        try {
            if (id == null) {
                model.addAttribute("code", -1004);
                return "/data/json";
            } else {

                Article article = articleService.getObjectById(id);
                if (article == null) {
                    model.addAttribute("code", -9003);
                    return "/data/json";
                } else {
                    log.info("get article data is " + article);
                    model.addAttribute("code", 0);
                    model.addAttribute("article", article);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/carrots-replay-admin-service/article/json/articleDetailJson";
    }


    /**
     * 修改article
     *
     * @param request
     * @param response
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.PUT)
    public String updateArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Article article,
                                    @PathVariable Long id) throws Exception {

        log.info("update article : article= " + article);

        try {

            if (article == null) {
                model.addAttribute("code", -1004);

                return "/data/json";
            }

            if (DataUtils.isNullOrEmpty(article.getType())) {
                model.addAttribute("code", -4013);
                return "common/success";
            }

            if (DataUtils.isNullOrEmpty(article.getImg())) {
                model.addAttribute("code", -4014);
                return "common/success";
            }
            if (DataUtils.isNullOrEmpty(article.getTitle())) {
                model.addAttribute("code", -4015);
                return "common/success";
            }
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
                    com.qding.common.util.http.cookie.CookieUtil.USER_ID));

            article.setUpdateBy(id);
            article.setId(id);

            Manager manager = managerService.getObjectById(uid);
            article.setAuthor(manager.getName());
            log.info("update article : article= " + article);
            articleService.update(article);

            model.addAttribute("code", 0);

            model.addAttribute("article", article);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update article error,id is  " + article.getId());
            model.addAttribute("code", -100000);
        }
        return "/data/json";
    }

    //38 .图片上传
    @RequestMapping(value = "/a/u/img/{module}", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model,
                             @RequestParam MultipartFile file, @PathVariable String module)
            throws Exception {
        log.info("hello upload " + module);
        if (StringUtils.isBlank(module)) {
            log.info("type is null");
        }
        int code = 0;
        log.info(file.getOriginalFilename());

        try {

            String extend = FileUtil.getFileExtension(file.getOriginalFilename());

            String fileName = UUID.randomUUID().toString() + "." + extend;
            log.info("new name is " + fileName);
//			String filePath = "/temp/" + fileName;
            String filePath = "/data/img/graship/" + module + "/" + fileName;
            String dirPath = "/data/img/graship/" + module;

            File dir = new File("/data/img/graship/" + module);
            if (dir.exists()) {
                log.info("创建目录" + dirPath + "失败，目标目录已经存在");
            } else {
                //创建目录
                if (dir.mkdirs()) {
                    log.info("创建目录" + dirPath + "成功！");
                } else {
                    log.info("创建目录" + dirPath + "失败！");
                }
            }

            File tempPic = new File(filePath);
            file.transferTo(tempPic);
            String url = this.imgStorageUtil.imgStorage(null, "graship/" + module + "/"
                    + fileName, filePath);
            log.info(module + " upload success ,and file name is " + fileName
                    + "temp path is " + filePath + " access url is " + url);
            tempPic.delete();
//			log.info(file.getOriginalFilename() + " delete success ");
            model.addAttribute("url", url);
            model.addAttribute("code", 0);

            return "/common/img";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
        }

        return "/common/success";
    }
}

