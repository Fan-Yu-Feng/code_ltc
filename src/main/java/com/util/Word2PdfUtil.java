// package com.util;
//
// import com.aspose.words.Document;
// import com.aspose.words.License;
// import com.aspose.words.SaveFormat;
// import com.itextpdf.awt.geom.AffineTransform;
// import com.itextpdf.text.pdf.PdfContentByte;
// import com.itextpdf.text.pdf.PdfImportedPage;
// import com.itextpdf.text.pdf.PdfReader;
// import com.itextpdf.text.pdf.PdfWriter;
//
// import java.io.*;
// import java.nio.file.Files;
// import java.util.List;
//
//
// /**
//  * <a href="https://cloud.tencent.com/developer/article/2021717">java word 转 pdf </a>
//  *
//  * @author Administrator
//  */
// public class Word2PdfUtil {
// 	public static boolean getLicense() {
// 		boolean result = false;
// 		try {
// 			// license.xml应放在..\WebRoot\WEB-INF\classes路径下
// 			InputStream is = Files.newInputStream(new File("G:\\ideaProject\\个人\\code_ltc\\src\\main\\resources\\license.xml").toPath());
// 			License aposeLic = new License();
// 			aposeLic.setLicense(is);
// 			result = true;
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return result;
// 	}
//
//
// 	public static void doc2pdf(String inPath, String outPath) {
// 		if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
// 			return;
// 		}
// 		try {
// 			long old = System.currentTimeMillis();
// 			File file = new File(outPath); // 新建一个空白pdf文档
// 			FileOutputStream os = new FileOutputStream(file);
// 			Document doc = new Document(inPath); // Address是将要被转化的word文档
// 			doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
// 			// EPUB, XPS, SWF 相互转换
// 			long now = System.currentTimeMillis();
// 			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
// 			os.close();
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}
//
//
// 	/*public static void main(String[] args) {
// 		String basePath = "G:\\GoogleDownload\\广东省高考真题\\";
// 		String filePath = "G:\\GoogleDownload\\广东省高考真题\\09-21年广东省高考地理真题\\全国1卷地理\\2010年全国统一高考文综卷地理（全国卷ⅰ）及解析.doc";
//
// 		// File f = new File("G:\\GoogleDownload\\广东省高考真题\\09-21年广东省高考地理真题\\全国1卷地理\\2010年全国统一高考文综卷地理（全国卷ⅰ）及解析.doc");
//
// 		// Word2PdfUtil.doc2pdf(filePath, "G:\\GoogleDownload\\广东省高考真题\\09-21年广东省高考地理真题\\全国1卷地理\\2010年全国统一高考文综卷地理（全国卷ⅰ）及解析.pdf");
//
// 		File baseFile = new File(basePath);
// 		List<String> resultFileName = new ArrayList<>();
// 		ergodic(baseFile, resultFileName);
//
// 		for (String path : resultFileName) {
// 			String extension = FilenameUtils.getExtension(path);
// 			if (extension.equals("doc")) {
// 				File file = new File(path);
// 				file.delete();
// 			}
// 		}
//
//
// 		//
// 		// for (String path : resultFileName) {
// 		// 	String pdfPath = path.replace("doc", "pdf");
// 		// 	Word2PdfUtil.doc2pdf(path, pdfPath);
// 		// }
// 		//
//
// 	}
// 	*/
//
// 	static List<String> ergodic(File file, List<String> resultFileName) {
// 		File[] files = file.listFiles();
// 		if (files == null) {
// 			return resultFileName;// 判断目录下是不是空的
// 		}
// 		for (File f : files) {
// 			if (f.isDirectory()) {// 判断是否文件夹
// 				//resultFileName.add(f.getPath());
// 				ergodic(f, resultFileName);// 调用自身,查找子目录
// 			} else {
// 				resultFileName.add(f.getPath());
// 			}
// 		}
// 		return resultFileName;
// 	}
//
// 	/**
//
// 	 * @author viralpatel.net
//
// 	 *
//
// 	 * @param inputStream Input PDF file
//
// 	 * @param outputStream Output PDF file
//
// 	 * @param fromPage start page from input PDF file
//
// 	 * @param toPage end page from input PDF file
//
// 	 */
//
// 	public static void splitPDF(InputStream inputStream, OutputStream outputStream, int fromPage, int toPage) throws Exception {
//
// 		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
//
// 		try {
//
// 			PdfReader inputPDF = new PdfReader(inputStream);
//
// 			int totalPages = inputPDF.getNumberOfPages();
//
// //make fromPage equals to toPage if it is greater
//
// 			if(fromPage > toPage ) {
//
// 				fromPage = toPage;
//
// 			}
//
// 			if(toPage > totalPages) {
//
// 				toPage = totalPages;
//
// 			}
//
// // Create a writer for the outputstream
//
// 			PdfWriter writer = PdfWriter.getInstance(document,outputStream);
//
// 			document.open();
//
// 			PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
//
// 			PdfImportedPage page;
//
// 			while(fromPage <= toPage) {
//
// 				document.newPage();
//
// 				page = writer.getImportedPage(inputPDF,fromPage);
//
// 				cb.addTemplate(page, AffineTransform.getRotateInstance(0));
//
// 				fromPage++;
//
// 			}
//
// 			outputStream.flush();
//
// 			document.close();
//
// 			outputStream.close();
//
// 		} catch (Exception e) {
//
// 			e.printStackTrace();
//
// 		} finally {
//
// 			if (document.isOpen()) {
// 				document.close();
// 			}
//
// 			try {
//
// 				if (outputStream != null) {
// 					outputStream.close();
// 				}
//
// 			} catch (IOException ioe) {
//
// 				ioe.printStackTrace();
//
// 			}
//
// 		}
//
// 	}
//
// 	public static void main(String[] args) {
//
// 		try {
//
// 			String path = "G:\\WechatFile\\WeChat Files\\wxid_txzjtuu5ha9k22\\FileStorage\\File\\2023-01\\2022高考数学试卷及答案.pdf";
//
// 			Word2PdfUtil.splitPDF(new FileInputStream(path),new FileOutputStream("D:\\output1.pdf"),78,96);
//
// 			// Word2PdfUtil.splitPDF(new FileInputStream("C:\\input.pdf"),new FileOutputStream("C:\\output2.pdf"),13,20);
//
// 		} catch (Exception e) {
//
// 			e.printStackTrace();
//
// 		}
//
// 	}
//
//
// }