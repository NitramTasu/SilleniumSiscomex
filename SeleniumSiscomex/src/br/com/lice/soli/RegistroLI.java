package br.com.lice.soli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;

public class RegistroLI extends ObjectSiscomex{

	public RegistroLI (WebDriver driver, LI li){
		super(driver, li);
	}
	
	public  void menu(Actions builder) throws InterruptedException {
		
		builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
	    Thread.sleep(500);
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
	    Thread.sleep(500);
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem4']"))).click().build().perform();
	    Thread.sleep(500);
	}
	
	private void registrarLI(){

		
		preencherCampo("indentificacao", "123");
		preencherCampo("cnpjImportador", "123");
		preencherCampo("cpfImportador", "123");
		preencherCampo("cpfUsuario", "123");
		preencherCampo("dtInicial", "123");
		preencherCampo("dataFinal", "123");
		
		driver.findElement(By.id("enviar")).click();
	}
	
	public void registrarLI(Actions builder)throws InterruptedException {
		menu(builder);
		registrarLI();
	}

}
