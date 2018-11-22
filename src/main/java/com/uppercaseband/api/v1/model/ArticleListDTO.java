/**
 * 
 */
package com.uppercaseband.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author markdeleon
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListDTO {	//wrapper object for the list of articles
	
	List<ArticleDTO> articles;

}
