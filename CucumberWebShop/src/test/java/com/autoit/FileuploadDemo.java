package com.autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileuploadDemo {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        
//        driver.get("https://pdf2doc.com/");
//        
//        WebElement upload = driver.findElement(By.xpath("//span[text()='UPLOAD FILES']"));
//        upload.click();
//        
//        try {
//            // Set file path to clipboard
//            String filePath = "C:\\Users\\drcha\\COE-2024-KIOT-EXPLEO-SDET - Technical Assessment - 18 (1).pdf";
//            StringSelection str = new StringSelection(filePath);
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//
//            // Simulate Ctrl+V and Enter
//            Robot rb = new Robot();
//            rb.delay(2000); // Small wait for dialog to appear
//            rb.keyPress(KeyEvent.VK_CONTROL);
//            rb.keyPress(KeyEvent.VK_V);
//            rb.keyRelease(KeyEvent.VK_V);
//            rb.keyRelease(KeyEvent.VK_CONTROL);
//            rb.delay(500);
//            rb.keyPress(KeyEvent.VK_ENTER);
//            rb.keyRelease(KeyEvent.VK_ENTER);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	String downloadFilePath=System.getProperty("user.dir")+File.separator+"downloads";
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", downloadFilePath);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://freetestdata.com/document-files/pdf/");
		WebElement downloadLink=driver.findElement(By.xpath("//*[@class=\"elementor-button-text\"]"));
		downloadLink.click();
		Thread.sleep(5000);
		File downloadedFile=new File(downloadFilePath+"/Free_Test_Data_100KB_PDF.pdf");
		if(downloadedFile.exists()) {
			System.out.println("File is downloaded");
		}else {
			System.out.println("File is not downloaded");
		}
		driver.quit();
		PDDocument document=null;
		try {
			document=Loader.loadPDF(downloadedFile);
			PDFTextStripper pdfstripper=new PDFTextStripper();
			String text=pdfstripper.getText(document);
			document.close();
			System.out.println("Text in PDF:");
			System.out.println(text);
		}catch(IOException e) {
			System.err.println("An error occured while loading or reading the PDF file: "+e.getMessage());
			e.printStackTrace();
		}
	}
}