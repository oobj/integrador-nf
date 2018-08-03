package br.com.oobj.integrador.destino.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oobj.integrador.dao.NotaFiscalDAO;
import br.com.oobj.integrador.destino.Destino;
import br.com.oobj.integrador.model.NotaFiscal;

@Service
public class GravadorBancoDeDados implements Destino {
	
	private NotaFiscalDAO notaFiscalDao;
	
	@Autowired
	public GravadorBancoDeDados(NotaFiscalDAO notaFiscalDao) {
		this.notaFiscalDao = notaFiscalDao;
	}
	
	@Override
	public void escreveRegistros(List<NotaFiscal> notas) {
		System.out.println("Gravando registros no banco de dados...");
		
		for (NotaFiscal nota : notas) {
			System.out.println("Fazendo INSERT no banco para nota " + nota.getNomeArquivo());
			
			notaFiscalDao.inserirNotaFiscal(nota);
		}
	}

}
