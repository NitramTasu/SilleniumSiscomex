package br.com.di.registro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.ObjectSiscomex;

public class RegXMLDI extends ObjectSiscomex {
	
	public RegXMLDI(WebDriver driver ){
		super(driver);
	}

	public void menu(Actions builder) throws InterruptedException {
		
		Thread.sleep(1000);
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem1']"))).click()
				.build().perform();
		
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menuItem3']")));
		Thread.sleep(500);
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem7']"))).click()
				.build().perform();
		
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menuItem11']")));
		Thread.sleep(500);
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem18']"))).click()
				.build().perform();
		Thread.sleep(500);
		
		
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem34']"))).click()
				.build().perform();
		Thread.sleep(500);
		
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem56']"))).click()
				.build().perform();
		Thread.sleep(2000);
	}
	public void envioXML(String dir, String filename){
		driver.findElement(By.xpath("//input[@name='arquivoEstruturaPropria']")).click();

		Autoit roboWin = new Autoit();
		
		try {
			roboWin.findXML(dir, filename);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@value='Enviar XML']")).click();

	}
	
}

