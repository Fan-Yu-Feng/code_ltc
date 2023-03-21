// package com.util;
//
// import cn.hutool.core.io.FileUtil;
// import org.opencv.core.Core;
// import org.opencv.core.Mat;
// import org.opencv.core.Size;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.Imgproc;
//
// import java.io.File;
//
//
// /**
//  * <a href="https://github.com/opencv/opencv/releases/tag/4.7.0">opencv jar 包等下载地址</a>
//  * <a href="https://blog.csdn.net/qq_22136439/article/details/103937436">整合 opencv 教程</a>
//  *
//  * @author FYF
//  * @since 2023/1/4 18:20
//  */
// public class ImageUtil {
//
//
//
// 	public static void main(String[] args) {
// 		try {
//
// 			// 增强图片清晰度 该版本需要 java 11 以上
// 			String filePath = "D:\\businessdata\\faceImage";
// 			String ext = "_opencv_enhance.jpg";
//
// 			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
// 			for (int i = 1; i <= 11; i++) {
// 				String fileDir = filePath.concat(File.separator).concat(String.valueOf(i));
// 				File file = new File(fileDir);
// 				File[] files = file.listFiles();
// 				for (File f : files) {
// 					// 前缀 文件名
// 					String prefix = FileUtil.getPrefix(f);
// 					String newFilePath = f.getParentFile().getAbsolutePath().concat(File.separator).concat(prefix).concat(ext);
// 					Mat source = Imgcodecs.imread(f.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
// 					Mat destination = new Mat(source.rows(), source.cols(), source.type());
// 					Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10);
// 					Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
// 					Imgcodecs.imwrite(newFilePath, destination);
// 				}
//
//
// 				// Mat source = Imgcodecs.imread("D:\\businessdata\\faceImage\\1\\371481198411107517_01.jpg",Imgcodecs.IMREAD_COLOR);
// 				// Mat destination = new Mat(source.rows(),source.cols(),source.type());
// 				// Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
// 				// Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
// 				// Imgcodecs.imwrite("D:\\businessdata\\faceImage\\1\\371481198411107517_01_opencv_enhance.jpg", destination);
// 			}
// 		} catch (Exception e) {
// 			System.out.println("e = " + e);
// 		}
// 	}
//
//
//
// }