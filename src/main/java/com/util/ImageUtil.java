package com.util;

import cn.hutool.core.io.FileUtil;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;


/**
 * <a href="https://github.com/opencv/opencv/releases/tag/4.7.0">opencv jar 包等下载地址</a>
 * <a href="https://blog.csdn.net/qq_22136439/article/details/103937436">整合 opencv 教程</a>
 *
 * @author FYF
 * @since 2023/1/4 18:20
 */
public class ImageUtil {
	
	public static BufferedImage sharpen(BufferedImage image) {
		float[] elements = {0.0f, -1.0f, 0.0f, -1.0f, 5.0f, -1.0f, 0.0f, -1.0f, 0, 0f};
		BufferedImage bimg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		
		cop.filter(image, bimg);
		return bimg;
	}
	
	
	public static void main(String[] args) {
		try {
			
			// 增强图片清晰度 该版本需要 java 11 以上
			String filePath = "D:\\businessdata\\faceImage";
			String ext = "_opencv_enhance.jpg";
			
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			for (int i = 1; i <= 11; i++) {
				String fileDir = filePath.concat(File.separator).concat(String.valueOf(i));
				File file = new File(fileDir);
				File[] files = file.listFiles();
				for (File f : files) {
					// 前缀 文件名
					String prefix = FileUtil.getPrefix(f);
					String newFilePath = f.getParentFile().getAbsolutePath().concat(File.separator).concat(prefix).concat(ext);
					Mat source = Imgcodecs.imread(f.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
					Mat destination = new Mat(source.rows(), source.cols(), source.type());
					Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10);
					Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
					Imgcodecs.imwrite(newFilePath, destination);
				}
				
				
				// Mat source = Imgcodecs.imread("D:\\businessdata\\faceImage\\1\\371481198411107517_01.jpg",Imgcodecs.IMREAD_COLOR);
				// Mat destination = new Mat(source.rows(),source.cols(),source.type());
				// Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
				// Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
				// Imgcodecs.imwrite("D:\\businessdata\\faceImage\\1\\371481198411107517_01_opencv_enhance.jpg", destination);
			}
		} catch (Exception e) {
			System.out.println("e = " + e);
		}
	}
	
	private static BufferedImage read(File file) throws IOException {
		return ImageIO.read(file);
	}
	
	public static BufferedImage blur(BufferedImage image) {
		float[] elements = {0.11111f, 0.11111f, 0.11111f, 0.11111f, 0.11111f, 0.11111f, 0.11111f, 0.11111f, 0.11111f};
		BufferedImage bimg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		
		cop.filter(image, bimg);
		return bimg;
	}
	
	
}