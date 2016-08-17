package br.com.lice.soli.recupe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.LI;
import br.com.lice.ObjectSiscomex;

public class RecupLISoliAdicao extends ObjectSiscomex {

	public RecupLISoliAdicao(WebDriver driver, LI li) {
		super(driver, li);
	}

	public void menu(Actions builder) throws InterruptedException {

		// Licenciamento de Importa��o
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem0']"))).click()
				.build().perform();
		Thread.sleep(500);
		// Solicita��es
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem3']"))).click()
				.build().perform();
		Thread.sleep(500);

		// Licen�a
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem7']"))).build()
				.perform();
		Thread.sleep(500);

		// Recupera��o
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem8']"))).build()
				.perform();
		Thread.sleep(500);

		// Solicita��o
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem11']")))
				.build().perform();
		Thread.sleep(500);

		// LI a partir da Solicita��o de DI/Adi��o
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem13']")))
				.click().build().perform();
		Thread.sleep(500);
	}

	public void recuperarSoliciAdi() {

		preencherCampo("identificacaoLI", "22012015");
		preencherCampo("solicitacaoIdentificacaoDI", "22012015");
		preencherCampo("numeroAdicao", "22012015");

		driver.findElement(By.id("enviar")).click();
		verifyAlert();
	}

	public void recuSoliAdicao(Actions builder) throws InterruptedException {
		menu(builder);
		recuperarSoliciAdi();
	}
}
