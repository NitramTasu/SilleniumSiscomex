package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorPesquisaMoedaNeg extends Extrator{

	public ExtratorPesquisaMoedaNeg(WebDriver driver, Robot rb) {
		super(driver, rb);
	}

	public void extrairDados(boolean autenticar){
		//driver.findElement(By.linkText("Mercadoria")).click();
		try {
			this.extrair("img[alt='Pesquisar Moeda Negociada']", "Pesquisar Moeda Negociada",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
