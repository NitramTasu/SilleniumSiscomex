package br.com.ext.campos;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ext.Extrator;

public class ExtratorNCM extends Extrator {

	public ExtratorNCM(WebDriver driver, Robot rb) {
		super(driver, rb);
		// TODO Auto-generated constructor stub
	}

	protected void extrair(String btnSearch, String fileName, boolean autenticar)
			throws InterruptedException {
		
		String nomeTabela = "TABLE_7";
		
		System.out.println("Clica no botão : " + btnSearch);
		
		driver.findElement(By.cssSelector(btnSearch)).click();
		
		Thread.sleep(2000);

		//Verifica se é necessário aceitar autenticação
		if (autenticar) {
			aceitaAuten();
		}

		encontrarPopUp();
		Thread.sleep(1000);
		
		driver.findElement(By.name("SelecionarMercadoriaForm")).click();
		driver.findElement(By.xpath("(//input[@id='opcaoBuscaNcm'])[3]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("descricaoNcm")).clear();
		driver.findElement(By.id("descricaoNcm")).sendKeys("a");
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#TABLE_6 > tbody > tr > td > input[name=\"enviar\"]")).click();
		Thread.sleep(5000);
		
		WebElement table_element = driver.findElement(By.id(nomeTabela));
		List<WebElement> tr_collection = table_element.findElements(By
				.xpath("//table[@id='"+nomeTabela+"']/tbody/tr"));

		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ tr_collection.size());
		System.out.println("Extraindo dados da tabela: " + fileName);

		// Executa função JavaScript para extrair os dados das tabelas(muito
		// mais rapido do que utilizar a função getText()

		String conteudo = (String) ((JavascriptExecutor) driver)
				.executeScript(
						" var s=''; for (var l = 1; l < document.getElementById('"+nomeTabela+"').rows.length; l++)  {  for (var c = 0; c < document.getElementById('"+nomeTabela+"').rows[0].cells.length; c++) {	s += document.getElementById('"+nomeTabela+"').rows[l].cells.item(c).innerText; if(document.getElementById('"+nomeTabela+"').rows[0].cells.length-1 != c){s += ';';}	}  s += '\\r\\n';} return s;",
						table_element).toString();

		System.out.println("Gravando em arquivo...");
		try {
			gravarArquivo(conteudo, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void extrairDados(boolean autenticar) {
		driver.findElement(By.linkText("Mercadoria")).click();
		
		try {
			this.extrair("img[alt=\"Pesquisar Item NCM\"]",
					"Pesquisar Item NCM", autenticar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
