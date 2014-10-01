package com.pradeep.portal.ratings.comment.util;

import java.util.Comparator;

import com.pradeep.portal.ratings.comment.impl.MostCommentedArticle;



/**
 * 
 * @author pbadhai : Pradeep K. Badhai
 * 		   emai: erpkb.sharma@gmail.com
 *
 */
public class MostCommentedArticleComparator implements Comparator<MostCommentedArticle> {

	/**
	 * Compare the most commented article among the articles.
	 */
	public int compare(MostCommentedArticle a, MostCommentedArticle b){
		
		if(a.getTotalMessageCount() < b.getTotalMessageCount())
			return 1;
		else{
			return -1;
		}		
	}
}
