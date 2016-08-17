package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.ext.Extrator;

public class ExtratorMotivoCober extends Extrator {

	public ExtratorMotivoCober(WebDriver driver, Robot rb) {
		super(driver, rb);
		// TODO Auto-generated constructor stub
	}
	
	public void extrairDados(boolean autenticar){
		driver.findElement(By.linkText("Negociação")).click();

		//driver.findElement(By.cssSelector("img[alt=\"Pesquisar Regime de Tributação\"]")).click();
		new Select(driver.findElement(By.id("tipoCoberturaCambial"))).selectByVisibleText("Sem Cobertura");


		try {
			extrair("img[alt=\"Pesquisar Motivo Cobertura Cambial\"]", "Pesquisar Motivo Cobertura Cambial",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
