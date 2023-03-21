package com.fyf.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author FYF
 * @since 2023/3/21 19:36
 */
public class CompressionImageTest {

	

	@Test
	public void compressionImage() throws IOException {
		
		Thumbnails.of(new File("D:\\Desktop\\st\\image").listFiles())
				.size(640, 480)
				.outputFormat("jpg")
				.toFiles(Rename.PREFIX_DOT_THUMBNAIL);
	}
	
	
}