package br.com.lice;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

@XmlRootElement
public class LI {

	protected WebDriver driver;

	// ----Aba Básicas-------
	String operacao;
	String identificacao;
	String tipoImportador;
	String cdPaisProcMerc;
	String cdUrfDespacho;
	String cdUrfEntrada;
	String txInfoComplementar;
	String identificacaoPF;
	String nomeImportadorPF;
	String paisPF;
	String telefonePF;
	String logradouroPF;
	String numeroPF;
	String complementoPF;
	String cidadePF;
	String telefone;
	String logradouro;
	String numero;
	String complemento;
	String bairro;
	String cep;
	String municipio;
	String codigoUF;
	String cnpjImportador;
	String cpfImportador;
	String identificacaoInstituicao;
	String codPais;

	// -----Aba Mercadoria----
	String temSistemaDrawback;
	String numItemDrawback;
	String quantidadeProdutoDrawback;
	String valProdutoLocalEmbarqueMoedaNegociada;
	String condicaoMercadoria;

	// Dados Gerais da mercadoria
	String cdSubItemNCM;
	String cdNaladiSh;
	String quantidadeUnidEstatistica;
	String numeroPesoLiquidoMerc;
	String cdMoedaNegociada;
	String cdIncontermsVenda;
	String valorMercLocalEmb;
	List<DestaqueNCM> destaquesNCM;
	List<Mercadoria> mercadorias;
	List<ProcessoAnuente> processosAnuentes;

	// ----Aba Fornecedor
	String tipoFornecedor;
	String nomeFornecEstr;
	String cdPaisAquisMerc;
	String edLogrFornecEstr;
	String edNumeroFornecEstr;
	String edComplFornecEstr;
	String edCidadeFornecEstr;
	String edEstFornecEstr;
	String cdPaisOrigProdDesconhecido;
	
	String nomeFabricMerc;
	String cdPaisOrigMerc;
	String edLogrFabric;
	String edNumeroFabric;
	String edComplFabric;
	String edCidadeFabric;
	String edEstadoFabric;

	// ----Aba Negociação
	String cdRegimeTrib;
	String cdFundLegal;
	String cdTipoAcordoTar;
	String cdAcordoAladi;
	String tipoCoberturaCambial;
	String cdModalidade;
	String quantidadeDiaLimitePgto;
	String cdOrgaoFimInter;
	String cdMotivoSemCob;

	// Elaboração de Solicitação de LI a partir de DI/Adição
	String numeroIdentUsuario;
	String numeroIdentificacaoDI;
	String numeroAdicao;

	public LI() {

	}

	public LI(WebDriver driver) {
		this.driver = driver;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	@XmlElement
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getTipoImportador() {
		return tipoImportador;
	}

	@XmlElement
	public void setTipoImportador(String tipoImportador) {
		this.tipoImportador = tipoImportador;
	}

	public String getCdPaisProcMerc() {
		return cdPaisProcMerc;
	}

	@XmlElement
	public void setCdPaisProcMerc(String cdPaisProcMerc) {
		this.cdPaisProcMerc = cdPaisProcMerc;
	}

	public String getCdUrfDespacho() {
		return cdUrfDespacho;
	}

	@XmlElement
	public void setCdUrfDespacho(String cdUrfDespacho) {
		this.cdUrfDespacho = cdUrfDespacho;
	}

	public String getCdUrfEntrada() {
		return cdUrfEntrada;
	}

	@XmlElement
	public void setCdUrfEntrada(String cdUrfEntrada) {
		this.cdUrfEntrada = cdUrfEntrada;
	}

	public String getTxInfoComplementar() {
		return txInfoComplementar;
	}

	@XmlElement
	public void setTxInfoComplementar(String txInfoComplementar) {
		this.txInfoComplementar = txInfoComplementar;
	}


	public String getTemSistemaDrawback() {
		return temSistemaDrawback;
	}

	@XmlElement
	public void setTemSistemaDrawback(String temSistemaDrawback) {
		this.temSistemaDrawback = temSistemaDrawback;
	}

	public String getNumItemDrawback() {
		return numItemDrawback;
	}

	@XmlElement
	public void setNumItemDrawback(String numItemDrawback) {
		this.numItemDrawback = numItemDrawback;
	}

	public String getQuantidadeProdutoDrawback() {
		return quantidadeProdutoDrawback;
	}

	@XmlElement
	public void setQuantidadeProdutoDrawback(String quantidadeProdutoDrawback) {
		this.quantidadeProdutoDrawback = quantidadeProdutoDrawback;
	}

	public String getValProdutoLocalEmbarqueMoedaNegociada() {
		return valProdutoLocalEmbarqueMoedaNegociada;
	}

	@XmlElement
	public void setValProdutoLocalEmbarqueMoedaNegociada(
			String valProdutoLocalEmbarqueMoedaNegociada) {
		this.valProdutoLocalEmbarqueMoedaNegociada = valProdutoLocalEmbarqueMoedaNegociada;
	}

	public String getCondicaoMercadoria() {
		return condicaoMercadoria;
	}

	@XmlElement
	public void setCondicaoMercadoria(String condicaoMercadoria) {
		this.condicaoMercadoria = condicaoMercadoria;
	}

	public String getCdSubItemNCM() {
		return cdSubItemNCM;
	}

	@XmlElement
	public void setCdSubItemNCM(String cdSubItemNCM) {
		this.cdSubItemNCM = cdSubItemNCM;
	}

	public String getCdNaladiSh() {
		return cdNaladiSh;
	}

	@XmlElement
	public void setCdNaladiSh(String cdNaladiSh) {
		this.cdNaladiSh = cdNaladiSh;
	}

	public String getQuantidadeUnidEstatistica() {
		return quantidadeUnidEstatistica;
	}

	@XmlElement
	public void setQuantidadeUnidEstatistica(String quantidadeUnidEstatistica) {
		this.quantidadeUnidEstatistica = quantidadeUnidEstatistica;
	}

	public String getNumeroPesoLiquidoMerc() {
		return numeroPesoLiquidoMerc;
	}

	@XmlElement
	public void setNumeroPesoLiquidoMerc(String numeroPesoLiquidoMerc) {
		this.numeroPesoLiquidoMerc = numeroPesoLiquidoMerc;
	}

	public String getCdMoedaNegociada() {
		return cdMoedaNegociada;
	}

	@XmlElement
	public void setCdMoedaNegociada(String cdMoedaNegociada) {
		this.cdMoedaNegociada = cdMoedaNegociada;
	}

	public String getCdIncontermsVenda() {
		return cdIncontermsVenda;
	}

	@XmlElement
	public void setCdIncontermsVenda(String cdIncontermsVenda) {
		this.cdIncontermsVenda = cdIncontermsVenda;
	}

	public String getValorMercLocalEmb() {
		return valorMercLocalEmb;
	}

	@XmlElement
	public void setValorMercLocalEmb(String valorMercLocalEmb) {
		this.valorMercLocalEmb = valorMercLocalEmb;
	}

	public String getNomeFornecEstr() {
		return nomeFornecEstr;
	}

	@XmlElement
	public void setNomeFornecEstr(String nomeFornecEstr) {
		this.nomeFornecEstr = nomeFornecEstr;
	}

	public String getCdPaisAquisMerc() {
		return cdPaisAquisMerc;
	}

	@XmlElement
	public void setCdPaisAquisMerc(String cdPaisAquisMerc) {
		this.cdPaisAquisMerc = cdPaisAquisMerc;
	}

	public String getEdLogrFornecEstr() {
		return edLogrFornecEstr;
	}

	@XmlElement
	public void setEdLogrFornecEstr(String edLogrFornecEstr) {
		this.edLogrFornecEstr = edLogrFornecEstr;
	}

	public String getEdNumeroFornecEstr() {
		return edNumeroFornecEstr;
	}

	@XmlElement
	public void setEdNumeroFornecEstr(String edNumeroFornecEstr) {
		this.edNumeroFornecEstr = edNumeroFornecEstr;
	}

	public String getEdComplFornecEstr() {
		return edComplFornecEstr;
	}

	@XmlElement
	public void setEdComplFornecEstr(String edComplFornecEstr) {
		this.edComplFornecEstr = edComplFornecEstr;
	}

	public String getEdCidadeFornecEstr() {
		return edCidadeFornecEstr;
	}

	@XmlElement
	public void setEdCidadeFornecEstr(String edCidadeFornecEstr) {
		this.edCidadeFornecEstr = edCidadeFornecEstr;
	}

	public String getEdEstFornecEstr() {
		return edEstFornecEstr;
	}

	@XmlElement
	public void setEdEstFornecEstr(String edEstFornecEstr) {
		this.edEstFornecEstr = edEstFornecEstr;
	}

	public String getNumeroIdentUsuario() {
		return numeroIdentUsuario;
	}

	@XmlElement
	public void setNumeroIdentUsuario(String numeroIdentUsuario) {
		this.numeroIdentUsuario = numeroIdentUsuario;
	}

	public String getNumeroIdentificacaoDI() {
		return numeroIdentificacaoDI;
	}

	@XmlElement
	public void setNumeroIdentificacaoDI(String numeroIdentificacaoDI) {
		this.numeroIdentificacaoDI = numeroIdentificacaoDI;
	}

	public String getNumeroAdicao() {
		return numeroAdicao;
	}

	@XmlElement
	public void setNumeroAdicao(String numeroAdicao) {
		this.numeroAdicao = numeroAdicao;
	}

	public String getIdentificacaoPF() {
		return identificacaoPF;
	}

	@XmlElement
	public void setIdentificacaoPF(String identificacaoPF) {
		this.identificacaoPF = identificacaoPF;
	}

	public String getNomeImportadorPF() {
		return nomeImportadorPF;
	}

	@XmlElement
	public void setNomeImportadorPF(String nomeImportadorPF) {
		this.nomeImportadorPF = nomeImportadorPF;
	}

	public String getPaisPF() {
		return paisPF;
	}

	@XmlElement
	public void setPaisPF(String paisPF) {
		this.paisPF = paisPF;
	}

	public String getTelefonePF() {
		return telefonePF;
	}

	@XmlElement
	public void setTelefonePF(String telefonePF) {
		this.telefonePF = telefonePF;
	}

	public String getLogradouroPF() {
		return logradouroPF;
	}

	@XmlElement
	public void setLogradouroPF(String logradouroPF) {
		this.logradouroPF = logradouroPF;
	}

	public String getNumeroPF() {
		return numeroPF;
	}

	@XmlElement
	public void setNumeroPF(String numeroPF) {
		this.numeroPF = numeroPF;
	}

	public String getComplementoPF() {
		return complementoPF;
	}

	@XmlElement
	public void setComplementoPF(String complementoPF) {
		this.complementoPF = complementoPF;
	}

	public String getCidadePF() {
		return cidadePF;
	}

	@XmlElement
	public void setCidadePF(String cidadePF) {
		this.cidadePF = cidadePF;
	}

	public String getTelefone() {
		return telefone;
	}

	@XmlElement
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	@XmlElement
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	@XmlElement
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	@XmlElement
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	@XmlElement
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	@XmlElement
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	@XmlElement
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCodigoUF() {
		return codigoUF;
	}

	@XmlElement
	public void setCodigoUF(String codigoUF) {
		this.codigoUF = codigoUF;
	}

	public String getTipoFornecedor() {
		return tipoFornecedor;
	}

	@XmlElement
	public void setTipoFornecedor(String tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}

	public String getCdPaisOrigProdDesconhecido() {
		return cdPaisOrigProdDesconhecido;
	}

	@XmlElement
	public void setCdPaisOrigProdDesconhecido(String cdPaisOrigProdDesconhecido) {
		this.cdPaisOrigProdDesconhecido = cdPaisOrigProdDesconhecido;
	}

	public String getCnpjImportador() {
		return cnpjImportador;
	}

	@XmlElement
	public void setCnpjImportador(String cnpjImportador) {
		this.cnpjImportador = cnpjImportador;
	}

	public String getCpfImportador() {
		return cpfImportador;
	}

	@XmlElement
	public void setCpfImportador(String cpfImportador) {
		this.cpfImportador = cpfImportador;
	}

	public String getCdRegimeTrib() {
		return cdRegimeTrib;
	}

	@XmlElement
	public void setCdRegimeTrib(String cdRegimeTrib) {
		this.cdRegimeTrib = cdRegimeTrib;
	}

	public String getCdTipoAcordoTar() {
		return cdTipoAcordoTar;
	}

	@XmlElement
	public void setCdTipoAcordoTar(String cdTipoAcordoTar) {
		this.cdTipoAcordoTar = cdTipoAcordoTar;
	}

	public String getCdAcordoAladi() {
		return cdAcordoAladi;
	}

	@XmlElement
	public void setCdAcordoAladi(String cdAcordoAladi) {
		this.cdAcordoAladi = cdAcordoAladi;
	}

	public String getTipoCoberturaCambial() {
		return tipoCoberturaCambial;
	}

	@XmlElement
	public void setTipoCoberturaCambial(String tipoCoberturaCambial) {
		this.tipoCoberturaCambial = tipoCoberturaCambial;
	}

	public String getCdModalidade() {
		return cdModalidade;
	}

	@XmlElement
	public void setCdModalidade(String cdModalidade) {
		this.cdModalidade = cdModalidade;
	}

	public String getQuantidadeDiaLimitePgto() {
		return quantidadeDiaLimitePgto;
	}

	@XmlElement
	public void setQuantidadeDiaLimitePgto(String quantidadeDiaLimitePgto) {
		this.quantidadeDiaLimitePgto = quantidadeDiaLimitePgto;
	}

	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}

	@XmlElementWrapper(name = "mercadorias")
	@XmlElement(name = "mercadoria")
	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
		
	}
	
	public List<DestaqueNCM> getDestaquesNCM() {
		return destaquesNCM;
	}

	@XmlElementWrapper(name = "destaquesNCMs")
	@XmlElement(name = "destaqueNCM")
	public void setDestaquesNCM(List<DestaqueNCM> destaquesNCM) {
		this.destaquesNCM = destaquesNCM;
	}

	public List<ProcessoAnuente> getProcessosAnuentes() {
		return processosAnuentes;
	}
	
	@XmlElementWrapper(name = "processosAnuentes")
	@XmlElement(name = "processoAnuente")
	public void setProcessosAnuentes(List<ProcessoAnuente> processosAnuentes) {
		this.processosAnuentes = processosAnuentes;
	}

	public String getCdOrgaoFimInter() {
		return cdOrgaoFimInter;
	}

	public void setCdOrgaoFimInter(String cdOrgaoFimInter) {
		this.cdOrgaoFimInter = cdOrgaoFimInter;
	}

	public String getCdMotivoSemCob() {
		return cdMotivoSemCob;
	}

	public void setCdMotivoSemCob(String cdMotivoSemCob) {
		this.cdMotivoSemCob = cdMotivoSemCob;
	}
	

	public String getNomeFabricMerc() {
		return nomeFabricMerc;
	}

	@XmlElement
	public void setNomeFabricMerc(String nomeFabricMerc) {
		this.nomeFabricMerc = nomeFabricMerc;
	}

	public String getCdPaisOrigMerc() {
		return cdPaisOrigMerc;
	}
	@XmlElement
	public void setCdPaisOrigMerc(String cdPaisOrigMerc) {
		this.cdPaisOrigMerc = cdPaisOrigMerc;
	}

	public String getEdLogrFabric() {
		return edLogrFabric;
	}
	@XmlElement
	public void setEdLogrFabric(String edLogrFabric) {
		this.edLogrFabric = edLogrFabric;
	}

	public String getEdNumeroFabric() {
		return edNumeroFabric;
	}
	@XmlElement
	public void setEdNumeroFabric(String edNumeroFabric) {
		this.edNumeroFabric = edNumeroFabric;
	}

	public String getEdComplFabric() {
		return edComplFabric;
	}
	@XmlElement
	public void setEdComplFabric(String edComplFabric) {
		this.edComplFabric = edComplFabric;
	}

	public String getEdCidadeFabric() {
		return edCidadeFabric;
	}
	@XmlElement
	public void setEdCidadeFabric(String edCidadeFabric) {
		this.edCidadeFabric = edCidadeFabric;
	}

	public String getEdEstadoFabric() {
		return edEstadoFabric;
	}
	@XmlElement
	public void setEdEstadoFabric(String edEstadoFabric) {
		this.edEstadoFabric = edEstadoFabric;
	}
	
	public String getIdentificacaoInstituicao() {
		return identificacaoInstituicao;
	}

	@XmlElement
	public void setIdentificacaoInstituicao(String identificacaoInstituicao) {
		this.identificacaoInstituicao = identificacaoInstituicao;
	}
	
	public String getCodPais() {
		return codPais;
	}

	@XmlElement
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	
	public String getCdFundLegal() {
		return cdFundLegal;
	}

	@XmlElement
	public void setCdFundLegal(String cdFundLegal) {
		this.cdFundLegal = cdFundLegal;
	}
	
	public String getOperacao() {
		return operacao;
	}

	@XmlElement
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	protected void preencherCampo(String nomeCampo, String valor) {
		if (isElementPresent(By.id(nomeCampo))) {
			driver.findElement(By.id(nomeCampo)).clear();
			driver.findElement(By.id(nomeCampo)).sendKeys(valor);
		} else {
			System.out.println("Elemento :" + nomeCampo);
			printLog("Elemento não encontrado: " + nomeCampo + "\n"
					+ "Tela que pertence: "
					+ this.getClass().getSimpleName().toString());
			driver.quit();
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

	private void printLog(String errorMsg) {
		PrintWriter writer = null;
		try {

			writer = new PrintWriter("log_Sele_SiscomexImp.txt", "UTF-8");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(errorMsg);
		writer.close();
	}

	protected void verifyAlert() throws UnhandledAlertException {
		Alert alert = driver.switchTo().alert();
		if (alert != null) {
			printLog(alert.getText());
			driver.quit();
		}
	}
}
