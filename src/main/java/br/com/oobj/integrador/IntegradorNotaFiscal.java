package br.com.oobj.integrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oobj.integrador.destino.Destino;
import br.com.oobj.integrador.origem.Origem;

@Service
public class IntegradorNotaFiscal {
	
	private Origem origem;
	private Destino destino;
	
	@Autowired
	public IntegradorNotaFiscal(Origem origem, Destino destino) {
		this.origem = origem;
		this.destino = destino;
	}
	
	public void integraNotaFiscal() {
		System.out.println("Iniciando integracao de NF...");
		
		destino.escreveRegistros(origem.obterNotas());
		
		System.out.println("Integracao de NF finalizada.");
	}

}
