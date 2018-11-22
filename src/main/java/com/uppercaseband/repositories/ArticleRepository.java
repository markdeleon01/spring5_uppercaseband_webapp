/**
 * 
 */
package com.uppercaseband.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;


/**
 * @author markdeleon
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

	//Spring Data will provide us with functionalities out of the box from JpaRepository
	
	List<Article> findByCategory(Category c);

}
