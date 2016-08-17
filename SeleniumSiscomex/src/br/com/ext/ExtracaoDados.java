package br.com.ext;
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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.ext.campos.ExtratorAcordoAladi;
import br.com.ext.campos.ExtratorCodigoTrib;
import br.com.ext.campos.ExtratorFundLegTrib;
import br.com.ext.campos.ExtratorIncoterm;
import br.com.ext.campos.ExtratorModalidadePag;
import br.com.ext.campos.ExtratorMotivoCober;
import br.com.ext.campos.ExtratorNCM;
import br.com.ext.campos.ExtratorNaladish;
import br.com.ext.campos.ExtratorPesquisaMoedaNeg;
import br.com.ext.campos.ExtratorURF;
import br.com.lice.soli.SolicitacaoLI;


public class ExtracaoDados {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Robot rb;
	private Actions builder;
	private static String newline = System.getProperty("line.separator");
	
	public ExtracaoDados(){
		
	}
	public ExtracaoDados(WebDriver driver){
		this.driver = driver;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	private void extrair(String btnSearch, String fileName, boolean autenticar) throws InterruptedException {
		//driver.findElement(By.xpath("(//img[@alt='Pesquisar Tabela de URF'])")).click();
		//driver.findElement(By.cssSelector("img[alt=\"Pesquisar Tabela de URF\"]")).click();
		System.out.println("Clica no botão : "+btnSearch);
		driver.findElement(By.cssSelector(btnSearch)).click();
		
		Thread.sleep(2000);
		
		if (autenticar) {
			aceitaAuten();
		}
	
	    encontrarPopUp();
	    Thread.sleep(1000);
	    WebElement table_element = driver.findElement(By.id("TABLE_3"));
        List<WebElement> tr_collection=table_element.findElements(By.xpath("//table[@id='TABLE_3']/tbody/tr"));

        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
        System.out.println("Extraindo dados da tabela: "+fileName);
       
        //Executa função JavaScript para extrair os dados das tabelas(muito mais rapido do que utilizar a função getText()

        String conteudo = (String)((JavascriptExecutor)driver).executeScript(" var s=''; for (var l = 1; l < document.getElementById('TABLE_3').rows.length; l++)  {  for (var c = 0; c < document.getElementById('TABLE_3').rows[0].cells.length; c++) {	s += document.getElementById('TABLE_3').rows[l].cells.item(c).innerText; if(document.getElementById('TABLE_3').rows[0].cells.length-1 != c){s += ';';}	}  s += '\\r\\n';} return s;", table_element).toString();
        
        System.out.println("Gravando em arquivo...");
		try {
			gravarArquivo(conteudo,fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void gravarArquivo(String conteudo, String fileName) throws IOException{
		
		File file = new File("C:\\Users\\Martin\\Desktop\\"+fileName+".csv");
		FileWriter writer = new FileWriter(file);
		
		writer.append(conteudo);
		writer.close();
	}
	public void encontrarPopUp() {
		Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
	    Iterator<String> itererator = windowId.iterator();
	    
	    
	    String mainWinID = itererator.next();
	    String  newAdwinID = itererator.next();

	    driver.switchTo().window(newAdwinID);
	    System.out.println(driver.getTitle());
	}
	public void aceitaAuten() throws InterruptedException{
		rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);    
	    Thread.sleep(4000);
	}
	public ExtratorNCM criarExtratorNCM(){
		ExtratorNCM extrator = new ExtratorNCM(driver, rb);
		return extrator;
	}
	
	public ExtratorNaladish criarExtratorNaladish(){
		ExtratorNaladish extrator = new ExtratorNaladish(driver, rb);
		return extrator;
	}
	public ExtratorPesquisaMoedaNeg criarExtratorPesquisaMoedaNeg(){
		ExtratorPesquisaMoedaNeg extrator = new ExtratorPesquisaMoedaNeg(driver, rb);
		return extrator;
	}
	public ExtratorIncoterm criarExtratorIncoterm(){
		ExtratorIncoterm extrator = new ExtratorIncoterm(driver,rb);
		return extrator;
	}
	public ExtratorCodigoTrib criarExtratorCodigoTrib(){
		ExtratorCodigoTrib extrator = new ExtratorCodigoTrib(driver,rb);
		return extrator;
	}
	public ExtratorFundLegTrib criarExtratorFundLegTrib(){
		ExtratorFundLegTrib extrator = new ExtratorFundLegTrib(driver,rb);
		return extrator;
	}
	public ExtratorURF criarExtratorURF(){
		ExtratorURF extrator = new ExtratorURF(driver, rb);
		return extrator;
	}
	public ExtratorModalidadePag criarModalidadePag(){
		ExtratorModalidadePag extrator = new ExtratorModalidadePag(driver, rb);
		return extrator;
	}
	public ExtratorMotivoCober criarExtratorMotivoCober(){
		ExtratorMotivoCober extrator = new ExtratorMotivoCober(driver, rb);
		return extrator;
	}
	public ExtratorAcordoAladi criarExtratorAcordoAladi(){
		ExtratorAcordoAladi extrator = new ExtratorAcordoAladi(driver, rb);
		return extrator;
	}
	
}
