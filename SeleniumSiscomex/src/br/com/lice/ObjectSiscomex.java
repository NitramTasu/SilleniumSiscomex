package br.com.lice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.log.PrinterLogger;

public class ObjectSiscomex {
	
	protected WebDriver driver;
	protected LI li;
	
	public ObjectSiscomex(){
		
	}
	
	public ObjectSiscomex (WebDriver driver, LI li) {
		this.driver = driver;
		this.li = li;
	}
	
	public ObjectSiscomex (WebDriver driver) {
		this.driver = driver;
		
	}
	
	public LI getLi() {
		return li;
	}

	public void setLi(LI li) {
		this.li = li; 
	}

	protected void preencherCampo(String nomeCampo, String valor) {
		if (isElementPresent(By.id(nomeCampo))) {
			
			//driver.findElement(By.id(nomeCampo)).clear();
			cleanField(nomeCampo);
			driver.findElement(By.id(nomeCampo)).sendKeys(valor);
		} else {
			System.out.println("Elemento :" + nomeCampo);
			printLog("Elemento não encontrado: " + nomeCampo + "\n"
					+ "Tela que pertence: "
					+ this.getClass().getSimpleName().toString());
			driver.quit();
		}
	}
	protected void selecionarCombo(String nomeCampo, String opcao){
		if (isElementPresent(By.id(nomeCampo))) {
			
			Select select = new Select(driver.findElement(By
					.id(nomeCampo)));
			
			try {
				select.selectByVisibleText(opcao);
			} catch (NoSuchElementException e) {
				printLog("Opção ->"+opcao+" do elemento "+nomeCampo+" não encontrado\n"
						+ "Tela que pertence: "
						+ this.getClass().getSimpleName().toString());
				driver.quit();
			}
			
			

		} else {
			System.out.println("Elemento :" + nomeCampo);
			printLog("Elemento não encontrado: " + nomeCampo + "\n"
					+ "Tela que pertence: "
					+ this.getClass().getSimpleName().toString());
			driver.quit();
		}
	}
	//Função que substitui o clear() do Selenium, por não funcionar corretamente
	public void cleanField(String nomeCampo) {
		
		if(driver.findElement(By.id(nomeCampo)).getAttribute("value").trim().length() != 0){
			driver.findElement(By.id(nomeCampo)).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		}
		
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*private void printLog(String errorMsg) {
		PrintWriter writer = null;
		String dir = "uzsisc\\li\\env\\erro";
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		
		criaDiretorio(dir);
		
		try {
			writer = new PrintWriter(dir+"\\log_SiscomexInte"+format1.format(cal.getTime())+".txt", "UTF-8");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(errorMsg);
		writer.close();
	}
	*/
	private void printLog(String errorMsg) {
		PrinterLogger pl  = new PrinterLogger();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		
		//pl.printLog(errorMsg, "c:\\uzsisc\\li\\env\\erro", "\\msgSiscomex"+format1.format(cal.getTime()), PrinterLogger.TEXTO);
		pl.printLog(errorMsg, "c:\\uzsisc\\li\\env\\erro", "\\msgSiscomex", PrinterLogger.TEXTO);
	}
	protected void selection (String idSelect, String option) {
		System.out.println("O driver : "+driver);
		try {
			Select select = new Select(driver.findElement(By.id(idSelect)));
			select.selectByVisibleText(option);
		} catch (Exception e) {
			PrinterLogger printL = new PrinterLogger();
			printL.printLog(e.getMessage(), "c:\\uzsisc\\log", "LogErroOpcaoCombo", PrinterLogger.TEXTO);
			driver.close();
		}
	}

	protected void verifyAlert() {
		System.out.println("Verificando se foi exibido alerta");
		
		try {
			Alert alert = driver.switchTo().alert();
			
			System.out.println("Alerta capturado. Mensagem: "+alert.getText());
			printLog(alert.getText());
			driver.quit();
		} catch (NoAlertPresentException e) {
			System.out.println("Não alert exibido");
		}
		
	}

}
