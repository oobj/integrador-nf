package br.com.oobj.integrador;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import br.com.oobj.integrador.destino.Destino;
import br.com.oobj.integrador.origem.Origem;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		ApplicationContext contextoDoSpring = 
				new ClassPathXmlApplicationContext("rafadao.xml");
		
		IntegradorNotaFiscal integrador = 
				contextoDoSpring.getBean(IntegradorNotaFiscal.class);

		while (true) {
			integrador.integraNotaFiscal();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        
		
		
//		Destino destino = contextoDoSpring.getBean(Destino.class);
//		System.out.println(destino.getClass());
//		
//		NotaFiscalDAO notaFiscalDAO = contextoDoSpring.getBean(NotaFiscalDAO.class);
//		System.out.println("Implementacao de notaFiscalDAO: " + notaFiscalDAO.getClass());
//		
//		NotaFiscal notaFiscal2 = new NotaFiscal();
//		// nome: procNFE35130303555225000445550230002594841319344452AUT.xml
//		notaFiscal2.setNomeArquivo("mais novo nome ainda.xml");
//		notaFiscal2.setConteudoArquivo("novo conteudo");
//		notaFiscal2.setDataHoraEmissao(new Date());
//		
//		System.out.println("Inserindo nota...");
//		notaFiscalDAO.inserirNotaFiscal(notaFiscal2);
//		System.out.println("Nota inserida!");
//		
//		System.out.println("Quantidade de registros: " + notaFiscalDAO.contar());
//		
//		NotaFiscal notaFiscal = new NotaFiscal();
//		notaFiscal.setNomeArquivo("nova nota");
//		notaFiscal.setConteudoArquivo("novo conteudo");
//		// import java.util.Date;
//		// 'new Date()' retorna a hora local da maquina, no momento da execucao...
//		notaFiscal.setDataHoraEmissao(new Date());
//		notaFiscalDAO.inserirNotaFiscal(notaFiscal);
//		
//		System.out.println("Quantidade de registros: " + notaFiscalDAO.contar());
//		
//		NotaFiscal nfe = notaFiscalDAO.buscarPeloId(3L);
//		System.out.println(nfe.getNomeArquivo());
		
//		Origem origemBean = contextoDoSpring.getBean("origem", Origem.class);
//		Destino destinoBean = contextoDoSpring.getBean("destino", Destino.class);
//		
//		IntegradorNotaFiscal integrador = new IntegradorNotaFiscal();
//		integrador.setOrigem(origemBean);
//		integrador.setDestino(destinoBean);
//		
//		while (true) {
//			integrador.integraNotaFiscal();
//			
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
