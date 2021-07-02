/**
 * 
 */
package com.uppercaseband.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ArticleDTO {		//DTO:  Data Transfer Object

	private String title;
	
	private String description;
	
	@JsonProperty("display_order")
	private int displayOrder;
	
	private String category;
	
	@JsonProperty("sub_content")
	private String subcontent;
	
	private MediaDTO media;
}
