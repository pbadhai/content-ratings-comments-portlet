package com.pradeep.portal.ratings.comment.impl;

/**
 * 
 * @author pbadhai : Pradeep K. Badhai
 * 		   emai: erpkb.sharma@gmail.com
 *
 */
public class MostCommentedArticle {
	
	private String articleTitle;
	private int totalMessageCount;
	private String completeUrl;
	
	/**
	 * 
	 * @param articleTitleName
	 * @param messageCount
	 * @param completeUrl
	 */
	public MostCommentedArticle(String articleTitleName,int messageCount, String completeUrl ) {
		
		this.articleTitle = articleTitleName;
		this.totalMessageCount = messageCount;
		this.completeUrl = completeUrl;		
	}
	
	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public int getTotalMessageCount() {
		return totalMessageCount;
	}

	public void setTotalMessageCount(int totalMessageCount) {
		this.totalMessageCount = totalMessageCount;
	}	
	
	public String getCompleteUrl() {
		return completeUrl;
	}

	public void setCompleteUrl(String completeUrl) {
		this.completeUrl = completeUrl;
	}

	
	
	public String toString(){
        return "Article Name: "+this.articleTitle+"-- Message Count: "+this.totalMessageCount;
    }
}
