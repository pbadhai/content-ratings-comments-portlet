
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:javaee="http://java.sun.com/xml/ns/javaee"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee;http://java.sun.com/xml/ns/j2ee/web-app_2_5.xsd"
    id="WebApp_ID" version="2.5">
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portlet.journal.util.comparator.ArticleModifiedDateComparator" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.util.comparator.ArticleDisplayDateComparator" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>

<%@page import="com.liferay.portlet.asset.service.persistence.*"%>
<%@page import="com.liferay.portlet.asset.service.*"%>
<%@page import="com.liferay.portlet.journal.service.*"%>
<%@page import="com.liferay.portlet.journalcontent.util.*"%>
<%@page import="com.liferay.portlet.asset.model.*"%>
<%@page import="com.liferay.portlet.journal.model.*"%> 
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>



<portlet:defineObjects />


<portlet:actionURL name="showMostCommentedArticlePage" var="mostCommentedArticleUrl">
	<portlet:param name="pageName" value="mostCommentedArticle-jsp"></portlet:param>
</portlet:actionURL>

<portlet:actionURL name="showMostRatedArticlePage" var="mostRatedAticleUrl">
	<portlet:param name="pageName" value="mostRatedAticle-jsp"></portlet:param>
</portlet:actionURL>

<div id="container" style="width:800px">

<div id="header" style="background-color:#00AAFF;">
<h3 style="margin-bottom:0;"><center>Welcome to Enterprise Content Reports</center></h3></div>

<div id="menu" style="background-color:#EEEEEE;height:float;width:200px;float:left;">
<span></span>
<ul class="nav"></ul>
<b><a href="${mostCommentedArticleUrl}">Most Commented Article</a></b><br>
<b><a href="${mostRatedAticleUrl}">Most Rated Article</a></b><br>
</div>

<div id="content" style="background-color:#EEEEEE;height:float;width:600px;float:left;">

	<center> Please Select the Report Type.</center>
	
	</div>
	<div id="footer" style="background-color:#00AAFF;clear:both;text-align:center;">
	Copyright © pradeep@sharma email: erpkb.sharma@gmail.com</div>

</div>

