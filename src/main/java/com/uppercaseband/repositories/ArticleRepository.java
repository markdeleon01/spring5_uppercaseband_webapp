/**
 * 
 */
package com.uppercaseband.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uppercaseband.domain.Article;


/**
 * @author markdeleon
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

	//Spring Data will provide us with functionalities out of the box from JpaRepository

}
