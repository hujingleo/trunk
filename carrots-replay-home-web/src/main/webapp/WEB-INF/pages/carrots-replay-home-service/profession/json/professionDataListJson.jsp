<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${professionDataList}" var="professionDataMap">
            <json:object>
            <json:property name="professionId" value="${professionDataMap.professionId}"></json:property>
            <json:property name="professionName" value="${professionDataMap.professionName}"></json:property>
            <json:property name="professionEducation" value="${professionDataMap.professionEducation}"></json:property>
            <json:property name="professionExperience"
                           value="${professionDataMap.professionExperience}"></json:property>
            <json:property name="professionCompensation"
                           value="${professionDataMap.professionCompensation}"></json:property>
            <json:property name="professionResponsibility"
                           value="${professionDataMap.professionResponsibility}"></json:property>
            <json:property name="professionRequisite" value="${professionDataMap.professionRequisite}"></json:property>
            <json:property name="professionReleaseAt" value="${professionDataMap.professionReleaseAt}"></json:property>

            <json:property name="companyId" value="${professionDataMap.companyId}"></json:property>
            <json:property name="companyIndustry" value="${professionDataMap.companyIndustry}"></json:property>
            <json:property name="companyName" value="${professionDataMap.companyName}"></json:property>
            <json:property name="companyLogo" value="${professionDataMap.companyLogo}"></json:property>

            <json:property name="companyTags" value="${professionDataMap.companyTags}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>






