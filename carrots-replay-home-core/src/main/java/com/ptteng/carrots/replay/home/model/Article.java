package com.ptteng.carrots.replay.home.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "article")
public class Article implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2214056312477476864L;


    private Long id;


    private Long type;


    private String title;


    private String img;


    private String url;


    private String industry;


    private String status;

    private String author;


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

    @Column(name = "type")
    public Long getType() {
        return type;
    }


    public void setType(Long type) {
        this.type = type;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "img")
    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }


    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
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

