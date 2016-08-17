
import static org.junit.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import br.com.log.PrinterLogger;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class Sele {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	
	File file = new File("C:\\Users\\Martin\\Desktop\\Projeto aFill\\Siscomex Web\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
	//File file = new File("IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
  	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
    driver = new InternetExplorerDriver();
    baseUrl = "https://www4c.receita.fazenda.gov.br";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSele() throws Exception {
	Robot rb = new Robot();  
    driver.get("https://www4c.receita.fazenda.gov.br/siscomexImpweb-7/private_siscomeximpweb_inicio.do");
    Actions builder = new Actions(driver);
    
    //Utilizado o Robot para interagir com a mensagem do IE sobre o certificado digital que precisa ser selecionado
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    driver.findElement(By.cssSelector("a > img")).click();
    Thread.sleep(500);
    
    //Utilizado a classe Actions para localizar os itens do menu a serem acessados
    menuSoliLI(builder);
    
    //Digita no campo Identificação da Solicitação de LI
    driver.findElement(By.id("numeroIdentUsuario")).sendKeys("numeroLI");
    Thread.sleep(500);
    
    tipoImp();
    dadosAuxiliares(rb);
    abaFornecedor();
    abaMercadoria();
    abaNegociacao();

    //Clica em sair
    driver.findElement(By.xpath("//div[@id='menu-geral']/a[3]/img")).click();
  }

private void abaNegociacao() {
	driver.findElement(By.linkText("Negociação")).click();

	driver.findElement(By.id("cdRegimeTrib")).clear();
	driver.findElement(By.id("cdRegimeTrib")).sendKeys("1");
	
	Select tipoAcordo= new Select (driver.findElement(By.id("cdTipoAcordoTar")));
	tipoAcordo.selectByVisibleText("ALADI");
	
	driver.findElement(By.id("cdAcordoAladi")).clear();
	driver.findElement(By.id("cdAcordoAladi")).sendKeys("111");
	
	
	Select tipoCobert= new Select (driver.findElement(By.id("tipoCoberturaCambial")));
	tipoCobert.selectByVisibleText("Com Cobertura de 180 até 360 dias");
	
	driver.findElement(By.id("cdModalidade")).clear();
	driver.findElement(By.id("cdModalidade")).sendKeys("10");

	
}

public void abaMercadoria() throws InterruptedException {
	driver.findElement(By.linkText("Mercadoria")).click();
	
	dadosGeraisMerca();
	
	//-----------------Condições de Mercadoria------------------------------------------
	Select paisProc= new Select (driver.findElement(By.id("condicaoMercadoria")));
    paisProc.selectByVisibleText("Bem Fabricado Sob Encomenda");
    
    //----------------------------------------------------------------------------------
    
    driver.findElement(By.id("inclusaoNCM")).clear();
    driver.findElement(By.id("inclusaoNCM")).sendKeys("010");
    driver.findElement(By.id("numProcessoAnuente")).clear();
    driver.findElement(By.id("numProcessoAnuente")).sendKeys("123456");
    

    /*driver.findElement(By.id("siglaOrgaoAnuente")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("siglaOrgaoAnuente")).sendKeys("123");
    Thread.sleep(500);*/
    
    //-----------------Drawback------------------------------------------
	Select modalidade= new Select (driver.findElement(By.id("temSistemaDrawback")));
	modalidade.selectByVisibleText("Suspensão Genérico");
	
	//----------------------------------------------------------------------------------
	
	driver.findElement(By.id("unidComercializada")).clear();
	driver.findElement(By.id("unidComercializada")).sendKeys("Kilograma");
	driver.findElement(By.id("qtdeUnidComercializada")).clear();
	driver.findElement(By.id("qtdeUnidComercializada")).sendKeys("2");
	driver.findElement(By.id("valorUnitCondicaoVenda")).clear();
	driver.findElement(By.id("valorUnitCondicaoVenda")).sendKeys("2");
	driver.findElement(By.id("especificacaoMercadoria")).clear();
	driver.findElement(By.id("especificacaoMercadoria")).sendKeys("Especificação qualquer coisa.");
	driver.findElement(By.id("numItemDrawback")).clear();
	driver.findElement(By.id("numItemDrawback")).sendKeys("23");
	driver.findElement(By.id("quantidadeProdutoDrawback")).clear();
	driver.findElement(By.id("quantidadeProdutoDrawback")).sendKeys("30");
	driver.findElement(By.id("valProdutoLocalEmbarqueMoedaNegociada")).clear();
	driver.findElement(By.id("valProdutoLocalEmbarqueMoedaNegociada")).sendKeys("20");
	
	//Clica em Incluir
	driver.findElement(By.id("buttonMercadoriaIncluir")).click();
	Thread.sleep(5000);

}

public void dadosGeraisMerca() throws InterruptedException {
	driver.findElement(By.id("cdSubItemNCM")).clear();
	Thread.sleep(500);
	driver.findElement(By.id("cdSubItemNCM")).sendKeys("2101.11.10");
	Thread.sleep(500);
	driver.findElement(By.id("cdNaladiSh")).clear();
	Thread.sleep(500);
	driver.findElement(By.id("cdNaladiSh")).sendKeys("01011010");
	Thread.sleep(500);
	driver.findElement(By.id("quantidadeUnidEstatistica")).clear();
	driver.findElement(By.id("quantidadeUnidEstatistica")).sendKeys("2");
	driver.findElement(By.id("numeroPesoLiquidoMerc")).clear();
	driver.findElement(By.id("numeroPesoLiquidoMerc")).sendKeys("2");
	driver.findElement(By.id("cdMoedaNegociada")).clear();
	driver.findElement(By.id("cdMoedaNegociada")).sendKeys("005");
	driver.findElement(By.id("cdIncontermsVenda")).clear();
	driver.findElement(By.id("cdIncontermsVenda")).sendKeys("CIP");
	driver.findElement(By.id("valorMercLocalEmb")).clear();
	driver.findElement(By.id("valorMercLocalEmb")).sendKeys("3");
}

public void abaFornecedor() throws InterruptedException {
	driver.findElement(By.linkText("Fornecedor")).click();
	driver.findElement(By.id("nomeFornecEstr")).clear();
	driver.findElement(By.id("nomeFornecEstr")).sendKeys("Nome do Fabricante");
	
    try {
    	Select paisAqMerc= new Select (driver.findElement(By.id("cdPaisAquisMerc")));
        paisAqMerc.selectByVisibleText("ANTIGUA E BARBUDA");
	} catch (Exception e) {
		PrinterLogger printL = new PrinterLogger();
		printL.printLog(e.getMessage(), "uzsisc/log", "LogErroOpcaoCombo", PrinterLogger.TEXTO);
		driver.close();
	}
    
    Thread.sleep(100);

	driver.findElement(By.id("edLogrFornecEstr")).clear();
	driver.findElement(By.id("edLogrFornecEstr")).sendKeys("Logradouro");
	driver.findElement(By.id("edNumeroFornecEstr")).clear();
	driver.findElement(By.id("edNumeroFornecEstr")).sendKeys("123456");
	driver.findElement(By.id("edComplFornecEstr")).clear();
	driver.findElement(By.id("edComplFornecEstr")).sendKeys("Qualquer coisa");
	driver.findElement(By.id("edCidadeFornecEstr")).clear();
	driver.findElement(By.id("edCidadeFornecEstr")).sendKeys("São Paulo");
	driver.findElement(By.id("edEstFornecEstr")).clear();
	driver.findElement(By.id("edEstFornecEstr")).sendKeys("SP");
}

public void tipoImp() throws InterruptedException {
	//Seleciona o tipo de importador no comboBox
    Select selectTipImp= new Select (driver.findElement(By.id("tipoImportador")));
    Thread.sleep(500);
    
    selectTipImp.selectByVisibleText("Pessoa Física Domiciliada no País");
    Thread.sleep(2000);

    //driver.findElement(By.id("cpfImportador")).sendKeys("23573668267");
    //Thread.sleep(2000);
}

public void menuSoliLI(Actions builder) throws InterruptedException {
	
	/*builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
    Thread.sleep(500);
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
    Thread.sleep(500);
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem7']"))).click().build().perform();
    Thread.sleep(500);*/
    
	//Licenciamento de Importação
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem0']"))).click().build().perform();
    Thread.sleep(500);
    //Solicitações
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem3']"))).click().build().perform();
    Thread.sleep(500);
    
    //Licença
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem7']"))).build().perform();
    Thread.sleep(500);
    
    //Recuperação
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem8']"))).build().perform();
    Thread.sleep(500);
    
    //Solicitação
    builder.moveToElement(driver.findElement(By.xpath("//div[@id='menuItem11']"))).click().build().perform();
    Thread.sleep(1000);
}

public void dadosAuxiliares(Robot rb) throws InterruptedException {
	
	//-----------------------Seleciona País de Procedência----------------------
	Select paisProc= new Select (driver.findElement(By.id("cdPaisProcMerc")));
    Thread.sleep(500);
    
    paisProc.selectByVisibleText("AFEGANISTAO");
    Thread.sleep(2000);
	//--------------------------------------------------------------------------
    
   /* //Abre pesquisa
    driver.findElement(By.cssSelector("img[alt=\"Pesquisar Tabela de URF\"]")).click();
    Thread.sleep(2000);
    
    //O navegador vai pedir o certificado digital e o robo pressiona Enter para continuar
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);    
    Thread.sleep(3000);
    */
    
    //encontrarPopUp();
    
    //Preenche os campos sem entrar na janela de pesquisa
    driver.findElement(By.id("cdUrfDespacho")).clear();
    driver.findElement(By.id("cdUrfDespacho")).sendKeys("0210102");
    
    driver.findElement(By.id("cdUrfEntrada")).clear();
    driver.findElement(By.id("cdUrfEntrada")).sendKeys("0310102");



    //Procura URF de Despacho
    /*driver.findElement(By.id("codigo")).clear();
    Thread.sleep(500);
	driver.findElement(By.id("codigo")).sendKeys("0210102");
	Thread.sleep(500);
	driver.findElement(By.linkText("0210102")).click();
	Thread.sleep(1000);*/
	
	/*encontrarMainWindow();
	
    //Procura URF de Despacho
	driver.findElement(By.xpath("(//img[@alt='Pesquisar Tabela de URF'])[2]")).click();
	
	rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);    
    Thread.sleep(3000);
    
    encontrarPopUp();
    
	//Procura URF de Entrada
    driver.findElement(By.id("codigo")).clear();
    Thread.sleep(500);
	driver.findElement(By.id("codigo")).sendKeys("0310102");
	Thread.sleep(500);
	driver.findElement(By.linkText("0310102")).click();
	Thread.sleep(1000);
	
	encontrarMainWindow();*/
	
	driver.findElement(By.id("txInfoComplementar")).clear();
	driver.findElement(By.id("txInfoComplementar")).sendKeys("Informações comprementares para teste.");

    Thread.sleep(2000);
    
}

public void encontrarPopUp() {
	Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
    Iterator<String> itererator = windowId.iterator();
    
    String mainWinID = itererator.next();
    String  newAdwinID = itererator.next();

    driver.switchTo().window(newAdwinID);
    System.out.println(driver.getTitle());
}

public void encontrarMainWindow(){
	Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
    Iterator<String> itererator = windowId.iterator();
    
    String mainWinID = itererator.next();

    driver.switchTo().window(mainWinID);
    System.out.println(driver.getTitle());
}

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
