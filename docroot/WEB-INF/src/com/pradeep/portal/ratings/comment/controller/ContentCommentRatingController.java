package com.pradeep.portal.ratings.comment.controller;


import java.io.IOException;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;  
import javax.portlet.ActionResponse;  
import javax.portlet.PortletException;  
import javax.portlet.ProcessAction;  
import javax.portlet.RenderRequest;  
import javax.portlet.RenderResponse; 

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;  
import com.liferay.util.bridges.mvc.MVCPortlet;  
import com.pradeep.portal.ratings.comment.impl.MostCommentedArticle;
import com.pradeep.portal.ratings.comment.impl.MostRatedArticle;
import com.pradeep.portal.ratings.comment.util.MostRatedArticleComparator;
import com.pradeep.portal.ratings.comment.util.MostCommentedArticleComparator;

/**
 * 
 * @author pbadhai : Pradeep K. Badhai
 * 		   emai: erpkb.sharma@gmail.com
 *
 */
public class ContentCommentRatingController extends MVCPortlet{  
	  
	  
	private static final Log logger = LogFactoryUtil
			.getLog(ContentCommentRatingController.class);
	
	String url = "";		
	
	/**
	 * 
	 */
	 @Override  
	 public void render(RenderRequest request, RenderResponse response)  
	   throws PortletException, IOException {  
	  String renderPageName = ParamUtil.get(request, "renderPage", "articleMenu-jsp");  
	  String renderPagePath = getInitParameter(renderPageName);  
	  include(renderPagePath, request, response); 
	  logger.info("Welcome to Liferay MVC Enterprise Content Comment Rating Reports Portlet");
	  super.render(request, response); 	  

	 } 
	 
	 /**
	  * 
	  * @param actionRequest
	  * @param actionResponse
	  * @throws IOException
	  * @throws PortletException
	  * @throws PortalException
	  * @throws SystemException
	  * @throws SQLException
	  */
	 @ProcessAction(name="showMostCommentedArticlePage")  
	 public void showMostCommentedArticle(ActionRequest actionRequest, ActionResponse actionResponse)throws IOException, PortletException, PortalException, SystemException, SQLException{  
	    
	  String renderPageName = ParamUtil.get(actionRequest, "pageName", "mostCommentedArticle-jsp");
	  mostCommentedArticleReportOrderedByArticle(actionRequest, actionResponse);
	  actionResponse.setRenderParameter("renderPage", renderPageName);  
	 } 
	 
	 /**
	  * 
	  * @param actionRequest
	  * @param actionResponse
	  * @throws IOException
	  * @throws PortletException
	  * @throws PortalException
	  * @throws SystemException
	  */
	 @ProcessAction(name="showMostRatedArticlePage")  
	 public void showMostRatedArticle(ActionRequest actionRequest, ActionResponse actionResponse)throws IOException, PortletException, PortalException, SystemException{  
	    
	  String renderPageName = ParamUtil.get(actionRequest, "pageName", "mostRatedAticle-jsp");  
	  ratingStatsReport(actionRequest, actionResponse);
	  actionResponse.setRenderParameter("renderPage", renderPageName);  
	 } 
	 
	 
	 
	 /** This method will calculate the Comments and list of Web Contents and provide the date to the view/
		 * 
		 * @param actionRequest
		 * @param actionResponse
		 * @param model
		 * @throws SystemException
		 * @throws PortalException
		 * @throws SQLException 
		 */
		public void mostCommentedArticleReportOrderedByArticle(ActionRequest actionRequest,
				ActionResponse actionResponse) throws SystemException,
				PortalException, SQLException {
	
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			themeDisplay.getCompanyId();
			long groupId = themeDisplay.getScopeGroupId();
			List<JournalArticle> articles = Collections
					.synchronizedList(new ArrayList<JournalArticle>());			
			
			int start = 0;
			int end = 10000;			
			long classNameId = 0;
			int status = 0;
			
			try {
				articles = JournalArticleLocalServiceUtil.search(groupId,
						classNameId, status, start, end);
	
			} catch (Exception e) {
	
			}
	
			List<String> articleNameList = new ArrayList<String>();
			List<Long> totalNumberOfContent = new ArrayList<Long>();
			List<String> articleIDList = new ArrayList<String>();						
			List<String> completeUrlList = new ArrayList<String>();			     
			List<Long> classPKList = new ArrayList<Long>();			
			List<Integer> msgCountList = new ArrayList<Integer>();
			
			List<MostCommentedArticle> mostCommentedArticle = new ArrayList<MostCommentedArticle>();
			
			String articleTitleCurrentValue = null;			
			
			for (JournalArticle article : articles) {
	
				String articleIds = article.getArticleId();
				articleIDList.add(articleIds);
				
				// Get the URL and add into List
				url = getThisURL(actionRequest);			
				String completeUrl = url + articleIds;
				completeUrlList.add(completeUrl);	
				
				articleTitleCurrentValue = article.getTitleCurrentValue();
				articleNameList.add(articleTitleCurrentValue);
				
				long resourcePK = article.getResourcePrimKey();
				classPKList.add(resourcePK);				
				
				// This count the number of comments on each content and list will pupulate on the screen.
				int messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(10109, resourcePK, status);
				msgCountList.add(messagesCount);
			
				long noOfComments = article.getClassPK();
				totalNumberOfContent.add(noOfComments);	
				
				// Bind all required item list
				MostCommentedArticle mca = new MostCommentedArticle(articleTitleCurrentValue, messagesCount, completeUrl);
				
				mca.setArticleTitle(articleTitleCurrentValue);
				mca.setTotalMessageCount(messagesCount);
				mca.setCompleteUrl(completeUrl);
								
				mostCommentedArticle.add(mca);
				
				Collections.sort(mostCommentedArticle ,new MostCommentedArticleComparator());
				//logger.info("Sorted list entries: ");
		        for(MostCommentedArticle e:mostCommentedArticle){
		            //logger.info("XXX" + e.getArticleTitle());
		        }
		        
				actionRequest.setAttribute("mostCommentedArticle", mostCommentedArticle);	
			}			
		}
		
		
	
		/**
		 * This method will calculate the Rating - Total Count, Average Score, Total Score for the article
		 * @param actionRequest
		 * @param actionResponse
		 * @throws SystemException
		 * @throws PortalException
		 */
		public void ratingStatsReport(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException,
				PortalException {
	
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			themeDisplay.getCompanyId();
			long groupId = themeDisplay.getScopeGroupId();
			List<JournalArticle> articles = Collections
					.synchronizedList(new ArrayList<JournalArticle>());
			int start = 0;
			int end = 10000;			
			long classNameId = 0;
			int status = 0;
			
			try {
				articles = JournalArticleLocalServiceUtil.search(groupId,
						classNameId, status, start, end);
	
			} catch (Exception e) {
	
			}
	
			List<String> articleNameList = new ArrayList<String>();
			List<Double> averageScoreList = new ArrayList<Double>();
			List<Integer> totalEntriesList = new ArrayList<Integer>();
			List<Double> totalScoreList = new ArrayList<Double>();
			List<Integer> totalNumberOfContent = new ArrayList<Integer>();
			List<String> articleIDList = new ArrayList<String>();			
			List<String> completeUrlList = new ArrayList<String>();	
			
			List<MostRatedArticle> mostRatedArticle = new ArrayList<MostRatedArticle>();
			
			String articleTitleCurrentValue = null;
	
			for (JournalArticle article : articles) {
	
				// Get Article Id List
				String articleIds = article.getArticleId();
				articleIDList.add(articleIds);
				
				// Get Article Title List
				article.getTitle();
				articleTitleCurrentValue = article.getTitleCurrentValue();
				articleNameList.add(articleTitleCurrentValue);
				
				// Get the URL and add into List
				url = getThisURL(actionRequest);			
				String completeUrl = url + articleIds;
				
				// Get the Complete URL for the link to Edit the web Content.
				completeUrlList.add(completeUrl);
	
				long articleResourcePK = article.getResourcePrimKey();
				
				RatingsStats ratingsList = RatingsStatsLocalServiceUtil.getStats(
						"com.liferay.portlet.journal.model.JournalArticle",
						articleResourcePK);
	
				// Add All article and generate the size of Items
				totalNumberOfContent.add(articleNameList.size());
	
				// Get the Average Score
				Double averageScore = ratingsList.getAverageScore();
				averageScoreList.add(averageScore);
				
				// Get the total Entries
				Integer totalEntries = ratingsList.getTotalEntries();
				totalEntriesList.add(totalEntries);
				
				// Get the total Score
				Double totalScore = ratingsList.getTotalScore();
				totalScoreList.add(totalScore);
				
				
				MostRatedArticle mra = new MostRatedArticle(articleTitleCurrentValue, totalEntries, averageScore, totalScore, completeUrl);
				
				mra.setArticleTitle(articleTitleCurrentValue);
				mra.setTotalEntries(totalEntries);
				mra.setAverageScore(averageScore);
				mra.setTotalScore(totalScore);
				mra.setCompleteUrl(completeUrl);
				
				mostRatedArticle.add(mra);
								
				Collections.sort(mostRatedArticle ,new MostRatedArticleComparator());
				//logger.info("Sorted list entries: ");
		        for(MostRatedArticle e:mostRatedArticle){
		        	//logger.info("XXX" + e.getArticleTitle());
		        }				
		        actionRequest.setAttribute("mostRatedArticle", mostRatedArticle);				
			}	
		}
		
		
		/**
		 * This method will generate the URL to link the page to edit the web content
		 * 
		 * @param actionRequest
		 * @return
		 */
		private String getThisURL(ActionRequest actionRequest) {
	
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			themeDisplay.getPortalURL();
	
			String protocol = "http://";
			if (actionRequest.isSecure()) {
				protocol = "https://";
			}
					
			String controlUrl1 = "/group/control_panel/manage?p_p_auth=rwon0UBG&p_p_id=15&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&doAsGroupId=10184&refererPlid=10187&controlPanelCategory=current_site.content&_15_struts_action=%2Fjournal%2Fedit_article&_15_redirect=http%3A%2F%2F";
			String controlUrl2 = "localhost";
			String controlUrl3 = "%3A8080%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_auth%3Drwon0UBG%26p_p_id%3D15%26p_p_lifecycle%3D0%26p_p_state%3Dmaximized%26p_p_mode%3Dview%26doAsGroupId%3D10184%26refererPlid%3D10187%26controlPanelCategory%3Dcurrent_site.content&_15_groupId=10184&_15_folderId=0&_15_articleId=";
			
			String controlUrl = controlUrl1 + controlUrl2 + controlUrl3;
			
			String serverPath = protocol + actionRequest.getServerName() + ":"
					+ actionRequest.getServerPort() + controlUrl;
			
			serverPath += "";
			return serverPath;
		}
	 
	 
	}  