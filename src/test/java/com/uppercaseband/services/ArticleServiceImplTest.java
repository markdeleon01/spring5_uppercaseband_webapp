/**
 * 
 */
package com.uppercaseband.services;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.uppercaseband.api.v1.mapper.ArticleMapper;
import com.uppercaseband.api.v1.mapper.ArticleMapperImpl;
import com.uppercaseband.api.v1.mapper.MediaMapperImpl;
import com.uppercaseband.api.v1.model.ArticleListDTO;
import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;
import com.uppercaseband.repositories.ArticleRepository;

/**
 * @author markdeleon
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
		ArticleMapperImpl.class,
		MediaMapperImpl.class})
public class ArticleServiceImplTest {

	@Autowired
	ArticleMapper articleMapper;
	
	@Mock
	ArticleRepository articleRepository;
	
	ArticleService articleService;
	
	
	@Before
	public void setUp() throws Exception {
		
        MockitoAnnotations.initMocks(this);	//inject mock objects

        articleService = new ArticleServiceImpl(articleMapper, articleRepository);
	}
	
	
	
	@Test
	public void getAllArticles() throws Exception {
		
		//behaviour-based development
		
		//given
		List<Article> articles = Arrays.asList(getArticle1(), getArticle2());
		given(articleRepository.findAll()).willReturn(articles);
		
		//when
		ArticleListDTO articleDTOs = articleService.getAllArticles();
		
		//then
		then(articleRepository).should(times(1)).findAll();	//repository invokes findAll one time
		assertThat(articleDTOs.getArticles().size(), equalTo(2));
	}
	
	
	@Test
	public void getArticlesByCategory() throws Exception {
		
		//given
		given(articleRepository.findByCategory( any(Category.class) )).willReturn(Arrays.asList(getArticle3()));
		
		//when
		ArticleListDTO articles = articleService.getArticlesByCategory(Category.EVENTS.name());
		
		//then
		assertThat(articles.getArticles().size(), equalTo(1));
	}
	
	
	private Article getArticle1() {
    	Article article1 = new Article();
    	article1.setTitle("Tanging Ikaw");
    	article1.setDescription("The brand new single from UPPERCASE released under Radio Insect Records");
    	article1.setDisplayOrder(100);
    	article1.setCategory(Category.HIGHLIGHTS);
    	article1.setSubcontent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>");
    	
    	Media article1Media = new Media();
    	article1Media.setType(MediaType.IMAGE);
    	article1Media.setPath("/images/tanging_ikaw.png");
    	
    	article1.setMedia(article1Media);
		return article1;
	}


	private Article getArticle2() {
    	Article article2 = new Article();
    	article2.setTitle("'Time Space Warp' Album Launch");
    	article2.setDescription("May 17, 2013 – Hard Rock Café Toronto");
    	article2.setDisplayOrder(200);
    	article2.setCategory(Category.HIGHLIGHTS);
    	article2.setSubcontent("<p><a href='https://www.facebook.com/pg/cyberpinoyradio/photos/?tab=album&album_id=657041557656169'>SEE EVENT PICS</a></p><p><a href='https://youtu.be/yNt0JV8or3k?list=PL0AgfLYM2K_sKTvDMqLY4sDr8Pi1zadB0'>WATCH EVENT VIDEO</a></p>");
    	
    	Media article2Media = new Media();
    	article2Media.setType(MediaType.IMAGE);
    	article2Media.setPath("/images/tsw_album.png");
    	
    	article2.setMedia(article2Media);
    	return article2;
	}
	
	
	private Article getArticle3() {
    	Article article3 = new Article();
    	article3.setTitle("'Time Space Warp' Music Video Launch");
    	article3.setDescription("July 12, 2013 – Prestige Bar, North York");
    	article3.setDisplayOrder(200);
    	article3.setCategory(Category.EVENTS);
    	
    	Media article3Media = new Media();
    	article3Media.setType(MediaType.VIDEO);
    	article3Media.setPath("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/ZfNUPtLtH5w\" frameborder=\"0\" allowfullscreen></iframe>");
    	
    	article3.setMedia(article3Media);
		return article3;
	}
}
