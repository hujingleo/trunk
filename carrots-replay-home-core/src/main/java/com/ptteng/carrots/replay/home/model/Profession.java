package com.ptteng.carrots.replay.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "profession")
public class Profession implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2586462182213269504L;


    private Long id;


    private String companyName;


    private Long companyId;


    private String companyLogo;


    private String name;


    private String category;


    private String education;


    private String experience;


    private String compensation;


    private String responsibility;


    private String requisite;


    private String boon;


    private String status;


    private Long releaseAt;


    private String recommend;


    private String tagId;


    private Long createBy;


    private Long updateBy;


    private Long updateAt;


    private Long createAt;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "company_Id")
    public Long getCompanyId() {
        return companyId;
    }


    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Column(name = "company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }


    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "education")
    public String getEducation() {
        return education;
    }


    public void setEducation(String education) {
        this.education = education;
    }

    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }


    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Column(name = "compensation")
    public String getCompensation() {
        return compensation;
    }


    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    @Column(name = "responsibility")
    public String getResponsibility() {
        return responsibility;
    }


    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Column(name = "requisite")
    public String getRequisite() {
        return requisite;
    }


    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    @Column(name = "boon")
    public String getBoon() {
        return boon;
    }


    public void setBoon(String boon) {
        this.boon = boon;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "release_at")
    public Long getReleaseAt() {
        return releaseAt;
    }


    public void setReleaseAt(Long releaseAt) {
        this.releaseAt = releaseAt;
    }

    @Column(name = "recommend")
    public String getRecommend() {
        return recommend;
    }


    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Column(name = "tag_id")
    public String getTagId() {
        return tagId;
    }


    public void setTagId(String tagId) {
        this.tagId = tagId;
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

    @Column(name = "update_at")
    public Long getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Column(name = "create_at")
    public Long getCreateAt() {
        return createAt;
    }


    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}

