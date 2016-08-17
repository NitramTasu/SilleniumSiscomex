package br.com.test;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.lice.soli.SolicitacaoLI;


public class ExtratorDadosTest {
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
		iniciarAcesso();
	}

	@Test
	public void solicitacaoDeRegistroLI() throws InterruptedException {
		
		SolicitacaoLI soliciLi = new SolicitacaoLI(driver, null,null);

		soliciLi.menu(builder);
		//soliciLi.abaBasicas();
		buscarTabela("TABLE_3");

		//soliciLi.abaFornecedor();
		//soliciLi.abaMercadoria();
		//soliciLi.abaNegociacao();

	}
	public void iniciarAcesso() {
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		driver.get("https://www4c.receita.fazenda.gov.br/siscomexImpweb-7/private_siscomeximpweb_inicio.do");
		builder = new Actions(driver);

		// Utilizado o Robot para interagir com a mensagem do IE sobre o
		// certificado digital que precisa ser selecionado
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Tratamento para saber se a página foi carregada Obs:A mensagem da excessão precisa ir no arquivo de log
		try {
			driver.findElement(By.cssSelector("a > img")).click();
		} catch (Exception e) {
			System.out.println(driver.getTitle());
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void buscarTabela(String idElement) throws InterruptedException {
		//driver.findElement(By.xpath("(//img[@alt='Pesquisar Tabela de URF'])")).click();
		driver.findElement(By.cssSelector("img[alt=\"Pesquisar Tabela de URF\"]")).click();
		Thread.sleep(1000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);    
	    Thread.sleep(4000);
	    
	    encontrarPopUp();
	    Thread.sleep(1000);
	    WebElement table_element = driver.findElement(By.id(idElement));
        List<WebElement> tr_collection=table_element.findElements(By.xpath("//table[@id='"+idElement+"']/tbody/tr"));

        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
       
        //Executa função JavaScript para extrair os dados das tabelas(muito mais rapido do que utilizar a função getText()
        String conteudo = (String)((JavascriptExecutor)driver).executeScript(" var s=''; for (var l = 0; l < document.getElementById('TABLE_3').rows.length; l++)  {  for (var c = 0; c < document.getElementById('TABLE_3').rows[0].cells.length; c++) {	s += document.getElementById('TABLE_3').rows[l].cells.item(c).innerText; if(document.getElementById('TABLE_3').rows[0].cells.length-1 != c){s += ';';}	}  s += '\\r\\n';} return s;", table_element).toString();
        
/*        int row_num,col_num;
        row_num=1;
        
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
*/
		try {
			gravarArquivo(conteudo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void encontrarPopUp() {
		Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
	    Iterator<String> itererator = windowId.iterator();
	    
	    String mainWinID = itererator.next();
	    String  newAdwinID = itererator.next();

	    driver.switchTo().window(newAdwinID);
	    System.out.println(driver.getTitle());
	}
	
	public void gravarArquivo(String conteudo) throws IOException{
		File file = new File("C:\\Users\\Martin\\Desktop\\URF.csv");
		FileWriter writer = new FileWriter(file);
		
		writer.append(conteudo);
		writer.close();
	}

	

}
