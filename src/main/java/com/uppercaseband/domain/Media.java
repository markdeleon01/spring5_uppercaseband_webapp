/**
 * 
 */
package com.uppercaseband.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


/**
 * @author markdeleon
 *
 */

@Data					//Project Lombok
@Entity					//JPA annotation
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne			//no need for cascade operations here; allow the Article to own this
	private Article article;
	
	private MediaType type;
	
	private String path;
	
}
