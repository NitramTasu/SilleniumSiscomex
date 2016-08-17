package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorModalidadePag extends Extrator{

	public ExtratorModalidadePag(WebDriver driver, Robot rb) {
		super(driver, rb);
		// TODO Auto-generated constructor stub
	}
	
	public void extrairDados(boolean autenticar){
		driver.findElement(By.linkText("Negocia��o")).click();

		//driver.findElement(By.cssSelector("img[alt=\"Pesquisar Regime de Tributa��o\"]")).click();

		try {
			extrair("img[alt=\"Pesquisar Modalidade Pagamento\"]", "Pesquisar Modalidade Pagamento",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
