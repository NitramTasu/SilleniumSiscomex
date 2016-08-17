package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorNaladish extends Extrator {
	
	public ExtratorNaladish(WebDriver driver,Robot rb){
		super(driver,rb);
	}
	public void extrairDados(boolean autenticar){
		
		driver.findElement(By.linkText("Mercadoria")).click();
		try {
			this.extrair("img[alt='Pesquisar NaladiSh']", "NaladiSh",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
