/**
 * 
 */
package com.uppercaseband.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.uppercaseband.api.v1.model.MediaDTO;
import com.uppercaseband.domain.Media;

/**
 * @author markdeleon
 *
 */

@Mapper		//this mapper is implemented via MapStruct
public interface MediaMapper {
	
	MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);
	
	@Mapping(source="path", target="url")
	MediaDTO mediaToMediaDTO (Media media);
	
	@Mapping(source="url", target="path")
	Media mediaDTOToMedia (MediaDTO mediaDTO);

}
