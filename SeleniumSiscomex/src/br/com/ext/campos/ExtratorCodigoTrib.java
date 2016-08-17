package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorCodigoTrib extends Extrator{

	public ExtratorCodigoTrib(WebDriver driver2, Robot rb) {
		super(driver2, rb);
	}
	
	public void extrairDados(boolean autenticar){
		driver.findElement(By.linkText("Negociação")).click();

		driver.findElement(By.cssSelector("img[alt=\"Pesquisar Regime de Tributação\"]")).click();
		try {
			extrair("[alt=\"Pesquisar Regime de Tributação\"]", "Pesquisar Regime de Tributação",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	
}
