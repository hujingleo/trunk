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
		<c:forEach items="${professionList}" var="profession">
			<json:object>
					
               
                    <json:property name="id" value="${profession.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyName" value="${profession.companyName}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyId" value="${profession.companyId}"></json:property>


                <json:property name="companyLogo" value="${profession.companyLogo}"></json:property>


        			
               
                    <json:property name="name" value="${profession.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="category" value="${profession.category}"></json:property>
           
           
	   
        			
               
                    <json:property name="education" value="${profession.education}"></json:property>
           
           
	   
        			
               
                    <json:property name="experience" value="${profession.experience}"></json:property>
           
           
	   
        			
               
                    <json:property name="compensation" value="${profession.compensation}"></json:property>
           
           
	   
        			
               
                    <json:property name="responsibility" value="${profession.responsibility}"></json:property>
           
           
	   
        			
               
                    <json:property name="requisite" value="${profession.requisite}"></json:property>
           
           
	   
        			
               
                    <json:property name="boon" value="${profession.boon}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${profession.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="releaseAt" value="${profession.releaseAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="recommend" value="${profession.recommend}"></json:property>
           
           
	   
        			
               
                    <json:property name="tagId" value="${profession.tagId}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${profession.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${profession.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${profession.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${profession.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


