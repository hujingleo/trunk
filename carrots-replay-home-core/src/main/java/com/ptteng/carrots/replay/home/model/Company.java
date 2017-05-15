package com.ptteng.carrots.replay.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "company")
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4469335896974980096L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String province;


    private  String city;
	
  	 
    private  String county;
	
  	 
    private  String finacing;
	
  	 
    private  String approved;
	
  	 
    private  String freezed;
	
  	 
    private  String logo;
	
  	 
    private  String slogan;
	
  	 
    private  Long totalNum;
	
  	 
    private  String summary;
	
  	 
    private  String industry;
	
  	 
    private  Long phone;
	
  	 
    private  String address;
	
  	 
    private  String map;
	
  	 
    private  String mail;
	
  	 
    private  Long professionCount;
	
  	 
    private  String productName;
	
  	 
    private  String productLogo;
	
  	 
    private  String productSolgan;
	
  	 
    private  String productSummary;
	
  	 
    private  Long approvedAt;
	
  	 
    private  Long releaseAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "province")
	public String getProvince() {
		return province;
	}
	
	
	public void setProvince(String province) {
		this.province = province;
	}
		 	@Column(name = "city")
	public String getCity() {
		return city;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
		 	@Column(name = "county")
	public String getCounty() {
		return county;
	}
	
	
	public void setCounty(String county) {
		this.county = county;
	}
		 	@Column(name = "finacing")
	public String getFinacing() {
		return finacing;
	}
	
	
	public void setFinacing(String finacing) {
		this.finacing = finacing;
	}
		 	@Column(name = "approved")
	public String getApproved() {
		return approved;
	}
	
	
	public void setApproved(String approved) {
		this.approved = approved;
	}
		 	@Column(name = "freezed")
	public String getFreezed() {
		return freezed;
	}
	
	
	public void setFreezed(String freezed) {
		this.freezed = freezed;
	}
		 	@Column(name = "logo")
	public String getLogo() {
		return logo;
	}
	
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
		 	@Column(name = "slogan")
	public String getSlogan() {
		return slogan;
	}
	
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
		 	@Column(name = "total_num")
	public Long getTotalNum() {
		return totalNum;
	}
	
	
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
		 	@Column(name = "summary")
	public String getSummary() {
		return summary;
	}
	
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
		 	@Column(name = "industry")
	public String getIndustry() {
		return industry;
	}
	
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
		 	@Column(name = "phone")
	public Long getPhone() {
		return phone;
	}
	
	
	public void setPhone(Long phone) {
		this.phone = phone;
	}
		 	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
		 	@Column(name = "map")
	public String getMap() {
		return map;
	}
	
	
	public void setMap(String map) {
		this.map = map;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}
	
	
	public void setMail(String mail) {
		this.mail = mail;
	}
		 	@Column(name = "profession_count")
	public Long getProfessionCount() {
		return professionCount;
	}
	
	
	public void setProfessionCount(Long professionCount) {
		this.professionCount = professionCount;
	}
		 	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
		 	@Column(name = "product_logo")
	public String getProductLogo() {
		return productLogo;
	}
	
	
	public void setProductLogo(String productLogo) {
		this.productLogo = productLogo;
	}
		 	@Column(name = "product_solgan")
	public String getProductSolgan() {
		return productSolgan;
	}
	
	
	public void setProductSolgan(String productSolgan) {
		this.productSolgan = productSolgan;
	}
		 	@Column(name = "product_summary")
	public String getProductSummary() {
		return productSummary;
	}
	
	
	public void setProductSummary(String productSummary) {
		this.productSummary = productSummary;
	}
		 	@Column(name = "approved_at")
	public Long getApprovedAt() {
		return approvedAt;
	}
	
	
	public void setApprovedAt(Long approvedAt) {
		this.approvedAt = approvedAt;
	}
		 	@Column(name = "release_at")
	public Long getReleaseAt() {
		return releaseAt;
	}
	
	
	public void setReleaseAt(Long releaseAt) {
		this.releaseAt = releaseAt;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

