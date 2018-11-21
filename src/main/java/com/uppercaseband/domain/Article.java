/**
 * 
 */
package com.uppercaseband.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;


/**
 * @author markdeleon
 * 
 */
@Data						//Project Lombok
@Entity						//JPA annotation
public class Article {		//domain object (POJO)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	
	@OneToOne(cascade = CascadeType.ALL)	//will cascade down to related media
	private Media media;
	
	@Lob									//String has 255 characters limit; JPA will store this in a CLOB database field
	private String subcontent;
	
	@Enumerated(value = EnumType.STRING)	//use string enum type instead of ordinal (the default which uses numbers)
	private Category category;
	
}
