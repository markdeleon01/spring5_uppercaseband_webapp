/**
 * 
 */
package com.uppercaseband.services;

import com.uppercaseband.api.v1.model.ArticleListDTO;

/**
 * @author markdeleon
 *
 */
public interface ArticleService {
	
	ArticleListDTO getAllArticles();
	
	ArticleListDTO getArticlesByCategory(String category);

}
