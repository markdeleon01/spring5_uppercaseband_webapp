/**
 * 
 */
package com.uppercaseband.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.uppercaseband.api.v1.model.ArticleDTO;
import com.uppercaseband.domain.Article;

/**
 * @author markdeleon
 *
 */

@Mapper		//this mapper is implemented via MapStruct
public interface ArticleMapper {
	
	ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
	
	ArticleDTO articleToArticleDTO(Article article);
	
	Article articleDTOToArticle(ArticleDTO articleDTO);

}
