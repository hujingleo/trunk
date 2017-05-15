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
	 * 查询职位列表
	 */
	public static Map<String, Object> getProfessionList(String companyName, String name,String province,String city,String county,
														String recommend, String industry, String experience, String compensation, String status, Long releaseAt) {

		Map<String, Object> params = new HashMap<String, Object>();

		if (DataUtils.isNotNullOrEmpty(companyName)) {
			params.put("company_name & like ", "'%" + companyName + "%'");
		}
		if (DataUtils.isNotNullOrEmpty(name)) {
			params.put("name & like", "'%" + name + "%'");
		}
		if (DataUtils.isNotNullOrEmpty(city)) {
			params.put("company_id & in ", "(select company_id from company_industry where city in (" + city + "))");
		}
		if (DataUtils.isNotNullOrEmpty(recommend)) {
			params.put("recommend", "'"+recommend+"'") ;
		}
		if (DataUtils.isNotNullOrEmpty(industry)) {
			params.put("company_id & in ", "(select company_id from company_industry where industry in (" + industry + "))");
		}
		if (DataUtils.isNotNullOrEmpty(experience)) {
			params.put("experience & in ", "(" + experience + ")");
		}

		if (DataUtils.isNotNullOrEmpty(compensation)) {
			params.put("compensation & in", "(" + compensation + ")");
		}
		if (DataUtils.isNotNullOrEmpty(status)) {
			params.put("status","'" + status+"'") ;
		}
		// 获取时间戳
		if (DataUtils.isNotNullOrEmpty(releaseAt)) {
			//获取系统当前时间
			Long time = System.currentTimeMillis();
			//获取当天0点时间戳
			Long t = time/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
			switch (releaseAt.intValue()) {
				case 0:
					// 今天,挤发布时间大于当天0点时间戳
					params.put("release_at & >",t);
					break;

				case 1:
					// 3天内,即发布时间大于三天前0点时间戳
					params.put("release_at & >",  t- 86400000 * 3);
					break;

				case 2:
					// 7天内,即发布时间大于七天前0点时间戳
					params.put("release_at & >", t - 86400000 * 7);
					break;
			}
		}
//按照发布时间排序
		params.put("@order", "release_at desc" );
		params.put("@query", " id");
		params.put("@table", " profession ");

		log.info("getProfessionList sql is " + SQLUtil.convert2Sql(params, 0, 0));

		return params;
	}

	/**
	 * 查询公司列表
	 */
	public static Map<String, Object> getCompanyMangerList(String name, String industry, String city, String financing, String approved) {

		Map<String, Object> params = new HashMap<String, Object>();

		if (DataUtils.isNotNullOrEmpty(name)) {
			params.put("name & like", "'%" + name + "%'");
		}
		if (DataUtils.isNotNullOrEmpty(industry)) {
			params.put("industry ", "'" + industry + "'");
		}
		if (DataUtils.isNotNullOrEmpty(city)) {
			params.put("city ", "'" + city + "'");
		}
		if (DataUtils.isNotNullOrEmpty(financing)) {
			params.put("financing & like", "'%" + financing + "%'");
		}
		if (DataUtils.isNotNullOrEmpty(approved)) {
			params.put("approved ", "'" + approved + "'");
		}
		params.put("@order", " release_at desc ");

		params.put("@query", " id");

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
			params.put("type ", type);
		}
		if (DataUtils.isNotNullOrEmpty(status)) {
			params.put("status ", "status");
		}

		params.put("@order", "  publish_at desc ");

		params.put("@query", " id");

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
	public static Map<String, Object> getProfessionNum(Long companyId) {
		Map<String, Object> params = new HashMap<String, Object>();

		if (DataUtils.isNotNullOrEmpty(companyId)) {
			params.put("company_id", companyId);
		}

		params.put("@order", " update_at desc ");

		params.put("@query", " count(id)");

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




	public static Map<String, Object> getArticleByIndustry(String industry) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (DataUtils.isNotNullOrEmpty(industry)) {
			params.put("industry", "'" + industry + "'");
		}
		params.put("@order", " create_at desc ");

		params.put("@query", " id ");

		params.put("@table", " article ");

		log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));

		return params;
	}
	public static Map<String, Object> getNewlyApprovedCompany() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("@order", " create_at desc ");

		params.put("@query", " id");

		params.put("@table", " company ");

		log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));

		return params;
	}
	public static Map<String, Object> getGeneralCompanyList(String approved){
		Map<String, Object> params = new HashMap<String, Object>();
		if (DataUtils.isNotNullOrEmpty(approved)) {
			params.put("approved", "'" +approved+ "'");
		}
		params.put("@order", " create_at desc ");

		params.put("@query", " id ");

		params.put("@table", " company ");

		log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));
		return  params;
	}

	public static Map<String, Object> getCompanyTagIdsByCompanyId(Long companyId){
		Map<String, Object> params = new HashMap<String, Object>();
		if (DataUtils.isNotNullOrEmpty(companyId)) {
			params.put("company_id", companyId);
		}
		params.put("@order", "create_at desc" );

		params.put("@query", " id");

		params.put("@table", " companyTag ");

		log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));

		return params;
	}
	public static Map<String, Object> getProfessionIdsByCompanyId(Long companyId){
		Map<String, Object> params = new HashMap<String, Object>();
		if (DataUtils.isNotNullOrEmpty(companyId)) {
			params.put("company_id", companyId);
		}
		params.put("@order", "create_at desc" );

		params.put("@query", " id");

		params.put("@table", " profession ");

		log.info("getTalentListWithIsShelve sql is " + SQLUtil.convert2Sql(params, 0, 0));

		return params;
	}
}
