/**
 * 
 */
package com.uppercaseband.controllers.v1;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.uppercaseband.api.v1.model.ArticleDTO;
import com.uppercaseband.api.v1.model.ArticleListDTO;
import com.uppercaseband.api.v1.model.MediaDTO;
import com.uppercaseband.controllers.ArticleController;
import com.uppercaseband.services.ArticleService;


/**
 * @author markdeleon
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {ArticleController.class})	//brings up a small set of the Spring context for the web front-end
public class ArticleControllerTest {					//this is essentially an integration test

	@MockBean											//provided by Spring Context - Spring creates the Mockito mock and injects it into this class
	ArticleService articleService;						//instead of MockitoAnnotations.initMocks(this);

    @Autowired
    MockMvc mockMvc; //provided by Spring Context because of @WebMvcTest annotation
	
	ArticleDTO article1;
	ArticleDTO article2;
	ArticleDTO article3;
	
	
	@Before
	public void setUp() throws Exception {

		article1 = new ArticleDTO();
    	article1.setTitle("Tanging Ikaw");
    	article1.setDescription("The brand new single from UPPERCASE released under Radio Insect Records");
    	article1.setSubcontent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>");

    	MediaDTO article1Media = new MediaDTO();
    	article1Media.setType("IMAGE");
    	article1Media.setUrl("/images/tanging_ikaw.png");
    	
    	article1.setMedia(article1Media);
    	
		article2 = new ArticleDTO();    	
    	article2.setTitle("'Time Space Warp' Album Launch");
    	article2.setDescription("May 17, 2013 – Hard Rock Café Toronto");
    	article2.setSubcontent("<p><a href='https://www.facebook.com/pg/cyberpinoyradio/photos/?tab=album&album_id=657041557656169'>SEE EVENT PICS</a></p><p><a href='https://youtu.be/yNt0JV8or3k?list=PL0AgfLYM2K_sKTvDMqLY4sDr8Pi1zadB0'>WATCH EVENT VIDEO</a></p>");

    	MediaDTO article2Media = new MediaDTO();
    	article2Media.setType("IMAGE");
    	article2Media.setUrl("/images/tsw_album.png");
    	
    	article2.setMedia(article2Media);
    	
		article3 = new ArticleDTO();
    	article3.setTitle("'Time Space Warp' Music Video Launch");
    	article3.setDescription("July 12, 2013 – Prestige Bar, North York");
    	
    	MediaDTO article3Media = new MediaDTO();
       	article3Media.setType("VIDEO");
    	article3Media.setUrl("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/ZfNUPtLtH5w\" frameborder=\"0\" allowfullscreen></iframe>");
    	
    	article3.setMedia(article3Media);
	}
	
	
	@Test
	public void getArticlesByCategory() throws Exception {
		
		ArticleListDTO articleListDTO = new ArticleListDTO(Arrays.asList(article1, article2));
		
		given(articleService.getArticlesByCategory(anyString())).willReturn(articleListDTO);	//given that the service call will return the mocked data..
		
		//perform the REST call to the controller to get articles by category
		mockMvc.perform( get(ArticleController.BASE_URL+"?category=HIGHLIGHTS")
						.contentType(MediaType.APPLICATION_JSON) )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.articles", hasSize(2)));
						
	}
	
	
	@Test
	public void getAllArticles() throws Exception {
		
		ArticleListDTO articleListDTO = new ArticleListDTO(Arrays.asList(article1, article2, article3));
		
		given(articleService.getAllArticles()).willReturn(articleListDTO);	//given that the service call will return the mocked data..
		
		//perform the REST call to the controller to get all articles
		mockMvc.perform( get(ArticleController.BASE_URL)
						.contentType(MediaType.APPLICATION_JSON) )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.articles", hasSize(3)));
						
	}

}
