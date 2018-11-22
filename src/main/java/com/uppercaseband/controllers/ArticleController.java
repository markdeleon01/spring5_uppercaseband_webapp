/**
 * 
 */
package com.uppercaseband.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uppercaseband.api.v1.model.ArticleListDTO;
import com.uppercaseband.services.ArticleService;


/**
 * @author markdeleon
 *
 */
@RestController
@RequestMapping(ArticleController.BASE_URL)
public class ArticleController {

	//provide a constant for the base URL
    public static final String BASE_URL = "/api/v1/articles";
    
    
    private final ArticleService articleService;


	public ArticleController(ArticleService articleService) {	//Spring will inject the service when the controller constructor is called
		this.articleService = articleService;
	}
    
    
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ArticleListDTO getArticles(@RequestParam Optional<String> category) {
		
		if (category.isPresent()) {
			return articleService.getArticlesByCategory(category.get());			
		} else {
			return articleService.getAllArticles();
		}
		
	}
}
