<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${professionInfoList}" var="professionInfo">
			<json:object>


                <json:property name="id" value="${professionInfo.profession.id}"></json:property>

                <json:property name="industry" value="${professionInfo.company.industry}"></json:property>
                <json:property name="companyLogo" value="${professionInfo.company.logo}"></json:property>
                <json:property name="companyTag" value="${professionInfo.company.id}"></json:property>
                <json:property name=" " value="${professionInfo.company.id}"></json:property>
                <json:property name=" " value="${professionInfo.company.id}"></json:property>
               
                    <json:property name="companyName" value="${professionInfo.profession.companyName}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyId" value="${professionInfo.profession.companyId}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${professionInfo.profession.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="category" value="${professionInfo.profession.category}"></json:property>
           
           
	   
        			
               
                    <json:property name="education" value="${professionInfo.profession.education}"></json:property>
           
           
	   
        			
               
                    <json:property name="experience" value="${professionInfo.profession.experience}"></json:property>
           
           
	   
        			
               
                    <json:property name="compensation" value="${professionInfo.profession.compensation}"></json:property>
           
           
	   
        			
               
                    <json:property name="responsibility" value="${professionInfo.profession.responsibility}"></json:property>
           
           
	   
        			
               
                    <json:property name="requisite" value="${professionInfo.profession.requisite}"></json:property>
           
           
	   
        			
               
                    <json:property name="boon" value="${professionInfo.profession.boon}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${professionInfo.profession.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="releaseAt" value="${professionInfo.profession.releaseAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="recommend" value="${professionInfo.profession.recommend}"></json:property>
           
           
	   
        			
               
                    <json:property name="tagId" value="${professionInfo.profession.tagId}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${professionInfo.profession.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${professionInfo.profession.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${professionInfo.profession.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${professionInfo.profession.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


