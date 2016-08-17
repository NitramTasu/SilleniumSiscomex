import java.io.File;
import java.util.Set;
import java.awt.Robot;
import java.util.Iterator;
import java.awt.AWTException;

import org.openqa.selenium.By;

import java.awt.event.KeyEvent;

import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.di.registro.RegXMLDI;
import br.com.ext.ExtracaoDados;
import br.com.lice.LI;
import br.com.lice.soli.RegistroLI;
import br.com.lice.soli.SolicitacaoLI;
import br.com.lice.soli.consul.ConsultaLI;
import br.com.lice.soli.consul.Diagnostico;
import br.com.lice.soli.recupe.RecupLISoliAdicao;
import br.com.lice.soli.recupe.RecuperacaoLI;
import br.com.lice.soli.recupe.RecuperacaoLIAdicao;
import br.com.log.PrinterLogger;

public class SeleniumRobot {
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	//private static int operacao = 8;
	//private static String direcFile = "C:\\Users\\Martin\\Desktop\\pli00017_001_20150315_01.xml";
	//private static String direcFile = "C:\\Users\\Martin\\AppData\\Roaming\\Skype\\My Skype Received Files\\cli00115_00_20150320.xml";
	private static String direcFile = "";
	private static LI li;
	private static File fileInput;
	private static String mainWinID = "";

	public static void main(String[] args) throws InterruptedException,
			AWTException {
		
		preCarregamento();
		Actions builder = iniciarNavegador();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		new WebDriverWait(driver,10).until(ExpectedConditions.titleContains("Siscomex Importação Web v1.5 07/08/2014"));
		
		//Thread.sleep(1000);
		
		System.out.println("Primeiro clique");
		try {
			//Espera até o botão do menu consiga ser clicado
			WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a > img")));
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//driver.findElement(By.cssSelector("a > img")).click();
		//Thread.sleep(500);
		
		//direcFile = args[0];
		//direcFile="C:\\Users\\Martin\\AppData\\Roaming\\Skype\\My Skype Received Files\\cli00115_00_20150326.xml";
		//li = toObject();

		operacao(builder);

		// Clica em sair
		driver.findElement(By.xpath("//div[@id='menu-geral']/a[3]/img"))
				.click();

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.quit();
		//driver.close();

	}


	public static void operacao(Actions builder) throws InterruptedException {
		SolicitacaoLI solicitacaoLi;
		
		switch ("DI") {
		case "E":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			
			
			solicitacaoLi = new SolicitacaoLI(driver, li, fileInput);
			solicitacaoLi.solicitarLI(builder);
			break;
		case "R":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			RecuperacaoLI recuperacaoLi = new RecuperacaoLI(driver, li);
			solicitacaoLi = new SolicitacaoLI(driver, li, fileInput);
			
			recuperacaoLi.recuperarLI(builder);
			solicitacaoLi.solicitarLI();
			
			break;
		case "X11":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			RecuperacaoLIAdicao recuperaLIAdi = new RecuperacaoLIAdicao(driver, li);
			recuperaLIAdi.recuperarLIAdicao(builder);
			break;
		case "X1":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			RecupLISoliAdicao recupSoliAdicao = new RecupLISoliAdicao(driver, li);
			recupSoliAdicao.recuSoliAdicao(builder);
			break;
		case "X2":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			RegistroLI regLi = new RegistroLI(driver, li);
			regLi.registrarLI(builder);
			break;
		case "X3":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			Diagnostico diagnosticoLI = new Diagnostico(driver, li);
			diagnosticoLI.diagnosticar(builder);
			break;
		case "X4":
			//Procura um Xml e transforma em objeto LI(Licenca de importação)
			//li = toObject();
			
			ConsultaLI consultaLI = new ConsultaLI(driver, li);
			consultaLI.consultaLI(builder);
			break;
		case "DI":
			RegXMLDI regXML = new RegXMLDI(driver);
			regXML.menu(builder);
			regXML.envioXML("C:\\Users\\Martin\\AppData\\Roaming\\Skype\\My Skype Received Files\\","cli00115_00_20150326.xml");
			break;
		case "X5":
			SolicitacaoLI soliLi = new SolicitacaoLI(driver, null, null);
			
			ExtracaoDados extrac = new ExtracaoDados(driver);
			
			soliLi.menu(builder);
			
			extrac.criarExtratorURF().extrairDados(true);
			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			extrac.criarExtratorNCM().extrairDados(false);
					
			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			extrac.criarExtratorNaladish().extrairDados(false);
		
			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			System.out.println("Abrindo a PesquisaMoeda");
			
			extrac.criarExtratorPesquisaMoedaNeg().extrairDados(false);
			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			extrac.criarExtratorIncoterm().extrairDados(false);
			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			extrac.criarExtratorCodigoTrib().extrairDados(false);

			Thread.sleep(500);
			trocarJanela();
			Thread.sleep(500);
			
			for (int codTrib = 7; codTrib <=9; codTrib++) {
				extrac.criarExtratorFundLegTrib().extrairDados(false, codTrib);
				Thread.sleep(500);
				//driver.close();
				Thread.sleep(500);
				trocarJanela();
				Thread.sleep(500);
			}
			
			break;

		default:
			break;
		}
	}


	public static Actions iniciarNavegador() throws AWTException,
			InterruptedException {
		Robot rb = new Robot();

		driver.get("https://www1c.siscomex.receita.fazenda.gov.br/siscomexImpweb-7/private_siscomeximpweb_inicio.do");
		
		Actions builder = new Actions(driver);

		// Utilizado o Robot para interagir com a mensagem do IE sobre o
		// certificado digital que precisa ser selecionado
		Thread.sleep(800);
		if (isAlertPresent()) {
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		mainWinID = driver.getWindowHandle();
		Thread.sleep(1000);
		return builder;
	}


	public static void toXML(SolicitacaoLI li) {

		try {

			File file = new File("C:\\Users\\Martin\\Desktop\\file.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(LI.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(li, file);
			jaxbMarshaller.marshal(li, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void preCarregamento() {
		//File file = new File("C:\\Users\\Martin\\Desktop\\Projeto aFill\\Siscomex Web\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
		//File file = new File("C:\\Users\\Martin\\Desktop\\Projeto aFill\\Siscomex Web\\chromedriver_win32\\chromedriver.exe");
		
		//File file = new File("IEDriverServer.exe");
		File file = new File("chromedriver.exe");
		
		System.out.println(file.getPath());
		
		//System.setProperty("webdriver.ie.driver", file.getPath());
		System.setProperty("webdriver.chrome.driver", file.getPath());
		
		try {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("ignoreZoomSetting", true);
			
			//driver = new InternetExplorerDriver();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			PrinterLogger printL = new PrinterLogger();
			printL.printLog("O driver de navegador não foi encontrado. Erro: "+e, "uzsisc/log", "LogErroDriver", PrinterLogger.TEXTO);
			
		}
		
	}

	public static void trocarJanela() {

		Set<String> windowId = driver.getWindowHandles(); // get window id of
		// current window
		Iterator<String> itererator = windowId.iterator();
		
		//String mainWinID = itererator.next();
		String  newAdwinID = itererator.next();
		
		System.out.println("*******Janela principal: " + mainWinID);
		
		if(newAdwinID.equals(mainWinID)){
			
	    	newAdwinID = itererator.next();
	    }
		
		System.out.println("*******Janela que será fechada: " + newAdwinID);
		
		driver.switchTo().window(newAdwinID);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(mainWinID);

		/*System.out.println(mainWinID);
		driver.switchTo().window(mainWinID);
		System.out.println(driver.getTitle());*/

	}
	
	public static void encontrarMainWindow() {

		/*Set<String> windowId = driver.getWindowHandles(); // get window id of
															// current window
		Iterator<String> itererator = windowId.iterator();

		String mainWinID = itererator.next();
		
		System.out.println(mainWinID);
		driver.switchTo().window(mainWinID);
		System.out.println(driver.getTitle());*/
		
		Set<String> windowId = driver.getWindowHandles(); // get window id of
		// current window
		Iterator<String> itererator = windowId.iterator();
		
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		
		driver.switchTo().window(newAdwinID);
		System.out.println(driver.getTitle());

	}

	private static boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void encontrarPopUp() {
		Set<String> windowId = driver.getWindowHandles(); // get window id of
															// current window
		Iterator<String> itererator = windowId.iterator();

		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();

		driver.switchTo().window(newAdwinID);
		System.out.println(driver.getTitle());
	}
	
	
	public static LI toObject() {
		LI li = null;
		try {
			//File file = new File("C:\\Users\\Martin\\Desktop\\file.xml");
			fileInput = new File(direcFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(LI.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			li =  (LI) jaxbUnmarshaller.unmarshal(fileInput);
			
			System.out.println(li);

		} catch (JAXBException e) {
			PrinterLogger printL = new PrinterLogger();
			printL.printLog("Não foi encontrado o XML de entrada", "C:/uzsisc/log", "LogErro", PrinterLogger.TEXTO);
			
			e.printStackTrace();
			
		}
		return li;
	}
}
