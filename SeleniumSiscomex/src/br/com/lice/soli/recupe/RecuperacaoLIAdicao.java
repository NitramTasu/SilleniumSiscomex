package br.com.lice.soli.recupe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;


public class RecuperacaoLIAdicao extends ObjectSiscomex{
	
	
	public RecuperacaoLIAdicao(WebDriver driver, LI li){
		super(driver, li);
	}
	public void menu(Actions builder) throws InterruptedException {
			
		//Licenciamento de Importação
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
	    Thread.sleep(500);
	    //Solicitações
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
	    Thread.sleep(500);
	    
	    //Licença
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem7']"))).build().perform();
	    Thread.sleep(500);
	    
	    //Recuperação
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem8']"))).build().perform();
	    Thread.sleep(500);
	    
	    //Solicitação
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem11']"))).build().perform();
	    Thread.sleep(500);
	    
	    //LI a partir da adição
	    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem12']"))).click().build().perform();
	    Thread.sleep(500);
	}
	
	public void recuperar(){
		
		preencherCampo("numeroIdentUsuario", "22012015");
		preencherCampo("numeroIdentificacaoDI", "22012015");
		preencherCampo("numeroAdicao", "22012015");
		
		driver.findElement(By.id("confirmar")).click();
		verifyAlert();
	}
	
	public void recuperarLIAdicao(Actions builder) throws InterruptedException {

		menu(builder);
		recuperar();
	}
}
