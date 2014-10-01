package com.pradeep.portal.ratings.comment.impl;

/**
 * 
 * @author pbadhai : Pradeep K. Badhai
 * 		   emai: erpkb.sharma@gmail.com
 *
 */
public class MostRatedArticle {
	
	private String articleTitle;
	private Integer totalEntries;
	private double averageScore;
	private double totalScore;
	private String completeUrl;
	
	/**
	 * 
	 * @param articleTitle
	 * @param totalEntries
	 * @param averageScore
	 * @param totalScore
	 * @param completeUrl
	 */
	public MostRatedArticle(String articleTitle, int totalEntries, double averageScore, double totalScore, String completeUrl ) {
		
		this.articleTitle = articleTitle;
		this.totalEntries = totalEntries;
		this.averageScore = averageScore;
		this.totalScore = totalScore;
		this.completeUrl = completeUrl;
				
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}	

	public Integer getTotalEntries() {
		return totalEntries;
	}

	public void setTotalEntries(Integer totalEntries) {
		this.totalEntries = totalEntries;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public String getCompleteUrl() {
		return completeUrl;
	}

	public void setCompleteUrl(String completeUrl) {
		this.completeUrl = completeUrl;
	}

	
}
