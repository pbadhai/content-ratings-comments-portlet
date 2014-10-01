  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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



<portlet:defineObjects />

<portlet:actionURL name="showMostCommentedArticlePage" var="mostCommentedArticleUrl">
	<portlet:param name="pageName" value="mostCommentedArticle-jsp"></portlet:param>
</portlet:actionURL>

<portlet:actionURL name="showMostRatedArticlePage" var="mostRatedAticleUrl">
	<portlet:param name="pageName" value="mostRatedAticle-jsp"></portlet:param>
</portlet:actionURL>

<div id="container" style="width:800px">

<div id="header" style="background-color:#00AAFF;">
<h3 style="margin-bottom:0;"><center>Articles Comments Reports</center></h3></div>

<div id="menu" style="background-color:#EEEEEE;height:float;width:200px;float:left;">
<ul class="nav"></ul>
<b><a href="${mostCommentedArticleUrl}">Most Commented Article</a></b><br>
<b><a href="${mostRatedAticleUrl}">Most Rated Article</a></b><br>
</div>

<div id="content" style="background-color:#EEEEEE;height:float;width:600px;float:left;">

		<table class="lfr-table" width="100%" border="1">
		<tr align="center">
					
			<th valign="top" width="80%" align="center" ><strong><center>Article Title</center></strong></th>
			
			<th valign="right" width="20%" align="center" ><strong><center>Number of Comments</center></strong></th>		
					
			</tr>		
				
			<c:forEach items='${mostCommentedArticle}' var="mostCommentedArticle">
			<tr>
				<td><a href="${mostCommentedArticle.completeUrl }"><c:out value="${mostCommentedArticle.articleTitle}" /><br></a></td>				 
				<td><c:out value="${mostCommentedArticle.totalMessageCount}" /></td>							
			</tr>
		</c:forEach>
				
	</table>
	
	</div>
	<div id="footer" style="background-color:#00AAFF;clear:both;text-align:center;">
	Copyright © pradeep@sharma email: erpkb.sharma@gmail.com</div>

</div>
