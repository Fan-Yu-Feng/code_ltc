package com.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF @Description
 * @date 2022/5/26
 */
public class pdfBoxUtil {

  public static void main(String[] args) throws IOException {

    File file = new File("D:\\businessdata\\irs\\app01\\lyf.pdf");
    PDDocument doc = PDDocument.load(file);

    InputStream in;
    in = new FileInputStream(file);
    List<PDSignatureField> signatureFields = doc.getSignatureFields();

    for (PDSignatureField sF : signatureFields) {
      List<PDAnnotationWidget> widgets = sF.getWidgets();
      PDAnnotationWidget pdAnnotationWidget = widgets.get(0);
      PDRectangle rectangle = pdAnnotationWidget.getRectangle();

      sF.getWidgets().get(0).setRectangle(new PDRectangle());
    }
    PDDocumentCatalog documentCatalog = doc.getDocumentCatalog();
    PDAcroForm acroForm = documentCatalog.getAcroForm();
    PDFieldTree fieldTree = acroForm.getFieldTree();
    List<PDField> fields = new ArrayList<>();
    for (PDField pdField : fieldTree) {
      if (pdField instanceof PDSignatureField) {
        fields.add(pdField);
      }
    }
    acroForm.flatten(fields, true);

    File file1 = new File("D:\\businessdata\\irs\\app01\\lyf_remove.pdf");
    OutputStream os = null;
    os = new FileOutputStream(file1);
    doc.save(os);
    doc.close();
    os.close();
    in.close();
  }
}
