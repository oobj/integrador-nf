package br.com.oobj.integrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aplicativo que enfileira a mensagem no JMS a partir de um diretorio.
 * 
 * @author Danilo
 *
 */
public class AppEnfileira {
	
	public static void main(String[] args) {
		ApplicationContext contextoDoSpring = new ClassPathXmlApplicationContext("app-enfileira.xml");
		
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
	}

}
