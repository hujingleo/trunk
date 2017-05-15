package util;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DynamicUtil {

    private static final Log log = LogFactory.getLog(DynamicUtil.class);

    /**
     * 查询职位标签
     *
     * @param companyId
     * @param tag
     * @return
     */
    public static Map<String, Object> getProfessionTagsList(Long companyId, String tag) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id ", companyId);
        }
        if (DataUtils.isNotNullOrEmpty(tag)) {
            params.put("tag", "'" + tag + "'");
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " profession_tags ");

        log.info("getProfessionTagsList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询人才关系技能树关系表
     *
     * @return
     */
    public static Map<String, Object> getTalentSkillRelationList() {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talent_skill_relation ");

        log.info("getTalentSkillRelationList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询技能树 这里我要查询所有，如果加上skill，就变成了select * from skill where id = ?
     *
     * @return
     */
    public static Map<String, Object> getSkillList() {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " skill ");

        log.info("getSkillList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 根据appraisalId查询skillId
     *
     * @param
     * @return
     */
    public static Map<String, Object> getRelationSkillId(Long appraisalId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNullOrEmpty(appraisalId)) {
            params.put("appraisal_id", appraisalId);
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talent_skill_relation ");

        log.info("getSkillList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 根据职位查询
     *
     * @param occupationId
     * @return
     */
    public static Map<String, Object> getOccupationList(Long occupationId) {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("occupation_id", occupationId);

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " skill ");

        log.info("getOccupationList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 根据测评报告id和技能树id查询人才技能树的关系表
     *
     * @param appraisalId
     * @param skillId
     * @return
     */
    public static Map<String, Object> getTalentSkillRelationList(Long appraisalId, Long skillId) {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("appraisal_id", appraisalId);

        params.put("skill_id", skillId);

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talentSkillRelation ");

        log.info("getOccupationList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询关系表中的degree
     *
     * @param skillId
     * @param appraisalId
     * @return
     */
    public static Map<String, Object> getSkillDegreeNum(Long skillId, Long appraisalId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(skillId)) {
            params.put("skill_id ", skillId);
        }

        if (DataUtils.isNotNullOrEmpty(appraisalId)) {
            params.put("appraisal_id ", appraisalId);
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talent_skill_relation ");

        log.info("getSkillDegreeNum sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 后台动态查询职位列表
     */
    public static Map<String, Object> getProfessionList(Long companyId,String companyName, String name,String category,
                                                        String experience, String education, String compensation, String status, Long startAt,Long endAt) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(companyName)) {
            params.put("company_name & like ", "'%" + companyName + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_Id& like ",  + companyId );
        }
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(category)) {
            params.put("category & in", "(" + category + ")");
        }
        if (DataUtils.isNotNullOrEmpty(experience)) {

            params.put("experience & in ", "(" + experience + ")");
        }

        if (DataUtils.isNotNullOrEmpty(education)) {

            params.put("education & in ", "(" + education + ")");
        }

        if (DataUtils.isNotNullOrEmpty(compensation)) {
            params.put("compensation & in", "(" + compensation + ")");
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", "'" + status + "'");
        }
//发布时间范围
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            params.put("release_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            params.put("release_at & <=", endAt);
        }
        //根据发布时间倒序排列
        params.put("@order", " release_at desc ");
        params.put("@query", " id");

        params.put("@table", " profession ");

        log.info("getProfessionList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询公司列表
     */
    public static Map<String, Object> getCompanyMangerList(String name, String industry,String  province, String city,
                                                           String county, String productName, String financing, String approved, String freezed) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            params.put("industry ", "'" + industry +"'");
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("province ", "'" + province +"'");
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city ", "'" + city + "'");
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            params.put("county ", "'" + county + "'");
        }

        if (DataUtils.isNotNullOrEmpty(productName)) {
            params.put("product_name & like", "'%" + productName + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(financing)) {
            params.put("financing ", "'" + financing + "'");
        }
        if (DataUtils.isNotNullOrEmpty(freezed)) {
            params.put("freezed ", "'" + freezed+ "'");
        }
        if (DataUtils.isNotNullOrEmpty(approved)) {
            params.put("approved ", "'" + approved + "'");
        }

        params.put("@order", " create_at desc ");

        params.put("@query", " id ");

        params.put("@table", " company ");

        log.info("getCompanyMangerList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    public static Map<String, Object> getArticleList(String title, String author, Long startAt, Long endAt, String type,
                                                     String status, String industry) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(title)) {
            params.put("title & like ", "'%" + title + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(author)) {
            params.put("author & like ", "'%" + author + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            params.put("update_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            params.put("update_at & <= ", endAt);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("type ", "'" +  type + "'");
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status ",  "'" + status + "'");
        }

        params.put("@order", "  create_at desc ");

        params.put("@query", " id ");

        params.put("@table", " article ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询职位数
     *
     * @param companyId
     * @return
     */
    public static Map<String, Object> getProfessionCount(Long companyId,String status) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id", companyId);
        }

        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status","'"+status+"'");
        }
        params.put("@order", " update_at desc ");

        params.put("@query", "id");

        params.put("@table", " profession ");

        log.info("getProfessionNum sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询上架职位数
     *
     * @param companyId
     * @return
     */
    public static Map<String, Object> getProfessionNumUp(Long companyId) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id", companyId);
        }
        params.put("status", '1');
        params.put("@order", " update_at desc ");

        params.put("@query", " count(id)");

        params.put("@table", " profession ");

        log.info("getProfessionNumUp sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询候选人列表
     */
    public static Map<String, Object> getCandidateList(String name, String phone, String status, String occupationType,
                                                       Long reserveFrom, Long reserveTo, boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(phone)) {
            params.put("phone & like ", "'%" + phone + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(occupationType)) {
            params.put("occupation_type", occupationType);
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }
        if (DataUtils.isNotNullOrEmpty(reserveFrom)) {
            params.put("reserve_time & >= ", reserveFrom);
        }
        if (DataUtils.isNotNullOrEmpty(reserveTo)) {
            params.put("reserve_time & <= ", reserveTo);
        }

        if (count) {
            params.put("@query", " count(id)");
        } else {
            params.put("@order", " update_at desc ");
            params.put("@query", " id");
        }

        params.put("@table", " candidate ");

        log.info("getCandidateList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询候选人电话
     *
     * @param phone
     * @return
     */
    public static Map<String, Object> getCandidateList(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(phone)) {
            params.put("phone", phone);
        }
        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " candidate ");

        log.info("getCandidateList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询推荐人列表
     */
    public static Map<String, Object> getRecommendList(String name, String occupationType, String company,
                                                       Long recommendFrom, Long recommendTo, Long reserveFrom, Long reserveTo, Long salaryFrom, Long salaryTo,
                                                       Long chargeFrom, Long chargeTo, boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(occupationType)) {
            params.put("occupation_type", occupationType);
        }
        if (DataUtils.isNotNullOrEmpty(company)) {
            params.put("company & like ", "'%" + company + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(recommendFrom)) {
            params.put("recommendatory & >= ", recommendFrom);
        }
        if (DataUtils.isNotNullOrEmpty(recommendTo)) {
            params.put("recommendatory & <= ", recommendTo);
        }
        if (DataUtils.isNotNullOrEmpty(reserveFrom)) {
            params.put("reserve_time & >= ", reserveFrom);
        }
        if (DataUtils.isNotNullOrEmpty(reserveTo)) {
            params.put("reserve_time & <= ", reserveTo);
        }
        if (DataUtils.isNotNullOrEmpty(salaryFrom)) {
            params.put("officially_salary & >= ", salaryFrom);
        }
        if (DataUtils.isNotNullOrEmpty(salaryTo)) {
            params.put("officially_salary & <= ", salaryTo);
        }
        if (DataUtils.isNotNullOrEmpty(chargeFrom)) {
            params.put("service_charge & >= ", chargeFrom);
        }
        if (DataUtils.isNotNullOrEmpty(chargeTo)) {
            params.put("service_charge & <= ", chargeTo);
        }

        if (count) {
            params.put("@query", " count(id)");
        } else {
            params.put("@order", " update_at desc ");
            params.put("@query", " id");
        }

        params.put("@table", " recommend ");

        log.info("getRecommendList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询推荐人详细
     *
     * @param talentId
     * @return
     */
    public static Map<String, Object> getRecommendList(Long talentId) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(talentId)) {
            params.put("talent_id", talentId);
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " recommend ");

        log.info("getRecommendList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询人才列表
     */
    public static Map<String, Object> getTalentList(String name, String occupationType, String degree,
                                                    String workExperience, String workSalary, String workStatus, String talentLevel, String recommendNum,
                                                    String isRecommend, String isShelve, Long candidateId, boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(occupationType)) {
            params.put("occupation_type", occupationType);
        }
        if (DataUtils.isNotNullOrEmpty(degree)) {
            params.put("degree", degree);
        }
        if (DataUtils.isNotNullOrEmpty(workExperience)) {
            params.put("work_experience", workExperience);
        }
        if (DataUtils.isNotNullOrEmpty(workSalary)) {
            params.put("work_salary", workSalary);
        }
        if (DataUtils.isNotNullOrEmpty(workStatus)) {
            params.put("work_status", workStatus);
        }
        if (DataUtils.isNotNullOrEmpty(talentLevel)) {
            params.put("talent_level", talentLevel);
        }
        if (DataUtils.isNotNullOrEmpty(recommendNum)) {
            params.put("recommend_num", recommendNum);
        }
        if (DataUtils.isNotNullOrEmpty(isRecommend)) {
            params.put("is_recommend", isRecommend);
        }
        if (DataUtils.isNotNullOrEmpty(isShelve)) {
            params.put("is_shelve", isShelve);
        }
        if (DataUtils.isNotNullOrEmpty(candidateId)) {
            params.put("candidate_id", candidateId);
        }

        if (count) {
            params.put("@query", " count(id)");
        } else {
            params.put("@order", " update_at desc ");
            params.put("@query", " id");
        }

        params.put("@table", " talent ");

        log.info("getTalentList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询人才电话
     *
     * @param phone
     * @return
     */
    public static Map<String, Object> getTalentList(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(phone)) {
            params.put("phone", phone);
        }
        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talent ");

        log.info("getTalentList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 查询人才等级
     *
     * @param isShelve
     * @param talentLevel
     * @return
     */
    public static Map<String, Object> getTalentListWithIsShelve(String isShelve, String talentLevel) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(isShelve)) {
            params.put("is_shelve", isShelve);
        }
        if (DataUtils.isNotNullOrEmpty(talentLevel)) {
            params.put("talent_level", talentLevel);
        }
        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " talent ");

        log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    public static void main(String[] args) {

    }

}
