/**
 * 
 */
package com.uppercaseband.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.uppercaseband.api.v1.model.ArticleDTO;
import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;

/**
 * @author markdeleon
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
		ArticleMapperImpl.class,
		MediaMapperImpl.class})
public class ArticleMapperTest {
	
	public static final String TITLE = "someTitle";
	public static final String DESCRIPTION = "someDescription";
	public static final String PATH = "images/image.png";

	@Autowired
	ArticleMapper articleMapper;
	
	
	@Test
	public void articleToArticleDTO() throws Exception {
		
		//given
		Article article = new Article();
		article.setId(1L);
		article.setTitle(TITLE);
		article.setDescription(DESCRIPTION);
		article.setDisplayOrder(100);
		article.setCategory(Category.HIGHLIGHTS);
		Media media = new Media();
		media.setId(1L);
		media.setType(MediaType.IMAGE);
		media.setPath(PATH);
		article.setMedia(media);
		
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
