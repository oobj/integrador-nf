package br.com.oobj.integrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.oobj.integrador.dao.NotaFiscalDAO;
import br.com.oobj.integrador.destino.Destino;
import br.com.oobj.integrador.origem.Origem;

public class Main {

	public static void main(String[] args) {
		ApplicationContext contextoDoSpring = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		NotaFiscalDAO notaFiscalDAO = contextoDoSpring.getBean("notaFiscalDao", NotaFiscalDAO.class);
		
		System.out.println("Quantidade de registros: " + notaFiscalDAO.contar());
		
		notaFiscalDAO.removerNota(1L);
		
		System.out.println("Quantidade de registros: " + notaFiscalDAO.contar());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
