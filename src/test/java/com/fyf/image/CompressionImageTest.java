package com.fyf.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author FYF
 * @since 2023/3/21 19:36
 */
public class CompressionImageTest {

	

	@Test
	public void compressionImage() throws IOException {
		File destinationDir = new File("D:\\Desktop\\st\\image");
		
		Thumbnails.of(Objects.requireNonNull(new File("D:\\Desktop\\st\\image").listFiles()))
				.size(90, 55)
				.outputFormat("jpg")
				.toFiles(destinationDir,Rename.PREFIX_DOT_THUMBNAIL);
	}
	
	
}