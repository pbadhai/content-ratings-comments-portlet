package com.pradeep.portal.ratings.comment.util;

import java.util.Comparator;

import com.pradeep.portal.ratings.comment.impl.MostRatedArticle;


/**
 * 
 * @author pbadhai : Pradeep K. Badhai
 * 		   emai: erpkb.sharma@gmail.com
 *
 */
public class MostRatedArticleComparator implements Comparator<MostRatedArticle>{

	/**
	 * Compare the highest average score among the articles.
	 */
	public int compare(MostRatedArticle a, MostRatedArticle b){
		
		if(a.getAverageScore() < b.getAverageScore())
			return 1;
		else{
			return -1;
		}		
	}
}
