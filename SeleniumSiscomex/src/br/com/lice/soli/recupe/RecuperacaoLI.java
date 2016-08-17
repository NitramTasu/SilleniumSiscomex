package br.com.lice.soli.recupe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;


public class RecuperacaoLI extends ObjectSiscomex {
	
	public RecuperacaoLI(WebDriver driver, LI li){
		super(driver, li);
	}
	public  void menu(Actions builder) throws InterruptedException {
		
		//Licenciamento de Importação
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
	    Thread.sleep(500);
	    //Solicitações
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    //Licença
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem12']"))).build().perform();
	    Thread.sleep(500);
	    
	    //Recuperação
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem28']"))).build().perform();
	    Thread.sleep(500);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem28']"))).click().build().perform();
	    Thread.sleep(500);
	    
	}
	
	public void criterioDePesquisa(){
		
		preencherCampo("identificacao", li.getIdentificacao());
		//preencherCampo("cnpjImportador", "12543154000109");
		//preencherCampo("cpfImportador", "57270181454");
		//preencherCampo("dtInicial", "22092014");
		//preencherCampo("dtFinal", "22012015");
		
		driver.findElement(By.xpath("//input[@id='enviar']")).click();
		
		verifyAlert();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void recuperarLI(Actions builder) throws InterruptedException{
		menu(builder);
		criterioDePesquisa();
	}

}
