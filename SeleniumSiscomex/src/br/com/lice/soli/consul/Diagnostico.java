package br.com.lice.soli.consul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;

public class Diagnostico extends ObjectSiscomex{
	
	public Diagnostico (WebDriver driver, LI li){
		super(driver, li );
	}
	
	public  void menu(Actions builder) throws InterruptedException {
		
		builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem5']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem14']"))).click().build().perform();
	    Thread.sleep(500);
	}
	
	private void consultarDiagnostico(){
		
		preencherCampo("numeroTransmissao", "123");
		preencherCampo("identificacao", "123");
		preencherCampo("cnpjImportador", "123");
		preencherCampo("cpfImportador", "123");
		preencherCampo("cpfUsuario", "123");
		preencherCampo("dtInicial", "22012015");
		preencherCampo("dtFinal", "15012015");
		
		driver.findElement(By.id("enviar")).click();
		
		verifyAlert();
		
	}
	public void diagnosticar(Actions builder)
			throws InterruptedException {
		menu(builder);
		consultarDiagnostico();
	}
}
