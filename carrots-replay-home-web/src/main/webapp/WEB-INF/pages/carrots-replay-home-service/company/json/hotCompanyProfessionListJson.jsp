<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
        <spring:message code="${code}" /></json:property>
<%--	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>--%>
	<json:array name="data">
        <c:forEach items="${hotCompanyProfessionList}" var="hotCompanyProfessionMap">
            <json:object>
            <json:property name="companyName" value="${hotCompanyProfessionMap.companyName}"></json:property>
            <json:property name="companyLogo" value="${hotCompanyProfessionMap.companyLogo}"></json:property>
            <json:property name="companyIndustry" value="${hotCompanyProfessionMap.companyIndustry}"></json:property>
            <json:property name="companyFinacing" value="${hotCompanyProfessionMap.companyFinacing}"></json:property>
            <json:property name="companyCity" value="${hotCompanyProfessionMap.companyCity}"></json:property>
            <json:property name="professions" value="${hotCompanyProfessionMap.professions}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>



