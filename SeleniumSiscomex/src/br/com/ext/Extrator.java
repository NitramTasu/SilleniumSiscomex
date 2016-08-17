package br.com.ext;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.log.PrinterLogger;

public class Extrator {
	protected WebDriver driver;
	private String mainWinID;
	private Robot rb;
	
	public Extrator(WebDriver driver, Robot rb) {
		this.driver = driver;
		this.mainWinID = driver.getWindowHandle();
		this.rb = rb;
	}
	public  void encontrarPopUp() {
		Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
	    Iterator<String> itererator = windowId.iterator();
	    
	    //String mainWinID = itererator.next();
	    String  newAdwinID = itererator.next();
	    
	    System.out.println("*******Janela principal: "+mainWinID);
	    System.out.println("*******Janela do popup que ficará em foco: "+newAdwinID);
	    
	    if(!newAdwinID.equals(mainWinID)){
	    	driver.switchTo().window(newAdwinID);
		    System.out.println(driver.getTitle());
	    }else{
	    	newAdwinID = itererator.next();
	    	driver.switchTo().window(newAdwinID);
		    System.out.println(driver.getTitle());
	    }

	    
	}
	public  void encontrarPopUpTeste() {
		Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
	    Iterator<String> itererator = windowId.iterator();
	    
	    String 	mainWinID = itererator.next();
	    String  newAdwinID = itererator.next();
	    
	    System.out.println("*******Janela principal: "+mainWinID);
	    System.out.println("*******Janela do popup que ficará em foco: "+newAdwinID);

	    driver.switchTo().window(newAdwinID);
	    System.out.println(driver.getTitle());
	}
	public void aceitaAuten() throws InterruptedException{
		rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);    
	    Thread.sleep(4000);
	}
	public void gravarArquivo(String conteudo, String fileName) throws IOException{
		PrinterLogger pl  = new PrinterLogger();
		pl.printLog(conteudo, "uzsisc\\li\\tab", fileName, PrinterLogger.CSV);
		
	}
	protected void extrair(String btnSearch, String fileName, boolean autenticar) throws InterruptedException {
		String conteudo = "";
		try {
			System.out.println("Clica no botão : "+btnSearch);
			driver.findElement(By.cssSelector(btnSearch)).click();
			
			Thread.sleep(2000);
			
			if (autenticar) {
				aceitaAuten();
			}
		
		    encontrarPopUp();
		    Thread.sleep(1000);
		    WebElement table_element = driver.findElement(By.id("TABLE_3"));
	        List<WebElement> tr_collection=table_element.findElements(By.xpath("//table[@id='TABLE_3']/tbody/tr"));

	        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	        System.out.println("Extraindo dados da tabela: "+fileName);
	       
	        //Executa função JavaScript para extrair os dados das tabelas(muito mais rapido do que utilizar a função getText()

	        conteudo = (String)((JavascriptExecutor)driver).executeScript(" var s=''; for (var l = 1; l < document.getElementById('TABLE_3').rows.length; l++)  {  for (var c = 0; c < document.getElementById('TABLE_3').rows[0].cells.length; c++) {	s += document.getElementById('TABLE_3').rows[l].cells.item(c).innerText; if(document.getElementById('TABLE_3').rows[0].cells.length-1 != c){s += ';';}	}  s += '\\r\\n';} return s;", table_element).toString();
	        
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
		
        System.out.println("Gravando em arquivo...");
		try {
			gravarArquivo(conteudo,fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
