package br.com.ext.campos;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;

import br.com.ext.Extrator;

public class ExtratorURF extends Extrator {

	public ExtratorURF(WebDriver driver, Robot rb) {
		super(driver, rb);
		
	}
	public void extrairDados(boolean autenticar){
		
		try {
			this.extrair("img[alt=\"Pesquisar Tabela de URF\"]", "TabelaURF",autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
