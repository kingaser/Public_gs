package org.park.public_bpss.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class ImgTest {

  public static void main(String[] args) throws TesseractException {

    String inputfile = "D:/image/car7.png";

    Tesseract tesseract = new Tesseract();
    tesseract.setDatapath("D:\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
    tesseract.setLanguage("kor");

    String fullText = tesseract.doOCR(new File(inputfile));

    System.out.println("=================================");
    System.out.println("test:" + fullText);

  }

}
