package br.com.oobj.integrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsome {

	public static void main(String[] args) {
		ApplicationContext contextoDoSpring = 
				new ClassPathXmlApplicationContext("app-consome.xml");
		
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
