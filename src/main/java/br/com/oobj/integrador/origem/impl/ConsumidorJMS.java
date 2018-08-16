package br.com.oobj.integrador.origem.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import br.com.oobj.integrador.model.NotaFiscal;
import br.com.oobj.integrador.origem.Origem;

@Service
public class ConsumidorJMS implements Origem, MessageListener {

	private List<NotaFiscal> notas = new ArrayList<>();
	
	@Override
	public List<NotaFiscal> obterNotas() {
		System.out.println("Retornando lista de notas obtidas do JMS");
		List<NotaFiscal> temporaria = new ArrayList<>(notas);
		
		notas.removeAll(notas);
		System.out.println("Tamanho do array 'notas': " + notas.size());
		
		return temporaria;
	}

	// consumir uma mensagem da fila JMS
	@Override
	public void onMessage(Message message) {
		System.out.println("Processando mensagem JMS");
		
		if (message instanceof TextMessage) {
			// Cast ou casting: força um determinado tipo
			TextMessage textMessage = (TextMessage) message;
		
			// obter o conteudo da mensagem JMS
			String conteudo;
			try {
				conteudo = textMessage.getText();
				// instanciar uma NotaFiscal
				NotaFiscal nota = new NotaFiscal();
				nota.setConteudoArquivo(conteudo);
				// adicionar notaFiscal na lista.
				notas.add(nota);
				
			} catch (JMSException e) {
				System.err.println("Falha ao obter o conteudo da mensagem");
				// TODO Implementar invalid message channel, do EIP
			}
		} else {
			System.err.println("Tipo de mensagem nao reconhecida: " + 
					message.getClass());
			// TODO Implementar invalid message channel, do EIP
		}
	}

}
