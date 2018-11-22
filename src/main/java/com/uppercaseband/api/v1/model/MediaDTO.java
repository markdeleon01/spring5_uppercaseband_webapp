/**
 * 
 */
package com.uppercaseband.api.v1.model;

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
public class MediaDTO {
	
	private String type;
	
	private String url;

}
