package com.ptteng.carrots.replay.home.vo;

import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.model.Profession;

import java.util.List;

/**
 * Created by hujin on 2017/5/2.
 */
public class ProfessionInfo {
    private Profession profession;
    private Company company;
    private List<CompanyTag> companyTagList ;

    public List<CompanyTag> getCompanyTagList() {
        return companyTagList;
    }

    public void setCompanyTagList(List<CompanyTag> companyTagList) {
        this.companyTagList = companyTagList;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
