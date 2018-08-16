package br.com.oobj.integrador.destino.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.oobj.integrador.destino.Destino;
import br.com.oobj.integrador.model.NotaFiscal;

@Service
public class EnfileiradorJms implements Destino {
	
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public EnfileiradorJms(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void escreveRegistros(List<NotaFiscal> notas) {
		System.out.println("Enfileirando no JMS...");
		
		for (NotaFiscal nota : notas) {
			System.out.println("Enfileiramento no JMS para nota " 
						+ nota.getNomeArquivo());
			
			jmsTemplate.convertAndSend("spring-teste", 
					nota.getConteudoArquivo());
			
			System.out.println("Nota enfileirada!");
		}

	}

}
