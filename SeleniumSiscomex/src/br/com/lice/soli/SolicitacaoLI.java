package br.com.lice.soli;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.lice.DestaqueNCM;
import br.com.lice.LI;
import br.com.lice.Mercadoria;
import br.com.lice.ObjectSiscomex;
import br.com.lice.ProcessoAnuente;
import br.com.log.PrinterLogger;

public class SolicitacaoLI extends ObjectSiscomex {
	File fileInput;
	public SolicitacaoLI(WebDriver driver, LI li, File fileInputName) {
		super(driver, li);
		this.fileInput = fileInputName;
		
	}

	public SolicitacaoLI() {

	}

	public void abaMercadoria() throws InterruptedException {
		driver.findElement(By.linkText("Mercadoria")).click();
		dadosGeraisMerca();

		// -----------------Condições de
		// Mercadoria------------------------------------------

		selecionarCombo("condicaoMercadoria",li.getCondicaoMercadoria());

		// ----------------------------------------------------------------------------------
		List<DestaqueNCM> destaques = li.getDestaquesNCM();
		for (DestaqueNCM destaque : destaques ) {
			if(!destaque.getInclusaoNCM().trim().equals("")){
				preencherCampo("inclusaoNCM", destaque.getInclusaoNCM());
				driver.findElement(By.id("imgDestaqueIncluir")).click();
			}
		}
		
		List<ProcessoAnuente> processos = li.getProcessosAnuentes();
		for (ProcessoAnuente processo : processos) {
			
			if(!processo.getNumProcessoAnuente().trim().equals("")){
				preencherCampo("numProcessoAnuente", processo.getNumProcessoAnuente());
				preencherCampo("siglaOrgaoAnuente", processo.getSiglaOrgaoAnuente());
				
				driver.findElement(By.id("imgProcessoAnuenteIncluir")).click();
			}
			
		}
		
		// -----------------Drawback------------------------------------------
		
		selecionarCombo("temSistemaDrawback",li.getTemSistemaDrawback());

		// ----------------------------------------------------------------------------------
		List<Mercadoria> mercadorias = li.getMercadorias();
		
		for (Mercadoria mercadoria : mercadorias ) {
			switch ("Não Tem Drawback") {
			case "Não Tem Drawback":
				
				preencherCampo("unidComercializada", mercadoria.getUnidComercializada());
				preencherCampo("qtdeUnidComercializada", mercadoria.getQtdeUnidComercializada());
				preencherCampo("valorUnitCondicaoVenda", mercadoria.getValorUnitCondicaoVenda());
				preencherCampo("especificacaoMercadoria",
						mercadoria.getEspecificacaoMercadoria());
	
				break;
			case "Suspensão Genérico":
				preencherCampo("unidComercializada", "unidade");
				preencherCampo("qtdeUnidComercializada", "2");
				preencherCampo("valorUnitCondicaoVenda", "2");
				preencherCampo("especificacaoMercadoria",
						"Especificação da mercadoria..");
	
				preencherCampo("numItemDrawback", "23");
				preencherCampo("quantidadeProdutoDrawback", "30");
				preencherCampo("valProdutoLocalEmbarqueMoedaNegociada", "20");
	
				break;
	
			case "Suspensão não Genérico":
				preencherCampo("unidComercializada", "unidade");
				preencherCampo("qtdeUnidComercializada", "2");
				preencherCampo("valorUnitCondicaoVenda", "2");
	
				preencherCampo("numItemDrawback", "23");
				preencherCampo("quantidadeProdutoDrawback", "30");
				preencherCampo("valProdutoLocalEmbarqueMoedaNegociada", "20");
	
				break;
			case "Isento":
				preencherCampo("unidComercializada", "unidade");
				preencherCampo("qtdeUnidComercializada", "2");
				preencherCampo("valorUnitCondicaoVenda", "2");
	
				preencherCampo("numItemDrawback", "23");
				preencherCampo("quantidadeProdutoDrawback", "30");
				preencherCampo("valProdutoLocalEmbarqueMoedaNegociada", "20");
	
				break;
			default:
				break;
			}
			
			// Clica em Incluir
			driver.findElement(By.id("buttonMercadoriaIncluir")).click();
		}
		Thread.sleep(1000);

	}

	public void dadosGeraisMerca() throws InterruptedException {

		preencherCampo("cdSubItemNCM", li.getCdSubItemNCM());
		preencherCampo("cdNaladiSh", li.getCdNaladiSh());
		verifyAlert();
		preencherCampo("quantidadeUnidEstatistica", li.getQuantidadeUnidEstatistica());
		preencherCampo("numeroPesoLiquidoMerc", li.getNumeroPesoLiquidoMerc());
		preencherCampo("cdMoedaNegociada", li.getCdMoedaNegociada());
		verifyAlert();
		preencherCampo("cdIncontermsVenda", li.getCdIncontermsVenda());
		verifyAlert();
		//Thread.sleep(1000);
		preencherCampo("valorMercLocalEmb", li.getValorMercLocalEmb());

	}

	public void abaFornecedor() throws InterruptedException {
		driver.findElement(By.linkText("Fornecedor")).click();
		
		
		//Comentando esse trecho de código para fazer um teste de refatoração
		/*Select paisAqMerc = new Select(driver.findElement(By
				.id("cdPaisAquisMerc")));
		
		
		new Select(driver.findElement(By.id("tipoFornecedor"))).selectByVisibleText(li.getTipoFornecedor());*/
		
		
		selecionarCombo("tipoFornecedor", li.getTipoFornecedor());
		


		switch (li.getTipoFornecedor()) {
		case "Fabricante/Produtor é Exportador":
			preencherCampo("nomeFornecEstr", li.getNomeFornecEstr());

			// Seleciona País de Aquisição

			//paisAqMerc.selectByVisibleText(li.getCdPaisAquisMerc());
			selecionarCombo("cdPaisAquisMerc", li.getCdPaisAquisMerc());
			Thread.sleep(100);

			preencherCampo("edLogrFornecEstr", li.getEdLogrFornecEstr());
			preencherCampo("edNumeroFornecEstr", li.getEdNumeroFornecEstr());
			preencherCampo("edComplFornecEstr", li.getEdComplFornecEstr());
			preencherCampo("edCidadeFornecEstr", li.getEdCidadeFornecEstr());
			preencherCampo("edEstFornecEstr", li.getEdEstFornecEstr());

			break;
		case "Fabricante/Produtor não é Exportador":

			//Formulário do Fornecedor
			preencherCampo("nomeFornecEstr", li.getNomeFornecEstr());

			/*new Select(driver.findElement(By.id("cdPaisAquisMerc")))
					.selectByVisibleText(li.getCdPaisAquisMerc());
*/			
			selecionarCombo("cdPaisAquisMerc", li.getCdPaisAquisMerc());

			preencherCampo("edLogrFornecEstr", li.getEdLogrFornecEstr());

			preencherCampo("edNumeroFornecEstr", li.getEdNumeroFornecEstr());
			preencherCampo("edComplFornecEstr", li.getEdComplFornecEstr());
			preencherCampo("edCidadeFornecEstr", li.getEdCidadeFornecEstr());
			preencherCampo("edEstFornecEstr", li.getEdEstFornecEstr());
			
			
			//Formulário do Fabricante
			preencherCampo("nomeFabricMerc", li.getNomeFabricMerc());
			
			//new Select(driver.findElement(By.id("cdPaisOrigMerc"))).selectByVisibleText(li.getCdPaisOrigMerc());
			selecionarCombo("cdPaisAquisMerc", li.getCdPaisAquisMerc());
			
			preencherCampo("edLogrFabric", li.getEdLogrFabric());
			preencherCampo("edNumeroFabric", li.getEdNumeroFabric());
			preencherCampo("edComplFabric", li.getEdComplFabric());
			preencherCampo("edCidadeFabric", li.getEdCidadeFabric());
			preencherCampo("edEstadoFabric", li.getEdEstadoFabric());

			break;
		case "Fabricante/Produtor é Desconhecido":

			preencherCampo("nomeFornecEstr", li.getNomeFornecEstr());

			// Seleciona País de Aquisição
			
			selecionarCombo("cdPaisAquisMerc", li.getCdPaisAquisMerc());

			//paisAqMerc.selectByVisibleText(li.getCdPaisAquisMerc());
			Thread.sleep(100);

			/*new Select(driver.findElement(By.id("cdPaisOrigProdDesconhecido")))
					.selectByVisibleText(li.getCdPaisOrigProdDesconhecido());*/
			
			selecionarCombo("cdPaisOrigProdDesconhecido", li.getCdPaisOrigProdDesconhecido());

			preencherCampo("edLogrFornecEstr", li.getEdLogrFornecEstr());
			preencherCampo("edNumeroFornecEstr", li.getEdNumeroFornecEstr());
			preencherCampo("edComplFornecEstr", li.getEdComplFornecEstr());
			preencherCampo("edCidadeFornecEstr", li.getEdCidadeFornecEstr());
			preencherCampo("edEstFornecEstr", li.getEdEstFornecEstr());

			break;

		default:
			break;
		}

	}

	public void tipoImp() throws InterruptedException {
		// Seleciona o tipo de importador no
		// comboBox------------------------------------
		driver.findElement(By.cssSelector("h1 > span")).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1 > span")));
	
		selecionarCombo("tipoImportador", li.getTipoImportador());
		Thread.sleep(1000);
		
		
		// ------------------------------------------------------------------------------

		System.out.println("Preenche o campo depois de ter selecionado o tipo de importador");
		switch (li.getTipoImportador()) {
		case "Pessoa Jurídica":
			preencherCampo("cnpjImportador", li.getCnpjImportador());
			verifyAlert();
			break;
		case "Pessoa Física Domiciliada no País":
			preencherCampo("cpfImportador", li.getCpfImportador());
			verifyAlert();
			break;
		case "Pessoa Física Domiciliada no Exterior":

			preencherCampo("identificacaoPF", li.getIdentificacaoPF());
			preencherCampo("nomeImportadorPF", li.getNomeImportadorPF());

			// Seleciona o país------------------------------------
			
			selecionarCombo("paisPF", li.getPaisPF());
			Thread.sleep(1000);
			// ------------------------------------------------------------------------------
			preencherCampo("telefonePF", li.getTelefonePF());
			preencherCampo("logradouroPF", li.getLogradouroPF());
			preencherCampo("numeroPF", li.getNumeroPF());
			preencherCampo("complementoPF", li.getComplementoPF());
			preencherCampo("cidadePF", li.getCidadePF());

			break;
		case "Orgãos Diplomáticos e Representações de Organismos Internacionais":
			preencherCampo("identificacaoInstituicao", li.getIdentificacaoInstituicao());

			
			selecionarCombo("codPais", li.getCodPais());

			preencherCampo("telefone", li.getTelefone());
			preencherCampo("logradouro", li.getLogradouro());
			preencherCampo("numero", li.getNumero());
			preencherCampo("complemento", li.getComplemento());
			preencherCampo("bairro", li.getBairro());
			preencherCampo("cep", li.getCep());
			preencherCampo("municipio", li.getMunicipio());

		
			selecionarCombo("codigoUF", li.getCodigoUF());

			break;
		default:
			break;
		}

	}

	public void menu(Actions builder) throws InterruptedException {
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem0']"))).click()
				.build().perform();
		
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menuItem3']")));
		Thread.sleep(500);
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem3']"))).click()
				.build().perform();
		
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menuItem11']")));
		Thread.sleep(500);
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@id='menuItem11']"))).click()
				.build().perform();
		Thread.sleep(500);
	}

	public void abaBasicas() throws InterruptedException {
		// Digita no campo Identificação da Solicitação de LI
		
		Thread.sleep(100);
		preencherCampo("numeroIdentUsuario", li.getIdentificacao());
		//driver.findElement(By.id("numeroIdentUsuario")).sendKeys(li.getIdentificacao());
		
		Thread.sleep(100);
		tipoImp();
		dadosAuxiliares();
	}

	public void abaNegociacao() throws InterruptedException {
		driver.findElement(By.linkText("Negociação")).click();

		preencherCampo("cdRegimeTrib", li.getCdRegimeTrib());
		verifyAlert();
		
		
		//Quando o código do Regime Tributário foi 1, o código de Fundamento Legal não é preenchido
		if(Integer.parseInt(li.getCdRegimeTrib()) != 1){
			preencherCampo("cdFundLegal", li.getCdFundLegal());
			verifyAlert();	
		}
		
		if(!li.getCdTipoAcordoTar().isEmpty()){
			
			selecionarCombo("cdTipoAcordoTar", li.getCdTipoAcordoTar());
		}
		
		verifyAlert();
		
		if (li.getCdTipoAcordoTar() == "ALADI") {
			preencherCampo("cdAcordoAladi", li.getCdAcordoAladi());
		}
		verifyAlert();
		
		selecionarCombo("tipoCoberturaCambial", li.getTipoCoberturaCambial());
		
		verifyAlert();
		switch (li.getTipoCoberturaCambial()) {
			case "Com Cobertura até 180 dias":
				preencherCampo("cdModalidade",li.getCdModalidade());
				verifyAlert();
				preencherCampo("quantidadeDiaLimitePgto", li.getQuantidadeDiaLimitePgto());
				break;
				
			case "Com Cobertura de 180 até 360 dias":
				preencherCampo("cdModalidade", li.getCdModalidade());
				verifyAlert();
				break;
				
			case "Com Cobertura acima de 360 dias":
				preencherCampo("cdOrgaoFimInter", li.getCdOrgaoFimInter());
				verifyAlert();
				break;
				
			case "Sem Cobertura":
				preencherCampo("cdMotivoSemCob", li.getCdMotivoSemCob());
				break;
	
			default:
				break;
		}

	}

	public void dadosAuxiliares() throws InterruptedException {

		// -----------------------Seleciona País de
		// Procedência----------------------

		selecionarCombo("cdPaisProcMerc", li.getCdPaisProcMerc());
		Thread.sleep(100);
		// --------------------------------------------------------------------------

		/*
		 * //Abre pesquisa
		 * driver.findElement(By.cssSelector("img[alt=\"Pesquisar Tabela de URF\"]"
		 * )).click(); Thread.sleep(2000);
		 * 
		 * //O navegador vai pedir o certificado digital e o robo pressiona
		 * Enter para continuar rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(3000);
		 */

		// encontrarPopUp();

		// Preenche os campos sem entrar na janela de pesquisa

		preencherCampo("cdUrfDespacho", li.getCdUrfDespacho());
		verifyAlert();
		preencherCampo("cdUrfEntrada", li.getCdUrfEntrada());
		verifyAlert();

		// Procura URF de Despacho
		/*
		 * driver.findElement(By.id("codigo")).clear(); Thread.sleep(500);
		 * driver.findElement(By.id("codigo")).sendKeys("0210102");
		 * Thread.sleep(500);
		 * driver.findElement(By.linkText("0210102")).click();
		 * Thread.sleep(1000);
		 */

		/*
		 * encontrarMainWindow();
		 * 
		 * //Procura URF de Despacho
		 * driver.findElement(By.xpath("(//img[@alt='Pesquisar Tabela de URF'])[2]"
		 * )).click();
		 * 
		 * rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
		 * Thread.sleep(3000);
		 * 
		 * encontrarPopUp();
		 * 
		 * //Procura URF de Entrada driver.findElement(By.id("codigo")).clear();
		 * Thread.sleep(500);
		 * driver.findElement(By.id("codigo")).sendKeys("0310102");
		 * Thread.sleep(500);
		 * driver.findElement(By.linkText("0310102")).click();
		 * Thread.sleep(1000);
		 * 
		 * encontrarMainWindow();
		 */

		preencherCampo("txInfoComplementar",
				li.getTxInfoComplementar());
		Thread.sleep(1000);

	}
	
	public void solicitarLI( Actions builder) throws InterruptedException {

		// Utilizado a classe Actions para localizar os itens do menu a serem
		// acessados
		menu(builder);
		abaBasicas();
		abaFornecedor();
		abaMercadoria();
		abaNegociacao();
		System.out.println("Clicou no botão de Registrar");
		verifyAlert();
		//driver.findElement(By.id("btnRegistrarLI")).click();
		receberRetorno();
		
	}
	//Processo de solicitação da LI sem o passo de acessar pelo Menu
	public void solicitarLI() throws InterruptedException {

		// Utilizado a classe Actions para localizar os itens do menu a serem
		// acessados
		abaBasicas();
		abaFornecedor();
		abaMercadoria();
		abaNegociacao();
		System.out.println("Clicou no botão de Registrar");
		verifyAlert();
		//driver.findElement(By.id("btnRegistrarLI")).click();
		receberRetorno();
		
	}
	

	private void receberRetorno() {
		String numeroTransmi = "102003770-6";
		String identSolicit = "CLI001/15";
		String numLI = "10/0000000-1";
		String dataRegistro = "12/11/2010";
		String mensagens = "";
		
		/*boolean msgError = driver.findElement(By.xpath("//fieldset[2]/legend/b")).getText().equalsIgnoreCase("Mensagens de erro");
		
		if(!msgError){
			
			numeroTransmi = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr/th[2]")).getText();
			identSolicit  = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr[2]/th[2]")).getText();
			numLI         =	driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr[3]/th[2]/b")).getText();
			dataRegistro  = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr[3]/th[2]")).getText();
			
		}else{
			
			numeroTransmi = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr/th[2]")).getText();
			identSolicit  = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr[2]/th[2]")).getText();
			numLI = " ";
			dataRegistro  = driver.findElement(By.xpath("//table[@id='TABLE_2']/tbody/tr[3]/th[2]")).getText();
			
			
			mensagens = driver.findElement(By.id("TABLE_3")).getText().replace("\n", ";");
			System.out.println(mensagens);

		}*/
		
		salvarEmCSV(numeroTransmi, identSolicit, numLI, dataRegistro, mensagens);
		
	}

	private void salvarEmCSV(String numeroTransmi, String identSolicit,
			String numLI, String dataRegistro, String msgErro) {
		
		PrinterLogger pl = new PrinterLogger();
		String caminhoRetorno;
		String conteudo;
		String arquivoEntrada;
		
		
		if(!numLI.trim().equals("")){
			conteudo = numeroTransmi+";"+identSolicit+";"+numLI+";"+dataRegistro;
			caminhoRetorno = "c:\\uzsisc\\li\\env\\ok";
			arquivoEntrada = ".OK";
		}else{
			conteudo = numeroTransmi+";"+identSolicit+";"+numLI+";"+dataRegistro+"\n";
			conteudo += msgErro;
			caminhoRetorno = "c:\\uzsisc\\li\\env\\erro";
			arquivoEntrada = ".ERRO";
		}
		
		//O arquivo passa do formato "cli00115_00_20150326.xml" para "rec00115_00_20150326.xml"
		String csvFileName = fileInput.getName().replace("CLI", "REC").replace(".xml", "");
		
		//O arquivo de retorno é gravado
		pl.printLog(conteudo, caminhoRetorno, csvFileName, PrinterLogger.CSV);
		
		//Renomeia o arquivo de entrada para "nomeDoArquivo.OK"
		File novoArq = new File(fileInput.getParent()+"\\"+fileInput.getName().replace(".xml", "")+arquivoEntrada);
		fileInput.renameTo(novoArq);
		
	}
}
