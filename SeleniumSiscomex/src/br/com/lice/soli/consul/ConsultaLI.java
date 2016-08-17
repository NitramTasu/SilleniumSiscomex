package br.com.lice.soli.consul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;
import br.com.log.PrinterLogger;

public class ConsultaLI extends ObjectSiscomex{

	public ConsultaLI(WebDriver driver, LI li ) {
		super(driver, li );
	}
	public  void menu(Actions builder) throws InterruptedException {
			
		builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem5']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem14']"))).build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem15']"))).click().build().perform();
	    Thread.sleep(500);
	}
	
	private void consultar(){
		preencherCampo("numeroLI", "123");
		preencherCampo("cnpjImportador", "123");
		preencherCampo("cpfImportador", "123");
		
		//-----------------Condições de Mercadoria------------------------------------------
		selection("situacao", "Em Exigência");
	    
	    
	    //----------------------------------------------------------------------------------
	    preencherCampo("codTratamentoAdm", "123");
	    preencherCampo("cdSubItemNCM", "123");
	    preencherCampo("dtInicial", "22082014");
	    preencherCampo("dtFinal", "22012015");
	    
	    driver.findElement(By.id("enviar")).click();
	    verifyAlert();
	}
	
	public void consultaLI(Actions builder)	throws InterruptedException {
		menu(builder);
		consultar();
	}

}
