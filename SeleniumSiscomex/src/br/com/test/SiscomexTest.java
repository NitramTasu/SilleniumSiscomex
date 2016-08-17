package br.com.test;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.soli.RegistroLI;
import br.com.lice.soli.SolicitacaoLI;
import br.com.lice.soli.consul.ConsultaLI;
import br.com.lice.soli.consul.Diagnostico;
import br.com.lice.soli.recupe.RecupLISoliAdicao;
import br.com.lice.soli.recupe.RecuperacaoLI;
import br.com.lice.soli.recupe.RecuperacaoLIAdicao;

public class SiscomexTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Robot rb;
	private Actions builder;
	private static String newline = System.getProperty("line.separator");

	@Before
	public void setUp() throws Exception {
		
		File file = new File(
				"C:\\Users\\Martin\\Desktop\\Projeto aFill\\Siscomex Web\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
		// File file = new
		// File("IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		baseUrl = "https://www4c.receita.fazenda.gov.br";
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test
	public void solicitacaoDeRegistroLI() throws InterruptedException {
		iniciarAcesso();
		SolicitacaoLI soliciLi = new SolicitacaoLI(driver, null,null);

		soliciLi.menu(builder);
		//soliciLi.abaBasicas();
		buscarTabelaURF();

		//soliciLi.abaFornecedor();
		//soliciLi.abaMercadoria();
		//soliciLi.abaNegociacao();

	}
	
	private void buscarTabelaURF() throws InterruptedException {
		//driver.findElement(By.xpath("(//img[@alt='Pesquisar Tabela de URF'])")).click();
		driver.findElement(By.cssSelector("img[alt=\"Pesquisar Tabela de URF\"]")).click();
		Thread.sleep(1000);
		

		rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);    
	    Thread.sleep(3000);
	    
	    encontrarPopUp();
	    
	    WebElement table_element = driver.findElement(By.id("TABLE_3"));
        List<WebElement> tr_collection=table_element.findElements(By.xpath("//table[@id='TABLE_3']/tbody/tr"));

        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
        
        int row_num,col_num;
        row_num=1;
        String conteudo = "";
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
            	
                //System.out.print(tdElement.getText()+",");
                conteudo += tdElement.getText()+",";
                col_num++;
            }
            conteudo += newline;
            row_num++;
        }

		System.out.println(conteudo);
		
	}
	
	public void encontrarPopUp() {
		Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
	    Iterator<String> itererator = windowId.iterator();
	    
	    String mainWinID = itererator.next();
	    String  newAdwinID = itererator.next();

	    driver.switchTo().window(newAdwinID);
	    System.out.println(driver.getTitle());
	}


	@Ignore
	@Test
	public void acessarTodosOsMenus() throws InterruptedException {
		SolicitacaoLI soliLi = new SolicitacaoLI(driver, null, null);
		RecuperacaoLI recuperacaoLi = new RecuperacaoLI(driver, null);
		RecuperacaoLIAdicao recuperaLIAdi = new RecuperacaoLIAdicao(driver, null);
		RecupLISoliAdicao recupSoliAdicao = new RecupLISoliAdicao(driver, null);
		RegistroLI regLi = new RegistroLI(driver, null);
		Diagnostico diagnosticoLI = new Diagnostico(driver, null);
		ConsultaLI consultaLI = new ConsultaLI(driver, null);

		iniciarAcesso();
		
		soliLi.menu(builder);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(1000);
		recuperacaoLi.menu(builder);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(500);
		recuperaLIAdi.menu(builder);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(500);
		recupSoliAdicao.menu(builder);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(500);
		regLi.menu(builder);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(500);
		diagnosticoLI.menu(builder);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(500);
		consultaLI.menu(builder);

		encerraAcesso();
	}
	

	public void iniciarAcesso() {
		try {
			rb = new Robot();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		driver.get("https://www4c.receita.fazenda.gov.br/siscomexImpweb-7/private_siscomeximpweb_inicio.do");
		
		builder = new Actions(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		// Utilizado o Robot para interagir com a mensagem do IE sobre o
		// certificado digital que precisa ser selecionado
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("a > img")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void encerraAcesso() {
		// Clica em sair
		driver.findElement(By.xpath("//div[@id='menu-geral']/a[3]/img"))
				.click();

		driver.quit();
		//driver.close();
	}

	@After
	public void tearDown() {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
