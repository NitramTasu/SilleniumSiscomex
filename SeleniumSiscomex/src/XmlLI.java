import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Ignore;
import org.junit.Test;

import br.com.lice.DestaqueNCM;
import br.com.lice.LI;
import br.com.lice.Mercadoria;
import br.com.lice.ProcessoAnuente;
import br.com.lice.soli.SolicitacaoLI;

public class XmlLI {

	//@Ignore
	@Test
	public void gerarXmldeLI() {

		SolicitacaoLI soli = new SolicitacaoLI();
		LI li = new LI();
		
		li.setOperacao("E");
		li.setIdentificacao("12345678");
		li.setTipoImportador("Pessoa Jurídica");
		li.setCnpjImportador("12345678");
		li.setCdPaisProcMerc("A DESIGNAR");
		li.setCdUrfDespacho("12345");
		li.setCdUrfEntrada("12345");
		li.setTxInfoComplementar("Informações complementares");
		li.setTipoFornecedor("Fabricante/Produtor é Exportador");
		li.setNomeFornecEstr("Nome Exportador");
		li.setCdPaisAquisMerc("A Designar");
		li.setEdLogrFornecEstr("Logradouro");
		li.setEdNumeroFornecEstr("12345");
		li.setEdComplFornecEstr("Complemento");
		li.setEdCidadeFornecEstr("São Paulo");
		li.setEdEstFornecEstr("SP");
		li.setCdSubItemNCM("123456");
		li.setCdNaladiSh("1234");
		li.setQuantidadeUnidEstatistica("123");
		li.setNumeroPesoLiquidoMerc("1");
		li.setCdIncontermsVenda("12");
		li.setValorMercLocalEmb("4");
		li.setCondicaoMercadoria("Material Usado");
		li.setTemSistemaDrawback("Suspensão Genérico");
		li.setNumeroIdentUsuario("123455");
		li.setCdMoedaNegociada("005");
		
		li.setCdRegimeTrib("123");
		li.setCdTipoAcordoTar("sei lá");
		li.setCdAcordoAladi("1234");
		li.setTipoCoberturaCambial("Cobertura");
		li.setCdModalidade("Modalidade");
		li.setCdOrgaoFimInter("Orgao");
		li.setCdMotivoSemCob("Motivo");
		li.setQuantidadeDiaLimitePgto("123");
		
		li.setNomeFabricMerc("Nome do Fabricante");
		li.setCdPaisOrigMerc("Sei lá");
		li.setEdLogrFabric("Logradouro");
		li.setEdNumeroFabric("Numero");
		li.setEdComplFabric("Complemento");
		li.setEdCidadeFabric("Cidade");
		li.setEdEstadoFabric("Estado");

		// Detalhes da mercadoria
		List<Mercadoria> mercadorias = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			criaMercadoria(mercadorias);
		}
		
		// Destaque da NCM
		List<DestaqueNCM> destaquesNCM = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			criaDestaquesNCM(destaquesNCM);
		}
		
		// Processos Anuentes
		List<ProcessoAnuente> processos = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			criaProcessosAnuentes(processos);
		}

		li.setProcessosAnuentes(processos);
		li.setDestaquesNCM(destaquesNCM);
		li.setMercadorias(mercadorias);
		

		// Drawback
		li.setNumItemDrawback("1234");
		li.setQuantidadeProdutoDrawback("10");
		li.setValProdutoLocalEmbarqueMoedaNegociada("1234");

		toXML(li);
	}

	@Ignore
	@Test
	public void converterXmlParaObjeto() {
		toObject();
	}

	public void criaMercadoria(List<Mercadoria> mercadorias) {
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setUnidComercializada("Kg");
		mercadoria.setQtdeUnidComercializada("2");
		mercadoria.setValorUnitCondicaoVenda("1234");
		mercadoria.setEspecificacaoMercadoria("Especificação da Mercadoria");
		mercadorias.add(mercadoria);
	}
	
	public void criaDestaquesNCM(List<DestaqueNCM> destaquesNCM) {
		DestaqueNCM destaqueNCM = new DestaqueNCM();
		destaqueNCM.setInclusaoNCM("031");
		destaquesNCM.add(destaqueNCM);
	}
	
	public void criaProcessosAnuentes(List<ProcessoAnuente> processos) {
		ProcessoAnuente processo = new ProcessoAnuente();
		processo.setNumProcessoAnuente("23454254");
		processo.setSiglaOrgaoAnuente("ANVISA");
		processos.add(processo);
	}

	public static void toXML(LI li) {

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

	public static void toObject() {
		try {

			File file = new File("C:\\Users\\Martin\\Desktop\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(LI.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			LI li =  (LI) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(li);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
