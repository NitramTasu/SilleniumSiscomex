package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorFundLegTrib extends Extrator{

	public ExtratorFundLegTrib(WebDriver driver2, Robot rb) {
		super(driver2, rb);
	}
	
	public void extrairDados(boolean autenticar, int codTrib){
		
		driver.findElement(By.id("cdRegimeTrib")).clear();
		driver.findElement(By.id("cdRegimeTrib")).sendKeys(""+codTrib);
		
		try {
			extrair("img[alt=\"Pesquisar Fundamento Legal\"]", "Fundamento Legal da Tributação Codigo "+codTrib,autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
