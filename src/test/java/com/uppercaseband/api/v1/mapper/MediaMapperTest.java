/**
 * 
 */
package com.uppercaseband.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.uppercaseband.api.v1.model.MediaDTO;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;

/**
 * @author markdeleon
 *
 */
public class MediaMapperTest {
	
	public static final String IMAGE = "IMAGE";
	
	MediaMapper mediaMapper = MediaMapper.INSTANCE;
	
	
	@Test
	public void mediaToMediaDTO() throws Exception {
		
		//given
		Media media = new Media();
		media.setType(MediaType.IMAGE);
		
		//when
		MediaDTO mediaDto = mediaMapper.mediaToMediaDTO(media);
		
		//then
		assertEquals(media.getType().name(), mediaDto.getType());
	}
	
	
	@Test
	public void mediaDTOtoMedia() throws Exception {
		
		//given
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setType(IMAGE);
		
		//when
		Media media = mediaMapper.mediaDTOToMedia(mediaDTO);
		
		//then
		assertEquals(mediaDTO.getType(), media.getType().name());
	}

}
