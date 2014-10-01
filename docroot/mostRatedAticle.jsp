<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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

<%@page import="com.liferay.portlet.ratings.model.RatingsEntry" %>
<%@page import="com.liferay.portlet.ratings.model.RatingsStats" %>
<%@page import="com.liferay.portlet.ratings.service.RatingsEntryLocalServiceUtil" %>
<%@page import="com.liferay.portlet.ratings.service.persistence.RatingsEntryUtil" %>
<%@page import="com.liferay.portlet.ratings.service.persistence.RatingsStatsUtil" %>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@page import="com.liferay.portal.model.Layout" %>


<portlet:defineObjects />

<%-- <portlet:renderURL var="mostCommentedArticleUrl">  
<portlet:param name="action" value="mostCommentedArticle"></portlet:param>  
</portlet:renderURL>  

<portlet:renderURL var="articleRatingUrl">  
<portlet:param name="action" value="articleRating"></portlet:param>  
</portlet:renderURL> --%> 

	
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
			<th valign="top" width="70%" align="center" ><strong><center>Article Titles</center></strong></th>			
			<th valign="right" width="10%" align="center" ><strong><center>Total Entries</center></strong></th>		
			<th valign="top" width="10%" align="center" >Average Score</th>
			<th valign="top" width="10%" align="center" ><center> Total Score </center></th>			
		</tr>
			
		<c:forEach items='${mostRatedArticle}' var="mostRatedArticle">
			<tr>
				<td><a href="${mostRatedArticle.completeUrl }"><c:out value="${mostRatedArticle.articleTitle}" /><br></a></td>					
				<td><c:out value="${mostRatedArticle.totalEntries}" /></td>				
				<td><c:out value="${mostRatedArticle.averageScore}" /></td>
				<td><c:out value="${mostRatedArticle.totalScore}" /></td>			
			</tr>
		</c:forEach>
		
	
	</table>
</div>
<div id="footer" style="background-color:#00AAFF;clear:both;text-align:center;">
Copyright © pradeep@sharma email: erpkb.sharma@gmail.com</div>

</div>
											