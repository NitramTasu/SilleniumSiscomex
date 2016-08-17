package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.ext.Extrator;

public class ExtratorAcordoAladi extends Extrator{

	public ExtratorAcordoAladi(WebDriver driver, Robot rb) {
		super(driver, rb);
		// TODO Auto-generated constructor stub
	}
	
	public void extrairDados(boolean autenticar){
		driver.findElement(By.linkText("Negociação")).click();

		new Select(driver.findElement(By.id("cdTipoAcordoTar"))).selectByVisibleText("ALADI");
		driver.findElement(By.cssSelector("img[alt=\"Pesquisar Acordo ALADI\"]")).click();

		try {
			extrair("img[alt=\"Pesquisar Acordo ALADI\"]", "Pesquisar Acordo ALADI",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
