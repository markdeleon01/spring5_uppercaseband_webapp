/**
 * 
 */
package com.uppercaseband.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.uppercaseband.api.v1.model.ArticleDTO;
import com.uppercaseband.domain.Article;

/**
 * @author markdeleon
 *
 */
public class ArticleMapperTest {
	
	public static final String TITLE = "someTitle";
	
	ArticleMapper articleMapper = ArticleMapper.INSTANCE;
	
	
	@Test
	public void articleToArticleDTO() throws Exception {
		
		//given
		Article article = new Article();
		article.setTitle(TITLE);
		
		//when
		ArticleDTO articleDto = articleMapper.articleToArticleDTO(article);
		
		//then
        assertEquals(article.getTitle(), articleDto.getTitle());
	}
	
	
	@Test
	public void articleDTOtoArticle() throws Exception {
		
		//given
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setTitle(TITLE);
		
		//when
		Article article = articleMapper.articleDTOToArticle(articleDTO);
		
		//then
		assertEquals(articleDTO.getTitle(), article.getTitle());
	}

}
