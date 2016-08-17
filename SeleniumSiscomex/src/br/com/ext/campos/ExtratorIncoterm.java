package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorIncoterm extends Extrator {

	public ExtratorIncoterm(WebDriver driver2, Robot rb) {
		super(driver2, rb);
	}

	public void extrairDados(boolean autenticar) {
		// driver.findElement(By.linkText("Mercadoria")).click();
		try {
			extrair("img[alt='Pesquisar Incoterm']", "Pesquisar Incoterm",	autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
